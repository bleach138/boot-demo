package com.fnic.mybatis.model;

import java.util.Date;

public class TSubOrder {
    private String id;

    private String orderId;

    private String status;

    private String itemId;

    private String itemName;

    private String itemType;

    private Integer itemFee;

    private String itemValue;

    private Date createTime;

    private Date updateTime;

    private Date startTime;

    private Date endTime;

    public TSubOrder(String id, String orderId, String status, String itemId, String itemName, String itemType, Integer itemFee, String itemValue, Date createTime, Date updateTime, Date startTime, Date endTime) {
        this.id = id;
        this.orderId = orderId;
        this.status = status;
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemFee = itemFee;
        this.itemValue = itemValue;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public TSubOrder() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType == null ? null : itemType.trim();
    }

    public Integer getItemFee() {
        return itemFee;
    }

    public void setItemFee(Integer itemFee) {
        this.itemFee = itemFee;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue == null ? null : itemValue.trim();
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
}