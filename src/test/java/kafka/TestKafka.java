package kafka;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsResult;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.*;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

public class TestKafka {

    private Properties props = new Properties();
    private Properties consumerProps = new Properties();
    private String topic = "test-topic2";

    @Before
    public void init () {
        //broker地址
        //props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.33.167:9092,192.168.33.167:9093,192.168.33.167:9094");
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.33.167:9092");

        /*消息持久性，关系到producer吞吐量和消息持久性
            0 不关心broker处理结果
            1 只关心leader broker处理结果
            all leader broker和所有副本都成功以后才发送响应结果
         */

        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.DELIVERY_TIMEOUT_MS_CONFIG, 60000);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");


        consumerProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.33.167:9092,192.168.33.167:9093,192.168.33.167:9094");
        consumerProps.put(ConsumerConfig.GROUP_ID_CONFIG, "test3");
        consumerProps.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        consumerProps.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        consumerProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        consumerProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
    }

    @Test
    public void createTopic() {
        try {
            AdminClient admin = AdminClient.create(props);
            NewTopic newTopic = new NewTopic(topic, 3, (short) 3);
            CreateTopicsResult result = admin.createTopics(Collections.singletonList(newTopic));
            result.all().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sendMessage() {

        Producer<String, String> producer = new KafkaProducer<>(props);
        ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, "test12345", "test");
        producer.send(record,new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception e) {
                // TODO Auto-generated method stub
                if (e != null)
                    System.out.println("the producer has a error:"
                            + e.getMessage());
                else {
                    System.out .println("The offset of the record we just sent is: "
                                    + metadata.offset());
                    System.out.println("The partition of the record we just sent is: "
                                    + metadata.partition());
                }
            }
        });

        producer.close();
    }

    @Test
    public void consumeMessage() {

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(consumerProps);
        consumer.subscribe(Arrays.asList(topic));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(10000));
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("@@@@@@@@@@@@@@@offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
        }

    }

    @Test
    public void consumeMessage2() {
        Properties consumerProps = new Properties();
        consumerProps.put("bootstrap.servers", "192.168.33.167:9092,192.168.33.167:9093,192.168.33.167:9094");
        consumerProps.put("group.id", "test3");
        consumerProps.put("enable.auto.commit", "true");
        consumerProps.put("auto.commit.interval.ms", "1000");
        consumerProps.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumerProps.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(consumerProps);
        consumer.subscribe(Arrays.asList(topic));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(10000));
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("@@@@@@@@@@@@@@@offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
        }

    }

}
