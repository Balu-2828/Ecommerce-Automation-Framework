package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwoPage {

    private WebDriver driver;

    // --- STRONGER LOCATORS ---
    // We are using cssSelector with [data-test] to be 100% sure it finds the element
    private By itemTotalLabel = By.cssSelector("[data-test='subtotal-label']");
    private By taxLabel = By.cssSelector("[data-test='tax-label']");
    private By totalLabel = By.cssSelector("[data-test='total-label']");

    private By finishBtn = By.id("finish");
    private By cancelBtn = By.id("cancel");

    public CheckoutStepTwoPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getItemTotal() {
        return driver.findElement(itemTotalLabel).getText();
    }

    public String getTax() {
        return driver.findElement(taxLabel).getText();
    }

    public String getTotalAmount() {
        return driver.findElement(totalLabel).getText();
    }

    public void clickFinish() {
        driver.findElement(finishBtn).click();
    }
}

