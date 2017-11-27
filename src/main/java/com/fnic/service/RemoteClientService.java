package com.fnic.service;

import com.google.gson.JsonObject;

import java.util.Map;

/**
 * Created by hjhuang on 2017/6/1.
 */
public interface RemoteClientService {
    public Map<String,Object> sendService(JsonObject param);
}
