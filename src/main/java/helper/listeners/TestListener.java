package helper.listeners;

import ch.qos.logback.classic.Logger;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.Screenshot;

public final class TestListener implements ITestListener {

    private static final Logger logger = (Logger) LoggerFactory.getLogger("helper.listeners.TestListener");

    public TestListener() {}

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test execution is starting... " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test execution is finished in... " + ((context.getEndDate().getTime() - context.getStartDate().getTime()) / 1000) + " s."
                + "\nPassed tests: " + context.getPassedTests()
                + "\nFailed tests: " + context.getFailedTests()
                + "\nSkipped tests: " + context.getSkippedTests());
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test execution starts: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test execution was successful: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test has failed: " + result.getMethod().getMethodName());

        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("webDriver");
        Screenshot.takeScreenshotAs(driver, result.getMethod().getMethodName());
    }
}
