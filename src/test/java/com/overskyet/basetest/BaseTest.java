package com.overskyet.basetest;

import com.overskyet.helper.config.WebDrivers;
import com.overskyet.helper.listeners.DriverListener;
import com.overskyet.helper.listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public abstract class BaseTest {
    private WebDriver driver;

    public WebDriver getDriver() {
        return this.driver;
    }

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setup(ITestContext context, String browser) {
        driver = new DriverListener().getDecoratedWebDriver(new WebDrivers().initWebDriverFor(browser));
        context.setAttribute("webDriver", getDriver());

//         * Be able to pass the drivers through command line arguments
//         * Be able to declare the drivers in the properties file
//         * For each driver in the array create a new WebDriver instance and use it for running test methods
//         * Access the WebDriver instance from one place in the code
//         * 1) Initialize the WebDriver instance before executing test methods
//         * 2) -> Run test methods sequentially or in parallel using one WebDriver instance
//         * 3) -> When the test execution is complete switch to the next WebDriver instance (if several drivers were passed)
//         * 4) -> Repeat the steps
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
