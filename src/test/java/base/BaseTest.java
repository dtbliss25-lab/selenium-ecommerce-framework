package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;
import org.testng.ITestResult;
import utils.ScreenshotUtils;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = DriverFactory.initDriver();

        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void teardown(ITestResult result) {

        if(result.getStatus() == ITestResult.FAILURE) {

            ScreenshotUtils.captureScreenshot(
                    driver,
                    result.getName()
            );
        }

        if(driver != null) {
            driver.quit();
        }
    }
}