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
public class ShippingCostCategoryTest {

    private static Product prod1, prod2, prod3;
    private static List<Cart> shoppingCart1 = new ArrayList<>();
    private static List<Cart> shoppingCart2 = new ArrayList<>();
    private static List<Cart> shoppingCart3 = new ArrayList<>();

    private static Calculator calculator1, calculator2, calculator3;

    @BeforeAll
    public static void setupCarts() {
        // generate products
        prod1 = new Product(1, "icons/Blaue Steine.jpg", "Blaue Steine", "test", "Steine", "Lego", 1199, "");
        prod2 = new Product(2, "icons/Eldorado.jpg", "Eldorado Fortress 1989", "test", "Set", "Vintage Lego Sets", 29999, "new");
        prod3 = new Product(3, "icons/Millenium Falke.webp", "Millenium Falke", "test", "Set", "Star Wars", 99999, "neu");

        // first shopping cart: 11.99 € excl. VAT
        shoppingCart1.add(new Cart(prod1));
        calculator1 = new Calculator(shoppingCart1);

        // second shopping cart: 299.99 € excl. VAT
        shoppingCart2.add(new Cart(prod2));
        calculator2 = new Calculator(shoppingCart2);

        // third shopping cart: 1011.98 € excl. VAT
        shoppingCart3.add(new Cart(prod1));
        shoppingCart3.add(new Cart(prod3));
        calculator3 = new Calculator(shoppingCart3);

    }

    @Test
    public void calculateShippingCosts() {

        // 11.99 € excl. VAT
        Assertions.assertEquals(500, calculator1.calculateShippingCosts());

        // 299.99 € excl. VAT
        Assertions.assertEquals(250, calculator2.calculateShippingCosts());

        // 1011.98 € excl. VAT
        Assertions.assertEquals(0, calculator3.calculateShippingCosts());
    }
}
