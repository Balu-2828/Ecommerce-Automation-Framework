package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage {

    private WebDriver driver;

    // Locator
    private By thankYouMessage = By.className("complete-header");

    // Constructor
    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Action
    public String getThankYouMessage() {
        return driver.findElement(thankYouMessage).getText();
    }
}

