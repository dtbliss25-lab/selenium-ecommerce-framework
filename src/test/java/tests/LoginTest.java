package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ScreenshotUtils;


public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );



        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory")
        );
    }

    @Test
    public void invalidLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "invalid_user",
                "wrong_password"
        );

        Assert.assertTrue(
                driver.getPageSource().contains("Epic sadface")
        );
    }
    @Test
    public void lockedUserTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "locked_out_user",
                "secret_sauce"
        );

        Assert.assertTrue(
                driver.getPageSource().contains("locked out")
        );
    }
}