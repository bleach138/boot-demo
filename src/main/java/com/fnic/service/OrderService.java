package com.fnic.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface OrderService  {

    @Transactional
    public boolean submitShoppingCart(Map<String,Object> inputParam) throws Exception;

    @Transactional
    public boolean submitOrder(List<Integer> idList) throws Exception;
}