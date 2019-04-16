package edge;

import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.junit.Test;

public class TestMqtt {

    @Test
    public void testMqttPulish() throws Exception {
        MqttConnectOptions options = new MqttConnectOptions();
        // MQTT的连接设置
        options = new MqttConnectOptions();
        // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，设置为true表示每次连接到服务器都以新的身份连接
        options.setCleanSession(false);
        // 设置连接的用户名
        options.setUserName("test");
        options.setPassword("dba42c5b66104220a3371b3cc58860a7".toCharArray());

        MqttAsyncClient client = new MqttAsyncClient("tcp://47.110.34.29:1883", "333");

//        MqttAsyncClient client = new MqttAsyncClient("tcp://112.64.32.250:1884", "QwFioGJrxYMa4ton1rpg");
        //MqttAsyncClient client = new MqttAsyncClient("tcp://192.168.33.167:1884", "QwFioGJrxYMa4ton1rpg");
        client.connect(options).waitForCompletion();

        //Thread.sleep(3000);
        MqttMessage message = new MqttMessage();
        //String content2 = "{\"key1\":\"sss\"}";
        String content2 = "{\"key6\":11}";

        message.setPayload(content2.getBytes());
        client.publish("hi2", message);
        client.disconnect();
    }
}

