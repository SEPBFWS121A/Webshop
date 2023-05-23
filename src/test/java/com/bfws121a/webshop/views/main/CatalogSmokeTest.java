package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Product;
import com.bfws121a.webshop.repositories.H2ProductRepository;
import com.bfws121a.webshop.services.ProductService;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class CatalogSmokeTest {

    @Test
    public void checkCatalog() {
        ProductService productService = new ProductService(new H2ProductRepository("jdbc:h2:./webshop", "sa", ""));
        List<Product> products = productService.findAll();

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://localhost:8080/Katalog");

            new WebDriverWait(driver, ofSeconds(30), ofSeconds(1))
                    .until(titleIs("Produktkatalog"));

            for (Product product: products) {
                var layout = driver.findElement(By.id("ProductTile-" + product.getName()));
                assertTrue(layout.getText().contains(product.getName()));
            }

        } finally {
            driver.quit();
        }
    }
}
