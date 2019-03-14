package com.fnic.service.impl;

import com.fnic.mybatis.iot.dao.*;
import com.fnic.mybatis.iot.dao.EventMapper;
import com.fnic.mybatis.iot.model.Event;
import com.fnic.mybatis.iot.model.*;
import com.fnic.mybatis.thingsboard.dao.CustomerMapper;
import com.fnic.mybatis.thingsboard.model.Customer;
import com.fnic.service.OrderService;
import com.fnic.service.RemoteClientService;
import com.fnic.sysframe.security.SysUser;
import com.fnic.sysframe.utils.DateUtil;
import com.fnic.sysframe.utils.SequenceUtil;
import com.fnic.sysframe.utils.UserUtil;
import com.google.common.collect.Maps;
import com.google.gson.JsonObject;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hjhuang on 2017/5/19.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private TShoppingCartMapper shoppingCartMapper;

    @Autowired
    private TCartSubItemMapper cartSubItemMapper;

    @Autowired
    private TProductItemMapper productItemMapper;

    @Autowired
    private TProductCombMapper productCombMapper;

    @Autowired
    private TOrderMapper orderMapper;

    @Autowired
    private TSubOrderMapper subOrderMapper;

    @Autowired
    private TQosOrderMapper qosOrderMapper;

    @Autowired
    private TQosMapper qosMapper;

    @Autowired
    private RemoteClientService remoteClientService;

    @Value("${qos.totalBandWidth}")
    private int totalBandWidth;

    @Value("${qos.realTimeFlow}")
    private int realTimeFlow;

    @Value("${qos.keyBusiness}")
    private int keyBusiness;

    @Value("${qos.netManagement}")
    private int netManagement;

    @Value("${qos.netFlow}")
    private int netFlow;

    @Value("${qos.otherFlow}")
    private int otherFlow;

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private CustomerMapper customerMapper;

    public boolean submitShoppingCart(Map<String,Object> inputParam) throws Exception {

        boolean result = false;

        TProductCombExample productCombExample = new TProductCombExample();
        productCombExample.createCriteria().andCombIdEqualTo((String) inputParam.get("goodsId")).andCombTypeEqualTo("P");

        List<TProductComb> productList = productCombMapper.selectByExample(productCombExample);

        if(productList.size()>0) {
            TShoppingCart shoppingCart = new TShoppingCart();
            int goodsNum = (int) inputParam.get("goodsNum");
            Date now = DateUtil.getNowTime();

            shoppingCart.setAccountId(UserUtil.getUser().getAccountId());
            shoppingCart.setCreateTime(now);
            shoppingCart.setGoodsId((String) inputParam.get("goodsId"));
            shoppingCart.setGoodsName((String) inputParam.get("goodsName"));
            shoppingCart.setGoodsNum(goodsNum);
            shoppingCart.setId(SequenceUtil.getNext(SequenceUtil.T_SHOPPING_CART));
            shoppingCart.setOperType("0");
            shoppingCart.setOperUserId(UserUtil.getUser().getId());
            shoppingCart.setUserGroupId(UserUtil.getUser().getUserGroupId());
            shoppingCart.setUpdateTime(now);

            if(inputParam.get("startTime") != null) {
                shoppingCart.setStartTime(DateUtil.getDateFormat((String) inputParam.get("startTime")));
            }

            if(inputParam.get("endTime") != null) {
                shoppingCart.setEndTime(DateUtil.getDateFormat((String) inputParam.get("startTime")));
            }

            shoppingCart.setGoodsSum(productList.get(0).getPrice() * goodsNum);

            int count = shoppingCartMapper.insert(shoppingCart);

            List<Map<String,Object>> packageList = (List<Map<String,Object>>) inputParam.get("packageList");

            for(Map<String,Object> packagae : packageList) {

                TCartSubItem packSubItem = new TCartSubItem();
                packSubItem.setId(SequenceUtil.getNext(SequenceUtil.T_CART_SUB_ITEM));
                packSubItem.setCartId(shoppingCart.getId());
                packSubItem.setItemId((String) packagae.get("productPackageId"));
                //packSubItem.setItemName(packagae);
                packSubItem.setItemType("K");
                cartSubItemMapper.insert(packSubItem);

                List<String> itemList = (List<String>) packagae.get("itemList");
                if(itemList.size()>0) {
                    TProductItemExample productItemExample = new TProductItemExample();
                    productItemExample.createCriteria().andProductItemIdIn(itemList);
                    List<TProductItem> list = productItemMapper.selectByExample(productItemExample);

                    for(TProductItem productItem : list) {
                        TCartSubItem cartSubItem = new TCartSubItem();
                        cartSubItem.setId(SequenceUtil.getNext(SequenceUtil.T_CART_SUB_ITEM));
                        cartSubItem.setCartId(shoppingCart.getId());
                        cartSubItem.setItemId(productItem.getProductItemId());
                        cartSubItem.setItemName(productItem.getProductItemName());
                        cartSubItem.setItemType("I");
                        cartSubItem.setPackageId(packSubItem.getItemId());
                        cartSubItem.setItemValue(productItem.getProductItemValue());

                        cartSubItemMapper.insert(cartSubItem);
                    }
                }
            }

            if(count>0) {
                result = true;
            }
        }

        return result;
    }

    public boolean submitOrder(List<Integer> idList) throws Exception {

        boolean result = false;
        TShoppingCartExample shoppingCartExample = new TShoppingCartExample();
        shoppingCartExample.createCriteria().andIdIn(idList);
        List<TShoppingCart> cartList = shoppingCartMapper.selectByExample(shoppingCartExample);

        SysUser user = UserUtil.getUser();

        TOrder order = new TOrder();
        Date now = DateUtil.getNowTime();
        order.setId(SequenceUtil.getLogId(SequenceUtil.T_ORDER));
        order.setOperUserId(user.getId());
        order.setUserGroupId(user.getUserGroupId());
        order.setAccountId(user.getAccountId());
        order.setCreateTime(now);
        order.setUpdateTime(now);
        order.setStatus("0");
        StringBuffer subject = new StringBuffer();
        int totalFee = 0;

        for(TShoppingCart shoppingCart : cartList) {
            TSubOrder subOrder = new TSubOrder();
            subOrder.setId(SequenceUtil.getLogId(SequenceUtil.T_SUB_ORDER));
            subOrder.setStatus("0");
            subOrder.setCreateTime(now);
            subOrder.setUpdateTime(now);
            subOrder.setItemType("P");
            subOrder.setItemName(shoppingCart.getGoodsName());
            subOrder.setItemId(shoppingCart.getGoodsId());
            subOrder.setOrderId(order.getId());
            subOrder.setItemFee(shoppingCart.getGoodsSum());
            subOrder.setStartTime(shoppingCart.getStartTime());
            subOrder.setEndTime(shoppingCart.getEndTime());

            subject.append(shoppingCart.getGoodsName()).append(" ");
            totalFee += shoppingCart.getGoodsSum();

            if(subOrderMapper.insert(subOrder)>0) {

                if("Qos".equals(subOrder.getItemId())) {
                    dealQosOrder(subOrder,order);
                }

                TCartSubItemExample cartSubItemExample = new TCartSubItemExample();
                cartSubItemExample.createCriteria().andCartIdEqualTo(shoppingCart.getId());
                List<TCartSubItem> cartSubItemList = cartSubItemMapper.selectByExample(cartSubItemExample);

                for (TCartSubItem cartSubItem : cartSubItemList) {
                    TSubOrder subOrderItem = new TSubOrder();
                    subOrderItem.setId(SequenceUtil.getLogId(SequenceUtil.T_SUB_ORDER));
                    subOrderItem.setStatus("0");
                    subOrderItem.setCreateTime(now);
                    subOrderItem.setUpdateTime(now);
                    subOrderItem.setItemType(cartSubItem.getItemType());
                    subOrderItem.setItemName(cartSubItem.getItemName());
                    subOrderItem.setItemId(cartSubItem.getItemId());
                    subOrderItem.setOrderId(order.getId());
                    subOrderItem.setItemFee(cartSubItem.getItemFee());
                    subOrderItem.setStartTime(now);
                    subOrderItem.setStartTime(shoppingCart.getStartTime());
                    subOrderItem.setEndTime(shoppingCart.getEndTime());
                    subOrderItem.setItemValue(cartSubItem.getItemValue());

                    if(subOrderMapper.insert(subOrderItem)>0) {
                        cartSubItemMapper.deleteByPrimaryKey(cartSubItem.getId());
                    }
                }

                shoppingCartMapper.deleteByPrimaryKey(shoppingCart.getId());
            }
        }

        order.setSubject(subject.substring(0,subject.length()-1));
        order.setTotalFee(totalFee);

        if(orderMapper.insert(order)>0){
            result = true;
        }
        return result;
    }

    public void dealQosOrder(TSubOrder subOrderItem,TOrder order) {

        TQosOrder qosOrder = new TQosOrder();
        qosOrder.setId(SequenceUtil.getNext(SequenceUtil.T_QOS_ORDER));
        qosOrder.setStartTime(subOrderItem.getStartTime());
        qosOrder.setEndTime(subOrderItem.getEndTime());
        qosOrder.setAccountId(order.getAccountId());
        qosOrder.setUserGroupId(order.getUserGroupId());
        qosOrder.setBandWidth(totalBandWidth);
        qosOrder.setOperUserId(order.getOperUserId());
        qosOrder.setUpdateTime(subOrderItem.getUpdateTime());
        qosOrder.setCreateTime(subOrderItem.getCreateTime());
        qosOrder.setStatus("0");

        qosOrderMapper.insert(qosOrder);

        JsonObject param = new JsonObject();

        param.addProperty("class","qos");
        param.addProperty("total",totalBandWidth);
        param.addProperty("100",realTimeFlow);
        param.addProperty("200",keyBusiness);
        param.addProperty("300",netManagement);
        param.addProperty("400",netFlow);
        param.addProperty("999",otherFlow);

        Map<String,Object> rsp = remoteClientService.sendService(param);

        if("0000".equals(rsp.get("rspCode"))) {
            TQos qos = new TQos();

            qos.setAccountId(order.getAccountId());
            qos.setUserGroupId(order.getUserGroupId());
            qos.setCreateTime(order.getCreateTime());
            qos.setUpdateTime(order.getUpdateTime());
            qos.setOperUserId(order.getOperUserId());
            qos.setId(SequenceUtil.getNext(SequenceUtil.T_QOS));
            qos.setDefaultRate(realTimeFlow);
            qos.setMaxRate(totalBandWidth);
            qos.setQosCode("totalBandWidth");
            qos.setQosPriority(100);
            qos.setQosName("实时流量");
            qosMapper.insert(qos);

            qos.setId(SequenceUtil.getNext(SequenceUtil.T_QOS));
            qos.setDefaultRate(keyBusiness);
            qos.setQosCode("keyBusiness");
            qos.setQosPriority(200);
            qos.setQosName("关键业务");
            qosMapper.insert(qos);

            qos.setId(SequenceUtil.getNext(SequenceUtil.T_QOS));
            qos.setDefaultRate(netManagement);
            qos.setQosCode("netManagement");
            qos.setQosPriority(300);
            qos.setQosName("网络管理");
            qosMapper.insert(qos);

            qos.setId(SequenceUtil.getNext(SequenceUtil.T_QOS));
            qos.setDefaultRate(netFlow);
            qos.setQosCode("netFlow");
            qos.setQosPriority(400);
            qos.setQosName("上网流量");
            qosMapper.insert(qos);

            qos.setId(SequenceUtil.getNext(SequenceUtil.T_QOS));
            qos.setDefaultRate(otherFlow);
            qos.setQosCode("otherFlow");
            qos.setQosPriority(999);
            qos.setQosName("其他");
            qosMapper.insert(qos);

        }
    }

    @Override
    @Transactional(transactionManager = "xatx", propagation = Propagation.REQUIRED, rollbackFor = { java.lang.RuntimeException.class })
    public Map<String, Object> test() throws Exception {

        Map<String,Object> rsp = Maps.newHashMap();
        rsp.put("rspCode","0000");

        Customer customer = new Customer();
        customer.setId(DateUtil.getNowTimeStr());
        customer.setTenantId("123");
        customer.setTitle("TEST");
        customerMapper.insert(customer);

        Event event = new Event();
        event.setId("1111");
        event.setBody("@@@@@@@@@@@@@@");
        event.setEntityId("123");
        event.setEntityType("TEST");
        event.setEventType("TEST");
        event.setEventUid("123456");
        event.setTenantId("123");

        eventMapper.insert(event);

        return rsp;
    }

    @Override
    public void testPress() throws Exception {
        final String host = "192.168.33.168";
        //final String host = "127.0.0.1";
        final int port = 8082;

        for(int i=0;i<1000;i++) {
            String address = "123456" + String.format("%05d",i + 9009);
            ByteBuf buf = Unpooled.buffer(21);

            buf.writeByte(0x21);
            buf.writeByte(0x43);

            buf.writeByte(0x65);
            buf.writeByte(0x87);

            buf.writeBytes(address.getBytes());

            buf.writeByte(0x00);
            buf.writeByte(0xC0);
            buf.writeByte(0xA8);
            buf.writeByte(0x01);
            buf.writeByte(0x74);
            buf.writeByte(0x00);
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.submit(() -> {
                try {
                    Socket sc = new Socket(host,port);
                    OutputStream out = sc.getOutputStream();
                    out.write(buf.array());

                    ExecutorService rspExecutor = Executors.newFixedThreadPool(10);

                    while(true)
                    {
                        try {
                            getElevatorRsponse2(sc,rspExecutor);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

    }

    @Override
    public void testMqttPress(int num) {
        final String host = "tcp://192.168.33.168:1884";
        ExecutorService executor = Executors.newFixedThreadPool(num);

        for(int i=1;i<num;i++) {
            final int j = i;
            executor.execute( () -> {
//                String token = "123456" + String.format("%05d",j);
                long value = j + 12345600001l;
                String token = String.valueOf(value);
                MqttConnectOptions options = new MqttConnectOptions();
                // MQTT的连接设置
                options = new MqttConnectOptions();
                // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，设置为true表示每次连接到服务器都以新的身份连接
                options.setCleanSession(false);
                options.setKeepAliveInterval(600);
                // 设置连接的用户名
                options.setUserName(token);
                String clientId = MqttAsyncClient.generateClientId();
                MqttAsyncClient client = null;
                try {
                    client = new MqttAsyncClient(host, clientId);

                    MqttMessage message = new MqttMessage();
                    String content = "{\"key1\":" +  Math.random() + "}";
                    message.setPayload(content.getBytes());
                    client.connect(options).waitForCompletion();

                    while(true) {
                        client.publish("v1/devices/me/telemetry",  message.getPayload(),1,false);
                        Thread.sleep(6000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            //12345600001

            //client.disconnect();
        }
    }

    @Override
    public void testMqttConnect(int num) {

        final String host = "tcp://192.168.33.168:1884";

        ExecutorService executor = Executors.newFixedThreadPool(num);

        int i = 1;
        while(true) {
            final int j = i;
            if(i<= num) {
                executor.execute(() -> {
                    String token = "123456" + String.format("%05d", j);
                    MqttConnectOptions options = new MqttConnectOptions();
                    // MQTT的连接设置
                    options = new MqttConnectOptions();
                    // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，设置为true表示每次连接到服务器都以新的身份连接
                    options.setCleanSession(false);
                    // 设置连接的用户名
                    options.setUserName(token);
                    String clientId = MqttAsyncClient.generateClientId();
                    MqttAsyncClient client = null;
                    try {
                        client = new MqttAsyncClient(host, clientId);

                        MqttMessage message = new MqttMessage();
                        String content = "{\"key1\":" + Math.random() + "}";
                        message.setPayload(content.getBytes());
                        client.connect(options).waitForCompletion();

//                    while (true) {
//                        client.publish("v1/devices/me/telemetry", message);
//                        Thread.sleep(6000);
//                    }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                i++;
                System.out.println(i);
            }
        }
    }

    @Override
    public void testMqttPressAttr(int num) {
        //final String host = "tcp://192.168.33.168:1884";
        final String host = "tcp://112.64.32.192:9001";
        //final String host = "tcp://218.98.16.76:1883";
        //final String host = "tcp://172.30.207.60:1883";
        //final String host = "tcp://127.0.0.1:9001";
        //final String host = "tcp://192.168.1.9:9001";
        ExecutorService executor = Executors.newFixedThreadPool(num);

        for(int i=1;i<num;i++) {
            final int j = i;
            executor.execute( () -> {
                long value = j + 12345600001l;
                String token = String.valueOf(value);
                MqttConnectOptions options = new MqttConnectOptions();
                // MQTT的连接设置
                options = new MqttConnectOptions();
                // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，设置为true表示每次连接到服务器都以新的身份连接
                options.setCleanSession(false);
                options.setKeepAliveInterval(600);
                // 设置连接的用户名
                options.setUserName(token);
                String clientId = MqttAsyncClient.generateClientId();
                MqttAsyncClient client = null;
                try {
                    client = new MqttAsyncClient(host, clientId);

                    MqttMessage message = new MqttMessage();
                    String content = "{\"key3\":" +  Math.random() + "}";
                    message.setPayload(content.getBytes());
                    client.connect(options).waitForCompletion();

                    while(true) {
                        client.publish("v1/devices/me/attributes", message.getPayload(),1,false);
                        Thread.sleep(6000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private void getElevatorRsponse2(Socket socket) throws Exception {

        // while(true) {
        InputStream inputStream = socket.getInputStream();

        byte[] body = new byte[1024];
        int length = inputStream.read(body);

        // 失败案例
        // OpenJDK 64-Bit Server VM warning: Attempt to deallocate stack guard pages failed.OpenJDK 64-Bit Server VM warning: Attempt to deallocate stack guard pages failed.
        //OpenJDK 64-Bit Server VM warning: INFO: os::commit_memory(0x00007fb330f11000, 12288, 0) failed; error='无法分配内存' (errno=12)
        //[thread 140407598028544 also had an error]
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=1;i<10;i++) {
            final int address = i;
            executorService.execute( () -> {
                        try {
                            OutputStream out = socket.getOutputStream();
                            ByteBuf bBuf = Unpooled.buffer(12);
                            bBuf.writeByte(transToByte(0xfd));
                            bBuf.writeByte(transToByte( 0xee));

                            bBuf.writeByte(transToByte( 0x06));

                            bBuf.writeByte(transToByte( 0x44));
                            bBuf.writeByte(transToByte( 0x5e));

                            bBuf.writeByte(transToByte( address));
                            bBuf.writeByte(transToByte( 0x00));

                            bBuf.writeByte(transToByte( address));
                            bBuf.writeByte(transToByte( 0x01));

                            bBuf.writeByte(transToByte( 0x00));
                            bBuf.writeByte((int) (1+Math.random()*(10-1+1)));

                            bBuf.writeByte(transToByte( 0x8d));

                            out.write(bBuf.array());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            );

        }
    }

    private void getElevatorRsponse2(Socket socket,ExecutorService rspExecutor) throws Exception {

        // while(true) {
        InputStream inputStream = socket.getInputStream();
        if(inputStream != null) {
            byte[] body = new byte[10];
            int length = inputStream.read(body);

            rspExecutor.execute(() -> {
                try {
                    final int address = body[5] & 0xff;

                    OutputStream out = socket.getOutputStream();
                    ByteBuf bBuf = Unpooled.buffer(12);
                    bBuf.writeByte(transToByte(0xfd));
                    bBuf.writeByte(transToByte(0xee));

                    bBuf.writeByte(transToByte(0x06));

                    bBuf.writeByte(transToByte(0x44));
                    bBuf.writeByte(transToByte(0x5e));

                    bBuf.writeByte(transToByte(address));
                    bBuf.writeByte(transToByte(0x00));

                    bBuf.writeByte(transToByte(address));
                    bBuf.writeByte(transToByte(0x01));

                    bBuf.writeByte(transToByte(0x00));
                    bBuf.writeByte((int) (1 + Math.random() * (10 - 1 + 1)));

                    bBuf.writeByte(transToByte(0x8d));

                    out.write(bBuf.array());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

      /*
        会出现并发问题，同一个设备ID，同一个KEY，同一个时间戳，导致报错
        Caused by: org.postgresql.util.PSQLException: ERROR: duplicate key value violates unique constraint "ts_kv_latest_unq_key"
        Caused by: org.hibernate.HibernateException: More than one row with the given identifier was found: TsKvCompositeKey(entityType=DEVICE, entityId=1e8598ae3c975f0933219a5a4cf21f9, key=IOValue, ts=1543389046324), for class: org.thingsboard.server.dao.model.sql.TsKvEntity

       */
//    private void getElevatorRsponse2(Socket socket,ExecutorService rspExecutor) throws Exception {
//
//        // while(true) {
//        InputStream inputStream = socket.getInputStream();
//
//        byte[] body = new byte[1024];
//        int length = inputStream.read(body);
//        for(int i=1;i<10;i++) {
//            final int address = i;
//            rspExecutor.execute( () -> {
//                        try {
//                            OutputStream out = socket.getOutputStream();
//                            ByteBuf bBuf = Unpooled.buffer(12);
//                            bBuf.writeByte(transToByte(0xfd));
//                            bBuf.writeByte(transToByte( 0xee));
//
//                            bBuf.writeByte(transToByte( 0x06));
//
//                            bBuf.writeByte(transToByte( 0x44));
//                            bBuf.writeByte(transToByte( 0x5e));
//
//                            bBuf.writeByte(transToByte( address));
//                            bBuf.writeByte(transToByte( 0x00));
//
//                            bBuf.writeByte(transToByte( address));
//                            bBuf.writeByte(transToByte( 0x01));
//
//                            bBuf.writeByte(transToByte( 0x00));
//                            bBuf.writeByte((int) (1+Math.random()*(10-1+1)));
//
//                            bBuf.writeByte(transToByte( 0x8d));
//
//                            out.write(bBuf.array());
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//            );
//
//        }
//    }

    private byte transToByte(int i) {
        return (byte) i;
    }


}
