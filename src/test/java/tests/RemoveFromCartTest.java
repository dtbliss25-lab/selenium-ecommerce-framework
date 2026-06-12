package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class RemoveFromCartTest extends BaseTest {

    @Test
    public void removeProductFromCart(){
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

        Assert.assertTrue(
                cartPage.isCartEmpty()
        );

    }
}
