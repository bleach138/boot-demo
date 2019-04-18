package com.fnic.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Map;

public interface MQService {

    public Map<String, Object> miaoshaMQ(final Map<String, Object> param, DeferredResult<ResponseEntity> deferredResult) throws Exception;
}
