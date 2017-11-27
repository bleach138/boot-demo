package com.fnic.mybatis.dao;

import com.fnic.mybatis.model.TOrder;
import com.fnic.mybatis.model.TOrderExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

public interface TOrderMapper {
    @SelectProvider(type=TOrderSqlProvider.class, method="countByExample")
    int countByExample(TOrderExample example);

    @DeleteProvider(type=TOrderSqlProvider.class, method="deleteByExample")
    int deleteByExample(TOrderExample example);

    @Delete({
        "delete from t_order",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into t_order (id, status, ",
        "subject, account_id, ",
        "oper_user_id, create_time, ",
        "update_time, total_fee, ",
        "user_group_id, remark)",
        "values (#{id,jdbcType=VARCHAR}, #{status,jdbcType=VARCHAR}, ",
        "#{subject,jdbcType=VARCHAR}, #{accountId,jdbcType=VARCHAR}, ",
        "#{operUserId,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{totalFee,jdbcType=INTEGER}, ",
        "#{userGroupId,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR})"
    })
    int insert(TOrder record);

    @InsertProvider(type=TOrderSqlProvider.class, method="insertSelective")
    int insertSelective(TOrder record);

    @SelectProvider(type=TOrderSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="status", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="subject", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="account_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="oper_user_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="total_fee", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="user_group_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="remark", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<TOrder> selectByExample(TOrderExample example);

    @Select({
        "select",
        "id, status, subject, account_id, oper_user_id, create_time, update_time, total_fee, ",
        "user_group_id, remark",
        "from t_order",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="status", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="subject", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="account_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="oper_user_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="total_fee", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="user_group_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="remark", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    TOrder selectByPrimaryKey(String id);

    @UpdateProvider(type=TOrderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TOrder record, @Param("example") TOrderExample example);

    @UpdateProvider(type=TOrderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TOrder record, @Param("example") TOrderExample example);

    @UpdateProvider(type=TOrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TOrder record);

    @Update({
        "update t_order",
        "set status = #{status,jdbcType=VARCHAR},",
          "subject = #{subject,jdbcType=VARCHAR},",
          "account_id = #{accountId,jdbcType=VARCHAR},",
          "oper_user_id = #{operUserId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "total_fee = #{totalFee,jdbcType=INTEGER},",
          "user_group_id = #{userGroupId,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TOrder record);
}