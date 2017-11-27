package com.fnic.controller;

import com.ablecloud.cloudservice.ACCloud;
import com.ablecloud.common.ACConfig;
import com.ablecloud.service.AC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by hjhuang on 2017/5/24.
 */
public class BaseController {
    public Logger logger = LoggerFactory.getLogger(this.getClass());

    public String subDomainName = "envmontior";
    public String physicalId = "ACCF23FF8888";
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
}
