package com.fnic.mybatis.dao;

import com.fnic.mybatis.model.TProductType;
import com.fnic.mybatis.model.TProductTypeExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface TProductTypeMapper {
    @SelectProvider(type=TProductTypeSqlProvider.class, method="countByExample")
    int countByExample(TProductTypeExample example);

    @DeleteProvider(type=TProductTypeSqlProvider.class, method="deleteByExample")
    int deleteByExample(TProductTypeExample example);

    @Delete({
        "delete from t_product_type",
        "where product_type_id = #{productTypeId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String productTypeId);

    @Insert({
        "insert into t_product_type (product_type_id, product_type_name, ",
        "show_order)",
        "values (#{productTypeId,jdbcType=VARCHAR}, #{productTypeName,jdbcType=VARCHAR}, ",
        "#{showOrder,jdbcType=INTEGER})"
    })
    int insert(TProductType record);

    @InsertProvider(type=TProductTypeSqlProvider.class, method="insertSelective")
    int insertSelective(TProductType record);

    @SelectProvider(type=TProductTypeSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="product_type_id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="product_type_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="show_order", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    List<TProductType> selectByExample(TProductTypeExample example);

    @Select({
        "select",
        "product_type_id, product_type_name, show_order",
        "from t_product_type",
        "where product_type_id = #{productTypeId,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
        @Arg(column="product_type_id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="product_type_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="show_order", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    TProductType selectByPrimaryKey(String productTypeId);

    @UpdateProvider(type=TProductTypeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TProductType record, @Param("example") TProductTypeExample example);

    @UpdateProvider(type=TProductTypeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TProductType record, @Param("example") TProductTypeExample example);

    @UpdateProvider(type=TProductTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TProductType record);

    @Update({
        "update t_product_type",
        "set product_type_name = #{productTypeName,jdbcType=VARCHAR},",
          "show_order = #{showOrder,jdbcType=INTEGER}",
        "where product_type_id = #{productTypeId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TProductType record);
}