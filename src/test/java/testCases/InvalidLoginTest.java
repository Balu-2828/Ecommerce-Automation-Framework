package testCases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class InvalidLoginTest extends BaseTest {

    @Test
    public void invalidLoginTest() {
        // 1️⃣ Create LoginPage object
        LoginPage loginPage = new LoginPage(driver);

        // 2️⃣ Try invalid login
        loginPage.login("wrong_user", "wrong_password");

        // 3️⃣ Assertion: Verify error message is displayed
        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(actualError, expectedError, "Error message not shown as expected");
    }
}
