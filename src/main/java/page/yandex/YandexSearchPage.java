package page.yandex;

import helper.basepage.BasePage;
import helper.config.Locators;
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

    public YandexResultPage searchFor(String searchRequest) {
        type(getSearchInputField(), searchRequest);
        clickOn(getSearchSubmitButton());
        return new YandexResultPage(driver);
    }
}
