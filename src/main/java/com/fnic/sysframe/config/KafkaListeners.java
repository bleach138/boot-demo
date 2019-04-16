package com.fnic.sysframe.config;

/**
 * Created by hjhuang on 2017/5/27.
 */
import com.fnic.bean.MessageBean;
import com.google.common.collect.Maps;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Optional;

public class KafkaListeners {

    @Resource
    private KafkaTemplate kafkaTemplate;

    @KafkaListener(topics = {"test"})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            System.out.println("listen1 " + message);
        }
    }

    @KafkaListener(topics = {"miaosha"})
    public void miaoshaListen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Map<String,Object> message = (Map<String,Object>) kafkaMessage.get();
            System.out.println("listen1 " + message);

            Map<String,Object> param = Maps.newHashMap();
            param.put("rspCode","9011");
            param.put("ts",message.get("ts"));
            kafkaTemplate.send(new ProducerRecord("miaoshaResponse",param));
        }
    }
}