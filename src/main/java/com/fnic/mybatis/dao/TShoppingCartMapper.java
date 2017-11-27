package com.fnic.mybatis.dao;

import com.fnic.mybatis.model.TShoppingCart;
import com.fnic.mybatis.model.TShoppingCartExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

public interface TShoppingCartMapper {
    @SelectProvider(type=TShoppingCartSqlProvider.class, method="countByExample")
    int countByExample(TShoppingCartExample example);

    @DeleteProvider(type=TShoppingCartSqlProvider.class, method="deleteByExample")
    int deleteByExample(TShoppingCartExample example);

    @Delete({
        "delete from t_shopping_cart",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_shopping_cart (id, goods_id, ",
        "goods_name, oper_user_id, ",
        "account_id, user_group_id, ",
        "goods_num, start_time, ",
        "end_time, goods_sum, ",
        "oper_type, update_time, ",
        "create_time)",
        "values (#{id,jdbcType=INTEGER}, #{goodsId,jdbcType=VARCHAR}, ",
        "#{goodsName,jdbcType=VARCHAR}, #{operUserId,jdbcType=INTEGER}, ",
        "#{accountId,jdbcType=VARCHAR}, #{userGroupId,jdbcType=VARCHAR}, ",
        "#{goodsNum,jdbcType=INTEGER}, #{startTime,jdbcType=TIMESTAMP}, ",
        "#{endTime,jdbcType=TIMESTAMP}, #{goodsSum,jdbcType=INTEGER}, ",
        "#{operType,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(TShoppingCart record);

    @InsertProvider(type=TShoppingCartSqlProvider.class, method="insertSelective")
    int insertSelective(TShoppingCart record);

    @SelectProvider(type=TShoppingCartSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="goods_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="goods_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="oper_user_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="account_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="user_group_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="goods_num", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="start_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="end_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="goods_sum", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="oper_type", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    List<TShoppingCart> selectByExample(TShoppingCartExample example);

    @Select({
        "select",
        "id, goods_id, goods_name, oper_user_id, account_id, user_group_id, goods_num, ",
        "start_time, end_time, goods_sum, oper_type, update_time, create_time",
        "from t_shopping_cart",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="goods_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="goods_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="oper_user_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="account_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="user_group_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="goods_num", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="start_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="end_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="goods_sum", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="oper_type", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    TShoppingCart selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TShoppingCartSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TShoppingCart record, @Param("example") TShoppingCartExample example);

    @UpdateProvider(type=TShoppingCartSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TShoppingCart record, @Param("example") TShoppingCartExample example);

    @UpdateProvider(type=TShoppingCartSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TShoppingCart record);

    @Update({
        "update t_shopping_cart",
        "set goods_id = #{goodsId,jdbcType=VARCHAR},",
          "goods_name = #{goodsName,jdbcType=VARCHAR},",
          "oper_user_id = #{operUserId,jdbcType=INTEGER},",
          "account_id = #{accountId,jdbcType=VARCHAR},",
          "user_group_id = #{userGroupId,jdbcType=VARCHAR},",
          "goods_num = #{goodsNum,jdbcType=INTEGER},",
          "start_time = #{startTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "goods_sum = #{goodsSum,jdbcType=INTEGER},",
          "oper_type = #{operType,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TShoppingCart record);
}