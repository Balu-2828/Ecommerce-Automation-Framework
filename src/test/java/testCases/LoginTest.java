package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        // 1️⃣ Create LoginPage object
        LoginPage loginPage = new LoginPage(driver);

        // 2️⃣ Perform login
        loginPage.login("standard_user", "secret_sauce");

        // 3️⃣ Assertion: Verify successful login
        // On SauceDemo, successful login redirects to /inventory.html
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Login failed: URL mismatch");
    }
}

