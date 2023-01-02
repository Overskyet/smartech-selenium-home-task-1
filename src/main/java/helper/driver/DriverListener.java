package helper.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import java.lang.reflect.Method;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;

public class DriverListener implements WebDriverListener {
    //TODO Implement WebDriverListener
    // TODO Implement a Class that initializes log4j
    // TODO Implement a Class that takes an original WebDriver, prepares WebDriverListener and returns decorated WebDriver

    public WebDriver getDecoratedWebDriver(WebDriver original) {
        return new EventFiringDecorator<>(this).decorate(original);
    }

    @Override
    public void beforeAnyCall(Object target, Method method, Object[] args) {
        System.out.println(ZonedDateTime.now(ZoneId.of("UTC")) + ": " + "Before any call: " + target + "\n" + method + "\n" + Arrays.toString(args));
    }

    @Override
    public void afterAnyCall(Object target, Method method, Object[] args, Object result) {
        System.out.println(ZonedDateTime.now(ZoneId.of("UTC")) + ": " + "After any call: " + target + "\n" + method + "\n" + Arrays.toString(args) + "\n" + result);
    }

}
