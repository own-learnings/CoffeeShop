package com.coffeeshop.menu.controller;

import com.coffeeshop.menu.dto.OrderRequest;
import com.coffeeshop.menu.model.AddOn;
import com.coffeeshop.menu.model.Invoice;
import com.coffeeshop.menu.model.MenuItem;
import com.coffeeshop.menu.model.OrderItem;
import com.coffeeshop.menu.service.AddOnService;
import com.coffeeshop.menu.service.MenuService;
import com.coffeeshop.menu.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@SpringBootTest
public class OrderControllerTest {

    @Mock
    private MenuService menuService;

    @Mock
    private AddOnService addonService;

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @Test
    public void testCreateOrder() {
        when(menuService.getMenuItem("Cappuccino")).thenReturn(new MenuItem("Cappuccino", 120));
        when(addonService.getAddOn("Arabica")).thenReturn(new AddOn("Arabica", 50));
        when(addonService.getAddOn("Soya Milk")).thenReturn(new AddOn("Soya Milk", 20));

        OrderRequest request = new OrderRequest();
        request.setMenuItem("Cappuccino");
        request.setAddonNames(Arrays.asList("Arabica", "Soya Milk"));
        request.setQuantity(2);

        double totalPrice = orderController.createOrder(Arrays.asList(request));
        assertEquals(380, totalPrice); // 2 * (120 + 50 + 20)
    }

    @Value("${addon.coffee.arabica}")
    private double arabicaPrice;

    @Value("${addon.coffee.robusta}")
    private double robustaPrice;

    @Value("${addon.coffee.excelsa}")
    private double excelsaPrice;

    @Value("${addon.coffee.liberica}")
    private double libericaPrice;

    @Test
    public void testGetInvoice() throws Exception {
        List<AddOn> addOns = Arrays.asList(new AddOn("Arabica", arabicaPrice),
                new AddOn("Robusta", robustaPrice),
                new AddOn("Excelsa", excelsaPrice),
                new AddOn("Liberica", libericaPrice));
        List<OrderItem> orderItems = Arrays.asList(
                new OrderItem(new MenuItem("Cappuccino", 120), addOns, 1),
                new OrderItem(new MenuItem("Latte", 150), addOns,1)
        );

        double expectedTotalPrice = 420.0; // Assume a calculated total price

        Invoice expectedInvoice = new Invoice(orderItems, expectedTotalPrice);

        when(orderService.generateInvoice(anyList())).thenReturn(expectedInvoice);

        Invoice invoice = orderController.getInvoice(orderItems);

        assertEquals(invoice, expectedInvoice);
    }
}
