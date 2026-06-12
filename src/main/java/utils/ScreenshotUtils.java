package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    public static String captureScreenshot(
            WebDriver driver,
            String testName) {

        File sourceFile =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

        String destination =
                "screenshots/" + testName + ".png";

        try {
            FileUtils.copyFile(
                    sourceFile,
                    new File(destination)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        return destination;
    }
}