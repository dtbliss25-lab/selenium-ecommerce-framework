package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

    WebDriver driver;

    By cartItem = By.className("inventory_item_name");
    By checkoutButton = By.id("checkout");
    By removeButton = By.id("remove-sauce-labs-backpack");


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isItemDisplayed() {

        return driver.findElement(cartItem).isDisplayed();
    }

    public void clickCheckout() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("checkout")
        )).click();
    }

    public int getCartItemCount() {

        return driver.findElements(
                By.className("inventory_item_name")
        ).size();
    }

    public void removeItem() {

        driver.findElement(By.id("remove-sauce-labs-backpack")).click();

        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.invisibilityOfElementLocated(
                        By.cssSelector(".cart_item")
                ));
    }

    public boolean isCartEmpty() {

        List<WebElement> items =
                driver.findElements(By.cssSelector(".cart_item"));
        return items.isEmpty();
    }

    public void waitForCartPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.urlContains("cart.html"));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("checkout")
        ));
    }

}