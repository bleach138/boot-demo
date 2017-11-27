package com.fnic.mybatis.dao;

import com.fnic.mybatis.model.UserRole;
import com.fnic.mybatis.model.UserRoleExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface UserRoleMapper {
    @SelectProvider(type=UserRoleSqlProvider.class, method="countByExample")
    int countByExample(UserRoleExample example);

    @DeleteProvider(type=UserRoleSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserRoleExample example);

    @Insert({
        "insert into user_role (user_id, role_id)",
        "values (#{userId,jdbcType=INTEGER}, #{roleId,jdbcType=INTEGER})"
    })
    int insert(UserRole record);

    @InsertProvider(type=UserRoleSqlProvider.class, method="insertSelective")
    int insertSelective(UserRole record);

    @SelectProvider(type=UserRoleSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="user_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="role_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    List<UserRole> selectByExample(UserRoleExample example);

    @UpdateProvider(type=UserRoleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserRole record, @Param("fnic") UserRoleExample example);

    @UpdateProvider(type=UserRoleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserRole record, @Param("fnic") UserRoleExample example);
}