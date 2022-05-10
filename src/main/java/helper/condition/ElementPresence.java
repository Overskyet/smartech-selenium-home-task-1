package helper.condition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementPresence {
    private final WebDriver driver;

    public ElementPresence(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isNotPresent (By xpath) {
        return checkPresenceOfElement(xpath);
    }

    private boolean checkPresenceOfElement (By xpath) {
        List<WebElement> webElements = driver.findElements(xpath);
        return webElements.isEmpty();
    }
}
