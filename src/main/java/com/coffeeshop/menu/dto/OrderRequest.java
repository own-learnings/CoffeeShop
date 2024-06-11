package com.coffeeshop.menu.dto;

import lombok.Data;
import lombok.Generated;

import java.util.List;

@Data
@Generated
public class OrderRequest {
    private String menuItem;
    private List<String> addonNames;
    private int quantity;
}
