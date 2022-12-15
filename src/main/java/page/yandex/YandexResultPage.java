package page.yandex;

import helper.action.PageActions;
import helper.config.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.avtodispetcher.AvtodispetcherDistancePage;

public class YandexResultPage extends PageActions {

    private final Locators objRepo = new Locators("config.properties");

    private final By resultPageAvtodispetcherLink = objRepo.getLocator("yandex.resultPage.link.avtodispetcher.xpath");

    public YandexResultPage(WebDriver driver) {
        super(driver);
    }

    public By getResultPageAvtodispetcherLink() {
        return resultPageAvtodispetcherLink;
    }

    public AvtodispetcherDistancePage openAvtodispetcherPage() {
        clickOn(getResultPageAvtodispetcherLink());
        switchToLastOpenedTab();
        return new AvtodispetcherDistancePage(driver);
    }
}
