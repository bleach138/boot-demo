package tcp;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.buffer.UnpooledByteBufAllocator;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.concurrent.*;

public class TestGPS {

    private Socket socket = null;

    //@Before
    public void login() throws Exception {
        socket = new Socket("192.168.33.167",1887);
        OutputStream out = socket.getOutputStream();

        ByteBuf bBuf = Unpooled.buffer(18);
        bBuf.writeByte(transToByte(0x78));
        bBuf.writeByte(transToByte( 0x78));
        bBuf.writeByte(transToByte( 0x0D));
        bBuf.writeByte(transToByte( 0x01));
        bBuf.writeByte(transToByte( 0x01));
        bBuf.writeByte(transToByte( 0x23));
        bBuf.writeByte(transToByte( 0x45));
        bBuf.writeByte(transToByte( 0x67));
        bBuf.writeByte(transToByte( 0x89));
        bBuf.writeByte(transToByte( 0x01));
        bBuf.writeByte(transToByte( 0x23));
        bBuf.writeByte(transToByte( 0x45));
        bBuf.writeByte(transToByte( 0x00));
        bBuf.writeByte(transToByte( 0x01));
        bBuf.writeByte(transToByte( 0x8C));
        bBuf.writeByte(transToByte( 0xDD));
        bBuf.writeByte(transToByte( 0x0D));
        bBuf.writeByte(transToByte( 0x0A));

        out.write(bBuf.array());
        getSocketRsponse(socket);
    }

    @Test
    public void testGPS(){

        try {

            OutputStream out = socket.getOutputStream();

            ByteBuf bBuf = Unpooled.buffer(36);

            //header
            bBuf.writeByte(transToByte(0x78));
            bBuf.writeByte(transToByte( 0x78));
            bBuf.writeByte(transToByte( 0x1F));
            bBuf.writeByte(transToByte( 0x12));

            //body
            bBuf.writeByte(transToByte( 0x0B));
            bBuf.writeByte(transToByte( 0x08));
            bBuf.writeByte(transToByte( 0x1D));
            bBuf.writeByte(transToByte( 0x11));
            bBuf.writeByte(transToByte( 0x2E));
            bBuf.writeByte(transToByte( 0x10));

            bBuf.writeByte(transToByte( 0xCF));

            bBuf.writeByte(transToByte( 0x02));
            bBuf.writeByte(transToByte( 0x7A));
            bBuf.writeByte(transToByte( 0xC7));
            bBuf.writeByte(transToByte( 0xEB));
            bBuf.writeByte(transToByte( 0x0C));
            bBuf.writeByte(transToByte( 0x46));
            bBuf.writeByte(transToByte( 0x58));
            bBuf.writeByte(transToByte( 0x49));
            bBuf.writeByte(transToByte( 0x00));
            bBuf.writeByte(transToByte( 0x14));
            bBuf.writeByte(transToByte( 0x8F));
            bBuf.writeByte(transToByte( 0x01));
            bBuf.writeByte(transToByte( 0xCC));
            bBuf.writeByte(transToByte( 0x00));
            bBuf.writeByte(transToByte( 0x28));
            bBuf.writeByte(transToByte( 0x7D));
            bBuf.writeByte(transToByte( 0x00));
            bBuf.writeByte(transToByte( 0x1F));
            bBuf.writeByte(transToByte( 0xE8));

            //tail
            bBuf.writeByte(transToByte( 0x00));
            bBuf.writeByte(transToByte( 0x03));
            bBuf.writeByte(transToByte( 0x80));
            bBuf.writeByte(transToByte( 0x81));
            bBuf.writeByte(transToByte( 0x0D));
            bBuf.writeByte(transToByte( 0x0A));


//            78 78 1F 12 0B 08 1D 11 2E 10 CF 02 7A C7 EB 0C 46 58 49 00 14 8F
//            01 CC 00 28 7D 00 1F B8 00 03 80 81 0D 0A
            out.write(bBuf.array());

            System.out.println("@@@@@@@@@@@@");
            getSocketRsponse(socket);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRpcRsp2(){
        try {

            System.out.println("RPC REP@@@@@@@@@@@@@@@@@@@@@@@");
            getRpcSocketRsponse(socket);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void testRpcRsp(){
//
//        try {
//
//            getSocketRsponse(socket);
//
//            OutputStream out = socket.getOutputStream();
//
//            ByteBuf bBuf = Unpooled.buffer(14);
//            bBuf.writeByte(transToByte(0x78));
//            bBuf.writeByte(transToByte( 0x78));
//            bBuf.writeByte(transToByte( 0x00));
//            bBuf.writeByte(transToByte( 0x15));
//            bBuf.writeByte(transToByte( 0x00));
//            bBuf.writeByte(transToByte( 0x02));
//            bBuf.writeByte(transToByte( 's'));
//            bBuf.writeByte(transToByte( 's'));
//            bBuf.writeByte(transToByte( 0x80));
//            bBuf.writeByte(transToByte( 0x81));
//            bBuf.writeByte(transToByte( 0x00));
//            bBuf.writeByte(transToByte( 0x01));
//            bBuf.writeByte(transToByte( 0x80));
//            bBuf.writeByte(transToByte( 0x81));
//            bBuf.writeByte(transToByte( 0x0D));
//            bBuf.writeByte(transToByte( 0x0A));
//            out.write(bBuf.array());
//
//            System.out.println("@@@@@@@@@@@@");
//            getSocketRsponse(socket);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void testStatus(){

        try {
            OutputStream out = socket.getOutputStream();

            ByteBuf bBuf = Unpooled.buffer(13);

            //header
            bBuf.writeByte(transToByte(0x78));
            bBuf.writeByte(transToByte( 0x78));
            bBuf.writeByte(transToByte( 0x08));
            bBuf.writeByte(transToByte( 0x21));

            //body
            bBuf.writeByte(transToByte( 0x01));
            bBuf.writeByte(transToByte( 0x02));
            bBuf.writeByte(transToByte( 0x01));

            //tail
            bBuf.writeByte(transToByte( 0x00));
            bBuf.writeByte(transToByte( 0x11));
            bBuf.writeByte(transToByte( 0x80));
            bBuf.writeByte(transToByte( 0x81));
            bBuf.writeByte(transToByte( 0x0D));
            bBuf.writeByte(transToByte( 0x0A));
            out.write(bBuf.array());

            System.out.println("@@@@@@@@@@@@");
            getSocketRsponse(socket);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWifiInfo(){

        try {
            OutputStream out = socket.getOutputStream();

            ByteBuf bBuf = Unpooled.buffer(38);

            //header
            bBuf.writeByte(transToByte(0x78));
            bBuf.writeByte(transToByte( 0x78));
            bBuf.writeByte(transToByte( 0x21));
            bBuf.writeByte(transToByte( 0x20));

            //body
            bBuf.writeByte(transToByte( 0x0B));
            bBuf.writeByte(transToByte( 0x08));
            bBuf.writeByte(transToByte( 0x1D));
            bBuf.writeByte(transToByte( 0x11));
            bBuf.writeByte(transToByte( 0x2E));
            bBuf.writeByte(transToByte( 0x10));

            bBuf.writeByte(transToByte( 0x11));
            bBuf.writeByte(transToByte( 0x12));
            bBuf.writeByte(transToByte( 0x01));
            bBuf.writeByte(transToByte( 0x02));
            //base_station
            bBuf.writeByte(transToByte( 0x00));
            bBuf.writeByte(transToByte( 0x10));
            bBuf.writeByte(transToByte( 0x10));
            bBuf.writeByte(transToByte( 0x01));
            bBuf.writeByte(transToByte( 0x03));

            //base_station
            bBuf.writeByte(transToByte( 0x10));
            bBuf.writeByte(transToByte( 0x11));
            bBuf.writeByte(transToByte( 0x20));
            bBuf.writeByte(transToByte( 0x02));
            bBuf.writeByte(transToByte( 0x04));


            bBuf.writeByte(transToByte( 0x01));

            //AP
            bBuf.writeByte(transToByte( 0x11));
            bBuf.writeByte(transToByte( 0x20));
            bBuf.writeByte(transToByte( 0x02));
            bBuf.writeByte(transToByte( 0x04));
            bBuf.writeByte(transToByte( 0x02));
            bBuf.writeByte(transToByte( 0x04));
            bBuf.writeByte(transToByte( 0x05));

            //AP
//            bBuf.writeByte(transToByte( 0x11));
//            bBuf.writeByte(transToByte( 0x03));
//            bBuf.writeByte(transToByte( 0x02));
//            bBuf.writeByte(transToByte( 0x14));
//            bBuf.writeByte(transToByte( 0x12));
//            bBuf.writeByte(transToByte( 0x04));
//            bBuf.writeByte(transToByte( 0x14));

            //tail
            bBuf.writeByte(transToByte( 0x00));
            bBuf.writeByte(transToByte( 0x11));
            bBuf.writeByte(transToByte( 0x80));
            bBuf.writeByte(transToByte( 0x81));
            bBuf.writeByte(transToByte( 0x0D));
            bBuf.writeByte(transToByte( 0x0A));
            out.write(bBuf.array());

            System.out.println("@@@@@@@@@@@@");
            getSocketRsponse(socket);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        ByteBuffer bBuf = ByteBuffer.allocate(48);
        bBuf.put(transToByte(0x78));
        bBuf.put(transToByte( 0x78));
        bBuf.put(transToByte( 0x0D));
        bBuf.put(transToByte( 0x01));
//        bBuf.put(transToByte( 0x01));
//        bBuf.put(transToByte( 0x23));
//        bBuf.put(transToByte( 0x45));
//        bBuf.put(transToByte( 0x67));
//        bBuf.put(transToByte( 0x89));
//        bBuf.put(transToByte( 0x01));
//        bBuf.put(transToByte( 0x23));
//        bBuf.put(transToByte( 0x45));
        bBuf.put(transToByte( 01));
        bBuf.put(transToByte( 23));
        bBuf.put(transToByte( 45));
        bBuf.put(transToByte( 67));
        bBuf.put(transToByte( 89));
        bBuf.put(transToByte( 01));
        bBuf.put(transToByte( 23));
        bBuf.put(transToByte( 45));

        bBuf.put(transToByte( 0x00));
        bBuf.put(transToByte( 0x01));
        bBuf.put(transToByte( 0x8C));
        bBuf.put(transToByte( 0xDD));
        bBuf.put(transToByte( 0x0D));
        bBuf.put(transToByte( 0x0A));
        byte[] bytes = bBuf.array();
        for(int i=0;i<bytes.length;i++) {
            System.out.println("@@@@@@@@@@@@:" + bytes[i]);
        }
    }

    @Test
    public void testCRC(){
        ByteBuffer bBuf = ByteBuffer.allocate(4);
//        bBuf.put(transToByte( 0x01));
//        bBuf.put(transToByte( 0x23));
//        bBuf.put(transToByte( 0x45));
//        bBuf.put(transToByte( 0x67));
//        bBuf.put(transToByte( 0x89));
//        bBuf.put(transToByte( 0x01));
//        bBuf.put(transToByte( 0x23));
//        bBuf.put(transToByte( 0x45));


//        bBuf.put(transToByte( 0x0d));
//        bBuf.put(transToByte( 0x01));
//        bBuf.put(transToByte( 0x01));
//        bBuf.put(transToByte( 0x23));
//        bBuf.put(transToByte( 0x45));
//        bBuf.put(transToByte( 0x67));
//        bBuf.put(transToByte( 0x89));
//        bBuf.put(transToByte( 0x01));
//        bBuf.put(transToByte( 0x23));
//        bBuf.put(transToByte( 0x45));
//        bBuf.put(transToByte( 0x00));
//        bBuf.put(transToByte( 0x01));

//        ByteBuf bBuf = Unpooled.buffer(30);
//        bBuf.writeByte(transToByte( 0x1F));
//        bBuf.writeByte(transToByte( 0x12));
//        bBuf.writeByte(transToByte( 0x0B));
//        bBuf.writeByte(transToByte( 0x08));
//        bBuf.writeByte(transToByte( 0x1D));
//        bBuf.writeByte(transToByte( 0x11));
//        bBuf.writeByte(transToByte( 0x2E));
//        bBuf.writeByte(transToByte( 0x10));
//        bBuf.writeByte(transToByte( 0xCF));
//        bBuf.writeByte(transToByte( 0x02));
//        bBuf.writeByte(transToByte( 0x7A));
//        bBuf.writeByte(transToByte( 0xC7));
//        bBuf.writeByte(transToByte( 0xEB));
//        bBuf.writeByte(transToByte( 0x0C));
//        bBuf.writeByte(transToByte( 0x46));
//        bBuf.writeByte(transToByte( 0x58));
//        bBuf.writeByte(transToByte( 0x49));
//        bBuf.writeByte(transToByte( 0x00));
//        bBuf.writeByte(transToByte( 0x14));
//        bBuf.writeByte(transToByte( 0x8F));
//        bBuf.writeByte(transToByte( 0x01));
//        bBuf.writeByte(transToByte( 0xCC));
//        bBuf.writeByte(transToByte( 0x00));
//        bBuf.writeByte(transToByte( 0x28));
//        bBuf.writeByte(transToByte( 0x7D));
//        bBuf.writeByte(transToByte( 0x00));
//        bBuf.writeByte(transToByte( 0x1F));
//        bBuf.writeByte(transToByte( 0xE8));
//        bBuf.writeByte(transToByte( 0x00));
//        bBuf.writeByte(transToByte( 0x03));
        bBuf.put(transToByte( 0x05));
        bBuf.put(transToByte( 0x01));
        bBuf.put(transToByte( 0x00));
        bBuf.put(transToByte( 0x01));


        System.out.println(getCrc16(bBuf.array()));
//        System.out.println(getCrc16(bBuf.array()));
//        System.out.println(do_crc(bBuf.array()));
    }

    private static String getCrc(byte[] data) {
        int high;
        int flag;

        // 16位寄存器，所有数位均为1
        int wcrc = 0xffff;
        for (int i = 0; i < data.length; i++) {
            // 16 位寄存器的高位字节
            high = wcrc >> 8;
            // 取被校验串的一个字节与 16 位寄存器的高位字节进行“异或”运算
            wcrc = high ^ data[i];

            for (int j = 0; j < 8; j++) {
                flag = wcrc & 0x0001;
                // 把这个 16 寄存器向右移一位
                wcrc = wcrc >> 1;
                // 若向右(标记位)移出的数位是 1,则生成多项式 1010 0000 0000 0001 和这个寄存器进行“异或”运算
                if (flag == 1)
                    wcrc ^= 0xa001;
            }
        }

        return Integer.toHexString(wcrc);
    }

    private String getCrc16(byte[] data) {
        int[] table = {
                0x0000, 0x1189, 0x2312, 0x329b, 0x4624, 0x57ad, 0x6536, 0x74bf,
                0x8c48, 0x9dc1, 0xaf5a, 0xbed3, 0xca6c, 0xdbe5, 0xe97e, 0xf8f7,
                0x1081, 0x0108, 0x3393, 0x221a, 0x56a5, 0x472c, 0x75b7, 0x643e,
                0x9cc9, 0x8d40, 0xbfdb, 0xae52, 0xdaed, 0xcb64, 0xf9ff, 0xe876,
                0x2102, 0x308b, 0x0210, 0x1399, 0x6726, 0x76af, 0x4434, 0x55bd,
                0xad4a, 0xbcc3, 0x8e58, 0x9fd1, 0xeb6e, 0xfae7, 0xc87c, 0xd9f5,
                0x3183, 0x200a, 0x1291, 0x0318, 0x77a7, 0x662e, 0x54b5, 0x453c,
                0xbdcb, 0xac42, 0x9ed9, 0x8f50, 0xfbef, 0xea66, 0xd8fd, 0xc974,
                0x4204, 0x538d, 0x6116, 0x709f, 0x0420, 0x15a9, 0x2732, 0x36bb,
                0xce4c, 0xdfc5, 0xed5e, 0xfcd7, 0x8868, 0x99e1, 0xab7a, 0xbaf3,
                0x5285, 0x430c, 0x7197, 0x601e, 0x14a1, 0x0528, 0x37b3, 0x263a,
                0xdecd, 0xcf44, 0xfddf, 0xec56, 0x98e9, 0x8960, 0xbbfb, 0xaa72,
                0x6306, 0x728f, 0x4014, 0x519d, 0x2522, 0x34ab, 0x0630, 0x17b9,
                0xef4e, 0xfec7, 0xcc5c, 0xddd5, 0xa96a, 0xb8e3, 0x8a78, 0x9bf1,
                0x7387, 0x620e, 0x5095, 0x411c, 0x35a3, 0x242a, 0x16b1, 0x0738,
                0xffcf, 0xee46, 0xdcdd, 0xcd54, 0xb9eb, 0xa862, 0x9af9, 0x8b70,
                0x8408, 0x9581, 0xa71a, 0xb693, 0xc22c, 0xd3a5, 0xe13e, 0xf0b7,
                0x0840, 0x19c9, 0x2b52, 0x3adb, 0x4e64, 0x5fed, 0x6d76, 0x7cff,
                0x9489, 0x8500, 0xb79b, 0xa612, 0xd2ad, 0xc324, 0xf1bf, 0xe036,
                0x18c1, 0x0948, 0x3bd3, 0x2a5a, 0x5ee5, 0x4f6c, 0x7df7, 0x6c7e,
                0xa50a, 0xb483, 0x8618, 0x9791, 0xe32e, 0xf2a7, 0xc03c, 0xd1b5,
                0x2942, 0x38cb, 0x0a50, 0x1bd9, 0x6f66, 0x7eef, 0x4c74, 0x5dfd,
                0xb58b, 0xa402, 0x9699, 0x8710, 0xf3af, 0xe226, 0xd0bd, 0xc134,
                0x39c3, 0x284a, 0x1ad1, 0x0b58, 0x7fe7, 0x6e6e, 0x5cf5, 0x4d7c,
                0xc60c, 0xd785, 0xe51e, 0xf497, 0x8028, 0x91a1, 0xa33a, 0xb2b3,
                0x4a44, 0x5bcd, 0x6956, 0x78df, 0x0c60, 0x1de9, 0x2f72, 0x3efb,
                0xd68d, 0xc704, 0xf59f, 0xe416, 0x90a9, 0x8120, 0xb3bb, 0xa232,
                0x5ac5, 0x4b4c, 0x79d7, 0x685e, 0x1ce1, 0x0d68, 0x3ff3, 0x2e7a,
                0xe70e, 0xf687, 0xc41c, 0xd595, 0xa12a, 0xb0a3, 0x8238, 0x93b1,
                0x6b46, 0x7acf, 0x4854, 0x59dd, 0x2d62, 0x3ceb, 0x0e70, 0x1ff9,
                0xf78f, 0xe606, 0xd49d, 0xc514, 0xb1ab, 0xa022, 0x92b9, 0x8330,
                0x7bc7, 0x6a4e, 0x58d5, 0x495c, 0x3de3, 0x2c6a, 0x1ef1, 0x0f78
        };

        int crc = 0xffff;
        int num = 0;
        for (byte b : data) {
            num = (crc ^ b) & 0xff;
            crc = (crc >> 8 ) ^table[num];
        }
        System.out.println("CRC16 = " + crc);
        long result = (long) ~crc;
        //System.out.println("CRC16 = " + result);
//        for(byte b :shortToByte(result)) {
//            System.out.println("b= " + b);
//            System.out.println("b= " +Integer.toHexString (b));
//        }

        return Long.toHexString(result);
    }

    @Test
    public void test3() {
        System.out.println(~0xd9dc);
    }

    public static byte[] shortToByte(short number) {
        int temp = number;
        byte[] b = new byte[2];
        for (int i = 0; i < b.length; i++) {
            b[i] = new Integer(temp & 0xff).byteValue();// 将最低位保存在最低位
                    temp = temp >> 8; // 向右移8位
        }
        return b;
    }

    private byte transToByte(int i) {
        return (byte) i;
    }

    private void getSocketRsponse(Socket socket) throws Exception {

       // while(true) {
            InputStream inputStream = socket.getInputStream();

            byte[] header = new byte[1024];
            int length = inputStream.read(header);

            for(int i=0;i<length;i++) {
                String str = Integer.toHexString(header[i] & 0xff);
                if(str.length() == 1) {
                    str = "0" + str;
                }
                System.out.println("???????????::"+ str);
            }
      //  }
    }
    private void getRpcSocketRsponse(Socket socket) throws Exception {

        // while(true) {
        InputStream inputStream = socket.getInputStream();

        byte[] header = new byte[1024];
        int length = inputStream.read(header);

        for(int i=0;i<length;i++) {
            String str = Integer.toHexString(header[i] & 0xff);
            if(str.length() == 1) {
                str = "0" + str;
            }
            System.out.println("???????????::"+ str);
        }
        //  }

        rspRpc(header,length);
    }

    private void rspRpc(byte[] header,int hLength) throws Exception {

        OutputStream out = socket.getOutputStream();
        //ByteBuf bBuf = new UnpooledByteBufAllocator(false).buffer(hLength+1);
        ByteBuf bBuf = Unpooled.buffer(hLength+2);
        bBuf.writeByte(transToByte(0x78));
        bBuf.writeByte(transToByte( 0x78));
        int length = header[2] + 2;
        bBuf.writeByte(transToByte( length));
        bBuf.writeByte(transToByte( 0x15));
        int  contentLength = hLength;
        bBuf.writeByte(transToByte( 0x00));
        bBuf.writeByte(transToByte( contentLength));
        for(int i=4;i<contentLength;i++) {
            bBuf.writeByte(header[i+1]);
        }
//        bBuf.writeByte(transToByte( 0x80));
//        bBuf.writeByte(transToByte( 0x81));
//        bBuf.writeByte(transToByte( 0x0D));
//        bBuf.writeByte(transToByte( 0x0A));
        out.write(bBuf.array());

        System.out.println("@@@@@@@@@@@@");
        getSocketRsponse(socket);
    }

    @Test
    public void testBuf(){
        //-29475
        ByteBuf buf = Unpooled.buffer();

        buf.writeByte((byte) 0x8d);
        buf.writeByte((byte) 0xdd);
        buf.writeByte((byte) 0x01);
        buf.writeByte((byte) 0x02);
        buf.writeByte((byte) 0x03);
        buf.writeByte((byte) 0x04);
        buf.writeByte((byte) 0x05);


        //System.out.println(buf.readByte());
        byte[] b1 = new byte[2];
        buf.getBytes(5,b1,0,2);
        for(byte b : b1) {
            System.out.println(b);
        }
    }

    @Test
    public void testBuf2() {
        ByteBuf buf = Unpooled.buffer();

        buf.writeByte(transToByte(0x78));
        buf.writeByte(transToByte( 0x78));
        buf.writeByte(transToByte( 0x0D));
        buf.writeByte(transToByte( 0x01));

        buf.writeByte(transToByte( 0x01));
        buf.writeByte(transToByte( 0x23));
        buf.writeByte(transToByte( 0x45));
        buf.writeByte(transToByte( 0x67));
        buf.writeByte(transToByte( 0x89));
        buf.writeByte(transToByte( 0x01));
        buf.writeByte(transToByte( 0x23));
        buf.writeByte(transToByte( 0x45));
        buf.writeByte(transToByte( 0x00));
        buf.writeByte(transToByte( 0x01));
        buf.writeByte(transToByte( 0x8C));
        buf.writeByte(transToByte( 0xDD));

        buf.writeByte(transToByte( 0x0D));
        buf.writeByte(transToByte( 0x0A));

        int length = buf.getByte(2) + 3;

        //ByteBuf payload = buf.readRetainedSlice(12);

        byte[] contentBytes = new byte[length-4];
        byte[] crcBytes = new byte[2];
        buf.getBytes(2,contentBytes,0,length-4);
        buf.getBytes(length-2,crcBytes,0,2);


        System.out.println("CRC:" + getCrc16(contentBytes));
        System.out.println("@@@@@@@@@");
    }

    @Test
    public void testShort() {
        String str = "a";
        byte[] b2 = new byte[2];
        b2[0] = (byte) 0x8b;
        b2[1] = (byte) 0xdd;

        System.out.println(byteToShort(b2));

        //System.out.println(shortToByte(byteToShort(b2)));
        for(byte b :shortToByte(byteToShort(b2))) {
            System.out.println("b= " +Integer.toHexString (b & 0xff));
        }
    }

    @Test
    public void testHex() {
        ByteBuf buf = Unpooled.buffer();

        buf.writeByte(0x89);
        System.out.println( Integer.toHexString(buf.getByte(0) & 0xFF));
        System.out.println(Integer.toHexString(buf.getByte(0)));
    }

    @Test
    public void testPoolBuf() {
        int hLength=19;

        byte[] header = new byte[1024];

        ByteBuf bBuf = Unpooled.buffer(hLength+1);
        bBuf.writeByte(transToByte(0x78));
        bBuf.writeByte(transToByte( 0x78));
        int length = header[2] + 2;
        bBuf.writeByte(transToByte( length));
        bBuf.writeByte(transToByte( 0x15));
        int  contentLength = hLength;
        bBuf.writeByte(transToByte( 0x00));
        bBuf.writeByte(transToByte( contentLength));
        for(int i=4;i<contentLength;i++) {
            bBuf.writeByte(header[i]);
        }

        bBuf.getByte(0);
    }




    public static short byteToShort(byte[] b) {
        short s = 0;
        short s0 = (short) (b[0] & 0xff);// 最低位
        short s1 = (short) (b[1] & 0xff);
        s1 <<= 8;
        s = (short) (s0 | s1);
        return s;
    }

    @Test
    public void testModbus() throws Exception {
        socket = new Socket("112.64.32.250",30502);
        OutputStream out = socket.getOutputStream();

        ByteBuf bBuf = Unpooled.buffer(18);
        bBuf.writeByte(transToByte(0x78));
        bBuf.writeByte(transToByte( 0x78));
        bBuf.writeByte(transToByte( 0x0D));
        bBuf.writeByte(transToByte( 0x01));
        bBuf.writeByte(transToByte( 0x01));
        bBuf.writeByte(transToByte( 0x23));
        bBuf.writeByte(transToByte( 0x45));
        bBuf.writeByte(transToByte( 0x67));
        bBuf.writeByte(transToByte( 0x89));
        bBuf.writeByte(transToByte( 0x01));
        bBuf.writeByte(transToByte( 0x23));
        bBuf.writeByte(transToByte( 0x45));
        bBuf.writeByte(transToByte( 0x00));
        bBuf.writeByte(transToByte( 0x01));
        bBuf.writeByte(transToByte( 0x8C));
        bBuf.writeByte(transToByte( 0xDD));
        bBuf.writeByte(transToByte( 0x0D));
        bBuf.writeByte(transToByte( 0x0A));

        out.write(bBuf.array());
        getSocketRsponse(socket);
    }


}
