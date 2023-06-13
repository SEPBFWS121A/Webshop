package com.bfws121a.webshop.views.main;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class E2ETestDeleteShoppingcartItems {

    @Test
    public void deleteShoppingcartItems() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.navigate().to("http://localhost:8080/");

            new WebDriverWait(driver, ofSeconds(30)).until(titleIs("Main"));

            driver.findElement(By.id("tabs")).findElement(By.id("header-tab-Produkte")).click();

            new WebDriverWait(driver, ofSeconds(30)).until(titleIs("Produktkatalog"));

            driver.findElement(By.id("ProductTile-Hogwards")).findElement(By.className("image-prodTile")).click();

            new WebDriverWait(driver, ofSeconds(30)).until(titleIs("Hogwards"));

            driver.findElement(By.className("cart-productPage")).click();

            new WebDriverWait(driver, ofSeconds(20)).until(d -> d.findElement(By.className("add-dialog")));

            driver.findElement(By.className("add")).click();

            new WebDriverWait(driver, ofSeconds(30), ofSeconds(1)).until(titleIs("Einkaufswagen"));

            driver.findElement(By.className("delete")).click();

            driver.navigate().refresh();

            new WebDriverWait(driver, ofSeconds(30)).until(titleIs("Einkaufswagen"));

            driver.findElement(By.className("headline-shoppingcart"));
        } finally {
            driver.quit();
        }

    }

}
