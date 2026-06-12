package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CompleteCheckoutTest extends BaseTest {

    @Test
    public void completeCheckout() {

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

        cartPage.clickCheckout();

        CheckoutPage checkoutPage =
                new CheckoutPage(driver);

        checkoutPage.enterCustomerInformation(
                "John",
                "Smith",
                "3000"
        );

        checkoutPage.clickContinue();

        checkoutPage.clickFinish();

        Assert.assertTrue(
                checkoutPage.isOrderCompleted()
        );
    }
}