package com.overskyet.helper.config;

import org.openqa.selenium.By;

import java.util.Properties;

public class Locators {

    private Properties objectRepository;

    public Locators() {
        setupObjectRepository();
    }
    public Locators(String fileName) {
        setupObjectRepository(fileName);
    }

    public By getLocator(String locatorName) {
        return findLocator(locatorName);
    }

    public String getBasicUrl(String urlName) {
        return findBasicUrl(urlName);
    }

    private void setupObjectRepository() {
        objectRepository = new ConfigInitialization().setupProperties();
    }
    private void setupObjectRepository(String fileName) {
        objectRepository = new ConfigInitialization(fileName).setupProperties();
    }

    private By findLocator(String locatorName)
    {
        String locatorProperty = getProperty(locatorName);

        if (locatorProperty == null || locatorProperty.isBlank()) {
            throw new IllegalArgumentException(String.format("Can not find locator property '%s' in the properties" +
                    "\nEnsure that the property key '%s' is in the properties file", locatorName, locatorName));
        }

        String locatorType = locatorProperty.split(";")[0];
        String locatorValue = locatorProperty.split(";")[1];

        By locator;

        switch(locatorType)
        {
            case "id":
                locator = By.id(locatorValue);
                break;
            case "name":
                locator = By.name(locatorValue);
                break;
            case "cssSelector":
                locator = By.cssSelector(locatorValue);
                break;
            case "linkText":
                locator = By.linkText(locatorValue);
                break;
            case "partialLinkText":
                locator = By.partialLinkText(locatorValue);
                break;
            case "tagName":
                locator = By.tagName(locatorValue);
                break;
            case "xpath":
                locator = By.xpath(locatorValue);
                break;
            default: throw new IllegalArgumentException(String.format("Can not initialize new locator using provided locator type: %s" +
                "\nCheck the value of '%s' property key in the properties and ensure that locator type is correct", locatorType, locatorName));
        }
        return locator;
    }

    private String findBasicUrl(String urlName) {
        return getProperty(urlName);
    }

    private String getProperty(String propertyName) {
        return objectRepository.getProperty(propertyName);
    }


}