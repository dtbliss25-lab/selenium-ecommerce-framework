package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class EmptyLoginTest extends BaseTest {

    @Test
    public void verifyEmptyLoginError() {

        LoginPage loginPage =
                new LoginPage(driver);

        // Click login without entering anything
        loginPage.clickLoginButton();

        // Capture error message from UI
        String errorMessage =
                loginPage.getErrorMessage();

        System.out.println("Actual error message: " + errorMessage);

        /*Assert.assertTrue(errorMessage.contains("Username is required"));
        */
        Assert.assertEquals(errorMessage,
                "Epic sadface: Username is required");
    }
}