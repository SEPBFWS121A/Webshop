package com.bfws121a.webshop.unitTest;

import com.bfws121a.webshop.helper.Calculator;
import com.bfws121a.webshop.object.Cart;
import com.bfws121a.webshop.object.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class VATCalculatorTest {

    private static Product prod1;
    private static Product prod2;
    private static List<Cart> shoppingCart = new ArrayList<>();

    private static Calculator calculator;

    @BeforeAll
    public static void setupCart() {
        prod1 = new Product(1, "icons/Hogwards.png", "Hogwards", "test", "Set", "Harry Potter",49999, "bestseller");
        prod2 = new Product(2, "icons/Millenium Falke.webp", "Millenium Falke", "test", "Set", "Star Wars", 99999, "neu");
        shoppingCart.add(new Cart(prod1));
        shoppingCart.add(new Cart(prod2));
        calculator = new Calculator(shoppingCart);
    }

    @Test
    public void calculateVAT() {
        int value = (int) calculator.calculateVAT();
        Assertions.assertEquals(24029, value);
    }


}
