package com.overskyet.page.yandex;

import com.overskyet.helper.basepage.BasePage;
import com.overskyet.helper.basepage.PageFactoryImpl;
import com.overskyet.helper.config.Locators;
import com.overskyet.helper.enums.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexResultPage extends BasePage {

    private final Locators objRepo = new Locators();

    private final By resultPageAvtodispetcherLink = objRepo.getLocator("yandex.resultPage.link.avtodispetcher");

    public YandexResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyAvtodispetcherPageIsPresent() {
        return isAttributePresent(resultPageAvtodispetcherLink, "href");
    }

    public BasePage openAvtodispetcherPage() {
        clickOn(resultPageAvtodispetcherLink);
        switchToLastOpenedTab();
        return PageFactoryImpl.getInstance().createPage(Page.AVTODISPETCHER_DISTANCE, getDriver());
    }
}
