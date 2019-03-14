package com.fnic.mybatis.iot.dao;

import com.fnic.mybatis.iot.model.TSubOrder;
import com.fnic.mybatis.iot.model.TSubOrderExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TSubOrderMapper {
    @SelectProvider(type=TSubOrderSqlProvider.class, method="countByExample")
    int countByExample(TSubOrderExample example);

    @DeleteProvider(type=TSubOrderSqlProvider.class, method="deleteByExample")
    int deleteByExample(TSubOrderExample example);

    @Delete({
        "delete from t_sub_order",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into t_sub_order (id, order_id, ",
        "status, item_id, ",
        "item_name, item_type, ",
        "item_fee, item_value, ",
        "create_time, update_time, ",
        "start_time, end_time)",
        "values (#{id,jdbcType=VARCHAR}, #{orderId,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=VARCHAR}, #{itemId,jdbcType=VARCHAR}, ",
        "#{itemName,jdbcType=VARCHAR}, #{itemType,jdbcType=VARCHAR}, ",
        "#{itemFee,jdbcType=INTEGER}, #{itemValue,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{startTime,jdbcType=TIMESTAMP}, #{endTime,jdbcType=TIMESTAMP})"
    })
    int insert(TSubOrder record);

    @InsertProvider(type=TSubOrderSqlProvider.class, method="insertSelective")
    int insertSelective(TSubOrder record);

    @SelectProvider(type=TSubOrderSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="order_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="status", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="item_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="item_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="item_type", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="item_fee", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="item_value", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="start_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="end_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    List<TSubOrder> selectByExample(TSubOrderExample example);

    @Select({
        "select",
        "id, order_id, status, item_id, item_name, item_type, item_fee, item_value, create_time, ",
        "update_time, start_time, end_time",
        "from t_sub_order",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="order_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="status", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="item_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="item_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="item_type", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="item_fee", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="item_value", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="start_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="end_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    TSubOrder selectByPrimaryKey(String id);

    @UpdateProvider(type=TSubOrderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TSubOrder record, @Param("example") TSubOrderExample example);

    @UpdateProvider(type=TSubOrderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TSubOrder record, @Param("example") TSubOrderExample example);

    @UpdateProvider(type=TSubOrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TSubOrder record);

    @Update({
        "update t_sub_order",
        "set order_id = #{orderId,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR},",
          "item_id = #{itemId,jdbcType=VARCHAR},",
          "item_name = #{itemName,jdbcType=VARCHAR},",
          "item_type = #{itemType,jdbcType=VARCHAR},",
          "item_fee = #{itemFee,jdbcType=INTEGER},",
          "item_value = #{itemValue,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "start_time = #{startTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TSubOrder record);
}