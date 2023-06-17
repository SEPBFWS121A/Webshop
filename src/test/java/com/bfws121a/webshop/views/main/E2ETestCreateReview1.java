package com.bfws121a.webshop.views.main;

import com.bfws121a.webshop.repositories.H2ProductRepository;
import com.bfws121a.webshop.repositories.H2ReviewRepository;
import com.bfws121a.webshop.services.ReviewService;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class E2ETestCreateReview1 {

    int prodId;

    ReviewService reviewService = new ReviewService(new H2ReviewRepository(System.getenv("FHDW_WEBSHOP_DB_URL"), System.getenv("FHDW_WEBSHOP_DB_USER"), System.getenv("FHDW_WEBSHOP_DB_PASSWORD")));

    @Test
    public void createReview(){

        WebDriverManager.chromedriver().setup();
        var driver = new ChromeDriver();

        try{

            driver.navigate().to("http://localhost:8080/");
            new WebDriverWait(driver, ofSeconds(30)).until(titleIs("Main"));

            driver.findElement(By.id("tabs")).findElement(By.id("header-tab-Produkte")).click();
            new WebDriverWait(driver, ofSeconds(30)).until(titleIs("Produktkatalog"));

            driver.findElement(By.id("ProductTile-Ritterburg")).findElement(By.className("image-prodTile")).click();

            new WebDriverWait(driver, ofSeconds(20)).until(titleIs("Ritterburg"));

            new WebDriverWait(driver, ofSeconds(20)).until(d -> d.findElement(By.className("idLabel-prodPage")));

            var id = driver.findElement(By.className("idLabel-prodPage"));

            String[] text = id.getText().split(" ");

            System.out.println("TEST: " + text[1]);

            prodId = Integer.parseInt(text[1]);

            WebElement element = driver.findElement(By.className("Review-Button"));
            driver.executeScript("arguments[0].scrollIntoView();", element);
            driver.executeScript("arguments[0].click();", element);

            new WebDriverWait(driver, ofSeconds(20)).until(d -> d.findElement(By.className("Review-Button")));
            new WebDriverWait(driver, ofSeconds(20)).until(d -> d.findElement(By.className("add-review")));

            driver.findElement(By.className("publisher")).sendKeys("Max Mustermann");
            driver.findElement(By.className("title")).sendKeys("Beispieltitel");
            driver.findElement(By.className("reviewDialog-description")).sendKeys("Beispieltext");
            driver.findElement(By.className("rating")).click();
            driver.findElement(By.className("Submit-Button")).click();

            new WebDriverWait(driver, ofSeconds(20)).until(titleIs("Ritterburg"));

        } finally {
        reviewService.deleteByName("Max Mustermann", prodId);
        driver.quit();
    }

    }

}
