package com.fnic.mybatis.dao;

import com.fnic.mybatis.model.TProductItem;
import com.fnic.mybatis.model.TProductItemExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface TProductItemMapper {
    @SelectProvider(type=TProductItemSqlProvider.class, method="countByExample")
    int countByExample(TProductItemExample example);

    @DeleteProvider(type=TProductItemSqlProvider.class, method="deleteByExample")
    int deleteByExample(TProductItemExample example);

    @Delete({
        "delete from t_product_item",
        "where product_item_id = #{productItemId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String productItemId);

    @Insert({
        "insert into t_product_item (product_item_id, product_item_name, ",
        "product_item_value)",
        "values (#{productItemId,jdbcType=VARCHAR}, #{productItemName,jdbcType=VARCHAR}, ",
        "#{productItemValue,jdbcType=VARCHAR})"
    })
    int insert(TProductItem record);

    @InsertProvider(type=TProductItemSqlProvider.class, method="insertSelective")
    int insertSelective(TProductItem record);

    @SelectProvider(type=TProductItemSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="product_item_id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="product_item_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="product_item_value", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<TProductItem> selectByExample(TProductItemExample example);

    @Select({
        "select",
        "product_item_id, product_item_name, product_item_value",
        "from t_product_item",
        "where product_item_id = #{productItemId,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
        @Arg(column="product_item_id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="product_item_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="product_item_value", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    TProductItem selectByPrimaryKey(String productItemId);

    @UpdateProvider(type=TProductItemSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TProductItem record, @Param("example") TProductItemExample example);

    @UpdateProvider(type=TProductItemSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TProductItem record, @Param("example") TProductItemExample example);

    @UpdateProvider(type=TProductItemSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TProductItem record);

    @Update({
        "update t_product_item",
        "set product_item_name = #{productItemName,jdbcType=VARCHAR},",
          "product_item_value = #{productItemValue,jdbcType=VARCHAR}",
        "where product_item_id = #{productItemId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TProductItem record);
}