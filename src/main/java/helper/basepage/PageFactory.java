package helper.basepage;

import helper.enums.Page;
import org.openqa.selenium.WebDriver;

public interface PageFactory {
    BasePage createPage(Page pageName, WebDriver driver);
}
