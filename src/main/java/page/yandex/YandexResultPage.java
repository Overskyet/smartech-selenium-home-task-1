package page.yandex;

import helper.basepage.BasePage;
import helper.config.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.avtodispetcher.AvtodispetcherDistancePage;

public class YandexResultPage extends BasePage {

    private final Locators objRepo = new Locators();

    private final By resultPageAvtodispetcherLink = objRepo.getLocator("yandex.resultPage.link.avtodispetcher");

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
