package helper.browser;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class TabSwitcher {
    private final WebDriver driver;

    public TabSwitcher(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToLastOpenedTab() {
        switchToLastTab();
    }

    private void switchToLastTab() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() == 0) {
            throw new RuntimeException("There is no opened tabs");
        } else {
            driver.switchTo().window(tabs.get(tabs.size() - 1));
        }
    }
}
