package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import utils.ExtentManager;
import utils.ScreenshotUtil;

public class TestListener extends BaseClass implements ITestListener {

    ExtentReports extent = ExtentManager.getReportInstance();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail("Test Failed");

        String testName = result.getName();
        ScreenshotUtil.captureScreenshot(driver, testName);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}