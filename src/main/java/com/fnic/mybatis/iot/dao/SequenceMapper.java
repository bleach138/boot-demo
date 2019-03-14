package com.fnic.mybatis.iot.dao;

import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

/**
 * Created by hjhuang on 2017/5/19.
 */
public interface SequenceMapper {

    @Select({
            "select",
            "nextval(#{seqName,jdbcType=VARCHAR}) next_value"
    })
    @ConstructorArgs({
            @Arg(column="next_value", javaType=String.class, jdbcType= JdbcType.INTEGER, id=true)
    })
    int selectByPrimaryKey(String seqName);
}
