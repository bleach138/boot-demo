package com.fnic.mybatis.iot.model;

import java.util.Date;

public class TQosOrder {
    private Integer id;

    private Integer bandWidth;

    private Date startTime;

    private Date endTime;

    private Integer operUserId;

    private String accountId;

    private String userGroupId;

    private Date createTime;

    private Date updateTime;

    private String status;

    private String remark;

    public TQosOrder(Integer id, Integer bandWidth, Date startTime, Date endTime, Integer operUserId, String accountId, String userGroupId, Date createTime, Date updateTime, String status, String remark) {
        this.id = id;
        this.bandWidth = bandWidth;
        this.startTime = startTime;
        this.endTime = endTime;
        this.operUserId = operUserId;
        this.accountId = accountId;
        this.userGroupId = userGroupId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
        this.remark = remark;
    }

    public TQosOrder() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBandWidth() {
        return bandWidth;
    }

    public void setBandWidth(Integer bandWidth) {
        this.bandWidth = bandWidth;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getOperUserId() {
        return operUserId;
    }

    public void setOperUserId(Integer operUserId) {
        this.operUserId = operUserId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}