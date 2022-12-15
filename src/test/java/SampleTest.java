import org.testng.Assert;
import org.testng.annotations.Test;
import page.avtodispetcher.AvtodispetcherDistancePage;
import page.avtodispetcher.AvtodispetcherResultPage;
import page.yandex.YandexResultPage;
import page.yandex.YandexSearchPage;

import java.util.ArrayList;

public class SampleTest extends BaseTest {

    @Test
    public void sampleFirstTestScenario() {
        YandexSearchPage searchPage = new YandexSearchPage(driver);
        searchPage.visit(searchPage.getBaseUrl());
        searchPage.waitFor(searchPage.getHomeLogo(), 10L);
        searchPage.type(searchPage.getSearchInputField(), "расчет расстояний между городами");
        searchPage.clickOn(searchPage.getSearchSubmitButton());

        YandexResultPage yaResultPage = new YandexResultPage(driver);
        String actualSearchResultLink = yaResultPage.getAttributeValue(yaResultPage.getResultPageAvtodispetcherLink(), "href");

        AvtodispetcherDistancePage avtoDistancePage = yaResultPage.openAvtodispetcherPage();

        Assert.assertEquals(actualSearchResultLink, avtoDistancePage.getBaseUrl());

        avtoDistancePage.waitFor(avtoDistancePage.getDistancePageInputFieldFrom(), 10L);

        avtoDistancePage.clear(avtoDistancePage.getDistancePageInputFieldFrom());
        avtoDistancePage.type(avtoDistancePage.getDistancePageInputFieldFrom(), "Тула");

        avtoDistancePage.clear(avtoDistancePage.getDistancePageInputFieldTo());
        avtoDistancePage.type(avtoDistancePage.getDistancePageInputFieldTo(), "Санкт-Петербург");

        avtoDistancePage.clear(avtoDistancePage.getDistancePageInputFieldFuelConsumption());
        avtoDistancePage.type(avtoDistancePage.getDistancePageInputFieldFuelConsumption(), "9");

        avtoDistancePage.clear(avtoDistancePage.getDistancePageInputFieldFuelPrice());
        avtoDistancePage.type(avtoDistancePage.getDistancePageInputFieldFuelPrice(), "46");

        avtoDistancePage.clickOn(avtoDistancePage.getDistancePageSubmitButton());

        AvtodispetcherResultPage adResultPage = new AvtodispetcherResultPage(driver);
        adResultPage.waitFor(adResultPage.getTotalDistance(), 10L);
        Assert.assertEquals(adResultPage.getText(adResultPage.getTotalDistance()), "897");
        Assert.assertTrue(adResultPage.textContains(adResultPage.getTotalAmount(), "3726"),
                "Expected result: Стомость топлива: 3726\n" + "Actual result: " + adResultPage.getText(adResultPage.getTotalAmount()));

    }
}
