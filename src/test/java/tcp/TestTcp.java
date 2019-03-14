package tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.eclipse.paho.client.mqttv3.*;
import org.junit.Test;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;

public class TestTcp {

    private Socket socket = null;

    @Test
    public void test(){
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1",1887);
            OutputStream out = socket.getOutputStream();

            //out.write("0101011234".getBytes());
            //byte[] by = new Integer(101010);
            //out.write(intToBytes(101010));
            //out.write(new Integer(2).byteValue());
            //out.write("{\"attribute1\":\"value1\", \"attribute2\":true, \"attribute3\":42.0, \"attribute4\":173}\n".getBytes());


            ByteBuffer bBuf = ByteBuffer.allocate(40);
            bBuf.put("010101".getBytes());
            bBuf.put("1111".getBytes());
            bBuf.putShort((short) 4);
            bBuf.put("auth".getBytes());
            bBuf.put("01".getBytes());
            bBuf.putShort((short) 20);
            bBuf.put("QwFioGJrxYMa4ton1rpg".getBytes());

            StringBuffer buf = new StringBuffer();
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            System.out.println(buf.length());
            out.write(bBuf.array());
            //out.close();
            //out.flush();
            //socket.shutdownOutput();

            InputStream inputStream = socket.getInputStream();

            byte[] header = new byte[1024];
            int length = inputStream.read(header);

            for(int i=0;i<length;i++) {
                System.out.println("我是客户端，服务器说："+ header[i]);
            }

            System.out.println("我是客户端，服务器说："+ new String(header,0,length));


            bBuf = ByteBuffer.allocate(512);
            bBuf.put("010101".getBytes());
            bBuf.put("1111".getBytes());
            bBuf.putShort((short) 6);
            bBuf.put("update".getBytes());
            bBuf.put("01".getBytes());
            bBuf.putShort((short) 128);
            bBuf.putLong(1234);
            bBuf.put("02".getBytes());
            bBuf.putShort((short) 4);
            bBuf.put("aaaa".getBytes());
            out.write(bBuf.array());
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //@Before
    public void testConnect(){

        try {
            socket = new Socket("127.0.0.1",1887);
            OutputStream out = socket.getOutputStream();

            ByteBuffer bBuf = ByteBuffer.allocate(46);
            bBuf.put("010101".getBytes());
            bBuf.putShort((short) 32);
            bBuf.put("1111".getBytes());
            bBuf.putShort((short) 2);
            bBuf.put("01".getBytes());
            bBuf.put("01".getBytes());
            bBuf.putShort((short) 26);
            System.out.println("FN_YK_89860117750023551303".length());
            bBuf.put("FN_YK_89860117750023551303".getBytes());

            out.write(bBuf.array());
            //out.close();
            //out.flush();
            //socket.shutdownOutput();

            getSocketRsponse(socket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testHeartbeat(){
        try {
            OutputStream out = socket.getOutputStream();

            ByteBuffer bBuf = ByteBuffer.allocate(16);
            bBuf.put("010101".getBytes());
            bBuf.putShort((short) 8);
            bBuf.put("1111".getBytes());
            bBuf.putShort((short) 2);
            bBuf.put("02".getBytes());

            out.write(bBuf.array());

            getSocketRsponse(socket);

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getSocketRsponse(Socket socket) throws Exception {

        //while(true) {
            InputStream inputStream = socket.getInputStream();

            byte[] header = new byte[1024];
            int length = inputStream.read(header);

            for(int i=0;i<length;i++) {
                System.out.println("我是客户端，服务器说：" + header[i]);
                //System.out.print();
            }
        //}
    }

    @Test
    public void testPubilsh() {
        try {
            OutputStream out = socket.getOutputStream();

            ByteBuffer bBuf = ByteBuffer.allocate(43);
            bBuf.put("010101".getBytes());
            bBuf.putShort((short) 35);
            bBuf.put("1111".getBytes());
            bBuf.putShort((short) 2);
            bBuf.put("03".getBytes());

            bBuf.put("01".getBytes());
            bBuf.putShort((short) 4);
            bBuf.putLong(1234);
            bBuf.put("02".getBytes());
            bBuf.putShort((short) 4);
            bBuf.put("aaaa".getBytes());

            bBuf.put("03".getBytes());
            bBuf.putShort((short) 3);
            StringBuffer buf = new StringBuffer();
            buf.append("123");
            bBuf.put(buf.toString().getBytes());

            byte[] by = bBuf.array();

            for(byte b : by) {
                System.out.print(b);
            }
            //System.out.println(bBuf.array().length);
            out.write(bBuf.array());

            getSocketRsponse(socket);
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3(){
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1",1887);
            OutputStream out = socket.getOutputStream();

            ByteBuffer bBuf = ByteBuffer.allocate(2880);
            bBuf.put("010101".getBytes());
            bBuf.putShort((short) 2872);
            bBuf.put("1111".getBytes());
            bBuf.putShort((short) 6);
            bBuf.put("update".getBytes());
            bBuf.put("01".getBytes());
            bBuf.putShort((short) 128);
            bBuf.putLong(1234);
            bBuf.put("02".getBytes());
            bBuf.putShort((short) 4);
            bBuf.put("aaaa".getBytes());

            bBuf.put("03".getBytes());
            bBuf.putShort((short) 2835);
            StringBuffer buf = new StringBuffer();
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            buf.append("2daddsaefsjadlakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbb");
            System.out.println(buf.length());
            bBuf.put(buf.toString().getBytes());
            out.write(bBuf.array());
            //out.close();
            //out.flush();
            //socket.shutdownOutput();

            InputStream inputStream = socket.getInputStream();

            byte[] header = new byte[1024];
            int length = inputStream.read(header);

            for(int i=0;i<length;i++) {
                System.out.println("我是客户端，服务器说："+ header[i]);
            }
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public byte[] intToBytes( int value ) {
        byte[] src = new byte[4];
        src[0] = (byte) ((value>>24) & 0xFF);
        src[1] = (byte) ((value>>16)& 0xFF);
        src[2] = (byte) ((value>>8)&0xFF);
        src[3] = (byte) (value & 0xFF);
        return src;
    }

    @Test
    public void testByte() {
        String str = "101";
        int i1 = 128;

        System.out.println(str.getBytes());
        System.out.println((byte) 129);
    }

    @Test
    public void testLength() {

        ByteBuffer bBuf = ByteBuffer.allocate(512);
        bBuf.putShort((short) 128);
        bBuf.putShort((short) 128);
        bBuf.putShort((short) 127);
        bBuf.flip();
        int remainingLength = 0;
        int multiplier = 1;
        int loops = 0;

        System.out.println("缓冲区Pos：" + bBuf.position() + "  缓冲区Limit："
                + bBuf.limit());
        //System.out.println(bBuf.getShort());
        //System.out.println(bBuf.getShort());
        //System.out.println(bBuf.getShort());

        short digit;
        do {
            digit = bBuf.getShort();
            remainingLength += (digit & 127) * multiplier;
            multiplier *= 128;
            ++loops;
            System.out.println("loop:" + loops + "  " + remainingLength);
        } while((digit & 128) != 0 && loops < 4);
    }

    @Test
    public void testMqttPulish() throws Exception {
        MqttConnectOptions options = new MqttConnectOptions();
        // MQTT的连接设置
        options = new MqttConnectOptions();
        // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，设置为true表示每次连接到服务器都以新的身份连接
        options.setCleanSession(false);
        // 设置连接的用户名
        //options.setUserName("FN_YK_89860117750023553234");
//        options.setUserName("FN_YK_999999");
//        MqttAsyncClient client = new MqttAsyncClient("tcp://localhost:1885", "QwFioGJrxYMa4ton1rpg");

        options.setUserName("DHT11_DEMO_TOKEN1234");
        //MqttAsyncClient client = new MqttAsyncClient("tcp://117.8.229.22:1884", "QwFioGJrxYMa4ton1rpg");
        //MqttAsyncClient client = new MqttAsyncClient("tcp://192.168.33.167:1884", "111");
        MqttAsyncClient client = new MqttAsyncClient("tcp://112.64.32.250:1884", "111");

        client.connect(options);
        MqttMessage message = new MqttMessage();

        //error buffer length is too long
        ByteBuffer bBuf = ByteBuffer.allocate(512);
        bBuf.put("01".getBytes());
        bBuf.putShort((short) 128);
        bBuf.putLong(1234);
        bBuf.put("02".getBytes());
        bBuf.putShort((short) 4);
        bBuf.put("ssss".getBytes());

        message.setPayload(bBuf.array());
        client.publish("v1/devices/me/telemetry", message);
        Thread.sleep(6000);
        client.disconnect();
    }

    @Test
    public void testMqttPulish2() throws Exception {
        MqttConnectOptions options = new MqttConnectOptions();
        // MQTT的连接设置
        options = new MqttConnectOptions();
        // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，设置为true表示每次连接到服务器都以新的身份连接
        options.setCleanSession(false);
        // 设置连接的用户名
        //options.setUserName("FN_YK_asdasdas");
        //options.setUserName("FN_YK_999999");
        //options.setUserName("DHT11_DEMO_TOKEN1234");
        //options.setUserName("89860418231871144273");
        options.setUserName("12345609023");


        MqttAsyncClient client = new MqttAsyncClient("tcp://112.64.32.250:9001", "333");

//        MqttAsyncClient client = new MqttAsyncClient("tcp://112.64.32.250:1884", "QwFioGJrxYMa4ton1rpg");
        //MqttAsyncClient client = new MqttAsyncClient("tcp://192.168.33.167:1884", "QwFioGJrxYMa4ton1rpg");
        client.connect(options).waitForCompletion();

        //Thread.sleep(3000);
        MqttMessage message = new MqttMessage();
        //String content2 = "{\"key1\":\"sss\"}";
        String content2 = "{\"key6\":11}";

        message.setPayload(content2.getBytes());
        client.publish("v1/devices/me/attributes", message);
        client.disconnect();
    }

    @Test
    public void testMqttPulish3() throws Exception {
        MqttConnectOptions options = new MqttConnectOptions();
        // MQTT的连接设置
        options = new MqttConnectOptions();
        // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，设置为true表示每次连接到服务器都以新的身份连接
        options.setCleanSession(false);
        // 设置连接的用户名
        //options.setUserName("FN_YK_RRRRRRRRRRRRRRR");
        options.setUserName("DHT11_DEMO_TOKEN");
        //options.setUserName("FN_YK_999999");
        String clientId = MqttAsyncClient.generateClientId();
        MqttAsyncClient client = new MqttAsyncClient("tcp://localhost:1883", clientId);
        client.connect(options).waitForCompletion();

        MqttMessage message = new MqttMessage();
        String content2 = "{\"key1\": \"xxxx\",\"key2\": \"555\"}";

        message.setPayload(content2.getBytes());
        client.publish("v1/devices/me/telemetry", message);
        //Thread.sleep(50000);
        client.disconnect();
    }

    @Test
    public void testMqttSubscribeRequest() throws Exception {
        String clientId = MqttAsyncClient.generateClientId();
        MqttConnectOptions options = new MqttConnectOptions();
        // MQTT的连接设置
        options = new MqttConnectOptions();
        // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，设置为true表示每次连接到服务器都以新的身份连接
        options.setCleanSession(false);
        // 设置连接的用户名
        options.setUserName("FN_YK_89860117750023551303");
        MqttAsyncClient client = new MqttAsyncClient("tcp://192.168.33.167:1884", clientId);
        client.connect(options).waitForCompletion();

        client.subscribe("v1/devices/me/rpc/request/+", 1);
        client.setCallback(new TestMqttCallback(client));

        Thread.sleep(600000);
    }

    @Test
    public void testMqttSubscribeResponse() throws Exception {
        String clientId = MqttAsyncClient.generateClientId();
        MqttConnectOptions options = new MqttConnectOptions();
        // MQTT的连接设置
        options = new MqttConnectOptions();
        // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，设置为true表示每次连接到服务器都以新的身份连接
        options.setCleanSession(false);
        // 设置连接的用户名
        //options.setUserName("FN_YK_999999");
        options.setUserName("FN_YK_89860117750023553176");

        MqttAsyncClient client = new MqttAsyncClient("tcp://192.168.33.167:1884", clientId);
        client.connect(options).waitForCompletion();
        Thread.sleep(3000);

        int requestId = 1;
        String content = " {" +
                "\"method\": \"getTime\",\n" +
                "\"params\": {}\n" +
                "}";
        MqttMessage message = new MqttMessage();
        message.setPayload(content.getBytes());

        client.publish("v1/devices/me/rpc/request/"+ requestId,message);

        client.subscribe("v1/devices/me/rpc/response/+", 1);
        client.setCallback(new TestMqttCallback(client));


        Thread.sleep(60000);
    }

    private static class TestMqttCallback implements MqttCallback {

        private final MqttAsyncClient client;

        TestMqttCallback(MqttAsyncClient client) {
            this.client = client;
        }

        @Override
        public void connectionLost(Throwable throwable) {
        }

        @Override
        public void messageArrived(String requestTopic, MqttMessage mqttMessage) throws Exception {
            System.out.println("@@@@@@@@@@@@@@response " + new String(mqttMessage.getPayload()));
            MqttMessage message = new MqttMessage();
            String responseTopic = requestTopic.replace("request", "response");

//            String responseTopic = "v1/devices/me/rpc/response/1";
//            System.out.println("@@@@@@@@@@@@@@responseTopic:" + responseTopic);
//            message.setPayload("{\"value1\":\"A\", \"value2\":\"B\"}".getBytes());
//            client.publish(responseTopic, message);
        }

        @Override
        public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
            System.out.println("1111111111");
        }
    }

    @Test
    public void testMqttBrokerSubscribeResponse() throws Exception {
        String clientId = MqttAsyncClient.generateClientId();
        MqttConnectOptions options = new MqttConnectOptions();
        // MQTT的连接设置
        options = new MqttConnectOptions();
        // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，设置为true表示每次连接到服务器都以新的身份连接
        options.setCleanSession(false);
        // 设置连接的用户名
        //options.setUserName("FN_YK_999999");
        //options.setUserName("Q49tjLQpbB8GdG54IgWV");

        MqttAsyncClient client = new MqttAsyncClient("tcp://192.168.33.167:1883", clientId);
        client.connect(options).waitForCompletion();
        Thread.sleep(3000);

        int requestId = 1;
        String content = "{\"serialNumber\":\"SN-002\", \"model\":\"T1000\", \"temperature\":36.6}";
        String device = "SN-002";
        MqttMessage message = new MqttMessage();
        message.setPayload(content.getBytes());
        client.publish("sensor/" + device + "/connect", message);
        client.subscribe("sensor/" + device + "/request/+/+", 1);
        client.setCallback(new TestMqttCallback(client));


        Thread.sleep(60000);
    }

    @Test
    public void testMqttBrokerPublish() throws Exception {
        String clientId = MqttAsyncClient.generateClientId();
        MqttConnectOptions options = new MqttConnectOptions();
        // MQTT的连接设置
        options = new MqttConnectOptions();
        // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，设置为true表示每次连接到服务器都以新的身份连接
        options.setCleanSession(false);
        // 设置连接的用户名
        //options.setUserName("FN_YK_999999");
        //options.setUserName("Q49tjLQpbB8GdG54IgWV");

        MqttAsyncClient client = new MqttAsyncClient("tcp://192.168.33.167:1883", clientId);
        client.connect(options).waitForCompletion();
        Thread.sleep(3000);

        int requestId = 1;
        String content = "{\"serialNumber\":\"SN-002\", \"model\":\"T1000\", \"temperature\":36.6}";
        String device = "Temp Sensor2";
        MqttMessage message = new MqttMessage();
        message.setPayload(content.getBytes());

        client.publish("sensors", message);
    }

    @Test
    public void testGatewaySubscribeResponse() throws Exception {
        String clientId = MqttAsyncClient.generateClientId();
        MqttConnectOptions options = new MqttConnectOptions();
        // MQTT的连接设置
        options = new MqttConnectOptions();
        // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，设置为true表示每次连接到服务器都以新的身份连接
        options.setCleanSession(false);
        // 设置连接的用户名
        //options.setUserName("FN_YK_999999");
        options.setUserName("uHc4A6msJrLP2m7tEzr1");

        MqttAsyncClient client = new MqttAsyncClient("tcp://127.0.0.1:1884", clientId);
        client.connect(options).waitForCompletion();
        Thread.sleep(3000);

        int requestId = 1;
        String content = " {" +
                "\"device\": \"SN-002\"\n" +
                "}";
        //String content = "";
        MqttMessage message = new MqttMessage();
        message.setPayload(content.getBytes());
        client.publish("v1/gateway/connect", message);

        client.subscribe("v1/gateway/rpc/+", 1);
        client.setCallback(new TestMqttCallback(client));


        Thread.sleep(60000);
    }

    @Test
    public void test2() {
        System.out.println(("48" +
                "49484948490248490").length());
    }

    @Test
    public void tranChar() throws Exception {
        ByteBuf buf = Unpooled.buffer();
//        buf.writeByte(-95);
//        buf.writeByte(-66);
//        buf.writeByte(50);
//        buf.writeByte(48);
//        buf.writeByte(49);
//        buf.writeByte(56);
//        buf.writeByte(45);
//        buf.writeByte(48);
//        buf.writeByte(56);
//        buf.writeByte(45);
//        buf.writeByte(50);
//        buf.writeByte(55);
//        buf.writeByte(32);
//        buf.writeByte(49);
//        buf.writeByte(53);
//        buf.writeByte(58);
//        buf.writeByte(48);
//        buf.writeByte(54);
//        buf.writeByte(58);
//        buf.writeByte(51);
//        buf.writeByte(50);
//        buf.writeByte(58);
//        buf.writeByte(57);
//        buf.writeByte(50);
//        buf.writeByte(57);
//        buf.writeByte(-95);
//        buf.writeByte(-65);

        buf.writeByte(43);
        buf.writeByte(78);
        buf.writeByte(86);
        buf.writeByte(110);
        buf.writeByte(58);
        buf.writeByte(49);
        buf.writeByte(51);
        //13754
        //13654
        //13644
        buf.writeByte(54);
        buf.writeByte(53);
        buf.writeByte(53);

        buf.writeByte(44);
        buf.writeByte(49);
        buf.writeByte(44);
        buf.writeByte(49);
        buf.writeByte(44);
        buf.writeByte(51);

        buf.writeByte(13);
        buf.writeByte(10);

        byte[] b = new byte[18];
        try {
            System.out.println("#### " + buf.writerIndex());
            for(int i=0;i<buf.writerIndex();i++) {
                //System.out.print(" " + buf.readChar());
                b[i] = buf.readByte();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        String s = new String (b,"ascii");
        System.out.println(s);

        String[] s1 = s.substring(s.indexOf(":") + 1).split(",");

        for(String temp : s1) {
            System.out.println(temp);
        }
        System.out.println("@@@@@@@@" + s1[3].indexOf("\r\n"));


        char c = '+';
        System.out.println((byte) c);
    }

    @Test
    public void tranDeji() throws Exception {

        socket = new Socket("127.0.0.1",8081);

        ByteBuf buf = Unpooled.buffer(18);

        buf.writeByte(43);
        buf.writeByte(78);
        buf.writeByte(86);
        buf.writeByte(110);
        buf.writeByte(58);
        buf.writeByte(49);
        buf.writeByte(51);

        buf.writeByte(54);
        buf.writeByte(53);
        buf.writeByte(52);

        buf.writeByte(44);
        buf.writeByte(49);
        buf.writeByte(44);
        buf.writeByte(49);

        buf.writeByte(44);
        buf.writeByte(51);

        buf.writeByte(13);
        buf.writeByte(10);

        ByteBuf buf2 = Unpooled.buffer(18);

        buf2.writeByte(43);
        buf2.writeByte(78);
        buf2.writeByte(86);
        buf2.writeByte(110);
        buf2.writeByte(58);
        buf2.writeByte(49);
        buf2.writeByte(51);

        buf2.writeByte(54);
        buf2.writeByte(53);
        buf2.writeByte(53);

        buf2.writeByte(44);
        buf2.writeByte(49);
        buf2.writeByte(44);
        buf2.writeByte(49);
        buf2.writeByte(44);
        buf2.writeByte(50);

        buf2.writeByte(13);
        buf2.writeByte(10);

        OutputStream output = socket.getOutputStream();
        output.write(buf.array());
        Thread.sleep(1000);
        output.write(buf.array());
        Thread.sleep(1000);
        output.write(buf.array());
        Thread.sleep(1000);
        output.write(buf.array());
        Thread.sleep(1000);
        output.write(buf.array());
        Thread.sleep(1000);

//        socket = new Socket("127.0.0.1",8081);
//        output = socket.getOutputStream();
//        output.write(buf.array());
//        Thread.sleep(100);
//
//        socket = new Socket("127.0.0.1",8081);
//        output = socket.getOutputStream();
//        output.write(buf.array());
//        Thread.sleep(100);
//
//        socket = new Socket("127.0.0.1",8081);
//        output = socket.getOutputStream();
//        output.write(buf.array());
//        Thread.sleep(100);
//
//        socket = new Socket("127.0.0.1",8081);
//        output = socket.getOutputStream();
//        output.write(buf.array());
//        Thread.sleep(1000);
//
//        socket = new Socket("127.0.0.1",8081);
//        output = socket.getOutputStream();
//        output.write(buf.array());
//        Thread.sleep(100);
//
//        socket = new Socket("127.0.0.1",8081);
//        output = socket.getOutputStream();
//        output.write(buf.array());
//        Thread.sleep(100);
//
//        socket = new Socket("127.0.0.1",8081);
//        output = socket.getOutputStream();
//        output.write(buf.array());

    }

    @Test
    public void tranDeji2() throws Exception {

        socket = new Socket("127.0.0.1",8081);

        ByteBuf buf = Unpooled.buffer(18);

        buf.writeByte(43);
        buf.writeByte(78);
        buf.writeByte(86);
        buf.writeByte(110);
        buf.writeByte(58);
        buf.writeByte(49);
        buf.writeByte(51);

        buf.writeByte(54);
        buf.writeByte(53);
        buf.writeByte(52);

        buf.writeByte(44);
        buf.writeByte(49);
        buf.writeByte(44);
        buf.writeByte(49);

        buf.writeByte(44);
        buf.writeByte(51);

        buf.writeByte(13);
        buf.writeByte(10);

        ByteBuf buf2 = Unpooled.buffer(18);

        buf2.writeByte(43);
        buf2.writeByte(78);
        buf2.writeByte(86);
        buf2.writeByte(110);
        buf2.writeByte(58);
        buf2.writeByte(49);
        buf2.writeByte(51);

        buf2.writeByte(54);
        buf2.writeByte(53);
        buf2.writeByte(53);

        buf2.writeByte(44);
        buf2.writeByte(49);
        buf2.writeByte(44);
        buf2.writeByte(49);
        buf2.writeByte(44);
        buf2.writeByte(50);

        buf2.writeByte(13);
        buf2.writeByte(10);

        OutputStream output = socket.getOutputStream();
        output.write(buf.array());
        Thread.sleep(1000);
        output.write(buf.array());
        Thread.sleep(1000);
        output.write(buf.array());
        Thread.sleep(1000);
        output.write(buf.array());
        Thread.sleep(1000);
        output.write(buf.array());
        Thread.sleep(1000);

        socket = new Socket("127.0.0.1",8081);
        output = socket.getOutputStream();
        output.write(buf.array());
        Thread.sleep(1000);
        output.write(buf.array());
        Thread.sleep(1000);
        output.write(buf.array());
        Thread.sleep(1000);

        socket = new Socket("127.0.0.1",8081);
        output = socket.getOutputStream();
        output.write(buf.array());
        Thread.sleep(1000);
        output.write(buf.array());
        Thread.sleep(1000);
        output.write(buf.array());
        Thread.sleep(1000);
        output.write(buf.array());
        Thread.sleep(1000);
//
//        socket = new Socket("127.0.0.1",8081);
//        output = socket.getOutputStream();
//        output.write(buf.array());
//        Thread.sleep(100);
//
//        socket = new Socket("127.0.0.1",8081);
//        output = socket.getOutputStream();
//        output.write(buf.array());
//        Thread.sleep(1000);
//
//        socket = new Socket("127.0.0.1",8081);
//        output = socket.getOutputStream();
//        output.write(buf.array());
//        Thread.sleep(100);
//
//        socket = new Socket("127.0.0.1",8081);
//        output = socket.getOutputStream();
//        output.write(buf.array());
//        Thread.sleep(100);
//
//        socket = new Socket("127.0.0.1",8081);
//        output = socket.getOutputStream();
//        output.write(buf.array());

    }

    @Test
    public void testString() {
        String str = "xV412345678901";

        System.out.print(str.substring(0,2));
    }

    @Test
    public void testElevator() {

        byte b1 = (byte) 0xfdee;
        System.out.println(b1);

//        byte[] bytes = new byte[] {(byte) 0xfdee};
//
//        String str = new String(bytes);
//        System.out.println(str);

        ByteBuf buf = Unpooled.buffer(2);

        buf.writeByte(0x44);
        buf.writeByte(0x60);

        System.out.println(buf.readShort());

//        buf.writeShort(9311);
//        byte[] by = new byte[2];
//        buf.readBytes(by);
//        for(byte temp : by) {
//            System.out.println(Integer.toHexString(temp));
//        }

//        short number = 9311;
//        byte[] by = new byte[2];
//        by[0] = (byte) (number >> 8 & 0xff);
//        by[1] = (byte) (number & 0xff);

        int number = 20;
        byte[] by = new byte[2];
        by[0] = (byte) (number & 0xff);
        by[1] = (byte) (number >> 8 & 0xff);

        for(byte temp : by) {
            System.out.println(Integer.toHexString(temp));
        }

        System.out.println(by[0] & 0xFF | (by[1] & 0xFF) << 8) ;
    }

    @Test
    public void testStr() {
        ByteBuf buf = Unpooled.buffer();
        buf.writeByte(0x21);
        buf.writeByte(0x43);
        buf.writeByte(0x65);
        buf.writeByte(0x87);
        buf.writeByte(0x31);
        buf.writeByte(0x32);
        buf.writeByte(0x33);
        buf.writeByte(0x34);
        buf.writeByte(0x35);
        buf.writeByte(0x36);
        buf.writeByte(0x37);
        buf.writeByte(0x38);
        buf.writeByte(0x39);
        buf.writeByte(0x30);
        buf.writeByte(0x32);
        buf.writeByte(0x00);
        buf.writeByte(0x0A);
        buf.writeByte(0x67);
        buf.writeByte(0x87);
        buf.writeByte(0xA6);
        buf.writeByte(0x00);

        byte[] by = new byte[21];
        buf.readBytes(by);
        String str = new String(by);
        System.out.println(str.indexOf("\n"));
        System.out.println(str.substring(4,str.indexOf("\n")-1));
    }

    @Test
    public void testFCS() {
//        ByteBuf bBuf = Unpooled.buffer(34);

//        bBuf.writeByte((byte) ( 0x1f));
//
//        bBuf.writeByte((byte) ( 0x44));
//        bBuf.writeByte((byte) ( 0x5f));
//
//        bBuf.writeByte((byte) ( 0x00));
//        bBuf.writeByte((byte) ( 0x00));
//
//        bBuf.writeByte((byte) ( 0x01));
//        bBuf.writeByte((byte) ( 0x03));
//        bBuf.writeByte((byte) ( 0x18));
//        bBuf.writeByte((byte) ( 0x42));
//        bBuf.writeByte((byte) ( 0x33));
//        bBuf.writeByte((byte) ( 0x00));
//        bBuf.writeByte((byte) ( 0x00));
//        bBuf.writeByte((byte) ( 0x00));
//        bBuf.writeByte((byte) ( 0x00));
//        bBuf.writeByte((byte) ( 0x00));
//        bBuf.writeByte((byte) ( 0x00));
//        bBuf.writeByte((byte) ( 0x00));
//        bBuf.writeByte((byte) ( 0x00));
//        bBuf.writeByte((byte) ( 0x00));
//        bBuf.writeByte((byte) ( 0x00));
//        bBuf.writeByte((byte) ( 0x00));
//        bBuf.writeByte((byte) ( 0x00));
//        bBuf.writeByte((byte) ( 0x00));
//        bBuf.writeByte((byte) ( 0x00));
//        bBuf.writeByte((byte) ( 0x00));
//        bBuf.writeByte((byte) ( 0x00));
//        bBuf.writeByte((byte) ( 0x00));
//        bBuf.writeByte((byte) ( 0x00));
//        bBuf.writeByte((byte) ( 0x00));
//        bBuf.writeByte((byte) ( 0x01));
//        bBuf.writeByte((byte) ( 0x00));
//        bBuf.writeByte((byte) ( 0x02));
//        bBuf.writeByte((byte) ( 0x34));
//        bBuf.writeByte((byte) ( 0xb8));
//
//        byte[] by = new byte[34];

        ByteBuf bBuf = Unpooled.buffer(13);
        bBuf.writeByte((byte) ( 0x0A));
        bBuf.writeByte((byte) ( 0x24));
        bBuf.writeByte((byte) ( 0x5f));
        bBuf.writeByte((byte) ( 0x00));
        bBuf.writeByte((byte) ( 0x00));
        bBuf.writeByte((byte) ( 0x01));
        bBuf.writeByte((byte) ( 0x03));
        bBuf.writeByte((byte) ( 0x00));
        bBuf.writeByte((byte) ( 0x00));
        bBuf.writeByte((byte) ( 0x00));
        bBuf.writeByte((byte) ( 0x0C));
        bBuf.writeByte((byte) ( 0x45));
        bBuf.writeByte((byte) ( 0xCF));
        byte[] by = new byte[13];
        bBuf.readBytes(by);
        System.out.println();
        int number = 0;
        for(byte temp : by) {
            number ^= temp;
        }

        System.out.println(number);
        System.out.println(Integer.toHexString(number));
        System.out.println((byte) number);
    }

    @Test
    public void testByteToStr() {

        try {
            byte[] by = new byte[] {0x31,0x36};

            long floor = 0;

            if(by[0] == 0x42) {
                floor = -(by[1] - '0');
            }else if(by[0] == 0x00) {
                floor = by[1] - '0' ;
            }else if(by[0] >= '0' && by[0] <= '9' ) {
                floor = (by[0] - '0')* 10 + by[1] - '0';
            }

            System.out.println(floor);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testByteToChar() {


        byte[] by = new byte[14];
        by[0] = 10;

        short number = 9311;
        by[1] = (byte) (number >> 8 & 0xff);
        by[2] = (byte) (number & 0xff);

        int address = 0;
        by[3] = (byte) (address & 0xff);
        by[4] = (byte) (address >> 8 & 0xff);

        by[5] = 0x01;
        by[6] = 0x03;
        by[7] = 0x00;
        by[8] = 0x00;
        by[9] = 0x00;
        by[10] = 0x0C;
        by[11] = 0x45;
        by[12] = 0x11;

        byte b = (byte) (-13 & 0xff);
        System.out.println(b);
        System.out.println((char) 0x39);
    }
}
