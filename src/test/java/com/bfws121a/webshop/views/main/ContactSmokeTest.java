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


public class ContactSmokeTest {

    String eMail = "kontakt@thomas-klemmbaustein-palast.de";
    String adresse1 = "Hohe Str. 46";
    String adresse2 = "50667 Köln";
    String phoneNumber = "+49 437 42874647";

    @Test
    public void checkPageLoad() {
        WebDriverManager.chromedriver().setup();


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        var driver = new ChromeDriver(options);

        try {


            driver.get("http://localhost:8080/Kontakt");



            new WebDriverWait(driver, ofSeconds(30), ofSeconds(1))
                    .until(titleIs("Kontakt"));

            WebElement paragraph = driver.findElement(By.cssSelector("#ROOT-2521314 > vaadin-app-layout > div > vaadin-vertical-layout > div:nth-child(1) > p:nth-child(3)"));
            assertEquals(eMail, paragraph.getText());

            paragraph = driver.findElement(By.cssSelector("#ROOT-2521314 > vaadin-app-layout > div > vaadin-vertical-layout > div:nth-child(2) > p:nth-child(3)"));
            assertEquals(adresse1, paragraph.getText());

            paragraph = driver.findElement(By.cssSelector("#ROOT-2521314 > vaadin-app-layout > div > vaadin-vertical-layout > div:nth-child(2) > p:nth-child(4)"));
            assertEquals(adresse2, paragraph.getText());

            paragraph = driver.findElement(By.cssSelector("#ROOT-2521314 > vaadin-app-layout > div > vaadin-vertical-layout > div:nth-child(3) > p:nth-child(3)"));
            assertEquals(phoneNumber, paragraph.getText());

        } finally {
            driver.quit();


        }
    }
}
