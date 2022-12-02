package com.vttp2022.day23_workshop.models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Product {

    private Float quantity;
    private Float unitPrice;
    private Float discount;
    private String productId;
    private String productName;
    private Float standardCost;

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getStandardCost() {
        return standardCost;
    }

    public void setStandardCost(Float standardCost) {
        this.standardCost = standardCost;
    }

    @Override
    public String toString() {
        return "Product [quantity=" + quantity + ", unitPrice=" + unitPrice + ", discount=" + discount + ", productId="
                + productId + ", productName=" + productName + ", standardCost=" + standardCost + "]";
    }

    public static Product createProduct(SqlRowSet rs) {
        Product p = new Product();
        p.setQuantity(rs.getFloat("quantity"));
        p.setUnitPrice(rs.getFloat("unit_price"));
        p.setDiscount(rs.getFloat("discount"));
        p.setProductId(rs.getString("id"));
        p.setProductName(rs.getString("product_name"));
        p.setStandardCost(rs.getFloat("standard_cost"));
        return p;
    }

}
