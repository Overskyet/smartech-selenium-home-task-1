package helper.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class WebDrivers {
    private Properties driversSettings;

    public WebDrivers(String fileName){
        setupDriverSettings(fileName);
    }

    public WebDriver initDriver() {
        return getDriverFromSettings();
    }

    private void setupDriverSettings(String fileName) {
        driversSettings = new ConfigInitialization(fileName).setupProperties();
    }

    private WebDriver getDriverFromSettings() {
        //TODO: Handle missing property key
        String driverToUse = getProperty();

        WebDriver driver = null;

        switch (driverToUse) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
        }
        return driver;
    }

    private String getProperty() {
        return driversSettings.getProperty("webdriver.to.use");
    }

}
