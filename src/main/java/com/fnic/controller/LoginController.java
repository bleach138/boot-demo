package com.fnic.controller;

import com.fnic.mybatis.iot.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hjhuang on 2017/5/17.
 */
@RestController
public class LoginController extends BaseController {

    @RequestMapping("/login/success")
    public Map<String, Object> loginSuccess(User user) throws Exception {

        Map<String, Object> rspMap = new HashMap<>();
        rspMap.put("rspCode", "0000");
        rspMap.put("rspDesc", "Login Success");

        return rspMap;
    }

    @RequestMapping("/logout/success")
    public Map<String, Object> logoutSuccess() throws Exception {

        Map<String, Object> rspMap = new HashMap<>();
        rspMap.put("rspCode", "0000");
        rspMap.put("rspDesc", "Logout Success");

        return rspMap;
    }
}
