package page.yandex;

import helper.action.PageActions;
import helper.config.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexSearchPage extends PageActions {

    private final Locators objRepo = new Locators("config.properties");

    private final String baseUrl = objRepo.getBasicUrl("yandex.searchPage.baseUrl");

    private final By homeLogo = objRepo.getLocator("yandex.searchPage.homeLogo.xpath");
    private final By searchInputField = objRepo.getLocator("yandex.searchPage.inputField.search.xpath");
    private final By searchSubmitButton = objRepo.getLocator("yandex.searchPage.submitButton.search.xpath");

    public YandexSearchPage(WebDriver driver) {
        super(driver);
    }

    public String getBaseUrl() {
        return baseUrl;
    }
    public By getHomeLogo() {
        return homeLogo;
    }
    public By getSearchInputField() {
        return searchInputField;
    }
    public By getSearchSubmitButton() {
        return searchSubmitButton;
    }

}
