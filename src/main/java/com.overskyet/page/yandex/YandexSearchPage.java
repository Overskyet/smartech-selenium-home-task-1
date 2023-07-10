package com.overskyet.page.yandex;

import com.overskyet.helper.basepage.PageFactoryImpl;
import com.overskyet.helper.enums.Page;
import com.overskyet.helper.basepage.BasePage;
import com.overskyet.helper.config.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexSearchPage extends BasePage {

    private final Locators objRepo = new Locators();

    private final String baseUrl = objRepo.getBasicUrl("yandex.searchPage.baseUrl");

    private final By homeLogo = objRepo.getLocator("yandex.searchPage.homeLogo");
    private final By searchInputField = objRepo.getLocator("yandex.searchPage.inputField");
    private final By searchSubmitButton = objRepo.getLocator("yandex.searchPage.submitButton");

    public YandexSearchPage(WebDriver driver) {
        super(driver);
    }
    public By getSearchInputField() {
        return searchInputField;
    }
    public By getSearchSubmitButton() {
        return searchSubmitButton;
    }

    public BasePage searchFor(String searchRequest) {
        type(getSearchInputField(), searchRequest);
        clickOn(getSearchSubmitButton());
        return PageFactoryImpl.getInstance().createPage(Page.YANDEX_SEARCH_RESULT, getDriver());
    }

    public YandexSearchPage open() {
        super.visit(this.baseUrl);
        return this;
    }
}
