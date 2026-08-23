package com.enes.qa;

import com.enes.qa.base.BaseTest;
import com.enes.qa.pages.LoginPage;
import com.enes.qa.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.enes.qa.listeners.TestListener;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)

public class LoginDataTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void pageSetup() {
        loginPage = new LoginPage(driver);
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        return new Object[][]{
                {"tomsmith", "SuperSecretPassword!", true},
                {"wronguser", "wrongpass", false},
                {"tomsmith", "wrongpass", false}
        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username,
                          String password,
                          boolean shouldPass) {

        driver.get(
                ConfigReader.getProperty("url")
        );

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        String message =
                loginPage.getFlashMessage();

        if (shouldPass) {

            Assert.assertTrue(
                    message.contains("You logged into a secure area!")
            );

        } else {

            Assert.assertTrue(
                    message.contains("invalid")
            );
        }
    }
}