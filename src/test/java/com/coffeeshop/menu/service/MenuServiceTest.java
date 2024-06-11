package com.coffeeshop.menu.service;

import com.coffeeshop.menu.model.MenuItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuServiceTest {

    @InjectMocks
    private MenuService menuService;

    @BeforeEach
    public void setUp() {
        menuService = new MenuService();

        ReflectionTestUtils.setField(menuService, "cappuccinoPrice", 120.0);
        ReflectionTestUtils.setField(menuService, "lattePrice", 150.0);
        ReflectionTestUtils.setField(menuService, "espressoPrice", 100.0);
        ReflectionTestUtils.setField(menuService, "chocolateCookiePrice", 40.0);
        ReflectionTestUtils.setField(menuService, "oatmealCookiePrice", 50.0);

        menuService.init();
    }

    @Test
    public void testGetMenuItem_Cappuccino() {
        MenuItem menuItem = menuService.getMenuItem("Cappuccino");
        assertEquals(120.0, menuItem.getBasePrice());
        assertEquals("Cappuccino", menuItem.getName());
    }

    @Test
    public void testGetMenuItem_Latte() {
        MenuItem menuItem = menuService.getMenuItem("Latte");
        assertEquals(150.0, menuItem.getBasePrice());
        assertEquals("Latte", menuItem.getName());
    }

    @Test
    public void testGetMenuItem_Espresso() {
        MenuItem menuItem = menuService.getMenuItem("Espresso");
        assertEquals(100.0, menuItem.getBasePrice());
        assertEquals("Espresso", menuItem.getName());
    }

    @Test
    public void testGetMenuItem_ChocolateCookie() {
        MenuItem menuItem = menuService.getMenuItem("Chocolate Cookie");
        assertEquals(40.0, menuItem.getBasePrice());
        assertEquals("Chocolate Cookie", menuItem.getName());
    }

    @Test
    public void testGetMenuItem_OatmealCookie() {
        MenuItem menuItem = menuService.getMenuItem("Oatmeal Cookie");
        assertEquals(50.0, menuItem.getBasePrice());
        assertEquals("Oatmeal Cookie", menuItem.getName());
    }
}
