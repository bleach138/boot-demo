package com.fnic.mybatis.dao;

import com.fnic.mybatis.model.TQosOrder;
import com.fnic.mybatis.model.TQosOrderExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

public interface TQosOrderMapper {
    @SelectProvider(type=TQosOrderSqlProvider.class, method="countByExample")
    int countByExample(TQosOrderExample example);

    @DeleteProvider(type=TQosOrderSqlProvider.class, method="deleteByExample")
    int deleteByExample(TQosOrderExample example);

    @Delete({
        "delete from t_qos_order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_qos_order (id, band_width, ",
        "start_time, end_time, ",
        "oper_user_id, account_id, ",
        "user_group_id, create_time, ",
        "update_time, status, ",
        "remark)",
        "values (#{id,jdbcType=INTEGER}, #{bandWidth,jdbcType=INTEGER}, ",
        "#{startTime,jdbcType=TIMESTAMP}, #{endTime,jdbcType=TIMESTAMP}, ",
        "#{operUserId,jdbcType=INTEGER}, #{accountId,jdbcType=VARCHAR}, ",
        "#{userGroupId,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{status,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR})"
    })
    int insert(TQosOrder record);

    @InsertProvider(type=TQosOrderSqlProvider.class, method="insertSelective")
    int insertSelective(TQosOrder record);

    @SelectProvider(type=TQosOrderSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="band_width", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="start_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="end_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="oper_user_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="account_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="user_group_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="status", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="remark", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<TQosOrder> selectByExample(TQosOrderExample example);

    @Select({
        "select",
        "id, band_width, start_time, end_time, oper_user_id, account_id, user_group_id, ",
        "create_time, update_time, status, remark",
        "from t_qos_order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="band_width", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="start_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="end_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="oper_user_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="account_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="user_group_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="status", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="remark", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    TQosOrder selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TQosOrderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TQosOrder record, @Param("example") TQosOrderExample example);

    @UpdateProvider(type=TQosOrderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TQosOrder record, @Param("example") TQosOrderExample example);

    @UpdateProvider(type=TQosOrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TQosOrder record);

    @Update({
        "update t_qos_order",
        "set band_width = #{bandWidth,jdbcType=INTEGER},",
          "start_time = #{startTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "oper_user_id = #{operUserId,jdbcType=INTEGER},",
          "account_id = #{accountId,jdbcType=VARCHAR},",
          "user_group_id = #{userGroupId,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TQosOrder record);
}