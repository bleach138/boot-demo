package com.fnic.controller;

import com.fnic.service.OrderService;
import com.fnic.service.TestService;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by hjhuang on 2018/6/21.
 */
@Controller
@RequestMapping("/test")
public class TestController extends BaseController {

    @Resource
    private OrderService orderService;

    @Resource
    private TestService testServcie;

    @RequestMapping(value="test")
    @ResponseBody
    public Map<String,Object> test() throws Exception {


        Map<String,Object> rspMap = Maps.newHashMap();
        String rspCode = "0000";
        rspMap.put("rspDesc","sssss");

        orderService.test();

        return rspMap;
    }

    @RequestMapping(value="miaosha")
    @ResponseBody
    public Map<String,Object> miaosha() {

        Map<String,Object> param = Maps.newHashMap();
        Map<String,Object> rspMap = Maps.newHashMap();
        try {
            //redis+乐观锁
//            rspMap = testServcie.miaosha(param);

            //redis+ MQ
            param.put("ts",System.currentTimeMillis());
            rspMap = testServcie.miaoshaMQ(param);
        } catch (Exception e) {
            logger.error("@@@@@@@@@@@@@@@");
            e.printStackTrace();
        }
        return rspMap;
    }
}
