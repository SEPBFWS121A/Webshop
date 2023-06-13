package com.bfws121a.webshop.views.main;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.w3c.dom.html.HTMLElement;


public class SimpleIT {

    @Test
    public void checkPageLoad() {
        WebDriverManager.chromedriver().setup();


        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");

        var driver = new ChromeDriver(options);

        try {


            driver.get("http://localhost:8080");



            new WebDriverWait(driver, ofSeconds(30), ofSeconds(1))
                    .until(titleIs("Main"));

            driver.findElement(By.cssSelector("div.mainDiv:nth-child(1) > vaadin-horizontal-layout:nth-child(3) > vaadin-horizontal-layout:nth-child(1) > vaadin-vertical-layout:nth-child(1) > img:nth-child(1)")).click();

            new WebDriverWait(driver, ofSeconds(30), ofSeconds(1))
                    .until(titleIs("Ritterburg"));

            String label1 = driver.findElement(By.cssSelector("#ROOT-2521314 > vaadin-app-layout > vaadin-form-layout > vaadin-form-layout:nth-child(1) > vaadin-form-layout > label.idLabel-prodPage")).getText();

            driver.navigate().back();

            new WebDriverWait(driver, ofSeconds(30), ofSeconds(1))
                    .until(titleIs("Main"));

            WebElement element = driver.findElement(By.cssSelector("#ProductTile-Ritterburg > vaadin-button:nth-child(4)"));
            driver.executeScript("arguments[0].scrollIntoView();", element);
            driver.executeScript("arguments[0].click();", element);

            WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".add")));
            driver.findElement(By.cssSelector(".add")).click();

            new WebDriverWait(driver, ofSeconds(30), ofSeconds(1)).until(titleIs("Einkaufswagen"));

            wait = new WebDriverWait(driver, ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ROOT-2521314 > vaadin-app-layout > vaadin-vertical-layout > vaadin-form-layout > vaadin-vertical-layout:nth-child(2) > vaadin-button")));
            driver.findElement(By.cssSelector("#ROOT-2521314 > vaadin-app-layout > vaadin-vertical-layout > vaadin-form-layout > vaadin-vertical-layout:nth-child(2) > vaadin-button")).click();

            wait = new WebDriverWait(driver, ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#overlay > label:nth-child(2)")));
            String label2 = driver.findElement(By.cssSelector("#overlay > label:nth-child(2)")).getText();

            assertEquals(label2, label1);


        } finally {
            driver.quit();


        }
    }
}