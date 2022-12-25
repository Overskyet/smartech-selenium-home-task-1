import helper.config.WebDrivers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setupDriver() {

    }

    @BeforeMethod
    public void setup() {
        //TODO: Access config.properties from a single place
        this.driver = new WebDrivers("config.properties").initDriver();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
