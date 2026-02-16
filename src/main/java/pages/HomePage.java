package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By backpackAddToCart = By.id("add-to-cart-sauce-labs-backpack");
    By backpackRemove = By.id("remove-sauce-labs-backpack");

    By cartIcon = By.className("shopping_cart_link");

    // Methods
    public void addBackpackToCart() {
        driver.findElement(backpackAddToCart).click();
    }

    public void removeBackpackFromCart() {
        driver.findElement(backpackRemove).click();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }

    public boolean isBackpackRemoved() {
        return driver.findElements(backpackAddToCart).size() > 0;
    }

}
