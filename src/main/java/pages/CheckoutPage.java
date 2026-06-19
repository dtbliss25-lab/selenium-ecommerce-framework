package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    WebDriver driver;

    By firstName = By.xpath("//*[@id=\"first-name\"]");
    By lastName = By.xpath("//*[@id=\"last-name\"]");
    By postalCode = By.xpath("//*[@id=\"postal-code\"]");
    By continueBtn = By.id("continue");
    By finishBtn = By.xpath("//*[@id=\"finish\"]");
    By confirmationMessage =
            By.xpath("//*[@id=\"checkout_complete_container\"]/h2");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCustomerInformation(
            String first,
            String last,
            String zip) {

        driver.findElement(firstName).sendKeys(first);
        driver.findElement(lastName).sendKeys(last);
        driver.findElement(postalCode).sendKeys(zip);
    }

    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }

    public void clickFinish() {

        driver.findElement(finishBtn).click();
    }

    public boolean isOrderCompleted() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlContains("checkout-complete.html"));
        return driver.findElement(
                        confirmationMessage)
                .getText()
                .contains("Thank you");
    }
    public void waitForCheckoutPage() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("first-name")
                ));
    }
}