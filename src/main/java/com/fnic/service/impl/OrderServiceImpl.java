package com.fnic.service.impl;

import com.fnic.mybatis.dao.*;
import com.fnic.mybatis.model.*;
import com.fnic.service.OrderService;
import com.fnic.service.RemoteClientService;
import com.fnic.sysframe.security.SysUser;
import com.fnic.sysframe.utils.DateUtil;
import com.fnic.sysframe.utils.SequenceUtil;
import com.fnic.sysframe.utils.UserUtil;
import com.google.common.collect.Maps;
import com.google.gson.JsonObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
}
