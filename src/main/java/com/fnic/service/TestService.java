package com.fnic.service;

import java.util.Map;

public interface TestService {

    public Map<String,Object> miaosha(Map<String,Object> param) throws Exception;

    public Map<String,Object> miaoshaMQ(Map<String,Object> param) throws Exception;
}
