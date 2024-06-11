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
public class OrderItem {
    private MenuItem menuItem;
    private List<AddOn> addons;
    private int quantity;

    public double getTotalPrice() {
        double addonsCost = addons.stream().mapToDouble(AddOn::getPrice).sum();
        return (menuItem.getBasePrice() + addonsCost) * quantity;
    }
}