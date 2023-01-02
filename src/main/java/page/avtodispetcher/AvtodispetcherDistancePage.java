package page.avtodispetcher;

import helper.basepage.BasePage;
import helper.config.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AvtodispetcherDistancePage extends BasePage {

    private final Locators objRepo = new Locators();

    private final String baseUrl = objRepo.getBasicUrl("avtodispetcher.distance.baseUrl");

    private final By distancePageInputFieldFrom = objRepo.getLocator("avtodispetcher.distance.inputField.from");
    private final By distancePageInputFieldTo = objRepo.getLocator("avtodispetcher.distance.inputField.to");
    private final By distancePageInputFieldFuelConsumption = objRepo.getLocator("avtodispetcher.distance.inputField.fuelConsumption");
    private final By distancePageInputFieldFuelPrice = objRepo.getLocator("avtodispetcher.distance.inputField.fuelPrice");
    private final By distancePageSubmitButton = objRepo.getLocator("avtodispetcher.distance.submitButton.search");

    public AvtodispetcherDistancePage(WebDriver driver) {
        super(driver);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public By getDistancePageInputFieldFrom() {
        return distancePageInputFieldFrom;
    }
    public By getDistancePageInputFieldTo() {
        return distancePageInputFieldTo;
    }
    public By getDistancePageInputFieldFuelPrice() {
        return distancePageInputFieldFuelPrice;
    }
    public By getDistancePageInputFieldFuelConsumption() {
        return distancePageInputFieldFuelConsumption;
    }
    public By getDistancePageSubmitButton() {
        return distancePageSubmitButton;
    }
}
