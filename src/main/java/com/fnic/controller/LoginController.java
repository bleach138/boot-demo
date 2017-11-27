package com.fnic.controller;

import com.ablecloud.common.ACAccount;
import com.ablecloud.common.ACContext;
import com.ablecloud.service.ACAccountMgr;
import com.fnic.mybatis.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping("/loginIOT")
    public Map<String, Object> loginIOT(@RequestBody Map<String,Object> inputParam) throws Exception {

        String userName = (String) inputParam.get("userName");
        String password = (String) inputParam.get("password");

        ACContext ctx = ac.newContext(subDomainName);
        // 实例化ACAccountMgr对象
        ACAccountMgr accountMgr = ac.accountMgr(ctx);
        // 使用帐号密码登录
        Map<String, Object> rspMap = new HashMap<>();

        try{
            ACAccount user = accountMgr.login(userName, password);
            if(user != null) {
                rspMap.put("rspCode", "0000");
                rspMap.put("rspDesc", "Login Success");
            }
        }catch (Exception e) {
            rspMap.put("rspCode", "9999");
            rspMap.put("rspDesc", "Login failed");
        }

        return rspMap;
    }
}
