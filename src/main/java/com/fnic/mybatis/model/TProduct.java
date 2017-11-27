package com.fnic.mybatis.model;

public class TProduct {
    private String productId;

    private String productName;

    private String icon;

    private String desc;

    public TProduct(String productId, String productName, String icon, String desc) {
        this.productId = productId;
        this.productName = productName;
        this.icon = icon;
        this.desc = desc;
    }

    public TProduct() {
        super();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}