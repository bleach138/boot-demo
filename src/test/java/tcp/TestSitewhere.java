package tcp;

import org.eclipse.paho.client.mqttv3.*;
import org.junit.Test;

public class TestSitewhere {

    @Test
    public void testMqttReg() throws Exception {
        MqttConnectOptions options = new MqttConnectOptions();
        // MQTT的连接设置
        options = new MqttConnectOptions();
        // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，设置为true表示每次连接到服务器都以新的身份连接
        options.setCleanSession(false);
        // 设置连接的用户名
        //options.setUserName("FN_YK_asdasdas");
        //options.setUserName("FN_YK_999999");
        //options.setUserName("DHT11_DEMO_TOKEN1234");
        options.setUserName("89860418231871144273");

        String clientId = MqttAsyncClient.generateClientId();
        MqttAsyncClient client = new MqttAsyncClient("tcp://192.168.33.169:1883", clientId);


        client.connect(options).waitForCompletion();

        //Thread.sleep(3000);
        MqttMessage message = new MqttMessage();
        String content2 = "{\"hardwareId\": \"123-TEST-4567890\",\"type\": \"RegisterDevice\", " +
                "\"request\": {\"hardwareId\": \"123-TEST-4567890\"," +
                "\"specificationToken\": \"ipad\"," +
                "\"siteToken\": \"peachtree\"}";

        message.setPayload(content2.getBytes());
        client.publish("SiteWhere/default/input/json", message);
        client.setCallback(new PushCallback());
        client.disconnect();
    }

    @Test
    public void testMqttUpdate() throws Exception {
        MqttConnectOptions options = new MqttConnectOptions();
        // MQTT的连接设置
        options = new MqttConnectOptions();
        // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，设置为true表示每次连接到服务器都以新的身份连接
        options.setCleanSession(false);
        // 设置连接的用户名
        //options.setUserName("FN_YK_asdasdas");
        //options.setUserName("FN_YK_999999");
        //options.setUserName("DHT11_DEMO_TOKEN1234");
        options.setUserName("89860418231871144273");

        String clientId = MqttAsyncClient.generateClientId();
        MqttAsyncClient client = new MqttAsyncClient("tcp://192.168.33.169:1883", clientId);


        client.connect(options).waitForCompletion();

        //Thread.sleep(3000);
        MqttMessage message = new MqttMessage();
        String content2 = "{\"hardwareId\": \"99419-MEGA2560-568766\",\"type\": \"DeviceMeasurements\", " +
                "\"request\": {\"measurements\": {"+
            "\"fuel.level\": 87.1," +
                "\"engine.temp\": 170" +
            "}," +
                "\"updateState\": true," +
            "\"eventDate\": \"2018-02-10T19:40:03.391Z\"}";

        message.setPayload(content2.getBytes());
        client.publish("SiteWhere/input/json", message);
        client.setCallback(new PushCallback());
        client.disconnect();
    }

    public class PushCallback implements MqttCallback {

        public void connectionLost(Throwable cause) {
            // 连接丢失后，一般在这里面进行重连
            System.out.println("连接断开，可以做重连");
        }

        public void deliveryComplete(IMqttDeliveryToken token) {
            System.out.println("deliveryComplete---------" + token.isComplete());
        }

        public void messageArrived(String topic, MqttMessage message) throws Exception {
            // subscribe后得到的消息会执行到这里面
            System.out.println("接收消息主题 : " + topic);
            System.out.println("接收消息Qos : " + message.getQos());
            System.out.println("接收消息内容 : " + new String(message.getPayload()));
        }
    }
}
