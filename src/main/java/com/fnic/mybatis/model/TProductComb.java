package com.fnic.mybatis.model;

public class TProductComb {
    private String id;

    private String combId;

    private String combType;

    private String itemId;

    private String itemType;

    private Integer price;

    private Integer showOrder;

    private String productName;

    private String productItemName;

    private String productIcon;

    private String productDesc;

    public TProductComb(String id, String combId, String combType, String itemId, String itemType, Integer price, Integer showOrder, String productName, String productItemName, String productIcon, String productDesc) {
        this.id = id;
        this.combId = combId;
        this.combType = combType;
        this.itemId = itemId;
        this.itemType = itemType;
        this.price = price;
        this.showOrder = showOrder;
        this.productName = productName;
        this.productItemName = productItemName;
        this.productIcon = productIcon;
        this.productDesc = productDesc;
    }

    public TProductComb() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCombId() {
        return combId;
    }

    public void setCombId(String combId) {
        this.combId = combId == null ? null : combId.trim();
    }

    public String getCombType() {
        return combType;
    }

    public void setCombType(String combType) {
        this.combType = combType == null ? null : combType.trim();
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType == null ? null : itemType.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductItemName() {
        return productItemName;
    }

    public void setProductItemName(String productItemName) {
        this.productItemName = productItemName;
    }

    public String getProductIcon() {
        return productIcon;
    }

    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
}