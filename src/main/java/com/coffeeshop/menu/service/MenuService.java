package com.coffeeshop.menu.service;


import com.coffeeshop.menu.model.MenuItem;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MenuService {

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
        menuItems.put("Cappuccino", new MenuItem("Cappuccino", cappuccinoPrice));
        menuItems.put("Latte", new MenuItem("Latte", lattePrice));
        menuItems.put("Espresso", new MenuItem("Espresso", espressoPrice));
        menuItems.put("Chocolate Cookie", new MenuItem("Chocolate Cookie", chocolateCookiePrice));
        menuItems.put("Oatmeal Cookie", new MenuItem("Oatmeal Cookie", oatmealCookiePrice));
    }

    public MenuItem getMenuItem(String name) {
        return menuItems.get(name);
    }
}
