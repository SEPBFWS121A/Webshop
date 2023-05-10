package com.bfws121a.webshop.Testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class TestTest {

    @Test
    public void test() {

        WebDriverManager.chromedriver().setup();
        var driver = new ChromeDriver();

        try {
            driver.get("http://localhost:8080/product/12345");

            new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofSeconds(1)).until(titleIs(""));

            var button = driver.findElement(By.xpath("//vaadin-button[contains(.,'Kaufabwicklung')]"));

            assertEquals(button.getText(), "Kaufabwicklung");
        } finally {
            driver.quit();
        }

    }

}
