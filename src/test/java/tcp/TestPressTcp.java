package tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPressTcp {

    @Test
    public void test() throws Exception {

        //final String host = "192.168.33.168";
        final String host = "127.0.0.1";
        final int port = 8082;

        for(int i=0;i<10;i++) {
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

                    ExecutorService executors = Executors.newFixedThreadPool(10);
                    while(true)
                    {
                        try {
                            getElevatorRsponse2(address,sc,executors);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        Thread.sleep(360000000l);
    }

    private void getElevatorRsponse2(String gwAddress,Socket socket,ExecutorService executors) throws Exception {

        // while(true) {
        InputStream inputStream = socket.getInputStream();
        if(inputStream != null) {
            byte[] body = new byte[10];
            int length = inputStream.read(body);

            executors.execute( () -> {
                try {
                    final int address = body[5]  & 0xff;
                    System.out.println("address:" + gwAddress + " lora: " + address);
                    OutputStream out = socket.getOutputStream();
                    ByteBuf bBuf = Unpooled.buffer(12);
                    bBuf.writeByte(transToByte(0xfd));
                    bBuf.writeByte(transToByte( 0xee));

                    bBuf.writeByte(transToByte( 0x06));

                    bBuf.writeByte(transToByte( 0x44));
                    bBuf.writeByte(transToByte( 0x5e));

                    bBuf.writeByte(transToByte( address));
                    bBuf.writeByte(transToByte( 0x00));

                    //报错
                    //bBuf.writeByte(transToByte( 0x03));
                    bBuf.writeByte(transToByte( address));

                    bBuf.writeByte(transToByte( 0x01));

                    bBuf.writeByte(transToByte( 0x00));
                    bBuf.writeByte((int) (1+Math.random()*(10-1+1)));

                    bBuf.writeByte(transToByte( 0x8d));

                    out.write(bBuf.array());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

//        for(int i=0;i<length;i++) {
//            System.out.print(Integer.toHexString(body[i] & 0xff ));
//        }
//        System.out.println();



    }

//    private void getElevatorRsponse2(Socket socket,ExecutorService executors) throws Exception {
//
//        // while(true) {
//        InputStream inputStream = socket.getInputStream();
//
//        byte[] body = new byte[10];
//        int length = inputStream.read(body);
//
//        for(int i=0;i<length;i++) {
//            System.out.print(Integer.toHexString(body[i] & 0xff ));
//        }
//        System.out.println();
//        for(int i=1;i<10;i++) {
//            final int address = i;
//            executors.execute( () -> {
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
//                            //报错
//                            //bBuf.writeByte(transToByte( 0x03));
//                            bBuf.writeByte(transToByte( address));
//
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

    @Test
    public void testInt() {
        int i = 1000;
        byte[] by = intToBytes2(i);
        for(byte b:by) {
            System.out.println(b);
        }
    }


    @Test
    public void testString() {
        int i=999;
        i+= 9009;
//        String str = "12345609011";
        String str = "123456" + String.format("%05d",i);
        System.out.println(str);

        byte[] by = str.getBytes();
        for(byte b:by) {
            System.out.println(b);
        }
    }

    public byte[] intToBytes2(int value) {
        byte[] src = new byte[4];
        src[0] = (byte) ((value >> 24) & 0xFF);
        src[1] = (byte) ((value >> 16) & 0xFF);
        src[2] = (byte) ((value >> 8) & 0xFF);
        src[3] = (byte) (value & 0xFF);
        return src;
    }

    @Test
    public void testRadom() {

        System.out.println((int)(1+Math.random()*(255-1+1)));
        long value = 12345600001l;
        String token = String.valueOf(value);
        System.out.println(token);

    }

    @Test
    public void testMqtt() throws Exception {

        final String host = "tcp://192.168.33.168:1884";
//        final String host = "tcp://127.0.0.1:1884";

        ExecutorService executor = Executors.newFixedThreadPool(1);

        for(int i=1;i<2;i++) {
            final int j = i;
            executor.execute( () -> {
                String token = "123456" + String.format("%05d",j);
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
                    String content = "{\"key1\":" +  Math.random() + "}";
                    message.setPayload(content.getBytes());
                    client.connect(options).waitForCompletion();

                    while(true) {
                        client.publish("v1/devices/me/telemetry", message);
                        Thread.sleep(6000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            //12345600001

            //client.disconnect();
        }

        Thread.sleep(600000);
    }

    @Test
    public void testMqtt2() throws Exception {

        final String host = "tcp://192.168.33.168:1884";
//        final String host = "tcp://127.0.0.1:1884";

        ExecutorService executor = Executors.newFixedThreadPool(100);

        int i = 1;
        while(true) {
            final int j = i;
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

    @Test
    public void testMqttPressAttr() {

        int num = 10;
        //final String host = "tcp://192.168.33.168:1884";
        //final String host = "tcp://112.64.32.192:9001";
        final String host = "tcp://218.98.16.76:1883";
        ExecutorService executor = Executors.newFixedThreadPool(num);

        for(int i=1;i<num;i++) {
            final int j = i;
            executor.execute(() -> {
                long value = j + 12345610008l;
                String token = String.valueOf(value);
                MqttConnectOptions options = new MqttConnectOptions();
                // MQTT的连接设置
                options = new MqttConnectOptions();
                // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，设置为true表示每次连接到服务器都以新的身份连接
                //options.setCleanSession(false);
                options.setKeepAliveInterval(600);
                // 设置连接的用户名
                options.setUserName(token);
                String clientId = MqttAsyncClient.generateClientId();
                MqttAsyncClient client = null;
                try {
                    client = new MqttAsyncClient(host, clientId);

                    MqttMessage message = new MqttMessage();
                    String content = "{\"key5\":" + Math.random() + "}";
                    message.setPayload(content.getBytes());
                    client.connect(options).waitForCompletion();

                    while (true) {
                        client.publish("v1/devices/me/attributes", message.getPayload(),1,false);
                        Thread.sleep(6000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
