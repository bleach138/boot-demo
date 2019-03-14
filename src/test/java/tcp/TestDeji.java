package tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestDeji {

    private Socket socket = null;

    @Test
    public void testElevator() throws Exception {
        //socket = new Socket("192.168.33.168",8082);
        socket = new Socket("127.0.0.1",8082);
        OutputStream out = socket.getOutputStream();

        //String token = "12345609009";
        String token = "FNDJ8900001";
        ByteBuf buf = Unpooled.buffer(25);
//        buf.writeByte(0x21);
//        buf.writeByte(0x43);
//        buf.writeByte(0x65);
//        buf.writeByte(0x87);
//        buf.writeByte(0x31);
//        buf.writeByte(0x32);
//        buf.writeByte(0x33);
//        buf.writeByte(0x34);
//        buf.writeByte(0x35);
//        buf.writeByte(0x36);
//        buf.writeByte(0x37);
//        buf.writeByte(0x38);
//        buf.writeByte(0x39);
//        buf.writeByte(0x30);
//        buf.writeByte(0x32);
//        buf.writeByte(0x00);
//        buf.writeByte(0x0A);
//        buf.writeByte(0x67);
//        buf.writeByte(0x87);
//        buf.writeByte(0xA6);
//        buf.writeByte(0x00);


        buf.writeByte(0x21);
        buf.writeByte(0x43);
        buf.writeByte(0x65);
        buf.writeByte(0x87);

        buf.writeBytes(token.getBytes());
//        buf.writeByte(0x31);
//        buf.writeByte(0x32);
//        buf.writeByte(0x33);
//        buf.writeByte(0x34);
//        buf.writeByte(0x35);
//        buf.writeByte(0x36);
//        buf.writeByte(0x37);
//        buf.writeByte(0x38);
//        buf.writeByte(0x39);
//        buf.writeByte(0x30);
//        buf.writeByte(0x32);

        buf.writeByte(0x00);
        buf.writeByte(0xC0);
        buf.writeByte(0xA8);
        buf.writeByte(0x01);
        buf.writeByte(0x74);
        buf.writeByte(0x00);


        buf.writeByte(0x21);
        buf.writeByte(0x43);

        buf.writeByte(0x65);
        buf.writeByte(0x87);
          //12345678901
//        buf.writeByte(0x21);
//        buf.writeByte(0x43);
//
//        buf.writeByte(0x65);
//        buf.writeByte(0x87);
//
//        buf.writeByte(0x31);
//        buf.writeByte(0x32);
//        buf.writeByte(0x33);
//        buf.writeByte(0x34);
//        buf.writeByte(0x35);
//        buf.writeByte(0x36);
//        buf.writeByte(0x37);
//        buf.writeByte(0x38);
//        buf.writeByte(0x39);
//        buf.writeByte(0x30);
//        buf.writeByte(0x31);
//        buf.writeByte(0x00);
//        buf.writeByte(0xC0);
//        buf.writeByte(0xA8);
//        buf.writeByte(0x01);
//        buf.writeByte(0x74);
//        buf.writeByte(0x00);

        out.write(buf.array());

//        while(true)
//        {
            try {
                getElevatorRsponse(socket);
            } catch (Exception e) {
                e.printStackTrace();
            }
//        }
    }

    private void getElevatorRsponse(Socket socket) throws Exception {

        // while(true) {
        int j =0;
        while(true) {
            InputStream inputStream = socket.getInputStream();

            byte[] body = new byte[1024];
            int length = inputStream.read(body);
            System.out.println("############: "  + j++);
            for(int i=0;i<length;i++) {

                System.out.println("@@@@@@@@@@: " + Integer.toHexString(body[i] & 0xff ));
            }
        }


        //sendMesaage(socket);
        //sendSensorMesaage(socket);
        //sendXundaMesaage(socket);
        //sendDisenElevatorMesaage(socket);
        //sendDisenEscalatorMesaage(socket);
    }

    public void sendDisenElevatorMesaage(Socket socket) throws Exception {
        OutputStream out = socket.getOutputStream();

//        fd ee 帧头
//        1f 长度
//        44 5f 命令域
//        00 00 地址
//        01 03 18 42 33 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 01 00 02 34 b8
//        e0 异或和


//        长度 = 1 + MODBUS总长度
//        29+1+1
        ByteBuf bBuf = Unpooled.buffer(37);
        bBuf.writeByte(transToByte(0xfd));
        bBuf.writeByte(transToByte( 0xee));

        bBuf.writeByte(transToByte( 0x1f));

        bBuf.writeByte(transToByte( 0x44));
        bBuf.writeByte(transToByte( 0x5f));

        bBuf.writeByte(transToByte( 0x00));
        bBuf.writeByte(transToByte( 0x00));

        bBuf.writeByte(transToByte( 0x00));
        bBuf.writeByte(transToByte( 0x03));
        bBuf.writeByte(transToByte( 0x18));
        bBuf.writeByte(transToByte( 0x42));
        bBuf.writeByte(transToByte( 0x33));
        bBuf.writeByte(transToByte( 0x01));
        bBuf.writeByte(transToByte( 0x00));
        bBuf.writeByte(transToByte( 0x00));
        bBuf.writeByte(transToByte( 0x00));
        bBuf.writeByte(transToByte( 0x00));
        bBuf.writeByte(transToByte( 0x00));
        bBuf.writeByte(transToByte( 0x00));
        bBuf.writeByte(transToByte( 0x00));
        bBuf.writeByte(transToByte( 0x00));
        bBuf.writeByte(transToByte( 0x00));
        bBuf.writeByte(transToByte( 0x00));
        bBuf.writeByte(transToByte( 0x00));
        bBuf.writeByte(transToByte( 0x00));
        bBuf.writeByte(transToByte( 0x00));
        bBuf.writeByte(transToByte( 0x00));
        bBuf.writeByte(transToByte( 0x00));
        bBuf.writeByte(transToByte( 0x00));

        bBuf.writeByte((int) (Math.random()*(20-1+1)));

        bBuf.writeByte(transToByte( 0x00));
        bBuf.writeByte(transToByte( 0x01));
        bBuf.writeByte(transToByte( 0x00));
        bBuf.writeByte(transToByte( 0x02));
        bBuf.writeByte(transToByte( 0x34));
        bBuf.writeByte(transToByte( 0xb3));

        bBuf.writeByte(transToByte( 0xe0));

        out.write(bBuf.array());
    }

    public void sendSensorMesaage(Socket socket) throws Exception {
        OutputStream out = socket.getOutputStream();

        ByteBuf bBuf = Unpooled.buffer(12);
        bBuf.writeByte(transToByte(0xfd));
        bBuf.writeByte(transToByte( 0xee));

        bBuf.writeByte(transToByte( 0x06));

        bBuf.writeByte(transToByte( 0x44));
        bBuf.writeByte(transToByte( 0x5e));

//        bBuf.writeByte(transToByte( 0x00));
//        bBuf.writeByte(transToByte( 0x00));
//        bBuf.writeByte(transToByte( 0x00));
//        bBuf.writeByte(transToByte( 0x01));
//        bBuf.writeByte(transToByte( 0x00));

        bBuf.writeByte(transToByte( 0x01));
        bBuf.writeByte(transToByte( 0x00));
        bBuf.writeByte(transToByte( 0x01));
        bBuf.writeByte(transToByte( 0x01));
        bBuf.writeByte(transToByte( 0x00));
        bBuf.writeByte((int) (Math.random()*(20-1+1)));
        //bBuf.writeByte(transToByte( 0x28));

//        bBuf.writeByte(transToByte( 0x10));
//        bBuf.writeByte(transToByte( 0x0e));
//        bBuf.writeByte(transToByte( 0x03));
//        bBuf.writeByte(transToByte( 0x01));
//        bBuf.writeByte(transToByte( 0x83));
//        bBuf.writeByte(transToByte( 0x0e));

        bBuf.writeByte(transToByte( 0x8d));

        out.write(bBuf.array());
    }

    @Test
    public void testMulElevator() throws Exception {

        for(int i=0;i<10;i++) {
            final int address = 0x30 + i;
            ByteBuf buf = Unpooled.buffer(21);

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

            buf.writeByte(address);
            buf.writeByte(0x00);
            buf.writeByte(0xC0);
            buf.writeByte(0xA8);
            buf.writeByte(0x01);
            buf.writeByte(0x74);
            buf.writeByte(0x00);
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.submit(() -> {
                try {
                    Socket sc = sc = new Socket("192.168.33.168",8082);
                    OutputStream out = sc.getOutputStream();
                    out.write(buf.array());

                    while(true)
                    {
                        try {
                            getElevatorRsponse2(sc,address);
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

    private void getElevatorRsponse2(Socket socket,int address) throws Exception {

        // while(true) {
        InputStream inputStream = socket.getInputStream();

        byte[] body = new byte[1024];
        int length = inputStream.read(body);
        OutputStream out = socket.getOutputStream();

        for(int i=0;i<10;i++) {
            ByteBuf bBuf = Unpooled.buffer(37);
            bBuf.writeByte(transToByte(0xfd));
            bBuf.writeByte(transToByte( 0xee));

            bBuf.writeByte(transToByte( 0x1f));

            bBuf.writeByte(transToByte( 0x44));
            bBuf.writeByte(transToByte( 0x5f));

            bBuf.writeByte(transToByte( i));
            bBuf.writeByte(transToByte( 0x00));

            bBuf.writeByte(transToByte( 0x01));
            bBuf.writeByte(transToByte( 0x03));
            bBuf.writeByte(transToByte( 0x18));
            bBuf.writeByte(transToByte( 0x42));
            bBuf.writeByte(transToByte( 0x33));
            bBuf.writeByte(transToByte( 0x00));
            bBuf.writeByte(transToByte( 0x00));
            bBuf.writeByte(transToByte( 0x00));
            bBuf.writeByte(transToByte( 0x00));
            bBuf.writeByte(transToByte( 0x00));
            bBuf.writeByte(transToByte( 0x00));
            bBuf.writeByte(transToByte( 0x00));
            bBuf.writeByte(transToByte( 0x00));
            bBuf.writeByte(transToByte( 0x00));
            bBuf.writeByte(transToByte( 0x00));
            bBuf.writeByte(transToByte( 0x00));
            bBuf.writeByte(transToByte( 0x00));
            bBuf.writeByte(transToByte( 0x00));
            bBuf.writeByte(transToByte( 0x00));
            bBuf.writeByte(transToByte( 0x00));
            bBuf.writeByte(transToByte( 0x00));
            bBuf.writeByte(transToByte( 0x00));
            bBuf.writeByte(transToByte( 0x00));
            bBuf.writeByte(transToByte( 0x00));
            bBuf.writeByte(transToByte( 0x01));
            bBuf.writeByte(transToByte( 0x00));
            bBuf.writeByte(transToByte( 0x02));
            bBuf.writeByte(transToByte( 0x34));
            bBuf.writeByte(transToByte( 0xb3));

            bBuf.writeByte(transToByte( 0xe0));

            out.write(bBuf.array());
        }
    }

    private byte transToByte(int i) {
        return (byte) i;
    }

    @Test
    public void testElevatorRpc() throws Exception {
        //socket = new Socket("192.168.33.168",8082);
        socket = new Socket("127.0.0.1",8082);
        OutputStream out = socket.getOutputStream();

        ByteBuf buf = Unpooled.buffer(21);

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
        buf.writeByte(0x31);
        buf.writeByte(0x00);
        buf.writeByte(0xC0);
        buf.writeByte(0xA8);
        buf.writeByte(0x01);
        buf.writeByte(0x74);
        buf.writeByte(0x00);

        out.write(buf.array());

        while(true)
        {
            try {
                getElevatorRpcRsponse(socket);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void getElevatorRpcRsponse(Socket socket) throws Exception {

        // while(true) {
        InputStream inputStream = socket.getInputStream();

        byte[] body = new byte[1024];
        int length = inputStream.read(body);

        for(int i=0;i<length;i++) {

            System.out.println("@@@@@@@@@@: " + Integer.toHexString(body[i] & 0xff ));
        }

        OutputStream out = socket.getOutputStream();

        ByteBuf bBuf = Unpooled.buffer(10);
        bBuf.writeByte(transToByte(0xfd));
        bBuf.writeByte(transToByte( 0xee));

        bBuf.writeByte(transToByte( 0x04));

        bBuf.writeByte(transToByte( 0x44));
        bBuf.writeByte(transToByte( 0x60));

        bBuf.writeByte(transToByte( 0x01));
        bBuf.writeByte(transToByte( 0x00));
        bBuf.writeByte(transToByte( 0x03));
        bBuf.writeByte(transToByte( 0x00));

        bBuf.writeByte(transToByte( 0x3d));

        out.write(bBuf.array());
    }

    @Test
    public void test() {

        byte[] by = new byte[] {(byte) 0x81, (byte) 0x0e} ;
        int value =  ((by[1] & 0xFF)<<8)
                |((by[0] & 0xFF));


        System.out.println(value);
    }

    /**
     * 将int数值转换为占四个字节的byte数组，本方法适用于(低位在前，高位在后)的顺序。 和bytesToInt（）配套使用
     * @param value
     *            要转换的int值
     * @return byte数组
     */
    public byte[] intToBytes( int value )
    {
        byte[] src = new byte[4];
        src[3] =  (byte) ((value>>24) & 0xFF);
        src[2] =  (byte) ((value>>16) & 0xFF);
        src[1] =  (byte) ((value>>8) & 0xFF);
        src[0] =  (byte) (value & 0xFF);
        return src;
    }
    /**
     * 将int数值转换为占四个字节的byte数组，本方法适用于(高位在前，低位在后)的顺序。  和bytesToInt2（）配套使用
     */
    public byte[] intToBytes2(int value) {
        byte[] src = new byte[4];
        src[0] = (byte) ((value >> 24) & 0xFF);
        src[1] = (byte) ((value >> 16) & 0xFF);
        src[2] = (byte) ((value >> 8) & 0xFF);
        src[3] = (byte) (value & 0xFF);
        return src;
    }

    /**
     * byte数组中取int数值，本方法适用于(低位在前，高位在后)的顺序，和和intToBytes（）配套使用
     *
     * @param src
     *            byte数组
     * @param offset
     *            从数组的第offset位开始
     * @return int数值
     */
    public int bytesToInt(byte[] src,int offset) {
        int value;
        value = (int) ((src[offset] & 0xFF)
                | ((src[offset+1] & 0xFF)<<8)
                | ((src[offset+2] & 0xFF)<<16)
                | ((src[offset+3] & 0xFF)<<24));
        return value;
    }

    /**
     * byte数组中取int数值，本方法适用于(低位在后，高位在前)的顺序。和intToBytes2（）配套使用
     */
    public int bytesToInt2(byte[] src, int offset) {
        int value;
        value = (int) ( ((src[offset] & 0xFF)<<24)
                |((src[offset+1] & 0xFF)<<16)
                |((src[offset+2] & 0xFF)<<8)
                |(src[offset+3] & 0xFF));
        return value;
    }

    @Test
    public void testString() {

        String key = "0|M31";
        long loraAddres = Long.valueOf(key.substring(0,key.indexOf("|")));
        long modAddres = Long.valueOf(key.substring(key.indexOf("|")+2));

        System.out.println(loraAddres);
        System.out.println(modAddres);
    }

    public void sendXundaMesaage(Socket socket) throws Exception {
        OutputStream out = socket.getOutputStream();


        ByteBuf bBuf = Unpooled.buffer(19);
        //Lora协议功头
        bBuf.writeByte(transToByte(0xfd));
        bBuf.writeByte(transToByte( 0xee));

        //Lora协议长度
        //长度 = 1 + MODBUS总长度
        //9+1 + 2
        bBuf.writeByte(transToByte( 0x0c));

        //Lora协议命令域
        bBuf.writeByte(transToByte( 0x44));
        bBuf.writeByte(transToByte( 0x5f));

        //Lora协议从机地址
        bBuf.writeByte(transToByte( 0x01));
        bBuf.writeByte(transToByte( 0x00));

        //modbus从机地址
        bBuf.writeByte(transToByte( 0x00));
        // modbus功能码
        bBuf.writeByte(transToByte( 0x03));

        // 长度
        bBuf.writeByte(transToByte( 0x03));

        //内容
        bBuf.writeByte(transToByte( 0x01));
        bBuf.writeByte(transToByte( 0x01));
        bBuf.writeByte(transToByte( 0x01));
        bBuf.writeByte(transToByte( 0x01));
        bBuf.writeByte(transToByte( 0x01));
        bBuf.writeByte(transToByte( 0x01));
        //CRC校验码
        bBuf.writeByte(transToByte( 0x45));
        bBuf.writeByte(transToByte( 0xCF));
        //异或和
        bBuf.writeByte(transToByte( 0xe0));

        out.write(bBuf.array());
    }

    public void sendDisenEscalatorMesaage(Socket socket) throws Exception {
        OutputStream out = socket.getOutputStream();


        ByteBuf bBuf = Unpooled.buffer(15);
        //Lora协议功头
        bBuf.writeByte(transToByte(0xfd));
        bBuf.writeByte(transToByte( 0xee));

        //Lora协议长度
        //长度 = 1 + MODBUS总长度
        //9+1 + 2
        bBuf.writeByte(transToByte( 0x08));

        //Lora协议命令域
        bBuf.writeByte(transToByte( 0x44));
        bBuf.writeByte(transToByte( 0x5f));

        //Lora协议从机地址
        bBuf.writeByte(transToByte( 0x02));
        bBuf.writeByte(transToByte( 0x00));

        //modbus从机地址
        bBuf.writeByte(transToByte( 0x02));
        // modbus功能码
        bBuf.writeByte(transToByte( 0x03));

        // 长度
        bBuf.writeByte(transToByte( 0x03));

        //内容
        bBuf.writeByte(transToByte( 0x01));
        bBuf.writeByte(transToByte( 0x01));

        //CRC校验码
        bBuf.writeByte(transToByte( 0x45));
        bBuf.writeByte(transToByte( 0xCF));
        //异或和
        bBuf.writeByte(transToByte( 0xe0));

        out.write(bBuf.array());
    }
}
