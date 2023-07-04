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
    private final static String WEB_DRIVER_PROPERTY = "webdriver";
    private final static String PAGE_LOAD_TIMEOUT_PROPERTY = "pageLoad.timeout";

    public WebDrivers() {
        setupDriversSettings();
    }
    public WebDrivers(String propertiesFileName){
        setupDriverSettings(propertiesFileName);
    }

    public WebDriver initWebDriver() {
        return setupDriver();
    }

    private void setupDriversSettings() {
        driversSettings = new ConfigInitialization().setupProperties();
    }
    private void setupDriverSettings(String fileName) {
        driversSettings = new ConfigInitialization(fileName).setupProperties();
    }

    private WebDriver setupDriver() {
        String driverToUse = getProperty(WEB_DRIVER_PROPERTY);
        String pageLoadTimeout = getProperty(PAGE_LOAD_TIMEOUT_PROPERTY);

        if (driverToUse == null || driverToUse.isBlank()) {
            throw new IllegalArgumentException(String.format("Can not initialize new WebDriver instance" +
                    "\nProperty key: '%s' does not exist" +
                    "\nEnsure that the property key '%s' is in the properties file", WEB_DRIVER_PROPERTY, WEB_DRIVER_PROPERTY));
        }

        WebDriver driver;

        switch (driverToUse) {
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
            default: throw new IllegalArgumentException(String.format("Can not initialize new WebDriver instance, using provided parameter's value: %s" +
                    "\nCheck the value of '%s' property key in the properties", driverToUse, WEB_DRIVER_PROPERTY));
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
