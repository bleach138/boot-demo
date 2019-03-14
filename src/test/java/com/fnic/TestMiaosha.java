package com.fnic;

import com.fnic.service.TestService;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= BootApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestMiaosha {

    @Resource
    private TestService testService;

    @Test
    public void testMiaosha(){

        int threadNum = 1000;

        ExecutorService executor = Executors.newFixedThreadPool(threadNum);

        for(int i=0;i<threadNum;i++) {
            executor.execute(() -> {
                Map<String,Object> param = Maps.newHashMap();

                try {
                    testService.miaosha(param);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } );

        }

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
