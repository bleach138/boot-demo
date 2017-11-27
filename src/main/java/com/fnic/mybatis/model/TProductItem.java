package com.fnic.mybatis.model;

public class TProductItem {
    private String productItemId;

    private String productItemName;

    private String productItemValue;

    public TProductItem(String productItemId, String productItemName, String productItemValue) {
        this.productItemId = productItemId;
        this.productItemName = productItemName;
        this.productItemValue = productItemValue;
    }

    public TProductItem() {
        super();
    }

    public String getProductItemId() {
        return productItemId;
    }

    public void setProductItemId(String productItemId) {
        this.productItemId = productItemId == null ? null : productItemId.trim();
    }

    public String getProductItemName() {
        return productItemName;
    }

    public void setProductItemName(String productItemName) {
        this.productItemName = productItemName == null ? null : productItemName.trim();
    }

    public String getProductItemValue() {
        return productItemValue;
    }

    public void setProductItemValue(String productItemValue) {
        this.productItemValue = productItemValue == null ? null : productItemValue.trim();
    }
}