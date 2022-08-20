package page.yandex;

import helper.action.PageActions;
import helper.locator.ObjectRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexSearchPage extends PageActions {

    private final ObjectRepository objRepo = new ObjectRepository("object_repo.properties");

    private final String baseUrl = objRepo.getBasicUrl("yandex.searchPage.baseUrl");

    private final By homeLogo = objRepo.getLocator("yandex.searchPage.homeLogo.xpath");

    public YandexSearchPage(WebDriver driver) {
        super(driver);
    }

    public String getBaseUrl() {
        return baseUrl;
    }
    public By getHomeLogo() {
        return homeLogo;
    }


}
