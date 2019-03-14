package com.fnic.service.impl;

import com.fnic.service.MQService;
import com.google.common.collect.Maps;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Optional;

@Service
public class MQServiceImpl implements MQService {

    @Resource
    private KafkaTemplate kafkaTemplate;

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


    @KafkaListener(topics = {"miaoshaResponse"})
    public void miaoshaResponseListen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Map<String,Object> message = (Map<String,Object>) kafkaMessage.get();
            System.out.println("miaoshaResponseListen: " + message);
        }
    }
}
