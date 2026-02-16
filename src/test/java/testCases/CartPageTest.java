package testCases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;

public class CartPageTest extends BaseTest {

    @Test
    public void verifyProductInCart() {

        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        HomePage home = new HomePage(driver);
        home.addBackpackToCart();
        home.goToCart();

        CartPage cart = new CartPage(driver);

        String productName = cart.getProductName();
        Assert.assertEquals(productName, "Sauce Labs Backpack", "Incorrect product in cart");
    }
}

