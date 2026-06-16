package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    private static final String SCREENSHOT_DIR = "screenshots";

    public static String captureScreenshot(WebDriver driver, String testName) {

        if (driver == null) {
            throw new IllegalArgumentException("WebDriver is null. Cannot capture screenshot.");
        }

        try {
            // Ensure directory exists
            File directory = new File(SCREENSHOT_DIR);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Clean test name for file system safety
            String safeTestName = testName.replaceAll("[^a-zA-Z0-9-_\\.]", "_");

            File sourceFile =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);

            String destinationPath =
                    SCREENSHOT_DIR + File.separator + safeTestName + ".png";

            File destinationFile = new File(destinationPath);

            FileUtils.copyFile(sourceFile, destinationFile);

            return destinationPath;

        } catch (IOException e) {
            throw new RuntimeException("Failed to capture screenshot for test: " + testName, e);
        }
    }
}