package com.enes.qa.base;

import com.enes.qa.driver.DriverFactory;
import com.enes.qa.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {

        String browser =
                ConfigReader.getProperty("browser");

        driver =
                DriverFactory.createDriver(browser);

        driver.manage()
                .window()
                .maximize();
    }

    @AfterMethod
    public void teardown() {

        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}