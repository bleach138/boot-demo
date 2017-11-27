package com.fnic.mybatis.model;

import java.util.Date;

public class TUser {
    private Integer id;

    private String email;

    private String username;

    private String password;

    private String accountId;

    private String userGroupId;

    private Date updateTime;

    private Date createTime;

    public TUser(Integer id, String email, String username, String password, String accountId, String userGroupId, Date updateTime, Date createTime) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.accountId = accountId;
        this.userGroupId = userGroupId;
        this.updateTime = updateTime;
        this.createTime = createTime;
    }

    public TUser() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    public String getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(String userGroupId) {
        this.userGroupId = userGroupId == null ? null : userGroupId.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}