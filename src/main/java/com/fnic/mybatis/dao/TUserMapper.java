package com.fnic.mybatis.dao;

import com.fnic.mybatis.model.TUser;
import com.fnic.mybatis.model.TUserExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;
import java.util.List;

public interface TUserMapper {
    @SelectProvider(type=TUserSqlProvider.class, method="countByExample")
    int countByExample(TUserExample example);

    @DeleteProvider(type=TUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(TUserExample example);

    @Delete({
        "delete from t_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_user (id, email, ",
        "username, password, ",
        "account_id, user_group_id, ",
        "update_time, create_time)",
        "values (#{id,jdbcType=INTEGER}, #{email,jdbcType=VARCHAR}, ",
        "#{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{accountId,jdbcType=VARCHAR}, #{userGroupId,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(TUser record);

    @InsertProvider(type=TUserSqlProvider.class, method="insertSelective")
    int insertSelective(TUser record);

    @SelectProvider(type=TUserSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="email", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="username", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="password", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="account_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="user_group_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    List<TUser> selectByExample(TUserExample example);

    @Select({
        "select",
        "id, email, username, password, account_id, user_group_id, update_time, create_time",
        "from t_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="email", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="username", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="password", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="account_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="user_group_id", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="create_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    TUser selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TUser record, @Param("example") TUserExample example);

    @UpdateProvider(type=TUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TUser record, @Param("example") TUserExample example);

    @UpdateProvider(type=TUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TUser record);

    @Update({
        "update t_user",
        "set email = #{email,jdbcType=VARCHAR},",
          "username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "account_id = #{accountId,jdbcType=VARCHAR},",
          "user_group_id = #{userGroupId,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TUser record);
}