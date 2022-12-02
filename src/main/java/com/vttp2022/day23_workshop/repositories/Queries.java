package com.vttp2022.day23_workshop.repositories;

public class Queries {

    public static final String SQL_GET_ORDER_DETAILS = "SELECT id,order_date,customer_id FROM orders WHERE id = ?";

    public static final String SQL_GET_PRODUCT_DETAILS = "SELECT order_details.quantity,order_details.unit_price,order_details.discount,products.id,products.product_name,products.standard_cost FROM orders JOIN order_details ON orders.id = order_details.order_id JOIN products ON order_details.product_id = products.id WHERE orders.id = ?";

}
