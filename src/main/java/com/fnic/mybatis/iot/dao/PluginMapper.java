package com.fnic.mybatis.iot.dao;

import com.fnic.mybatis.iot.model.Plugin;
import com.fnic.mybatis.iot.model.PluginExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PluginMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table plugin
     *
     * @mbg.generated
     */
    long countByExample(PluginExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table plugin
     *
     * @mbg.generated
     */
    int deleteByExample(PluginExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table plugin
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table plugin
     *
     * @mbg.generated
     */
    int insert(Plugin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table plugin
     *
     * @mbg.generated
     */
    int insertSelective(Plugin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table plugin
     *
     * @mbg.generated
     */
    List<Plugin> selectByExample(PluginExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table plugin
     *
     * @mbg.generated
     */
    Plugin selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table plugin
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Plugin record, @Param("example") PluginExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table plugin
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Plugin record, @Param("example") PluginExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table plugin
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Plugin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table plugin
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Plugin record);
}