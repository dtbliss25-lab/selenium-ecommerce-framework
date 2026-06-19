package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

import java.time.Duration;

public class AddToCartTest extends BaseTest {

    @Test
    public void addProductToCart() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        InventoryPage inventoryPage =
                new InventoryPage(driver);

        inventoryPage.addBackpackToCart();

        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(cartPage.isItemDisplayed());
    }
}