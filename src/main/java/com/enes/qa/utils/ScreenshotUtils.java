package com.enes.qa.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtils {

    public static String takeScreenshot(
            WebDriver driver,
            String testName) {

        File source =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

        String timestamp =
                LocalDateTime.now()
                        .format(
                                DateTimeFormatter.ofPattern(
                                        "yyyy-MM-dd_HH-mm-ss"
                                )
                        );

        Path destination =
                Path.of(
                        "reports",
                        "screenshots",
                        testName + "_" + timestamp + ".png"
                );

        try {

            Files.createDirectories(
                    destination.getParent()
            );

            Files.copy(
                    source.toPath(),
                    destination,
                    StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println(
                    "Screenshot kaydedildi: "
                            + destination
            );

            return "screenshots/" + testName + "_" + timestamp + ".png";

        } catch (IOException e) {

            throw new RuntimeException(
                    "Screenshot alınamadı.",
                    e
            );
        }
    }
}
