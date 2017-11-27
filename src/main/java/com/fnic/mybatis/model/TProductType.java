package com.fnic.mybatis.model;

public class TProductType {
    private String productTypeId;

    private String productTypeName;

    private Integer showOrder;

    public TProductType(String productTypeId, String productTypeName, Integer showOrder) {
        this.productTypeId = productTypeId;
        this.productTypeName = productTypeName;
        this.showOrder = showOrder;
    }

    public TProductType() {
        super();
    }

    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId == null ? null : productTypeId.trim();
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName == null ? null : productTypeName.trim();
    }

    public Integer getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }
}