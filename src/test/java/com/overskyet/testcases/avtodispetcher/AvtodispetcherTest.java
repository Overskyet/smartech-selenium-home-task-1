package com.overskyet.testcases.avtodispetcher;

import com.overskyet.basetest.BaseTest;
import com.overskyet.dataProviders.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.overskyet.page.avtodispetcher.AvtodispetcherDistancePage;
import com.overskyet.page.avtodispetcher.AvtodispetcherResultPage;
import com.overskyet.page.yandex.YandexResultPage;
import com.overskyet.page.yandex.YandexSearchPage;

import java.util.Map;

public class AvtodispetcherTest extends BaseTest {

    @Test(priority = 1, groups = {"Smoke"}, dataProviderClass = DataProviders.class, dataProvider = "ymlTestData")
    public void avtodispetcherPageIsDisplayedInSearchResult(Map<String, Object> testData) {
        YandexSearchPage searchPage = new YandexSearchPage(super.getDriver()).open();
        YandexResultPage searchResult = (YandexResultPage) searchPage.searchFor((String) testData.get("searchRequest"));

        Assert.assertTrue(searchResult.verifyAvtodispetcherPageIsPresent(), "Avtodispetcher page is not present in search result");
    }

    @Test(priority = 2, groups = {"Regression"}, dataProviderClass = DataProviders.class, dataProvider = "ymlTestData")
    public void avtodispetcherPageIsAccessibleFromSearchResult(Map<String, Object> testData) {
        YandexSearchPage searchPage = new YandexSearchPage(super.getDriver()).open();
        YandexResultPage yaResultPage = (YandexResultPage) searchPage.searchFor((String) testData.get("searchRequest"));
        AvtodispetcherDistancePage distancePage = (AvtodispetcherDistancePage) yaResultPage.openAvtodispetcherPage();

        Assert.assertTrue(distancePage.verifyAvtodispetcherPageIsOpened(), "The wrong page was opened. Expected to open Avtodispetcher page");
    }

    @Test(priority = 3, groups = {"Regression"}, dataProviderClass = DataProviders.class, dataProvider = "ymlTestData")
    public void userIsAbleToCalculateDistanceAndFuelCost(Map<String, Object> testData) {
        AvtodispetcherDistancePage distancePage = new AvtodispetcherDistancePage(super.getDriver()).open();
        AvtodispetcherResultPage result = (AvtodispetcherResultPage) distancePage.fillInTheForm()
                .addDepartureCity((String) testData.get("departureCity"))
                .addDestinationCity((String) testData.get("destinationCity"))
                .addFuelConsumption((String) testData.get("fuelConsumption"))
                .addFuelPrice((String) testData.get("fuelPrice"))
                .submit();

        Assert.assertTrue(result.resultsOfCalculationAre((String) testData.get("expectedTotalDistance"), (String) testData.get("expectedFuelCost")), result.getActualCalculationResult());
    }

    @Test(priority = 3, groups = {"Regression"}, dataProviderClass = DataProviders.class, dataProvider = "ymlTestData")
    public void userIsAbleToEditTheCalculatedRoute(Map<String, Object> testData) {
        AvtodispetcherDistancePage distancePage = new AvtodispetcherDistancePage(super.getDriver()).open();
        AvtodispetcherResultPage result = (AvtodispetcherResultPage) distancePage.fillInTheForm()
                .addDepartureCity((String) testData.get("departureCity"))
                .addDestinationCity((String) testData.get("destinationCity"))
                .addFuelConsumption((String) testData.get("fuelConsumption"))
                .addFuelPrice((String) testData.get("fuelPrice"))
                .submit();

        result.editTheRoute();

        result = (AvtodispetcherResultPage) distancePage.fillInTheForm()
                .addTransitCity((String) testData.get("transitCity"))
                .submit();

        Assert.assertTrue(result.resultsOfCalculationAre((String) testData.get("expectedTotalDistance"), (String) testData.get("expectedFuelCost")), result.getActualCalculationResult());
    }
}
