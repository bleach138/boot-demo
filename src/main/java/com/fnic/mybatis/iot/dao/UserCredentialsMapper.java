package com.fnic.mybatis.iot.dao;

import com.fnic.mybatis.iot.model.UserCredentials;
import com.fnic.mybatis.iot.model.UserCredentialsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserCredentialsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_credentials
     *
     * @mbg.generated
     */
    long countByExample(UserCredentialsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_credentials
     *
     * @mbg.generated
     */
    int deleteByExample(UserCredentialsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_credentials
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_credentials
     *
     * @mbg.generated
     */
    int insert(UserCredentials record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_credentials
     *
     * @mbg.generated
     */
    int insertSelective(UserCredentials record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_credentials
     *
     * @mbg.generated
     */
    List<UserCredentials> selectByExample(UserCredentialsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_credentials
     *
     * @mbg.generated
     */
    UserCredentials selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_credentials
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") UserCredentials record, @Param("example") UserCredentialsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_credentials
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") UserCredentials record, @Param("example") UserCredentialsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_credentials
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(UserCredentials record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_credentials
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(UserCredentials record);
}