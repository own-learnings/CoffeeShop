package com.coffeeshop.menu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Generated
public class Order {
    private List<OrderItem> orderItems;

    public double getTotalPrice() {
        return orderItems.stream().mapToDouble(OrderItem::getTotalPrice).sum();
    }
}