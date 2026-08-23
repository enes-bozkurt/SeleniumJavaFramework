package com.enes.qa.tests;

import com.enes.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTest extends BaseTest {

    @Test
    public void mouseHoverTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/hovers");

        WebElement firstUser =
                driver.findElement(By.cssSelector(".figure"));

        // Hover öncesi bekle
        Thread.sleep(3000);

        Actions actions = new Actions(driver);

        actions.moveToElement(firstUser)
                .perform();

        // Hover sonrası bekle
        Thread.sleep(5000);

        String userText =
                driver.findElement(By.xpath("//h5"))
                        .getText();

        System.out.println(">" + userText + "<");

        Assert.assertEquals(
                userText.trim(),
                "name: user1"
        );

        Thread.sleep(3000);
    }
}