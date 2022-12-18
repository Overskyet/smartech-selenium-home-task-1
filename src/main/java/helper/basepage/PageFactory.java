package helper.basepage;

import helper.enums.PageName;
import org.openqa.selenium.WebDriver;

public interface PageFactory {
    BasePage createPage(PageName pageName, WebDriver driver);
}
