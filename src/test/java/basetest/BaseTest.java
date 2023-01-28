package basetest;

import helper.config.WebDrivers;
import helper.listeners.DriverListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public abstract class BaseTest {
    private WebDriver driver;

    protected WebDriver getDriver() {
        return this.driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        driver = new DriverListener().getDecoratedWebDriver(new WebDrivers().initWebDriver());


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
