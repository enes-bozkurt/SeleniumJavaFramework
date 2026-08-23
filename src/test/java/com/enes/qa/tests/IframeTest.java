package com.enes.qa.tests;

import com.enes.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class IframeTest extends BaseTest {

    @Test
    public void iframeTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/iframe");

        Thread.sleep(3000);

        driver.switchTo().frame("mce_0_ifr");

        String text =
                driver.findElement(By.id("tinymce"))
                        .getText();

        System.out.println("Iframe içindeki yazı: " + text);

        Thread.sleep(5000);
    }
}