package com.overskyet.page.avtodispetcher;

import com.overskyet.helper.basepage.BasePage;
import com.overskyet.helper.basepage.PageFactoryImpl;
import com.overskyet.helper.config.Locators;
import com.overskyet.helper.enums.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class AvtodispetcherDistancePage extends BasePage {

    private final Locators objRepo = new Locators();

    private final String baseUrl = objRepo.getBasicUrl("avtodispetcher.distance.baseUrl");
    private final By departureCityInputField = objRepo.getLocator("avtodispetcher.distance.inputField.departureCity");
    private final By destinationCityInputField = objRepo.getLocator("avtodispetcher.distance.inputField.destinationCity");
    private final By fuelConsumptionInputField = objRepo.getLocator("avtodispetcher.distance.inputField.fuelConsumption");
    private final By transitCityInputField = objRepo.getLocator("avtodispetcher.distance.inputField.transitCity");
    private final By fuelPriceInputField = objRepo.getLocator("avtodispetcher.distance.inputField.fuelPrice");
    private final By submitButton = objRepo.getLocator("avtodispetcher.distance.submitButton.calculate");

    public AvtodispetcherDistancePage(WebDriver driver) {
        super(driver);
    }

    public By getDepartureCityInputField() {
        return departureCityInputField;
    }
    public By getDestinationCityInputField() {
        return destinationCityInputField;
    }
    public By getFuelPriceInputField() {
        return fuelPriceInputField;
    }
    public By getTransitCityInputField() {
        return transitCityInputField;
    }
    public By getFuelConsumptionInputField() {
        return fuelConsumptionInputField;
    }
    public By getSubmitButton() {
        return submitButton;
    }

    public AvtodispetcherDistancePage open() {
        super.visit(this.baseUrl);
        return this;
    }

    public boolean verifyAvtodispetcherPageIsOpened() {
        return verifyCorrectPageIsOpened(baseUrl);
    }

    public FormBuilder fillInTheForm() {
        return new FormBuilder();
    }

    public class FormBuilder {
        private final Map<By, String> form = new HashMap<>();

        public FormBuilder addDepartureCity(String cityFrom) {
            form.put(getDepartureCityInputField(), cityFrom);
            return this;
        }

        public FormBuilder addDestinationCity(String cityTo) {
            form.put(getDestinationCityInputField(), cityTo);
            return this;
        }

        public FormBuilder addFuelConsumption(String fuelConsumption) {
            form.put(getFuelConsumptionInputField(), fuelConsumption);
            return this;
        }

        public FormBuilder addFuelPrice(String fuelPrice) {
            form.put(getFuelPriceInputField(), fuelPrice);
            return this;
        }

        public FormBuilder addTransitCity(String transitCity) {
            form.put(getTransitCityInputField(), transitCity);
            return this;
        }

        public BasePage submit() {

            for (var formField : form.entrySet()) {
                clearAndType(formField.getKey(), formField.getValue());
            }

            form.clear();

            clickOn(getSubmitButton());

            return PageFactoryImpl.getInstance().createPage(Page.AVTODISPETCHER_RESULT, getDriver());
        }
    }
}
