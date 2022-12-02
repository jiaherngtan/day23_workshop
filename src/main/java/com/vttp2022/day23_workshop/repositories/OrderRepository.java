package com.vttp2022.day23_workshop.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.vttp2022.day23_workshop.models.Order;
import com.vttp2022.day23_workshop.models.Product;

import static com.vttp2022.day23_workshop.repositories.Queries.*;

import java.util.LinkedList;
import java.util.List;

@Repository
public class OrderRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Order getOrderDetails(String id) {

        final SqlRowSet rsForProduct = jdbcTemplate.queryForRowSet(
                SQL_GET_PRODUCT_DETAILS, id);

        List<Product> products = new LinkedList<>();
        while (rsForProduct.next())
            products.add(Product.createProduct(rsForProduct));

        final SqlRowSet rsForOrder = jdbcTemplate.queryForRowSet(
                SQL_GET_ORDER_DETAILS, id);

        Order order = new Order();
        while (rsForOrder.next())
            order = Order.createOrder(rsForOrder, products);

        return order;
    }
}
