package helper.basepage;

import helper.browser.TabSwitcher;
import helper.condition.ElementPresence;
import helper.page.Highlighter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void visit(String url) {
        driver.get(url);
    }

    public void switchToLastOpenedTab() {
        TabSwitcher switcher = new TabSwitcher(driver);
        switcher.switchToLastOpenedTab();
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

    public String getActualURL() {
        return driver.getCurrentUrl();
    }

    public String getAttributeValue(By element, String attributeName) {
        return find(element).getAttribute(attributeName);
    }

    public void waitFor(By element, long seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void hightlightElement(By element, Long duration) {
        new Highlighter(driver).highlightElement(find(element), duration);
    }

    public boolean textContains(By element, String text){
        String elementText = getText(element);
        return elementText.contains(text);
    }

//    public boolean isOpened() {
//        return getActualURL().equals();
//    }

}