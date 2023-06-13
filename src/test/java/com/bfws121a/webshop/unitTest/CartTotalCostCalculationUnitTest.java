package com.bfws121a.webshop.unitTest;


import com.bfws121a.webshop.helper.Calculator;
import com.bfws121a.webshop.object.Cart;
import com.bfws121a.webshop.object.Product;
import com.bfws121a.webshop.repositories.H2ProductRepository;
import com.bfws121a.webshop.services.ProductService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CartTotalCostCalculationUnitTest {

    private static Product prod1;
    private static Product prod2;
    private static Product prod3;
    private static Product prod4;
    private static List<Cart> shoppingCart = new ArrayList<>();
    private static Calculator calculator;

    @BeforeAll
    public static void setup() {
        prod1 = new Product(1, "icons/Hogwards.png", "Hogwards", "test", "Set", "Harry Potter",49999, "bestseller");
        prod2 = new Product(2, "icons/Millenium Falke.webp", "Millenium Falke", "test", "Set", "Star Wars", 99999, "neu");
        prod3 = new Product(6, "icons/Kamera.png", "Vintage Kamera", "test", "Set", "Vintage",9999, "bestseller");
        prod4 = new Product(8, "icons/Titanic.webp", "Titanic", "test", "Set", "Vintage", 39999, "neu");
        shoppingCart.add(new Cart(prod1));
        shoppingCart.add(new Cart(prod2));
        shoppingCart.add(new Cart(prod3));
        shoppingCart.add(new Cart(prod4));
        calculator = new Calculator(shoppingCart);
    }

    @Test
    public void calculatePrice() {
        int value = (int) calculator.calculatePrice();
        Assertions.assertEquals(199996, value);
    }

}
