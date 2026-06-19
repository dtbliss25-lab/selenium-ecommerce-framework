package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

import java.time.Duration;

public class RemoveFromCartTest extends BaseTest {

    @Test
    public void removeProductFromCart() throws InterruptedException {
        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        InventoryPage inventoryPage =
                new InventoryPage(driver);

        inventoryPage.addBackpackToCart();

        inventoryPage.openCart();

        CartPage cartPage =
                new CartPage(driver);

        cartPage.removeItem();

     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]")
        ));
        Thread.sleep(1000);
        Assert.assertTrue(cartPage.isCartEmpty());

    }
}
