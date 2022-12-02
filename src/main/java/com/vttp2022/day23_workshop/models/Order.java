package com.vttp2022.day23_workshop.models;

import java.util.LinkedList;
import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Order {

    private String orderId;
    private String orderDate;
    private String customerId;
    private List<Product> products = new LinkedList<>();

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", customerId=" + customerId + ", products="
                + products + "]";
    }

    public static Order createOrder(SqlRowSet rs, List<Product> products) {
        Order o = new Order();
        o.setOrderId(rs.getString("id"));
        o.setOrderDate(rs.getString("order_date"));
        o.setCustomerId(rs.getString("customer_id"));
        o.setProducts(products);
        return o;
    }

}
