package com.fnic.controller;

import com.fnic.mybatis.dao.TQosMapper;
import com.fnic.mybatis.model.TQos;
import com.fnic.mybatis.model.TQosExample;
import com.fnic.sysframe.utils.UserUtil;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by hjhuang on 2017/6/2.
 */
@RestController
@RequestMapping("/strategy")
public class StrategyController extends BaseController{

    @Autowired
    private TQosMapper qosMapper;

    @RequestMapping("/queryQosList")
    public Map<String,Object> queryQosList(@RequestBody Map<String,Object> inputParam) {

        Map<String,Object> rspMap = Maps.newHashMap();

        rspMap.put("rspCode","0000");
        rspMap.put("rspDesc","Success");

        TQosExample qosExample = new TQosExample();
        qosExample.createCriteria().andAccountIdEqualTo(UserUtil.getUser().getAccountId());

        List<TQos> list = qosMapper.selectByExample(qosExample);

        rspMap.put("qosList",list);

        return rspMap;
    }

}
