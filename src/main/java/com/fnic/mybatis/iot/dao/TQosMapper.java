package com.fnic.mybatis.iot.dao;

import com.fnic.mybatis.iot.model.TQos;
import com.fnic.mybatis.iot.model.TQosExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

public interface TQosMapper {
    @SelectProvider(type=TQosSqlProvider.class, method="countByExample")
    int countByExample(TQosExample example);

    @DeleteProvider(type=TQosSqlProvider.class, method="deleteByExample")
    int deleteByExample(TQosExample example);

    @Delete({
        "delete from t_qos",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_qos (id, qos_priority, ",
        "qos_name, qos_code, ",
        "default_rate, max_rate, ",
        "account_id, user_group_id, ",
        "create_time, update_time, ",
        "oper_user_id)",
        "values (#{id,jdbcType=INTEGER}, #{qosPriority,jdbcType=INTEGER}, ",
        "#{qosName,jdbcType=VARCHAR}, #{qosCode,jdbcType=VARCHAR}, ",
        "#{defaultRate,jdbcType=INTEGER}, #{maxRate,jdbcType=INTEGER}, ",
        "#{accountId,jdbcType=VARCHAR}, #{userGroupId,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{operUserId,jdbcType=INTEGER})"
    })
    int insert(TQos record);

    @InsertProvider(type=TQosSqlProvider.class, method="insertSelective")
    int insertSelective(TQos record);

    @SelectProvider(type=TQosSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="qos_priority", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="qos_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="qos_code", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="default_rate", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="max_rate", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="account_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="user_group_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="oper_user_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    List<TQos> selectByExample(TQosExample example);

    @Select({
        "select",
        "id, qos_priority, qos_name, qos_code, default_rate, max_rate, account_id, user_group_id, ",
        "create_time, update_time, oper_user_id",
        "from t_qos",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="qos_priority", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="qos_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="qos_code", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="default_rate", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="max_rate", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="account_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="user_group_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="oper_user_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    TQos selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TQosSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TQos record, @Param("example") TQosExample example);

    @UpdateProvider(type=TQosSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TQos record, @Param("example") TQosExample example);

    @UpdateProvider(type=TQosSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TQos record);

    @Update({
        "update t_qos",
        "set qos_priority = #{qosPriority,jdbcType=INTEGER},",
          "qos_name = #{qosName,jdbcType=VARCHAR},",
          "qos_code = #{qosCode,jdbcType=VARCHAR},",
          "default_rate = #{defaultRate,jdbcType=INTEGER},",
          "max_rate = #{maxRate,jdbcType=INTEGER},",
          "account_id = #{accountId,jdbcType=VARCHAR},",
          "user_group_id = #{userGroupId,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "oper_user_id = #{operUserId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TQos record);
}