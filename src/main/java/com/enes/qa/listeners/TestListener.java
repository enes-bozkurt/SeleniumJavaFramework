package com.enes.qa.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.enes.qa.base.BaseTest;
import com.enes.qa.utils.ExtentManager;
import com.enes.qa.utils.ScreenshotUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private ExtentReports extent;
    private ExtentTest test;

    @Override
    public void onStart(ITestContext context) {

        extent = ExtentManager.getExtentReports();
    }

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(
                result.getName()
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test başarıyla geçti.");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        Object testClass =
                result.getInstance();

        BaseTest baseTest =
                (BaseTest) testClass;

        String screenshotPath =
                ScreenshotUtils.takeScreenshot(
                        baseTest.getDriver(),
                        result.getName()
                );

        try {

            test.addScreenCaptureFromPath(
                    screenshotPath
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}