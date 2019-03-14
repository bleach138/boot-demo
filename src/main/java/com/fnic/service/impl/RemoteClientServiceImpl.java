package com.fnic.service.impl;

import com.fnic.service.RemoteClientService;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by hjhuang on 2017/6/1.
 */
@Service
public class RemoteClientServiceImpl implements RemoteClientService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //@Value("${remote.url}")
    private String url;

    //@Value("${remote.connTimeOut}")
    private int connTimeOut;

    //@Value("${remote.invokeTimeOut}")
    private int invokeTimeOut;

    //@Value("${remote.charset}")
    private String charset;

    @Override
    public Map<String,Object> sendService(JsonObject param) {

        String rsp = null;
        Map<String,Object> rspMap = null;

        try {
            rsp = call(param);
            Gson gson = new Gson();
            rspMap = gson.fromJson(rsp,Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rspMap;
    }

    /**
     * @Title: call
     * @Description: 调用远程HTTP服务
     */
    public String call(JsonObject param) throws Exception {
        String rspXml = "";
        final HttpClient httpClient = new HttpClient();

        final PostMethod method = new PostMethod(url);
        httpClient.getParams().setConnectionManagerTimeout(connTimeOut);
        method.getParams().setSoTimeout(invokeTimeOut);
        httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, charset);

        method.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        RequestEntity entity  = new StringRequestEntity(param.toString(),"application/json;charset=UTF-8",charset);

        method.setRequestEntity(entity);

        logger.debug("@@@@@@@@@@@call:" + param);

        try {
            httpClient.executeMethod(method);
            rspXml = method.getResponseBodyAsString();
            rspXml = java.net.URLDecoder.decode(rspXml,charset);
        } catch (final HttpException e) {
           e.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
        logger.debug("[RSP_TEXT]:{}", rspXml);
        return rspXml;
    }
}
