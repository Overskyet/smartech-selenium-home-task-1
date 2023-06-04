package helper.listeners;

import ch.qos.logback.classic.Logger;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.Screenshot;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class TestListener implements ITestListener {

    private static final Logger logger = (Logger) LoggerFactory.getLogger("helper.listeners.TestListener");

    public TestListener() {}

    @Override
    public void onStart(ITestContext context) {
        logger.info("Tests execution is starting... " + context.getName() + "\n" + context);
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Tests execution finished... " + context.getName()
                + "\nPassed tests: " + context.getPassedTests()
                + "\nFailed tests: " + context.getFailedTests()
                + "\nSkipped tests: " + context.getSkippedTests());
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test execution starts: " + result.getTestName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test execution was successful: " + result.getTestName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("Test has failed: " + result.getTestName());

        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("webDriver");
        Screenshot.takeScreenshot(driver);

//        Object currentClass = result.getInstance();
//        WebDriver driver = (WebDriver) currentClass.getDriver();


//        try {
//            Class<?> testClass = result.getTestClass().getRealClass();
//
//            Constructor<?> constructor = testClass.getDeclaredConstructor();
//            constructor.setAccessible(true);
//            Object testInstance = constructor.newInstance();
//
//            WebDriver driver = (WebDriver) testClass.getSuperclass()
//                    .getDeclaredMethod("getDriver")
//                    .invoke(testInstance);
//
//            Screenshot.takeScreenshot(driver);
//        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
//            throw new RuntimeException(e);
//        }
    }
}
