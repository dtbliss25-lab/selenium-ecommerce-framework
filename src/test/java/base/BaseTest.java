package base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;
import utils.ScreenshotUtils;

import java.util.UUID;

public class BaseTest {

    protected WebDriver driver;
    private final ScreenshotUtils screenshotUtils = new ScreenshotUtils();


    @BeforeMethod
    public void setup() {
        driver = DriverFactory.initDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(ITestResult result) {

        try {
            if (result != null && result.getStatus() == ITestResult.FAILURE && driver != null) {

                String fileName = result.getTestClass().getName() + "_"
                        + result.getMethod().getMethodName()
                        + "_" + UUID.randomUUID();

                String path = screenshotUtils.captureScreenshot(driver, fileName);

                System.out.println("Screenshot saved at: " + path);
            }
        } catch (Exception e) {
                e.printStackTrace();
            } finally{
                try {
                    if (driver != null) {
                        driver.quit();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
}