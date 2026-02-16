package testCases;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutStepOneTest extends BaseTest {

    @Test
    public void fillCheckoutDetails() {

        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        HomePage home = new HomePage(driver);
        home.addBackpackToCart();
        home.goToCart();

        CartPage cart = new CartPage(driver);
        cart.clickCheckout();

        CheckoutStepOnePage stepOne = new CheckoutStepOnePage(driver);
        stepOne.fillDetailsAndContinue("Maqsoodh", "Shaik", "500072");
    }
}
