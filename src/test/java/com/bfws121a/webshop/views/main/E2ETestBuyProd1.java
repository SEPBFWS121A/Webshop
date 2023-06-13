package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.object.Product;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Timespan;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class E2ETestBuyProd1 {

    @Test
    public void buyProduct() {

        WebDriverManager.chromedriver().setup();
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");*/
        WebDriver driver = new ChromeDriver();

        try {

            driver.navigate().to("http://localhost:8080/Warenkorb");

            new WebDriverWait(driver, ofSeconds(30))
                    .until(titleIs("Einkaufswagen"));

            List<WebElement> elements = driver.findElements(By.className("delete"));

            for (WebElement element : elements) {
                element.click();
            }

            driver.navigate().to("http://localhost:8080/");

            new WebDriverWait(driver, ofSeconds(30))
                    .until(titleIs("Main"));


            driver.findElement(By.id("tabs")).findElement(By.id("header-tab-Produkte")).click();

            new WebDriverWait(driver, ofSeconds(30))
                    .until(titleIs("Produktkatalog"));

            driver.findElement(By.id("ProductTile-Hogwards")).findElement(By.className("cart")).click();


            new WebDriverWait(driver, ofSeconds(20)).until(d -> d.findElement(By.className("add-dialog")));

            driver.findElement(By.className("add")).click();

            new WebDriverWait(driver, ofSeconds(30), ofSeconds(1))
                    .until(titleIs("Einkaufswagen"));

            var cart = driver.findElement(By.className("label-prodTile-name"));

            assertTrue(cart.getText().contains("Hogwards"));

            var price = driver.findElement(By.className("total-price"));

            assertTrue(price.getText().contains("504.99 €"));

            driver.findElement(By.className("cart")).click();

            new WebDriverWait(driver, ofSeconds(20)).until(d -> d.findElement(By.className("dialog")));

            driver.findElement(By.className("dialog-ok")).click();

            new WebDriverWait(driver, ofSeconds(30))
                    .until(titleIs("Kontakt"));

            ;
        } finally {

            driver.navigate().to("http://localhost:8080/Warenkorb");

            new WebDriverWait(driver, ofSeconds(30))
                    .until(titleIs("Einkaufswagen"));

            List<WebElement> elements = driver.findElements(By.className("delete"));

            for (WebElement element : elements) {
                element.click();
            }

            driver.quit();
        }

    }


}
