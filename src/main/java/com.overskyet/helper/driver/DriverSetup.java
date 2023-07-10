package com.overskyet.helper.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {
    public static void setUpDriver(WebDriver driver) {
        initWebDriverManager(driver);
    }

    private static void initWebDriverManager(WebDriver driver) {
        if (driver instanceof ChromeDriver) {
            WebDriverManager.chromedriver().setup();
        } else if (driver instanceof FirefoxDriver) {
            WebDriverManager.firefoxdriver().setup();
        } else if (driver instanceof EdgeDriver) {
            WebDriverManager.edgedriver().setup();
        } else {
            throw new RuntimeException(driver.getClass().getName() + " is not an instance of WebDriver class");
        }
    }
}
