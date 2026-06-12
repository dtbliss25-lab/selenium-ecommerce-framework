package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        driver.findElement(checkoutButton).click();
    }

    public int getCartItemCount() {

        return driver.findElements(
                By.className("inventory_item_name")
        ).size();
    }

    public void removeItem() {
        driver.findElement(removeButton).click();
    }

    public boolean isCartEmpty() {
        return driver.findElements(cartItem).isEmpty();
    }

}