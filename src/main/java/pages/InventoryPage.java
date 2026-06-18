package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class InventoryPage {

    WebDriver driver;

 //   By addBackpackButton = By.xpath("//*[@id=\"add-to-cart\"]");

    By cartIcon =
            By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addBackpackToCart() {
      //  driver.findElement(By.xpath("//*[@id=\"add-to-cart\"]")).click();
      /* WebElement element;
        element = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(visibilityOfElementLocated(By.cssSelector("#add-to-cart")));*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement element1;
        element1 = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("add-to-cart-sauce-labs-backpack")
                )
        );

        driver.findElement( By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    public void openCart() {
       // driver.findElement(cartIcon).click();

      //  driver.findElement(cartIcon).click();

      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

      //  wait.until(ExpectedConditions.urlContains("https://www.saucedemo.com/cart.html"));

      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement element2;
        element2 = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[@id=\"shopping_cart_container\"]")
                )
        );
        driver.findElement(cartIcon).click();

      //  System.out.println(driver.getCurrentUrl());
        wait.until(ExpectedConditions.urlContains("cart.html"));
    //    System.out.println(driver.getCurrentUrl());

    }
}