package com.coffeeshop.menu.controller;


import com.coffeeshop.menu.dto.OrderRequest;
import com.coffeeshop.menu.model.Invoice;
import com.coffeeshop.menu.model.Order;
import com.coffeeshop.menu.model.OrderItem;
import com.coffeeshop.menu.service.AddOnService;
import com.coffeeshop.menu.service.MenuService;
import com.coffeeshop.menu.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private AddOnService addonService;

    @Autowired
    private OrderService orderService;

    @PostMapping
    public double createOrder(@RequestBody List<OrderRequest> orderRequests) {
        List<OrderItem> orderItems = orderRequests.stream()
                .map(request -> new OrderItem(menuService.getMenuItem(request.getMenuItem()), request.getAddonNames().stream()
                        .map(addonService::getAddOn)
                        .collect(Collectors.toList()),
                        request.getQuantity()))
                .collect(Collectors.toList());

        Order order = new Order(orderItems);
        return order.getTotalPrice();
    }

    @GetMapping("/order/invoice")
    public Invoice getInvoice(@RequestBody List<OrderItem> orderItems) {
        return orderService.generateInvoice(orderItems);
    }

    @GetMapping
    public String healthCheck() {
        return "Coffee Shop is running!";
    }
}
