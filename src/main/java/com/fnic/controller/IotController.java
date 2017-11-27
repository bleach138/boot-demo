package com.fnic.controller;

import com.ablecloud.cloudservice.ACCloud;
import com.ablecloud.common.ACContext;
import com.ablecloud.common.ACDeviceMsg;
import com.ablecloud.common.ACFilter;
import com.ablecloud.common.ACObject;
import com.ablecloud.service.AC;
import com.ablecloud.service.ACBindMgr;
import com.ablecloud.service.ACDStore;
import com.fnic.sysframe.utils.DateUtil;
import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/iot")
public class IotController extends BaseController {

    @RequestMapping("/queryDevices")
    public Map<String,Object> queryDevices() throws Exception {

        Map<String,Object> rspMap = Maps.newHashMap();
        rspMap.put("rspCode","0000");
        rspMap.put("rspDesc","Success");

        ACFilter filter = ac.filter().whereGreaterThan("location_x", 10);

        List<ACObject> results = ac.dstore(subDomainName).scanStatus()
                //.select(ACDStore.DEVICE_ID, ACDStore.TIMESTAMP, "lo", "speed")
                //.startTime(curTime-60*1000)
                .where(filter)
                .execute();

        rspMap.put("deviceList",results);


        return rspMap;
    }

    @RequestMapping("/sendCommand")
    public Map<String,Object> sendCommand(@RequestBody Map<String,Object> inputParam) throws Exception {

        Map<String,Object> rspMap = Maps.newHashMap();
        rspMap.put("rspCode","0000");
        rspMap.put("rspDesc","Success");

        ACContext ctx = ac.newContext(subDomainName);

        // 实例化ACBindMgr对象
        ACBindMgr bindMgr = ac.bindMgr(ctx);
        // 向设备发送消息
        long userId = 1;
        long deviceId = (long) inputParam.get("deviceId");
        // 第一个参数68表示发送给设备的消息的msgCode。
        // 第二个参数参数是拟发送给设备的二进制数据。
        ACDeviceMsg reqMsg = new ACDeviceMsg(68, new byte[]{8, 8, 8, 8});
        // 参数subDomain是目标设备在AbleCloud平台上所属子域的名字。
        // 参数deviceId是目标设备的逻辑ID
        // 参数ACDeviceMsg为发送给目标设备的具体消息内容
        // 参数userId为发送该消息的用户ID
        ACDeviceMsg respMsg = bindMgr.sendToDevice(subDomainName, deviceId, reqMsg, userId);

        rspMap.put("respMsg",respMsg);


        return rspMap;
    }

    @RequestMapping("/queryMonitorParam")
    public Map<String,Object> queryMonitorParam(@RequestBody Map<String,Object> inputParam) throws Exception {

        Map<String,Object> rspMap = Maps.newHashMap();
        rspMap.put("rspCode","0000");
        rspMap.put("rspDesc","Success");

        int floor = (Integer) inputParam.get("floor");

        ACFilter filter = ac.filter().whereEqualTo("floor", 18);

        List<ACObject> results = ac.dstore(subDomainName).scanStatus().where(filter).execute();

        if(results.size()>0) {
            for(ACObject result : results ) {
                int score = 0;

                Float temperature =  result.getFloat("temperature");
                Float co2Concentration = result.getFloat("humidity");
                Float illumination = result.getFloat("cascophen");
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

        rspMap.put("paramList",results);

        Date date = DateUtil.getNowDate();
        //long startTime = date.getTime()-3600*24*7*1000;
        long startTime = date.getTime() -3600*24*7*1000;
        long endTime = date.getTime();

        List<ACObject> tempList = ac.dstore(subDomainName).statisticsHistory(33)
                .startAbsoluteTime(startTime)
                .endAbsoluteTime(endTime)
                .interval(1, ACDStore.INTERVAL_DAYS)
                .addStatistic("temperature", ACDStore.AGGR_AVG)
                .execute();

        List<ACObject> humList = ac.dstore(subDomainName).statisticsHistory(33)
                .startAbsoluteTime(startTime)
                .endAbsoluteTime(endTime)
                .interval(1, ACDStore.INTERVAL_DAYS)
                .addStatistic("humidity", ACDStore.AGGR_AVG)
                .execute();

        List<ACObject> casList = ac.dstore(subDomainName).statisticsHistory(33)
                .startAbsoluteTime(startTime)
                .endAbsoluteTime(endTime)
                .interval(1, ACDStore.INTERVAL_DAYS)
                .addStatistic("cascophen", ACDStore.AGGR_AVG)
                .execute();

        List<ACObject> pmList = ac.dstore(subDomainName).statisticsHistory(33)
                .startAbsoluteTime(startTime)
                .endAbsoluteTime(endTime)
                .interval(1, ACDStore.INTERVAL_DAYS)
                .addStatistic("pm_2_5", ACDStore.AGGR_AVG)
                .execute();

        rspMap.put("tempList",tempList);
        rspMap.put("humList",humList);
        rspMap.put("casList",casList);
        rspMap.put("pmList",pmList);

        return rspMap;
    }

}
