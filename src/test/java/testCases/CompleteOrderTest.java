package testCases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions; // NEW IMPORT
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class CompleteOrderTest extends BaseTest {

    @Test
    public void placeOrderSuccessfully() {

        // 1. Login
        System.out.println("Step 1: Logging in...");
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        // 2. Add to Cart
        HomePage home = new HomePage(driver);
        home.addBackpackToCart();
        home.goToCart();

        // 3. Checkout
        CartPage cart = new CartPage(driver);
        cart.clickCheckout();

        // --- ACTIONS CLASS STRATEGY ---
        System.out.println("Step 4: Filling Form using Actions Class...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the box to be visible
        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));

        // Initialize the Physical Interaction Builder
        Actions act = new Actions(driver);

        // 1. Click 'First Name' to force focus (steals it back from popup)
        act.click(firstName).perform();

        // 2. Type Name
        act.sendKeys("Bala").perform();

        // 3. Press TAB to go to Last Name
        act.sendKeys(Keys.TAB).perform();

        // 4. Type Last Name
        act.sendKeys("Murali").perform();

        // 5. Press TAB to go to Zip
        act.sendKeys(Keys.TAB).perform();

        // 6. Type Zip
        act.sendKeys("500072").perform();

        // 7. Submit
        System.out.println("Step 4.1: Submitting Form...");
        WebElement continueBtn = driver.findElement(By.id("continue"));
        continueBtn.click();

        // ------------------------------------

        // 5. Overview Page
        System.out.println("Step 5: Verifying Overview...");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='subtotal-label']")));

        CheckoutStepTwoPage stepTwo = new CheckoutStepTwoPage(driver);
        System.out.println("Item Total: " + stepTwo.getItemTotal());

        stepTwo.clickFinish();

        // 6. Confirmation
        System.out.println("Step 6: Verifying Success...");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-header")));

        OrderConfirmationPage confirmation = new OrderConfirmationPage(driver);
        String message = confirmation.getThankYouMessage();
        System.out.println("Order Message: " + message);

        Assert.assertTrue(message.equalsIgnoreCase("Thank you for your order!"), "Message failed!");
    }
}