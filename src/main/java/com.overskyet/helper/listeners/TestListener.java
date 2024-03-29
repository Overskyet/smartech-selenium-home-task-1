package com.overskyet.helper.listeners;

import ch.qos.logback.classic.Logger;
import com.overskyet.utils.Screenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.testng.*;

import java.io.File;

public final class TestListener implements ITestListener {

    private static final Logger logger = (Logger) LoggerFactory.getLogger("com.overskyet.helper.listeners.TestListener");

    public TestListener() {}

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test execution is starting... " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test execution is finished in... " + ((context.getEndDate().getTime() - context.getStartDate().getTime()) / 1000) + " s."
                + "\nPassed tests: " + printOutTests(context.getPassedTests())
                + "\nFailed tests: " + printOutTests(context.getFailedTests())
                + "\nSkipped tests: " + printOutTests(context.getSkippedTests()));
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Start executing test case: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test execution was successful: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test failed: " + result.getMethod().getMethodName());
        shootScreenshotOnFailureAndAddItToReport(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info("Test skipped: " + result.getMethod().getMethodName());
    }

    private String printOutTests(IResultMap resultMap) {
        StringBuilder result = new StringBuilder();
        for (ITestResult entry : resultMap.getAllResults()) {
            result.append("\n***\nMethod: ").append(entry.getMethod()).append('\n');
            result.append("***\n");
        }
        return result.toString();
    }
    private void shootScreenshotOnFailureAndAddItToReport(ITestResult result) {
        ITestContext context = result.getTestContext();
        WebDriver driver = getWebDriverFromContext(context);
        String browserName = getBrowserNameFromContext(context);
        File screenshot = Screenshot.takeScreenshotAs(driver, (browserName + "_" + result.getMethod().getMethodName()));

        Reporter.log("<a href='"+ screenshot.getAbsolutePath() + "'> <img src='"+ screenshot.getAbsolutePath() + "' height='100' width='100'/> </a>");
    }

    private WebDriver getWebDriverFromContext(ITestContext context) {
        return (WebDriver) context.getAttribute("webDriver");
    }
    private String getBrowserNameFromContext(ITestContext context) {
        return context.getCurrentXmlTest().getParameter("browser");
    }
}
