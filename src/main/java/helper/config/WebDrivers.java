package helper.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class WebDrivers {
    private Properties driversSettings;

    public WebDrivers() {
        setupDriversSettings();
    }
    public WebDrivers(String propertiesFileName){
        setupDriverSettings(propertiesFileName);
    }

    public WebDriver initWebDriver() {
        return getDriverFromSettings("webdriver");
    }

    private void setupDriversSettings() {
        driversSettings = new ConfigInitialization().setupProperties();
    }
    private void setupDriverSettings(String fileName) {
        driversSettings = new ConfigInitialization(fileName).setupProperties();
    }

    private WebDriver getDriverFromSettings(String propertyKey) {
        String driverToUse = getProperty(propertyKey);

        if (driverToUse == null || driverToUse.isBlank()) {
            throw new IllegalArgumentException(String.format("Can not initialize new WebDriver instance" +
                    "\nProperty key: '%s' does not exist" +
                    "\nEnsure that the property key '%s' is in the properties file", propertyKey, propertyKey));
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
                    "\nCheck the value of '%s' property key in the properties", driverToUse, propertyKey));
        }
        return driver;
    }

    private String getProperty(String propertyKey) {
        return driversSettings.getProperty(propertyKey);
    }

}
