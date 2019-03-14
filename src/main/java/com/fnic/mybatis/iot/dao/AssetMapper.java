package com.fnic.mybatis.iot.dao;

import com.fnic.mybatis.iot.model.Asset;
import com.fnic.mybatis.iot.model.AssetExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AssetMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table asset
     *
     * @mbg.generated
     */
    long countByExample(AssetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table asset
     *
     * @mbg.generated
     */
    int deleteByExample(AssetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table asset
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table asset
     *
     * @mbg.generated
     */
    int insert(Asset record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table asset
     *
     * @mbg.generated
     */
    int insertSelective(Asset record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table asset
     *
     * @mbg.generated
     */
    List<Asset> selectByExample(AssetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table asset
     *
     * @mbg.generated
     */
    Asset selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table asset
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Asset record, @Param("example") AssetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table asset
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Asset record, @Param("example") AssetExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table asset
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Asset record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table asset
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Asset record);
}