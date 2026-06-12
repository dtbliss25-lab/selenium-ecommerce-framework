package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    WebDriver driver;

    By addBackpackButton =
            By.id("add-to-cart-sauce-labs-backpack");

    By cartIcon =
            By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addBackpackToCart() {
        driver.findElement(addBackpackButton).click();
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }
}