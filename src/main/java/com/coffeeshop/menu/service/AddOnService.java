package com.coffeeshop.menu.service;


import com.coffeeshop.menu.model.AddOn;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AddOnService {

    private final Map<String, AddOn> AddOns = new HashMap<>();

    @Value("${addon.coffee.arabica}")
    private double arabicaPrice;

    @Value("${addon.coffee.robusta}")
    private double robustaPrice;

    @Value("${addon.coffee.excelsa}")
    private double excelsaPrice;

    @Value("${addon.coffee.liberica}")
    private double libericaPrice;

    @Value("${addon.milk.soya}")
    private double soyaMilkPrice;

    @Value("${addon.milk.almond}")
    private double almondMilkPrice;

    @Value("${addon.sugar.white}")
    private double whiteSugarPrice;

    @Value("${addon.sugar.honey}")
    private double honeySugarPrice;

    @PostConstruct
    public void init() {
        AddOns.put("Arabica", new AddOn("Arabica", arabicaPrice));
        AddOns.put("Robusta", new AddOn("Robusta", robustaPrice));
        AddOns.put("Excelsa", new AddOn("Excelsa", excelsaPrice));
        AddOns.put("Liberica", new AddOn("Liberica", libericaPrice));
        AddOns.put("Soya Milk", new AddOn("Soya Milk", soyaMilkPrice));
        AddOns.put("Almond Milk", new AddOn("Almond Milk", almondMilkPrice));
        AddOns.put("White Sugar", new AddOn("White Sugar", whiteSugarPrice));
        AddOns.put("Honey Sugar", new AddOn("Honey Sugar", honeySugarPrice));
    }

    public AddOn getAddOn(String name) {
        return AddOns.get(name);
    }
}
