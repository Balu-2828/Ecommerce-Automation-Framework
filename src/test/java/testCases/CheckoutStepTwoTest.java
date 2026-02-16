package testCases;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutStepTwoTest extends BaseTest {

    @Test
    public void completeCheckout() {

        // Login
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        // Add item to cart
        HomePage home = new HomePage(driver);
        home.addBackpackToCart();
        home.goToCart();

        // Go to checkout step one
        CartPage cart = new CartPage(driver);
        cart.clickCheckout();

        // Fill user details (Step One)
        CheckoutStepOnePage stepOne = new CheckoutStepOnePage(driver);
        stepOne.fillDetailsAndContinue("Bala", "Murali", "500072");

        // Checkout Step Two
        CheckoutStepTwoPage stepTwo = new CheckoutStepTwoPage(driver);
        System.out.println("Item Total: " + stepTwo.getItemTotal());
        System.out.println("Tax: " + stepTwo.getTax());
        System.out.println("Total: " + stepTwo.getTotalAmount());

        // Finish order
        stepTwo.clickFinish();
    }
}

