package com.enes.qa.tests;

import com.enes.qa.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends BaseTest {

    @Test
    public void selectDropdown() {

        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropdownElement =
                driver.findElement(By.id("dropdown"));

        Select dropdown =
                new Select(dropdownElement);

        dropdown.selectByVisibleText("Option 1");

        String selectedOption =
                dropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(
                selectedOption,
                "Option 1"

        );

    }
}
