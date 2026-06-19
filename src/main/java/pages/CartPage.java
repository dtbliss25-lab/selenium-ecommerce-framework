package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class CartPage {

    WebDriver driver;

    By cartItem = By.className("inventory_item_name");
    //By checkoutButton = By.id("checkout");
   By removeButton = By.id("remove-sauce-labs-backpack");


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isItemDisplayed() {

        return driver.findElement(cartItem).isDisplayed();
    }

    public void clickCheckout() {

        WebElement element;
        element = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(visibilityOfElementLocated((
                        By.xpath("//*[@id=\"checkout\"]"))
                ));

        element.click();

    }

    public int getCartItemCount() {

        return driver.findElements(
                By.className("inventory_item_name")
        ).size();
    }

    public void removeItem() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.urlContains("cart.html"));
      //  System.out.println("URL: " + driver.getCurrentUrl());
        WebElement removeBtn = wait.until(ExpectedConditions.elementToBeClickable(removeButton));

        removeBtn.click();
    }

    public boolean isCartEmpty() {

        List<WebElement> items =
                driver.findElements(By.cssSelector(".cart_item"));
        return items.isEmpty();
    }

    public void waitForCartPage() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.urlContains("cart.html"));

        WebElement myElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
    }

}