package com.fnic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import javax.annotation.Resource;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
public class TestAsyncController extends BaseController {

    private ConcurrentHashMap<Long,DeferredResult<String>> resultMap = new ConcurrentHashMap<>();

    @RequestMapping("/testSync")
    public String testSync() throws Exception {
        logger.info("@@@@@@@@@@@开始执行");
        Thread.sleep(500);
        return "@@@@@@@@@@";
    }


    @RequestMapping("/testCallable")
    public Callable<String> testCallable() {
        logger.info("@@@@@@@@@@@开始执行");
        Callable<String> callable = () -> {

            Thread.sleep(5000);
            logger.info("实际工作执行完成");

            return "success";
        };
        return callable;
    }

    @RequestMapping("/testDeferredResult")
    public DeferredResult<String> testDeferredResult() {

        DeferredResult<String> deferredResult = new DeferredResult<>();
        long id = Thread.currentThread().getId();
        logger.debug("@@@@@@@@@@@@@@" + id);
        resultMap.put(1l,deferredResult);
        return deferredResult;
    }

    @RequestMapping("/setDeferredResult")
    public String setDeferredResult() {

        long id = Thread.currentThread().getId();
        logger.debug("@@@@@@@@@@@@@@" + id);
        DeferredResult<String> deferredResult = resultMap.get(1l);
        deferredResult.setResult("Test result!");
        return "success";
    }
}
