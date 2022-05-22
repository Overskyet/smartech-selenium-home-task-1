package helper.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.Wait;

import java.util.concurrent.TimeUnit;

public class Highlighter {
    private final WebDriver driver;

    public Highlighter(WebDriver driver) {
        this.driver = driver;
    }

    public void highlightElement(WebElement element, Long duration) {
        highlightOneElement(element, duration);
    }

    private void highlightOneElement(WebElement element, Long duration) {
        JavascriptExecutor js;
        String originalStyle = element.getAttribute("style");

        if (driver instanceof JavascriptExecutor) {
            js = (JavascriptExecutor) driver;
        } else throw new IllegalStateException("This driver doesn't support JavaScript!");

        if (duration.compareTo(0L) > 0) {
            js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");

            Wait.wait(duration);

            js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
        }
    }
}
