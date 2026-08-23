package com.enes.qa.tests;

import com.enes.qa.base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {

    @Test
    public void jsAlertTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        Thread.sleep(2000);

        driver.findElement(
                By.xpath("//button[text()='Click for JS Alert']")
        ).click();

        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();

        System.out.println(alert.getText());

        alert.accept();

        Thread.sleep(2000);

        String result =
                driver.findElement(By.id("result")).getText();

        Assert.assertEquals(
                result,
                "You successfully clicked an alert"
        );

        Thread.sleep(3000);
    }
}