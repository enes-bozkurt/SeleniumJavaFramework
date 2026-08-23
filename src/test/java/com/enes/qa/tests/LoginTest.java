package com.enes.qa.tests;

import com.enes.qa.base.BaseTest;
import com.enes.qa.pages.LoginPage;
import com.enes.qa.utils.ConfigReader;
import com.enes.qa.utils.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void pageSetup() {

        loginPage = new LoginPage(driver);
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        return ExcelReader.getExcelData(
                "src/test/resources/LoginData.xlsx",
                "Sayfa1"
        );
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username,
                          String password,
                          String expectedResult) {

        driver.get(
                ConfigReader.getProperty("url")
        );

        loginPage.login(
                username,
                password
        );

        String flashMessage =
                loginPage.getFlashMessage();

        if (expectedResult.equalsIgnoreCase("true")) {

            Assert.assertTrue(
                    flashMessage.contains(
                            "You logged into a secure area!"
                    )
            );

        } else {

            Assert.assertTrue(
                    flashMessage.contains(
                            "Your username is invalid!"
                    )
            );
        }
    }
}