package com.coffeeshop.menu.service;


import com.coffeeshop.menu.model.AddOn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddOnServiceTest {

    @InjectMocks
    private AddOnService AddOnService;

    @BeforeEach
    public void setUp() {
        AddOnService = new AddOnService();

        ReflectionTestUtils.setField(AddOnService, "arabicaPrice", 50.0);
        ReflectionTestUtils.setField(AddOnService, "robustaPrice", 55.0);
        ReflectionTestUtils.setField(AddOnService, "excelsaPrice", 60.0);
        ReflectionTestUtils.setField(AddOnService, "libericaPrice", 65.0);
        ReflectionTestUtils.setField(AddOnService, "soyaMilkPrice", 20.0);
        ReflectionTestUtils.setField(AddOnService, "almondMilkPrice", 30.0);
        ReflectionTestUtils.setField(AddOnService, "whiteSugarPrice", 5.0);
        ReflectionTestUtils.setField(AddOnService, "honeySugarPrice", 10.0);

        AddOnService.init();
    }

    @Test
    public void testGetAddOn_Arabica() {
        AddOn AddOn = AddOnService.getAddOn("Arabica");
        assertEquals(50.0, AddOn.getPrice());
        assertEquals("Arabica", AddOn.getName());
    }

    @Test
    public void testGetAddOn_Robusta() {
        AddOn AddOn = AddOnService.getAddOn("Robusta");
        assertEquals(55.0, AddOn.getPrice());
        assertEquals("Robusta", AddOn.getName());
    }

    @Test
    public void testGetAddOn_Excelsa() {
        AddOn AddOn = AddOnService.getAddOn("Excelsa");
        assertEquals(60.0, AddOn.getPrice());
        assertEquals("Excelsa", AddOn.getName());
    }

    @Test
    public void testGetAddOn_Liberica() {
        AddOn AddOn = AddOnService.getAddOn("Liberica");
        assertEquals(65.0, AddOn.getPrice());
        assertEquals("Liberica", AddOn.getName());
    }

    @Test
    public void testGetAddOn_SoyaMilk() {
        AddOn AddOn = AddOnService.getAddOn("Soya Milk");
        assertEquals(20.0, AddOn.getPrice());
        assertEquals("Soya Milk", AddOn.getName());
    }

    @Test
    public void testGetAddOn_AlmondMilk() {
        AddOn AddOn = AddOnService.getAddOn("Almond Milk");
        assertEquals(30.0, AddOn.getPrice());
        assertEquals("Almond Milk", AddOn.getName());
    }

    @Test
    public void testGetAddOn_WhiteSugar() {
        AddOn AddOn = AddOnService.getAddOn("White Sugar");
        assertEquals(5.0, AddOn.getPrice());
        assertEquals("White Sugar", AddOn.getName());
    }

    @Test
    public void testGetAddOn_HoneySugar() {
        AddOn AddOn = AddOnService.getAddOn("Honey Sugar");
        assertEquals(10.0, AddOn.getPrice());
        assertEquals("Honey Sugar", AddOn.getName());
    }
}
