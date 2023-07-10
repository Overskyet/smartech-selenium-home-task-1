package com.overskyet.helper.basepage;

import com.overskyet.helper.enums.Page;
import org.openqa.selenium.WebDriver;

public interface PageFactory {
    BasePage createPage(Page pageName, WebDriver driver);
}
