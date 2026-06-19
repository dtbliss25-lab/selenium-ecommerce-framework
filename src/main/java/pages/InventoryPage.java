package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class InventoryPage {

    WebDriver driver;

 //   By addBackpackButton = By.xpath("//*[@id=\"add-to-cart\"]");

    By cartIcon =
            By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addBackpackToCart() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
       // System.out.println(driver.getCurrentUrl());
        WebElement addToCartButton;
        addToCartButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("add-to-cart-sauce-labs-backpack")
                )
        );

        addToCartButton.click();

    }

    public void openCart() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement element2;
        element2 = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.className("shopping_cart_link")
                )
        );
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element2);

        Thread.sleep(2000);
        wait.until(ExpectedConditions.urlContains("cart.html"));

    }
}