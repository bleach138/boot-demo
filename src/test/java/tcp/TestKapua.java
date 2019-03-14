package tcp;

import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.junit.Test;

public class TestKapua {

    @Test
    public void testPublish() throws Exception {
        MqttConnectOptions options = new MqttConnectOptions();
        // MQTT的连接设置
        options = new MqttConnectOptions();
        // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，设置为true表示每次连接到服务器都以新的身份连接
        options.setCleanSession(false);
        // 设置连接的用户名
        options.setUserName("kapua-broker");

        String password = "kapua-password" ;
        options.setPassword(password.toCharArray());
        String clientId = MqttAsyncClient.generateClientId();
        MqttAsyncClient client = new MqttAsyncClient("tcp://192.168.33.169:1883", clientId);
        client.connect(options).waitForCompletion();

        MqttMessage message = new MqttMessage();
        String content2 = "{\"metrics\":{\"key1\": \"xxxx\",\"key2\": \"555\"}}";

        message.setPayload(content2.getBytes());
        client.publish("t3/data", message);
        //Thread.sleep(50000);
        client.disconnect();
    }
}
