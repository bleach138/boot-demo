package com.fnic.mybatis.dao;

import com.fnic.mybatis.model.TCartSubItem;
import com.fnic.mybatis.model.TCartSubItemExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface TCartSubItemMapper {
    @SelectProvider(type=TCartSubItemSqlProvider.class, method="countByExample")
    int countByExample(TCartSubItemExample example);

    @DeleteProvider(type=TCartSubItemSqlProvider.class, method="deleteByExample")
    int deleteByExample(TCartSubItemExample example);

    @Delete({
        "delete from t_cart_sub_item",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_cart_sub_item (id, cart_id, ",
        "item_id, item_name, ",
        "item_type, item_fee, ",
        "item_value, package_id)",
        "values (#{id,jdbcType=INTEGER}, #{cartId,jdbcType=INTEGER}, ",
        "#{itemId,jdbcType=VARCHAR}, #{itemName,jdbcType=VARCHAR}, ",
        "#{itemType,jdbcType=VARCHAR}, #{itemFee,jdbcType=INTEGER}, ",
        "#{itemValue,jdbcType=VARCHAR}, #{packageId,jdbcType=VARCHAR})"
    })
    int insert(TCartSubItem record);

    @InsertProvider(type=TCartSubItemSqlProvider.class, method="insertSelective")
    int insertSelective(TCartSubItem record);

    @SelectProvider(type=TCartSubItemSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="cart_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="item_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="item_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="item_type", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="item_fee", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="item_value", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="package_id", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<TCartSubItem> selectByExample(TCartSubItemExample example);

    @Select({
        "select",
        "id, cart_id, item_id, item_name, item_type, item_fee, item_value, package_id",
        "from t_cart_sub_item",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="cart_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="item_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="item_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="item_type", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="item_fee", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="item_value", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="package_id", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    TCartSubItem selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TCartSubItemSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TCartSubItem record, @Param("example") TCartSubItemExample example);

    @UpdateProvider(type=TCartSubItemSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TCartSubItem record, @Param("example") TCartSubItemExample example);

    @UpdateProvider(type=TCartSubItemSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TCartSubItem record);

    @Update({
        "update t_cart_sub_item",
        "set cart_id = #{cartId,jdbcType=INTEGER},",
          "item_id = #{itemId,jdbcType=VARCHAR},",
          "item_name = #{itemName,jdbcType=VARCHAR},",
          "item_type = #{itemType,jdbcType=VARCHAR},",
          "item_fee = #{itemFee,jdbcType=INTEGER},",
          "item_value = #{itemValue,jdbcType=VARCHAR},",
          "package_id = #{packageId,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TCartSubItem record);
}