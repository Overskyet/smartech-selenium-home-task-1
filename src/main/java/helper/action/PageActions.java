package helper.action;

import helper.condition.ElementPresence;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageActions {

    WebDriver driver;

    public PageActions() {}

    public PageActions(WebDriver driver) {
        this.driver = driver;
    }

    public void visit(String url) {
        driver.get(url);
    }

    public WebElement find(By element) {
        return driver.findElement(element);
    }

    public void clear(By element) {
        find(element).clear();
    }

    public void type(By element, String text) {
        find(element).sendKeys(text);
    }

    public void clickOn(By element) {
        find(element).click();
    }

    public boolean elementIsNotPresent(By element) {
        return new ElementPresence(driver).isNotPresent(element);
    }

    public String getText(By element) {
        return find(element).getText();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void waitFor(By element, long seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.presenceOfElementLocated(element));
    }

}