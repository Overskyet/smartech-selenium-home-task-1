package com.overskyet.page.avtodispetcher;

import com.overskyet.helper.basepage.BasePage;
import com.overskyet.helper.config.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AvtodispetcherResultPage extends BasePage {

    private final Locators objRepo = new Locators();
    private final By totalDistance = objRepo.getLocator("avtodispetcher.resultPage.field.totalDistance");
    private final By fuelCost = objRepo.getLocator("avtodispetcher.resultPage.field.fuelCost");
    private final By editTheRouteLink = objRepo.getLocator("avtodispetcher.resultPage.link.editTheRoute");

    public AvtodispetcherResultPage(WebDriver driver) {
        super(driver);
    }

    public By getTotalDistance() {
        return totalDistance;
    }
    public By getFuelCost() {
        return fuelCost;
    }
    public By getEditTheRouteLink() {
        return editTheRouteLink;
    }

    public boolean resultsOfCalculationAre(String totalDistance, String fuelCost) {
        return (super.getText(this.getTotalDistance()).equals(totalDistance) && super.elementTextContains(this.getFuelCost(), fuelCost));
    }

    public void editTheRoute() {
        super.clickOn(getEditTheRouteLink());
    }
}
