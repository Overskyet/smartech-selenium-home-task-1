package helper.basepage;

import helper.browser.TabSwitcher;
import helper.condition.ElementPresence;
import helper.page.Highlighter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver getDriver() {
        return driver;
    }

    public void visit(String url) {
        this.getDriver().get(url);
    }

    public void switchToLastOpenedTab() {
        TabSwitcher switcher = new TabSwitcher(this.getDriver());
        switcher.switchToLastOpenedTab();
    }

    public WebElement find(By element) {
        return waitForExplicitly(element, 10);
    }

    public void clear(By element) {
        find(element).clear();
    }

    public void type(By element, String text) {
        find(element).sendKeys(text);
    }

    public void clearAndType(By element, String text) {
        clear(element);
        type(element, text);
    }

    public void clickOn(By element) {
        find(element).click();
    }

    public boolean elementIsNotPresent(By element) {
        return new ElementPresence(this.getDriver()).isNotPresent(element);
    }

    public String getText(By element) {
        return find(element).getText();
    }

    public String getTitle() {
        return this.getDriver().getTitle();
    }

    public String getActualURL() {
        return this.getDriver().getCurrentUrl();
    }

    public String getAttributeValue(By element, String attributeName) {
        return find(element).getAttribute(attributeName);
    }

    public boolean isAttributePresent(By element, String attributeName) {
        return !(getAttributeValue(element, attributeName).isBlank() || getAttributeValue(element, attributeName) == null);
    }

    public void waitFor(By element, long seconds) {
        new WebDriverWait(this.getDriver(), Duration.ofSeconds(seconds)).until(ExpectedConditions.presenceOfElementLocated(element));
    }
    private WebElement waitForExplicitly(By element, long seconds) {
        return new WebDriverWait(this.getDriver(), Duration.ofSeconds(seconds)).ignoring(NoSuchElementException.class).until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void hightlightElement(By element, Long duration) {
        new Highlighter(this.getDriver()).highlightElement(find(element), duration);
    }

    public boolean textContains(By element, String text){
        String elementText = getText(element);
        return elementText.contains(text);
    }

}