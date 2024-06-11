package com.coffeeshop.menu.model;

import java.util.List;

public class Invoice {
    private List<OrderItem> orderItems;
    private double totalPrice;

    public Invoice(List<OrderItem> orderItems, double totalPrice) {
        this.orderItems = orderItems;
        this.totalPrice = totalPrice;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
