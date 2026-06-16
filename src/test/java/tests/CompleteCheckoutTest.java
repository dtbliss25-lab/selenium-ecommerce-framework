package tests;

import base.BaseTest;
import org.openqa.selenium.By;
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
       // System.out.println("Cart items: " +driver.findElements(By.className("cart_item")).size();
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.waitForCheckoutPage();

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