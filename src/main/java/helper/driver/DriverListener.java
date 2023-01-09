package helper.driver;

import ch.qos.logback.classic.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Arrays;

public class DriverListener implements WebDriverListener {
    private static final Logger logger = (Logger) LoggerFactory.getLogger("helper.driver.DriverListener");
    public WebDriver getDecoratedWebDriver(WebDriver original) {
        return new EventFiringDecorator<>(this).decorate(original);
    }

    @Override
    public void beforeAnyCall(Object target, Method method, Object[] args) {
        logger.debug("Before any call: " + target + "\n" + method + "\n" + Arrays.toString(args));
    }

    @Override
    public void afterAnyCall(Object target, Method method, Object[] args, Object result) {
        logger.debug("After any call: " + target + "\n" + method + "\n" + Arrays.toString(args));
    }

}
