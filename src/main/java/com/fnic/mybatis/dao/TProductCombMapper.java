package com.fnic.mybatis.dao;

import com.fnic.mybatis.model.TProductComb;
import com.fnic.mybatis.model.TProductCombExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface TProductCombMapper {
    @SelectProvider(type=TProductCombSqlProvider.class, method="countByExample")
    int countByExample(TProductCombExample example);

    @DeleteProvider(type=TProductCombSqlProvider.class, method="deleteByExample")
    int deleteByExample(TProductCombExample example);

    @Delete({
        "delete from t_product_comb",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into t_product_comb (id, comb_id, ",
        "comb_type, item_id, ",
        "item_type, price, ",
        "show_order)",
        "values (#{id,jdbcType=VARCHAR}, #{combId,jdbcType=VARCHAR}, ",
        "#{combType,jdbcType=VARCHAR}, #{itemId,jdbcType=VARCHAR}, ",
        "#{itemType,jdbcType=VARCHAR}, #{price,jdbcType=INTEGER}, ",
        "#{showOrder,jdbcType=INTEGER})"
    })
    int insert(TProductComb record);

    @InsertProvider(type=TProductCombSqlProvider.class, method="insertSelective")
    int insertSelective(TProductComb record);

    @SelectProvider(type=TProductCombSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="comb_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="comb_type", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="item_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="item_type", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="price", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="show_order", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="product_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="product_item_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="product_icon", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="product_desc", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<TProductComb> selectByExample(TProductCombExample example);

    @Select({
        "select",
        "id, comb_id, comb_type, item_id, item_type, price, show_order",
        "from t_product_comb",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="comb_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="comb_type", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="item_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="item_type", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="price", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="show_order", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    TProductComb selectByPrimaryKey(String id);

    @UpdateProvider(type=TProductCombSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TProductComb record, @Param("example") TProductCombExample example);

    @UpdateProvider(type=TProductCombSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TProductComb record, @Param("example") TProductCombExample example);

    @UpdateProvider(type=TProductCombSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TProductComb record);

    @Update({
        "update t_product_comb",
        "set comb_id = #{combId,jdbcType=VARCHAR},",
          "comb_type = #{combType,jdbcType=VARCHAR},",
          "item_id = #{itemId,jdbcType=VARCHAR},",
          "item_type = #{itemType,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=INTEGER},",
          "show_order = #{showOrder,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TProductComb record);
}