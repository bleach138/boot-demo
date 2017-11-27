package com.ac;

import com.ablecloud.cloudservice.ACCloud;
import com.ablecloud.common.*;
import com.ablecloud.service.AC;
import com.ablecloud.service.ACAccountMgr;
import com.ablecloud.service.ACBindMgr;
import com.ablecloud.service.ACDStore;
import com.fnic.sysframe.utils.DateUtil;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class TestCloud {

    //public String subDomainName = "hfwifi";
    public String subDomainName = "envmontior";

    //public String physicalId = "DYJLBP100";

    public String physicalId = "STM32W5500";

    public String name = "test";

    public long developerId = 1;
    public String accessKey = "7b10239e4082a2ef804c5de8577df8ce";
    public String secretKey = "a8100f3c40e94ab980554cee97b593f2";
    public String majorDomain = "future-network";
    public String routerAddr = "122.97.128.4:5000";

    public ACConfig config = new ACConfig() {
        public long getDeveloperId() {
            return developerId;
        }

        public String getAuthAccessKey() {
            return accessKey;
        }

        public String getAuthSecretKey() {
            return secretKey;
        }

        public String getMajorDomain() {
            return majorDomain;
        }

        public String getRouterAddr() {
            return routerAddr;
        }

        public String getMode() {
            return "test";
        }

        public String getHost() {
            return "0.0.0.0";
        }

        public int getPort() {
            return 80;
        }

        public String getDefaultDeviceName() {
            return "";
        }
    };

    public AC ac = new ACCloud(config);

    @Test
    public void test() throws Exception {

        ACContext ctx = ac.newContext(subDomainName);


        //List<ACObject> results = ac.dstore(ctx).scanHistory(deviceId).select();

        long deviceId = 17;

        //create(ac,deviceId);

        //bind(ac,deviceId,ctx);
    }

    @Test
    public void bind() throws Exception {

        ACContext ctx = ac.newContext(subDomainName);

        ACBindMgr bindMgr = ac.bindMgr(ctx);

        long userId = 1;
        // 根据设备物理ID绑定设备
        // 参数subDomain是设备所属的子域的名字；
        // 参数physicalId是设备的物理ID；
        // 参数name是设备绑定后的显示名称；
        // 参数userId是要绑定设备的用户的ID。
        ACUserDevice device = bindMgr.bindDevice(subDomainName, "WIFI0004", name, userId);
    }

    @Test
    public void createProperty() throws Exception {

        long deviceId = 16;

        ACObject obj = new ACObject();

        //obj.put("source", 1);
        //obj.put("switch", 0);
        obj.put("location_x", 39.5);
        obj.put("location_y", 71.5);

        ac.dstore(subDomainName).create(deviceId, System.currentTimeMillis(), obj).execute();
    }

    @Test
    public void sendDevice() throws Exception {
        AC ac = new ACCloud(config);
        ACContext ctx = ac.newContext(subDomainName);

        // 实例化ACBindMgr对象
        ACBindMgr bindMgr = ac.bindMgr(ctx);
        // 向设备发送消息
        long userId = 1;
        long deviceId = 33;
        // 第一个参数68表示发送给设备的消息的msgCode。
        // 第二个参数参数是拟发送给设备的二进制数据。
        ACDeviceMsg reqMsg = new ACDeviceMsg(102, new byte[]{8, 8, 8, 8});
        // 参数subDomain是目标设备在AbleCloud平台上所属子域的名字。
        // 参数deviceId是目标设备的逻辑ID
        // 参数ACDeviceMsg为发送给目标设备的具体消息内容
        // 参数userId为发送该消息的用户ID
        ACDeviceMsg respMsg = bindMgr.sendToDevice(subDomainName, deviceId, reqMsg, 0);

        System.out.println(respMsg);
    }

    @Test
    public void regUser() throws Exception {
        AC ac = new ACCloud(config);
        ACContext ctx = ac.newContext(subDomainName);

        // 实例化ACAccountMgr对象
        ACAccountMgr accountMgr = ac.accountMgr(ctx);

        // 参数name是用户的昵称；
        // 参数email和phone分别指用户的电子邮件及手机号。这两个参数至少需指定一个，以作为用户的登录名。两者俱备时任意一个都可用作登录名；
        // 参数password是登录密码；
        // 参数verifyCode是验证码。
        ACAccount user = accountMgr.register("", "43178430@qq.com", "13813970080", "123456", "556634");
    }

    @Test
    public void sendVerifyCode() throws Exception {

        AC ac = new ACCloud(config);
        ACContext ctx = ac.newContext(subDomainName);
        // 实例化ACAccountMgr对象
        ACAccountMgr accountMgr = ac.accountMgr(ctx);
        // 给用户发送注册验证码
        // 参数account为字符串，是用户的电子邮箱或手机号，也是用户注册后的登录帐号。
        // 参数template是拟采用的消息模板的编号。
        // 参数timeout是验证码的有效时长。单位为秒。
        accountMgr.sendVerifyCode("13813970080", 1, 500000);
    }

    @Test
    public void queryDevices() throws Exception {
        ACFilter filter = ac.filter().whereGreaterThan("temperature", 10);

        List<ACObject> list = ac.dstore(subDomainName).scanHistory(30).execute();


        System.out.println(list);
    }

    @Test
    public void queryDevice() throws Exception {
        ACContext ctx = ac.newContext(subDomainName);

        long id = ac.bindMgr(ctx).getDeviceId(subDomainName,"WIFI0004");

        System.out.println(id);
    }

    @Test
    public void queryDeviceHistory() throws Exception {
        ACContext ctx = ac.newContext(subDomainName);


        Date date = DateUtil.getNowDate();
        //long startTime = date.getTime()-3600*24*7*1000;
        long startTime = date.getTime() -3600*24*7*1000;
        long endTime = date.getTime();

        //List<ACObject> list = ac.dstore(subDomainName).scanHistory(33).startTime(startTime).endTime(endTime).avg("temperature").execute();

        List<ACObject> tempList = ac.dstore(subDomainName).statisticsHistory(33)
                .startAbsoluteTime(startTime)
                .endAbsoluteTime(endTime)
                .interval(1, ACDStore.INTERVAL_DAYS)
                .addStatistic("temperature", ACDStore.AGGR_AVG)
                .execute();

        for(ACObject temp : tempList) {
            System.out.println(temp);
        }

        List<ACObject> humList = ac.dstore(subDomainName).statisticsHistory(33)
                .startAbsoluteTime(startTime)
                .endAbsoluteTime(endTime)
                .interval(1, ACDStore.INTERVAL_DAYS)
                .addStatistic("humidity", ACDStore.AGGR_AVG)
                .execute();

        for(ACObject temp : humList) {
            System.out.println(temp);

            System.out.println(DateUtil.getDateFormat(new Date(temp.getLong("timestamp"))));
        }

        List<ACObject> casList = ac.dstore(subDomainName).statisticsHistory(33)
                .startAbsoluteTime(startTime)
                .endAbsoluteTime(endTime)
                .interval(1, ACDStore.INTERVAL_DAYS)
                .addStatistic("cascophen", ACDStore.AGGR_AVG)
                .execute();

        for(ACObject temp : casList) {
            System.out.println(temp);

            System.out.println(DateUtil.getDateFormat(new Date(temp.getLong("timestamp"))));
        }

        List<ACObject> pmList = ac.dstore(subDomainName).statisticsHistory(33)
                .startAbsoluteTime(startTime)
                .endAbsoluteTime(endTime)
                .interval(1, ACDStore.INTERVAL_DAYS)
                .addStatistic("pm_2_5", ACDStore.AGGR_AVG)
                .execute();

        for(ACObject temp : pmList) {
            System.out.println(temp);

            System.out.println(DateUtil.getDateFormat(new Date(temp.getLong("timestamp"))));
        }
    }

    @Test
    public void queryDeviceInfo () throws Exception {
        ACFilter filter = ac.filter().whereEqualTo("floor", 18);

        List<ACObject> results = ac.dstore(subDomainName).scanStatus().where(filter).execute();
//[{"co2_concentration":179.1,"illumination":140.9,"temperature":24.7,"id":33,"floor":18,"room_type":2,"timestamp":1511144521430}]

        System.out.println(results);

        if(results.size()>0) {
           for(ACObject result : results ) {
               int score = 0;

               Float temperature =  result.getFloat("temperature");
               Float co2Concentration = result.getFloat("co2_concentration");
               Float illumination = result.getFloat("illumination");
               int roomType = result.getInt("room_type");

               if(temperature>20) {
                   score += 30;
               }else if(temperature<20 && temperature>10) {
                   score += 20;
               }else {
                   score += 10;
               }

               if(co2Concentration>100) {
                   score += 30;
               }else if(co2Concentration<100 && co2Concentration>10) {
                   score += 20;
               }else {
                   score += 10;
               }

               if(illumination>100) {
                   score += 30;
               }else if(illumination<100 && illumination>10) {
                   score += 20;
               }else {
                   score += 10;
               }

               Random random = new Random();

               score += random.nextInt(10);

               result.put("score",score);
           }
        }

        System.out.println(results);
    }

    /*@Test
    public void queryDevice() throws Exception {
        ACContext ctx = ac.newContext(subDomainName);

        //ac.dstore(subDomainName).scanStatus()

        ACObject result = ac.store("device_data", ctx).find("phy", "001")
                .execute();

        String device_id = result.getString("device_id");
        Long timestamp = result.getLong("timestamp");
        Double pm25 = result.getDouble("pm25");
        String mode = result.getString("mode");
        Long speed = result.getLong("speed");
        System.out.println(device_id + ", " + timestamp + ", " + pm25 + ", " + mode + ", " + speed);
    }*/

    @Test
    public void queryDeviceStatus() throws Exception {
        ACFilter filter = ac.filter().whereGreaterThan("location_x", 10);

        List<ACObject> results = ac.dstore(subDomainName).scanStatus()
                //.select(ACDStore.DEVICE_ID, ACDStore.TIMESTAMP, "lo", "speed")
                //.startTime(curTime-60*1000)
                .where(filter)
                .execute();

        System.out.println(results);
    }

    @Test
    public void login() throws Exception {
        AC ac = new ACCloud(config);
        ACContext ctx = ac.newContext(subDomainName);

        // 实例化ACAccountMgr对象
        ACAccountMgr accountMgr = ac.accountMgr(ctx);

        // 参数name是用户的昵称；
        // 参数email和phone分别指用户的电子邮件及手机号。这两个参数至少需指定一个，以作为用户的登录名。两者俱备时任意一个都可用作登录名；
        // 参数password是登录密码；
        // 参数verifyCode是验证码。
        ACAccount user = accountMgr.login("13813970080", "1234567");

        System.out.println(user);
    }

    @Test
    public void sendUDS() throws Exception {
        ACMsg req = new ACMsg();
        // 参数methodName为访问UDS的方法名
        req.setName("handleLightReport");
        req.put("deviceId", 22);
        req.put("startTime", 0);
        req.put("endTime", System.currentTimeMillis());
        // 参数subDomain是要访问的服务在AbleCloud平台上所对应的子域的名字。访问主域UDS时使用空字符串。
        // 参数serviceName是要访问的UDS服务的名字
        // 参数serviceVersion用于指定服务的主版本号
        ACMsg resp = ac.sendToService("Test",1,req);

        System.out.println(resp);
    }

    @Test
    public void testTime() {
        Date date = new Date();
        date.getTime();
        long now = System.currentTimeMillis();

        System.out.println(now);
        Date date2 = new Date(now -3600*24*7*1000);
        System.out.println(DateUtil.getDateFormat(date2));
    }
}
