package com.vttp2022.day23_workshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vttp2022.day23_workshop.models.Order;
import com.vttp2022.day23_workshop.models.Product;
import com.vttp2022.day23_workshop.repositories.OrderRepository;

@Controller
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping(path = "/")
    public String generateMainPage(Model model) {
        return "main";
    }

    @GetMapping(path = "/order/total/{id}")
    public String getOrderDetails(
            @PathVariable String id,
            Model model) {
        Order order = orderRepository.getOrderDetails(id);
        List<Product> products = order.getProducts();
        int totalPrice = 0;
        for (Product p : products)
            totalPrice += p.getQuantity() * p.getUnitPrice() * (100 - p.getDiscount()) / 100;
        model.addAttribute("orderId", order.getOrderId());
        model.addAttribute("orderDate", order.getOrderDate());
        model.addAttribute("customerId", order.getCustomerId());
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("products", products);
        return "result";
    }

    @PostMapping(path = "/search")
    public String redirectToOrderDetails(@RequestParam(value = "id", required = true) String orderId) {
        return "redirect:/order/total/" + orderId;
    }

}
