package helper.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverEnv {
    public WebDriver setUpDriver() {
        return initDriver();
    }

    private WebDriver initDriver() {
        return new FirefoxDriver();
    }
}
