package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor; // ADDED THIS
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutStepOnePage {

    WebDriver driver;

    public CheckoutStepOnePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By firstNameInput = By.id("first-name");
    By lastNameInput = By.id("last-name");
    By zipInput = By.id("postal-code");
    By continueBtn = By.id("continue");

    // --- THE FIX: JavaScript Helper Methods ---

    // 1. Force Type: Injects text directly (Bypasses glitches)
    public void safeType(By locator, String text) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + text + "';", element);
    }

    // 2. Force Click: Clicks underneath popups (Bypasses Weak Password popup)
    public void safeClick(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    // --- The Main Action ---
    public void fillDetailsAndContinue(String fname, String lname, String zip) {
        // We use the new safe methods instead of standard selenium
        safeType(firstNameInput, fname);
        safeType(lastNameInput, lname);
        safeType(zipInput, zip);

        safeClick(continueBtn);
    }
}