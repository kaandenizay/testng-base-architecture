package listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import driver.DriverManager;
import extentReports.ExtentTestManager;
import log.LoggingManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.io.File;

import static extentReports.ExtentTestManager.getTest;
import static extentReports.ExtentTestManager.startTest;

public class TestListener implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onTestStart(ITestResult result) {
        LoggingManager.info(getTestMethodName(result) + " test is starting.");
        String desc = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).description();
        String methodName = result.getMethod().getConstructorOrMethod().getName();
        String className = result.getTestClass().getRealClass().getSimpleName();
        startTest(methodName, desc, className);
    }


    @Override
    public void onFinish(ITestContext iTestContext) {
        LoggingManager.info("I am in onFinish method " + iTestContext.getName());
        //Do tier down operations for ExtentReports reporting!
        ExtentTestManager.extentReports.flush();
    }



    @Override
    public void onTestSuccess(ITestResult result) {
        LoggingManager.info(getTestMethodName(result) + " test is succeed.");
        //ExtentReports log operation for passed tests.
        getTest().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LoggingManager.info(getTestMethodName(result) + " test is failed.");

        try {
            System.out.println("Taking screenshot for failed assert");
            String screenshotPath = System.getProperty("user.dir") + "/test-output/screenshots";

            File src = ((TakesScreenshot) DriverManager.getThreadDriver()).getScreenshotAs(OutputType.FILE);
            System.out.println("Adding screenshot to extent report");
            String screenshotName = "screenshot_" +result.getName() + ".png";
            screenshotPath = screenshotPath + File.separator + screenshotName;
            File destFile = new File(screenshotPath);
            FileUtils.copyFile(src, destFile);
//            getTest().log(Status.FAIL,result.getThrowable());
//            getTest().addScreenCaptureFromPath(screenshotPath);
            getTest().fail(result.getThrowable())
                    .fail("Failure Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(
                            "../test-output/screenshots/" + screenshotName).build());
        }catch (Exception e){
            System.out.println("Exception while taking screenshot "+e.getMessage());
        }

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LoggingManager.info(getTestMethodName(iTestResult) + " test is skipped.");
        //ExtentReports log operation for skipped tests.
        getTest().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        LoggingManager.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}