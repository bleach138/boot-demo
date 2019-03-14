package com.fnic.mybatis.iot.model;

import java.util.Date;

public class TShoppingCart {
    private Integer id;

    private String goodsId;

    private String goodsName;

    private Integer operUserId;

    private String accountId;

    private String userGroupId;

    private Integer goodsNum;

    private Date startTime;

    private Date endTime;

    private Integer goodsSum;

    private String operType;

    private Date updateTime;

    private Date createTime;

    public TShoppingCart(Integer id, String goodsId, String goodsName, Integer operUserId, String accountId, String userGroupId, Integer goodsNum, Date startTime, Date endTime, Integer goodsSum, String operType, Date updateTime, Date createTime) {
        this.id = id;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.operUserId = operUserId;
        this.accountId = accountId;
        this.userGroupId = userGroupId;
        this.goodsNum = goodsNum;
        this.startTime = startTime;
        this.endTime = endTime;
        this.goodsSum = goodsSum;
        this.operType = operType;
        this.updateTime = updateTime;
        this.createTime = createTime;
    }

    public TShoppingCart() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
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

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
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

    public Integer getGoodsSum() {
        return goodsSum;
    }

    public void setGoodsSum(Integer goodsSum) {
        this.goodsSum = goodsSum;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType == null ? null : operType.trim();
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