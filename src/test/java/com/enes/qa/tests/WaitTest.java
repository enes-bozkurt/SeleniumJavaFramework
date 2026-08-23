package com.enes.qa.tests;

import com.enes.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitTest extends BaseTest {

    @Test
    public void explicitWaitTest() {

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.xpath("//button[text()='Start']"))
                .click();

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement helloText =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.id("finish")
                        )
                );

        Assert.assertTrue(
                helloText.getText().contains("Hello World!")
        );
    }
}
