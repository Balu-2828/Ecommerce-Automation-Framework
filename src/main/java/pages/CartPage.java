package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By cartItemName = By.className("inventory_item_name");
    By checkoutBtn = By.id("checkout");

    // Methods
    public String getProductName() {
        return driver.findElement(cartItemName).getText();
    }

    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    }
}
