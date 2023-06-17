package com.bfws121a.webshop.unitTest;

import com.bfws121a.webshop.object.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PriceClassClassificationUnitTest {

    private static Product prod1;
    private static Product prod2;
    private static Product prod3;

    @BeforeAll
    public static void setup() {
        prod1 = new Product(1, "icons/Hogwards.png", "Hogwards", "test", "Set", "Harry Potter",49999, "bestseller");
        prod2 = new Product(4, "icons/Blaue Steine.jpg", "Blaue Steine", "test", "Set", "Klötze", 1199, "");
        prod3 = new Product(6, "icons/Kamera.png", "Vintage Kamera", "test", "Set", "Vintage",9999, "bestseller");
    }

    @Test
    public void calculatePrice() {
        Assertions.assertEquals("200€+", prod1.getPriceCate());
        Assertions.assertEquals("0€ - 20€", prod2.getPriceCate());
        Assertions.assertEquals("50€ - 100€", prod3.getPriceCate());
    }

}
