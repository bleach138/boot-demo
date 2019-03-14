package com.fnic.mybatis.iot.dao;

import com.fnic.mybatis.iot.model.TProduct;
import com.fnic.mybatis.iot.model.TProductExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface TProductMapper {
    @SelectProvider(type=TProductSqlProvider.class, method="countByExample")
    int countByExample(TProductExample example);

    @DeleteProvider(type=TProductSqlProvider.class, method="deleteByExample")
    int deleteByExample(TProductExample example);

    @Delete({
        "delete from t_product",
        "where product_id = #{productId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String productId);

    @Insert({
        "insert into t_product (product_id, product_name, ",
        "icon, desc)",
        "values (#{productId,jdbcType=VARCHAR}, #{productName,jdbcType=VARCHAR}, ",
        "#{icon,jdbcType=VARCHAR}, #{desc,jdbcType=VARCHAR})"
    })
    int insert(TProduct record);

    @InsertProvider(type=TProductSqlProvider.class, method="insertSelective")
    int insertSelective(TProduct record);

    @SelectProvider(type=TProductSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="product_id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="product_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="icon", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="desc", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<TProduct> selectByExample(TProductExample example);

    @Select({
        "select",
        "product_id, product_name, icon, desc",
        "from t_product",
        "where product_id = #{productId,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
        @Arg(column="product_id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="product_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="icon", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="desc", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    TProduct selectByPrimaryKey(String productId);

    @UpdateProvider(type=TProductSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TProduct record, @Param("example") TProductExample example);

    @UpdateProvider(type=TProductSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TProduct record, @Param("example") TProductExample example);

    @UpdateProvider(type=TProductSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TProduct record);

    @Update({
        "update t_product",
        "set product_name = #{productName,jdbcType=VARCHAR},",
          "icon = #{icon,jdbcType=VARCHAR},",
          "desc = #{desc,jdbcType=VARCHAR}",
        "where product_id = #{productId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TProduct record);
}