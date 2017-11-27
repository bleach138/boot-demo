package com.fnic.mybatis.model;

import java.util.Date;

public class TQos {
    private Integer id;

    private Integer qosPriority;

    private String qosName;

    private String qosCode;

    private Integer defaultRate;

    private Integer maxRate;

    private String accountId;

    private String userGroupId;

    private Date createTime;

    private Date updateTime;

    private Integer operUserId;

    public TQos(Integer id, Integer qosPriority, String qosName, String qosCode, Integer defaultRate, Integer maxRate, String accountId, String userGroupId, Date createTime, Date updateTime, Integer operUserId) {
        this.id = id;
        this.qosPriority = qosPriority;
        this.qosName = qosName;
        this.qosCode = qosCode;
        this.defaultRate = defaultRate;
        this.maxRate = maxRate;
        this.accountId = accountId;
        this.userGroupId = userGroupId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.operUserId = operUserId;
    }

    public TQos() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQosPriority() {
        return qosPriority;
    }

    public void setQosPriority(Integer qosPriority) {
        this.qosPriority = qosPriority;
    }

    public String getQosName() {
        return qosName;
    }

    public void setQosName(String qosName) {
        this.qosName = qosName == null ? null : qosName.trim();
    }

    public String getQosCode() {
        return qosCode;
    }

    public void setQosCode(String qosCode) {
        this.qosCode = qosCode == null ? null : qosCode.trim();
    }

    public Integer getDefaultRate() {
        return defaultRate;
    }

    public void setDefaultRate(Integer defaultRate) {
        this.defaultRate = defaultRate;
    }

    public Integer getMaxRate() {
        return maxRate;
    }

    public void setMaxRate(Integer maxRate) {
        this.maxRate = maxRate;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getOperUserId() {
        return operUserId;
    }

    public void setOperUserId(Integer operUserId) {
        this.operUserId = operUserId;
    }
}