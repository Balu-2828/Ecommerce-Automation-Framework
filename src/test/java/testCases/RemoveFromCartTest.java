package testCases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class RemoveFromCartTest extends BaseTest {

    @Test
    public void verifyRemoveFromCart() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        HomePage homePage = new HomePage(driver);
        homePage.addBackpackToCart();
        homePage.removeBackpackFromCart();

        boolean isRemoved = homePage.isBackpackRemoved();

        Assert.assertTrue(isRemoved, "Backpack was NOT removed!");
    }
}

