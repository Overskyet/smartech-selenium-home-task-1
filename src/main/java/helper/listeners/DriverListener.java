package helper.listeners;

import ch.qos.logback.classic.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public final class DriverListener implements WebDriverListener {
    private static final Logger logger = (Logger) LoggerFactory.getLogger("helper.listeners.DriverListener");

    public WebDriver getDecoratedWebDriver(WebDriver original) {
        return new EventFiringDecorator<>(this).decorate(original);
    }

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        logger.error("An error occurred while executing the method: '" + method + "'\n"
                + "With arguments: '" + Arrays.toString(args) + "'\n"
                + "On: '" + target + "'\n"
                + e + "\n"
                + e.getMessage());
    }

    @Override
    public void beforeGet(WebDriver driver, String url) {
        logger.info("Navigating to: '" + url + "'");
    }

    @Override
    public void afterGet(WebDriver driver, String url) {
        logger.info("Navigated to: '" + url + "'");
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        logger.info("Trying to find Element by: '" + locator.toString() + "'");
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        logger.info("Element found: '" + result.getAccessibleName() + "'");
    }

    @Override
    public void beforeFindElements(WebDriver driver, By locator) {
        logger.info("Trying to find Elements By: '" + locator.toString() + "'");
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        logger.info("Elements found: '" + String.join(", ", (CharSequence) result) + "'");
    }

    @Override
    public void beforeClick(WebElement element) {
        logger.info("Trying to click on: " + element.getAccessibleName());
    }

    @Override
    public void afterClick(WebElement element) {
        logger.info("Clicked on: " + element.getAccessibleName());
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        logger.info("Trying to input: '" + Arrays.toString(keysToSend) + "'\n"
        + "in the '" + element.getAccessibleName() + "' field");
    }

    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        logger.info("Entered: '" + Arrays.toString(keysToSend) + "'\n"
                + "in the '" + element.getAccessibleName() + "' field");
    }

    @Override
    public void beforeClear(WebElement element) {
        logger.info("Trying to clear the input field: '" + element.getAccessibleName() + "'");
    }

    @Override
    public void afterClear(WebElement element) {
        logger.info("Cleared the input field: '" + element.getAccessibleName() + "'");
    }

    @Override
    public void beforeSubmit(WebElement element) {
        logger.info("Trying to submit: '" + element.getAccessibleName() + "'");
    }

    @Override
    public void afterSubmit(WebElement element) {
        logger.info("Submitted: '" + element.getAccessibleName() + "'");
    }

    @Override
    public void beforeClose(WebDriver driver) {
        logger.info("Trying to close the driver: " + driver.toString());
    }

    @Override
    public void afterClose(WebDriver driver) {
        logger.info("The driver was closed");
    }

    @Override
    public void beforeQuit(WebDriver driver) {
        logger.info("Trying to quit the driver: " + driver.toString());
    }

    @Override
    public void afterQuit(WebDriver driver) {
        logger.info("Quit the driver");
    }

}
