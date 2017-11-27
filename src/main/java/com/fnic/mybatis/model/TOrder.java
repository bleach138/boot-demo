package com.fnic.mybatis.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TOrder {
    private String id;

    private String status;

    private String subject;

    private String accountId;

    private Integer operUserId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    private Date updateTime;

    private Integer totalFee;

    private String userGroupId;

    private String remark;

    public TOrder(String id, String status, String subject, String accountId, Integer operUserId, Date createTime, Date updateTime, Integer totalFee, String userGroupId, String remark) {
        this.id = id;
        this.status = status;
        this.subject = subject;
        this.accountId = accountId;
        this.operUserId = operUserId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.totalFee = totalFee;
        this.userGroupId = userGroupId;
        this.remark = remark;
    }

    public TOrder() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    public Integer getOperUserId() {
        return operUserId;
    }

    public void setOperUserId(Integer operUserId) {
        this.operUserId = operUserId;
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

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(String userGroupId) {
        this.userGroupId = userGroupId == null ? null : userGroupId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}