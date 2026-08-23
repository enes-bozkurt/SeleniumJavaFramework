package com.enes.qa.tests;

import com.enes.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {

    @Test
    public void uploadFileTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/upload");

        Thread.sleep(2000);

        String filePath =
                System.getProperty("user.dir")
                        + "\\src\\main\\resources\\test.txt";

        driver.findElement(By.id("file-upload"))
                .sendKeys(filePath);

        Thread.sleep(2000);

        driver.findElement(By.id("file-submit"))
                .click();

        Thread.sleep(2000);

        String uploadedFileName =
                driver.findElement(By.id("uploaded-files"))
                        .getText();

        Assert.assertEquals(
                uploadedFileName,
                "test.txt"
        );

        Thread.sleep(3000);
    }
}
