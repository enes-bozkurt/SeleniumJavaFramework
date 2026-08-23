package com.enes.qa.tests;

import com.enes.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsTest extends BaseTest {

    @Test
    public void doubleClickTest() throws InterruptedException {

        driver.get("https://demoqa.com/buttons");

        System.out.println(driver.getTitle());

        Thread.sleep(5000);

        Actions actions = new Actions(driver);

        actions.doubleClick(
                driver.findElement(By.id("doubleClickBtn"))
        ).perform();

        Thread.sleep(2000);

        String message =
                driver.findElement(By.id("doubleClickMessage"))
                        .getText();

        Assert.assertEquals(
                message,
                "You have done a double click"
        );

        Thread.sleep(3000);
    }
}