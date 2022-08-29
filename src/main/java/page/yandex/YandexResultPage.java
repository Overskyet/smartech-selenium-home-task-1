package page.yandex;

import helper.action.PageActions;
import helper.locator.ObjectRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexResultPage extends PageActions {

    private final ObjectRepository objRepo = new ObjectRepository("object_repo.properties");

    private final By resultPageAvtodispetcherLink = objRepo.getLocator("yandex.resultPage.link.avtodispetcher.xpath");

    public YandexResultPage(WebDriver driver) {
        super(driver);
    }

    public By getResultPageAvtodispetcherLink() {
        return resultPageAvtodispetcherLink;
    }
}
