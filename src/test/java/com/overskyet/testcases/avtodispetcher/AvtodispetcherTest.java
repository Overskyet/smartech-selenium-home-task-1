package com.overskyet.testcases.avtodispetcher;

import com.overskyet.basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.overskyet.page.avtodispetcher.AvtodispetcherDistancePage;
import com.overskyet.page.avtodispetcher.AvtodispetcherResultPage;
import com.overskyet.page.yandex.YandexResultPage;
import com.overskyet.page.yandex.YandexSearchPage;

public class AvtodispetcherTest extends BaseTest {

    @Test(priority = 1, groups = {"Smoke"})
    public void avtodispetcherPageIsDisplayedInSearchResult() {
        YandexSearchPage searchPage = new YandexSearchPage(super.getDriver()).open();
        YandexResultPage searchResult = (YandexResultPage) searchPage.searchFor("расчет расстояний между городами");

        Assert.assertTrue(searchResult.verifyAvtodispetcherPageIsPresent(), "Avtodispetcher page is not present in search result");
    }

    @Test(priority = 2, groups = {"Regression"})
    public void avtodispetcherPageIsAccessibleFromSearchResult() {
        YandexSearchPage searchPage = new YandexSearchPage(super.getDriver()).open();
        YandexResultPage yaResultPage = (YandexResultPage) searchPage.searchFor("расчет расстояний между городами");
        AvtodispetcherDistancePage distancePage = (AvtodispetcherDistancePage) yaResultPage.openAvtodispetcherPage();

        Assert.assertTrue(distancePage.verifyAvtodispetcherPageIsOpened(), "The wrong page was opened. Expected to open Avtodispetcher page");
    }

    @Test(priority = 3, groups = {"Regression"})
    public void userIsAbleToCalculateDistanceAndFuelCost() {
        AvtodispetcherDistancePage distancePage = new AvtodispetcherDistancePage(super.getDriver()).open();
        AvtodispetcherResultPage result = (AvtodispetcherResultPage) distancePage.fillInTheForm()
                .addDepartureCity("Тула")
                .addDestinationCity("Санкт-Петербург")
                .addFuelConsumption("9")
                .addFuelPrice("46")
                .submit();

        Assert.assertTrue(result.resultsOfCalculationAre("897", "3726"), "Results of calculation are not correct, or element is not displayed");
    }

    @Test(priority = 3, groups = {"Regression"})
    public void userIsAbleToEditTheCalculatedRoute() {
        AvtodispetcherDistancePage distancePage = new AvtodispetcherDistancePage(super.getDriver()).open();
        AvtodispetcherResultPage result = (AvtodispetcherResultPage) distancePage.fillInTheForm()
                .addDepartureCity("Тула")
                .addDestinationCity("Санкт-Петербург")
                .addFuelConsumption("9")
                .addFuelPrice("46")
                .submit();

        result.editTheRoute();

        result = (AvtodispetcherResultPage) distancePage.fillInTheForm()
                .addTransitCity("Великий Новгород")
                .submit();

        Assert.assertTrue(result.resultsOfCalculationAre("966", "4002"), "Results of calculation are not correct, or element is not displayed");
    }
}