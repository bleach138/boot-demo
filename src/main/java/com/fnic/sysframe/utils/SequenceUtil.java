package com.fnic.sysframe.utils;

import com.fnic.mybatis.dao.SequenceMapper;
import com.fnic.sysframe.service.SpringBeanService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hjhuang on 2017/5/19.
 */
public class SequenceUtil {

    private static SequenceMapper sequenceMapper = SpringBeanService.getBean(SequenceMapper.class);

    public static String T_SHOPPING_CART = "T_SHOPPING_CART";

    public static String T_CART_SUB_ITEM = "T_CART_SUB_ITEM";

    public static String T_ORDER = "T_ORDER";

    public static String T_SUB_ORDER = "T_SUB_ORDER";

    public static String T_QOS_ORDER = "T_QOS_ORDER";

    public static String T_QOS = "T_QOS";

    public static int getNext(String seqName) {

        return sequenceMapper.selectByPrimaryKey(seqName);
    }

    public static String getLogId(String seqName) {

        int id = sequenceMapper.selectByPrimaryKey(seqName);
        String logId = String.format("%06d", id);

        logId = DateUtil.getNowTimeStr() + logId.substring(logId.length()-6,logId.length());

        return  logId ;
    }
}
