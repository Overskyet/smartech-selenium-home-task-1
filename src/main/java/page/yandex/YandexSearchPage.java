package page.yandex;

import helper.action.PageActions;
import helper.locator.ObjectRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexSearchPage extends PageActions {

    private final ObjectRepository objRepo = new ObjectRepository("object_repo.properties");

    private final By homeLogo = objRepo.getLocator("yandex.searchPage.homeLogo.xpath");

    public YandexSearchPage(WebDriver driver) {
        super(driver);
    }

    public By getHomeLogo() {
        return homeLogo;
    }

}
