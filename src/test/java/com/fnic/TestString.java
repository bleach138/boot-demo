package com.fnic;

import com.fnic.sysframe.utils.CRCUtil;
import com.fnic.sysframe.utils.DateUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.junit.Test;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by hjhuang on 2017/5/22.
 */
public class TestString {

    private static final Charset UTF8 = Charset.forName("UTF-8");

    @Test
    public void test() {
        //System.out.print(String.format("%310s", "a"));

        int youNumber = 1;
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        String str = String.format("%06d", youNumber);
        System.out.println(str.substring(str.length()-6,str.length())); // 0001
    }

    @Test
    public void test2() {

        System.out.println(DateUtil.getDateFormat("2017-01-01"));
    }

    @Test
    public void test3() {
        int i = 0x78;
        System.out.println("22222:" + i);
        byte[] b1 = int2byte(i);
        for(int k=0;k<b1.length;k++) {
            System.out.println("b1:" + b1[k]);
        }

        String str = "0x78";
        byte[] b2 = str.getBytes();
        for(int k=0;k<b2.length;k++) {
            System.out.println("b2:" + b2[k]);
        }


        int j = 0x89;
        byte b = (byte) j;
        System.out.println("22222:" +  (b & 0xff));
    }

    @Test
    public void testString() {
        String str = "a";
        byte[] b2 = str.getBytes();
        for(int k=0;k<b2.length;k++) {
            System.out.println("b2:" + b2[k]);
        }

        int i = 0x12;
        System.out.println(String.valueOf(i & 0xff));
        System.out.println(Integer.toHexString(i & 0xff));

        String s= "0x12";
        System.out.println(Integer.parseInt(s));

    }

    @Test
    public void testTime() {
        Date date = new Date();
        System.out.println(date.getTime());

        String str= "2018-6-28 14:26:30" ;
        System.out.println(DateUtil.getDateTimeFormat(str).getTime());
    }

    @Test
    public void testJSON() {
        String str = "{\"method\": \"setGpio\",\"params\": {\"command\": \"23\",\"value\": 222222222222222}}";
        JsonParser parser = new JsonParser();

        JsonElement element = parser.parse(str);

        JsonObject object = element.getAsJsonObject();

        JsonElement command =  object.get("params").getAsJsonObject().get("command");

        byte[] bytes = command.getAsString().getBytes(UTF8);
        for(byte b : bytes ) {
            System.out.println("@@@@@@@@@@@@" + b);
        }

    }

    public static byte[] int2byte(int res) {
        byte[] targets = new byte[4];

        targets[3] = (byte) (res & 0xff);// 最低位
        targets[2] = (byte) ((res >> 8) & 0xff);// 次低位
        targets[1] = (byte) ((res >> 16) & 0xff);// 次高位
        targets[0] = (byte) (res >>> 24);// 最高位,无符号右移。
        return targets;
    }


    public static byte[] intToByte(int number) {
        int temp = number;
        byte[] b = new byte[4];
        for (int i = 0; i < b.length; i++) {
            b[i] = new Integer(temp & 0xff).byteValue();//将最低位保存在最低位
                    temp = temp >> 8; // 向右移8位
        }
        return b;
    }

    @Test
    public void testTrans() {

        byte[] b = new byte[4];
        b[0] = 0x01;
        b[1] = 0x00;
        b[2] = 0x00;
        b[3] = 0x00;

        System.out.println(byteToInt(b));
    }

    @Test
    public void test8bit() throws Exception {

        byte b = (byte) 0x1C;

        System.out.println(Integer.toBinaryString(b & 0xff));

        String str = Integer.toBinaryString(b & 0xff);

        int length = str.length();
        if(length<8) {
            for(int i=0;i<8-length;i++ ) {
                str = "0" + str;
            }
        }

        String str1 = str.substring(4);
        String str2 = str.substring(0,4);
        System.out.println( str1);
        System.out.println( str2);
        System.out.println( Integer.parseInt(str1,2));
        System.out.println( Integer.parseInt(str2,2));
    }

    @Test
    public void testHex() throws Exception {

        byte[] b = new byte[4];

//        b[0] = 0x02 ;
//        b[1] = 0x6b ;
//        b[2] = 0x3f ;
//        b[3] = 0x3e ;
          b[0] = (byte)  0x02 ;
          b[1] = (byte)  0x7A ;
          b[2] = (byte) 0x7A ;
          b[3] = (byte) 0xEB ;

        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(b);

        double num =  buf.readInt() /30000.0;

        int fInt = (int) num;
        BigDecimal b1 = new BigDecimal(Double.toString(num));
        BigDecimal b2 = new BigDecimal(Integer.toString(fInt));
        float fPoint = b1.subtract(b2).floatValue();
        System.out.println("整数部分为:" + fInt + "\n" + "小数部分为: " + fPoint);

        int i1 = fInt/60;

        System.out.println(i1);
        System.out.println(fInt-i1*60 + fPoint);
        System.out.println( i1+ "°");
        //System.out.println(str.substring(str.length()-4));


        //System.out.println(buf.readInt());
//        for(int i=0;i<4;i++) {
//            System.out.println(buf.readByte());
//        }
    }

    @Test
    public void testState() {
        byte[] bytes = new byte[2];

        bytes[0] = 0x45 ;
        bytes[1] = 0x4C ;
        String s1 = Integer.toBinaryString (bytes[0] & 0xff);
        String s2 = Integer.toBinaryString (bytes[1] & 0xff);
        System.out.println(s1);
        System.out.println(s2);

        String s3= "12345678";
        System.out.println(s3.substring(5,6));
        System.out.println(s3.substring(6,7));

        System.out.println(String.valueOf((byte) 0x01 ));
//        System.out.println(s1.substring(s1.length()-2) + "0" + s2);
//
//        System.out.println(Integer.parseInt(  s1.substring(s1.length()-2)  + "0" +s2,2));

    }

    @Test
    public void testBufToStr() {

        ByteBuf buf = Unpooled.buffer();
        buf.writeByte(0x11);
        buf.writeByte(0x20);
        buf.writeByte(0x02);
        buf.writeByte(0x04);
        buf.writeByte(0x02);
        buf.writeByte(0x04);


//        String str = buf.readBytes(6).toString(UTF8);
        String str = "";
        for(int i=0;i<6;i++) {
            byte b = buf.readByte();
            System.out.println("@@@@@@@@@@@@" + i +"  : " + String.valueOf(b));
            str += String.valueOf(b);
        }
        System.out.println("@@@@@@@@@@@@" + str);
    }

    @Test
    public void testStream() {
        List<String> list = Lists.newArrayList();

        list.add("aa");
        list.add("bb");
        list.add("cc");

        Map<String,String> param =Maps.newHashMap();
        list.stream().forEach( s -> param.put(s,s) );

        for( String s : param.keySet()) {
            System.out.println(s);
        }
    }

    @Test
    public void testCRC(){

//        byte[] by = new byte[7];
//        by[0]=0x08;
//        by[1]=0x13;
//
//        by[2]=0x4b;
//        by[3]=0x04;
//        by[4]=0x03;
//        by[5]=0x00;
//        by[6]=0x01;

//        by[7]=0x00;
//        by[8]=0x11;

//        byte[] by = new byte[11];
//        by[0]=0x0d;
//        by[1]=0x01;
//
//
//        by[2]=0x23;
//        by[3]=0x45;
//        by[4]=0x67;
//        by[5]=0x00;
//        by[6]= (byte) 0x89;
//        by[7]=0x01;
//        by[8]=0x23;
//        by[8]=0x45;
//
//        by[9]=0x00;
//        by[10]=0x01;
//        byte[] by = new byte[4];
//        by[0]=0x05;
//        by[1]=0x01;
//
//        by[2]=0x00;
//        by[3]=0x01;

//          byte[] by = new byte[4];
//          by[0]=0x05;
//          by[1]=0x13;
//
//          by[2]=0x00;
//          by[3]=0x11;

//        byte[] by = new byte[9];
//        by[0]=0x0a;
//        by[1]=0x13;
//
//        by[2]=0x44;
//        by[3]=0x01;
//        by[4]=0x04;
//        by[5]=0x00;
//        by[6]=0x01;
//
//        by[7]=0x00;
//        by[8]=0x05;

//        byte[] by = new byte[12];
//        by[0]=0x0D;
//        by[1]=0x01;
//
//        by[2]=0x03;
//        by[3]=0x53;
//        by[4]=0x41;
//        by[5]=0x35;
//        by[6]=0x32;
//        by[7]=0x15;
//        by[8]=0x03;
//        by[9]=0x62;
//
//        by[10]=0x00;
//        by[11]=0x02;

        byte[] by = new byte[30];
        by[0]=0x1f;
        by[1]=0x12;

        by[2]=0x0b;
        by[3]=0x58;
        by[4]=0x1d;
        by[5]=0x11;
        by[6]=0x2e;
        by[7]=0x10;
        by[8]=(byte) 0xcf;
        by[9]=0x02;
        by[10]=0x7a;
        by[11]=(byte) 0xc7;
        by[12]=(byte) 0xeb;
        by[13]=0x0c;
        by[14]=0x46;
        by[15]=0x58;
        by[16]=0x49;
        by[17]=0x00;
        by[18]=0x14;
        by[19]=(byte) 0x8f;
        by[20]=(byte) 0x01;
        by[21]=(byte) 0xcc;
        by[22]=0x00;
        by[23]=0x28;
        by[24]=0x7d;
        by[25]=0x00;
        by[26]=0x1f;
        by[27]= (byte) 0xb8;
        by[28]=0x00;
        by[29]=0x03;

//        byte[] by = new byte[]{0x1f,
//        0x12,
//        0x0b,
//        0x58,
//        0x1d,
//        0x11,
//        0x2e,
//        0x10, 0xcf,
//        0x02,
//0x7a,
//0xc7, 0xeb,
//0x0c,
//0x46,
//0x58,
//0x49,
//0x00,
//0x14,
//0x8f,
// 0x01,
// 0xcc,
//0x00,
//0x28,
//0x7d,
//0x00,
//0x1f,
// 0xb8,
//0x00,
//0x03
//        };


        //System.out.println(table.length);
        byte[] crc = CRCUtil.getCrc(by);
        for(byte b : crc) {
            System.out.println(b);
        }
    }

    private static final int[] table = {
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

    @Test
    public void testByte(){
        byte b =(byte) 0xcf;
        System.out.println(b);
    }

    public static int byteToInt(byte[] b) {
        int s = 0;
        int s0 = b[0] & 0xff;// 最低位
        int s1 = b[1] & 0xff;
        int s2 = b[2] & 0xff;
        int s3 = b[3] & 0xff;
        s3 <<= 24;
        s2 <<= 16;
        s1 <<= 8;
        s = s0 | s1 | s2 | s3;
        return s;
    }

    @Test
    public void transByteToBit() {

        byte by = 0x0F;
        for (int i=0;i<8;i++) {
            System.out.println((by>>i)&0x1);
        }

    }
}
