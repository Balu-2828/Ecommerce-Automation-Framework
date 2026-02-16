package testCases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class AddToCartTest extends BaseTest {

    @Test
    public void verifyAddProductToCart() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        HomePage homePage = new HomePage(driver);
        homePage.addBackpackToCart();

        homePage.goToCart();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("cart"), "Not navigated to cart");

    }
}

