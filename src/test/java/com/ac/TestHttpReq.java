package com.ac;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.Request;
import org.junit.Test;

public class TestHttpReq {

    public String host = "122.97.128.4:5000";

    public String loginUrl =  host + "/zc-account/v1/login";

    @Test
    public void test() {



        HttpClient client = new HttpClient();

        Request httpReq = client.POST(loginUrl);

        httpReq = dealRequest(httpReq);

    }

    private Request dealRequest(Request httpReq) {
        httpReq.header("Content-Type", "application/x-zc-object");
        //httpReq.header("Content-Length", String.valueOf(length));
        //httpReq.header("X-Zc-Content-Length", String.valueOf(length));


        httpReq.header("X-Zc-Major-Domain","future-network");



        httpReq.header("X-Zc-Sub-Domain", "hfwifi");



        httpReq.header("X-Zc-Major-Domain-Id", "1");

        httpReq.header("X-Zc-Developer-Id", "1");

        httpReq.header("X-Zc-Trace-Id", "d93b6dfeb27342e08d67a50a79e0c5f8");

        httpReq.header("X-Zc-Access-Key", "7b10239e4082a2ef804c5de8577df8ce");

        httpReq.header("X-Zc-Timeout", "5000");

        httpReq.header("X-Zc-Developer-Signature", "fb53c31f84401b68987214a70e2863757dd5d7448485358a0cbbb21724e19b49");


        return  httpReq;
    }
}
