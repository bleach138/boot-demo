package com.fnic.mybatis.iot.model;

public class TCartSubItem {
    private Integer id;

    private Integer cartId;

    private String itemId;

    private String itemName;

    private String itemType;

    private Integer itemFee;

    private String itemValue;

    private String packageId;

    public TCartSubItem(Integer id, Integer cartId, String itemId, String itemName, String itemType, Integer itemFee, String itemValue, String packageId) {
        this.id = id;
        this.cartId = cartId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemFee = itemFee;
        this.itemValue = itemValue;
        this.packageId = packageId;
    }

    public TCartSubItem() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
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

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId == null ? null : packageId.trim();
    }
}