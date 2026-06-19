package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class EmptyCartTest extends BaseTest {

    @Test
    public void verifyCartIsEmpty() throws InterruptedException {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        InventoryPage inventoryPage =
                new InventoryPage(driver);

        inventoryPage.openCart();

        CartPage cartPage =
                new CartPage(driver);

        Assert.assertTrue(
                cartPage.isCartEmpty(),
                "Cart should be empty"
        );
    }
}