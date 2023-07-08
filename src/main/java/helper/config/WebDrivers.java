package helper.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Properties;

public class WebDrivers {
    private Properties driversSettings;
    private final static String PAGE_LOAD_TIMEOUT_PROPERTY = "pageLoad.timeout";

    public WebDrivers() {
        setupDriversSettings();
    }
    public WebDrivers(String propertiesFileName){
        setupDriverSettings(propertiesFileName);
    }

    public WebDriver initWebDriverFor(String browser) {
        return setupDriver(browser);
    }

    private void setupDriversSettings() {
        driversSettings = new ConfigInitialization().setupProperties();
    }
    private void setupDriverSettings(String fileName) {
        driversSettings = new ConfigInitialization(fileName).setupProperties();
    }

    private WebDriver setupDriver(String browser) {
        String pageLoadTimeout = getProperty(PAGE_LOAD_TIMEOUT_PROPERTY);

        if (browser == null || browser.isBlank()) {
            throw new IllegalArgumentException("Can not initialize new WebDriver instance" +
                    "\nBrowser name is null or empty" +
                    "\nEnsure that the value for 'browser' parameter is specified in the testNG configuration");
        }

        WebDriver driver;

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default: throw new IllegalArgumentException(String.format("Can't initialize new WebDriver instance." +
                    "\nCan't find WebDriver for the provided browser name: %s" +
                    "\nCheck the browser name in the testNG configuration", browser));
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        if (!(pageLoadTimeout == null || pageLoadTimeout.isBlank()) && isNumeric(pageLoadTimeout)) {
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(pageLoadTimeout)));
        }

        return driver;
    }

    private String getProperty(String propertyKey) {
        return driversSettings.getProperty(propertyKey);
    }

    private boolean isNumeric(String numString) {
        try {
            Long.parseLong(numString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
