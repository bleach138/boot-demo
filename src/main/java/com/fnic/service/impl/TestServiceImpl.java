package com.fnic.service.impl;

import com.datastax.driver.core.utils.UUIDs;
import com.fnic.mybatis.iot.dao.AttributeKvMapper;
import com.fnic.mybatis.iot.dao.TsKvMapper;
import com.fnic.mybatis.iot.model.AttributeKv;
import com.fnic.mybatis.iot.model.AttributeKvExample;
import com.fnic.mybatis.iot.model.TsKv;
import com.fnic.service.TestService;
import com.fnic.sysframe.common.CacheConstants;
import com.fnic.sysframe.utils.RedisUtil;
import com.fnic.sysframe.utils.UUIDConverter;
import com.google.common.collect.Maps;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

    @Resource
    private AttributeKvMapper kvMapper;

    @Resource
    private TsKvMapper tsKvMapper;

    @Resource
    private RedisUtil redisUtil;

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    private int processCount = 0;

    @Resource
    private KafkaTemplate kafkaTemplate;

    //缓存
//    @Override
//    public Map<String, Object> miaosha(Map<String, Object> param) throws Exception {
//
//
//        Map<String,Object> rspMap = Maps.newHashMap();
//        AttributeKvExample example = new AttributeKvExample();
//        long num = 0;
//        if(redisUtil.hasKey(CacheConstants.MIAOSHA_GOODS_NUM)) {
//           int i = (Integer) redisUtil.get(CacheConstants.MIAOSHA_GOODS_NUM);
//           num = i;
//        }else {
//            example.createCriteria().andEntityIdEqualTo("1e9364deaf831d681140242ac110002").andAttributeKeyEqualTo("GOODS_NUM");
//            List<AttributeKv> list = kvMapper.selectByExample(example);
//
//            AttributeKv kv = list.get(0);
//            num = kv.getLongV();
//            redisUtil.set(CacheConstants.MIAOSHA_GOODS_NUM,num);
//        }
//
//        if(num>0) {
//
//            long count = redisUtil.decr( CacheConstants.MIAOSHA_GOODS_NUM,1);
//
//            if(count>0) {
//
//                long numNew = num - 1;
//                AttributeKv kv = new AttributeKv();
//                kv.setLongV(numNew);
//                AttributeKvExample example2 = new AttributeKvExample();
//                example2.createCriteria().andEntityIdEqualTo("1e9364deaf831d681140242ac110002").andAttributeKeyEqualTo("GOODS_NUM")
//                        .andLongVEqualTo(num);
//
//                kvMapper.updateByExampleSelective(kv,example2);
//
//                TsKv tsKv = new TsKv();
//                tsKv.setEntityId(UUIDConverter.fromTimeUUID(UUIDs.timeBased()));
//                tsKv.setEntityType("DEVICE");
//                tsKv.setKey("order");
//                tsKv.setTs(System.currentTimeMillis());
//                tsKv.setLongV(1l);
//                tsKvMapper.insert(tsKv);
//                rspMap.put("rspCode","0000");
//                rspMap.put("rspDesc","success");
//            }
//
//
//            //并发时会重复插入，实际数量大于限定数量
////            num--;
////            kv.setLongV(num);
////            kvMapper.updateByExample(kv,example);
////
////            TsKv tsKv = new TsKv();
////            tsKv.setEntityId(UUIDConverter.fromTimeUUID(UUIDs.timeBased()));
////            tsKv.setEntityType("DEVICE");
////            tsKv.setKey("order");
////            tsKv.setTs(System.currentTimeMillis());
////            tsKv.setLongV(1l);
////            tsKvMapper.insert(tsKv);
////            rspMap.put("rspCode","0000");
////            rspMap.put("rspDesc","success");
//        }else {
//            rspMap.put("rspCode","9999");
//            rspMap.put("rspDesc","goods sales out");
//        }
//        processCount++;
//        //logger.debug("@@@@@@@@@@@@" + processCount);
//        return rspMap;
//    }

      //缓存 + 乐观锁
    @Override
    public Map<String, Object> miaosha(Map<String, Object> param) throws Exception {


        Map<String,Object> rspMap = Maps.newHashMap();
        AttributeKvExample example = new AttributeKvExample();
        long num = 0;

        if(redisUtil.hasKey(CacheConstants.MIAOSHA_GOODS_NUM)) {
            int i = (Integer) redisUtil.get(CacheConstants.MIAOSHA_GOODS_NUM);
            redisUtil.incr(CacheConstants.MIAOSHA_REDIS_READ,1);
            num = i;
        }else {
            example.createCriteria().andEntityIdEqualTo("1e9364deaf831d681140242ac110002").andAttributeKeyEqualTo("GOODS_NUM");
            List<AttributeKv> list = kvMapper.selectByExample(example);

            AttributeKv kv = list.get(0);
            num = kv.getLongV();
            redisUtil.set(CacheConstants.MIAOSHA_GOODS_NUM,num);
        }

        if(num>0) {

            //乐观锁
            long numNew = num - 1;
            AttributeKv kv = new AttributeKv();
            kv.setLongV(numNew);
            AttributeKvExample example2 = new AttributeKvExample();
            example2.createCriteria().andEntityIdEqualTo("1e9364deaf831d681140242ac110002").andAttributeKeyEqualTo("GOODS_NUM")
                    .andLongVEqualTo(num);
            redisUtil.incr(CacheConstants.MIAOSHA_ORDER_COMMIT,1);

            int count = kvMapper.updateByExampleSelective(kv,example2);

            if(count>0) {
                TsKv tsKv = new TsKv();
                tsKv.setEntityId(UUIDConverter.fromTimeUUID(UUIDs.timeBased()));
                tsKv.setEntityType("DEVICE");
                tsKv.setKey("order");
                tsKv.setTs(System.currentTimeMillis());
                tsKv.setLongV(1l);
                tsKvMapper.insert(tsKv);
                rspMap.put("rspCode","0000");
                rspMap.put("rspDesc","success");
                redisUtil.decr( CacheConstants.MIAOSHA_GOODS_NUM,1);
            }


        }else {
            rspMap.put("rspCode","9999");
            rspMap.put("rspDesc","goods sales out");
        }
        processCount++;
        //logger.debug("@@@@@@@@@@@@" + processCount);
        return rspMap;
    }

    @Override
    public Map<String, Object> miaoshaMQ(final Map<String, Object> param) throws Exception {

        final Map<String,Object> rspMap = Maps.newHashMap();

        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(new ProducerRecord("miaosha",param));
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                handleSuccess(rspMap);
            }

            @Override
            public void onFailure(Throwable ex) {
                handleFailure(rspMap, ex);
            }

        });
        return rspMap;
    }

    private Map<String,Object> handleSuccess(Map<String, Object> param) {

        Map<String,Object> rspMap = Maps.newHashMap();
        rspMap.put("rspCode","0000");
        return rspMap;
    }

    private Map<String,Object> handleFailure(Map<String, Object> param,Throwable ex) {

        Map<String,Object> rspMap = Maps.newHashMap();
        rspMap.put("rspCode","9999");
        return rspMap;
    }


    //无缓存
//    @Override
//    public Map<String, Object> miaosha(Map<String, Object> param) throws Exception {
//
//
//        Map<String,Object> rspMap = Maps.newHashMap();
//        AttributeKvExample example = new AttributeKvExample();
//
//        example.createCriteria().andEntityIdEqualTo("1e9364deaf831d681140242ac110002").andAttributeKeyEqualTo("GOODS_NUM");
//        List<AttributeKv> list = kvMapper.selectByExample(example);
//
//        AttributeKv kv = list.get(0);
//        long num = kv.getLongV();
//        redisUtil.set(CacheConstants.MIAOSHA_GOODS_NUM,num);
//
//
//        if(num>0) {
//
//            //乐观锁
//            long numNew = num - 1;
//            kv.setLongV(numNew);
//            AttributeKvExample example2 = new AttributeKvExample();
//            example2.createCriteria().andEntityIdEqualTo("1e9364deaf831d681140242ac110002").andAttributeKeyEqualTo("GOODS_NUM")
//                    .andLongVEqualTo(num);
//
//            int count = kvMapper.updateByExampleSelective(kv,example2);
//
//            if(count>0) {
//                TsKv tsKv = new TsKv();
//                tsKv.setEntityId(UUIDConverter.fromTimeUUID(UUIDs.timeBased()));
//                tsKv.setEntityType("DEVICE");
//                tsKv.setKey("order");
//                tsKv.setTs(System.currentTimeMillis());
//                tsKv.setLongV(1l);
//                tsKvMapper.insert(tsKv);
//                rspMap.put("rspCode","0000");
//                rspMap.put("rspDesc","success");
//            }
//        }else {
//            rspMap.put("rspCode","9999");
//            rspMap.put("rspDesc","goods sales out");
//        }
//        processCount++;
//        //logger.debug("@@@@@@@@@@@@" + processCount);
//        return rspMap;
//    }
}
