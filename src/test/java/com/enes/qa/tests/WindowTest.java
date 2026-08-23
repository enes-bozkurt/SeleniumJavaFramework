package com.enes.qa.tests;

import com.enes.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowTest extends BaseTest {

    @Test
    public void switchWindowTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/windows");

        Thread.sleep(2000);

        String parentWindow =
                driver.getWindowHandle();

        driver.findElement(
                By.linkText("Click Here")
        ).click();

        Thread.sleep(3000);

        Set<String> allWindows =
                driver.getWindowHandles();

        for (String window : allWindows) {

            if (!window.equals(parentWindow)) {

                driver.switchTo().window(window);
                break;
            }
        }

        Thread.sleep(3000);

        String heading =
                driver.findElement(By.tagName("h3"))
                        .getText();

        Assert.assertEquals(
                heading,
                "New Window"
        );

        Thread.sleep(3000);
    }
}