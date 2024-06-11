package com.coffeeshop.menu.service;


import com.coffeeshop.menu.model.AddOn;
import com.coffeeshop.menu.model.Invoice;
import com.coffeeshop.menu.model.MenuItem;
import com.coffeeshop.menu.model.OrderItem;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    private final Map<String, MenuItem> menuItems = new HashMap<>();

    @Value("${menu.cappuccino}")
    private double cappuccinoPrice;

    @Value("${menu.latte}")
    private double lattePrice;

    @Value("${menu.espresso}")
    private double espressoPrice;

    @Value("${menu.cookie.chocolate}")
    private double chocolateCookiePrice;

    @Value("${menu.cookie.oatmeal}")
    private double oatmealCookiePrice;

    @PostConstruct
    public void init() {
        // Initialize Menu items
        menuItems.put("Cappuccino", new MenuItem("Cappuccino", cappuccinoPrice));
        menuItems.put("Latte", new MenuItem("Latte", lattePrice));
        menuItems.put("Espresso", new MenuItem("Espresso", espressoPrice));
        menuItems.put("Chocolate Cookie", new MenuItem("Chocolate Cookie", chocolateCookiePrice));
        menuItems.put("Oatmeal Cookie", new MenuItem("Oatmeal Cookie", oatmealCookiePrice));
    }

    @Getter
    private final Map<String, AddOn> addOns = new HashMap<>();

    public OrderService() {
        // Initialize add-ons
        addOns.put("Arabica", new AddOn("Arabica", 50));
        addOns.put("Robusta", new AddOn("Robusta", 55));
        addOns.put("Excelsa", new AddOn("Excelsa", 60));
        addOns.put("Liberica", new AddOn("Liberica", 65));
        addOns.put("Soya Milk", new AddOn("Soya Milk", 20));
        addOns.put("Almond Milk", new AddOn("Almond Milk", 30));
        addOns.put("White Sugar", new AddOn("White Sugar", 5));
        addOns.put("Honey Sugar", new AddOn("Honey Sugar", 10));
        // Add more add-ons if needed
    }

    public AddOn getAddOn(String name) {
        return addOns.get(name);
    }

    public Invoice generateInvoice(List<OrderItem> orderItems) {
        double totalPrice = calculateTotalPrice(orderItems);
        return new Invoice(orderItems, totalPrice);
    }

    public double calculateTotalPrice(List<OrderItem> orderItems) {
        double totalPrice = 0.0;
        for (OrderItem orderItem : orderItems) {
            double itemPrice = getBasePrice(orderItem.getMenuItem());
            for (AddOn addon : orderItem.getAddons()) {
                AddOn addOn = getAddOn(addon.getName());
                if (addOn != null) {
                    itemPrice += addOn.getPrice();
                }
            }
            totalPrice += itemPrice * orderItem.getQuantity();
        }
        return totalPrice;
    }

    private double getBasePrice(MenuItem menuItem) {
        return menuItems.get(menuItem.getName()).getBasePrice();
    }

}
