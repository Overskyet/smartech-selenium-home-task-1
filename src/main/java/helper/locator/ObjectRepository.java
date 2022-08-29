package helper.locator;

import org.openqa.selenium.By;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ObjectRepository {

    private Properties objectRepository;

    public ObjectRepository(String fileName) {
        setupObjectRepository(fileName);
    }

    public By getLocator(String locatorName) {
        return findLocator(locatorName);
    }

    public String getBasicUrl(String urlName) {
        return findBasicUrl(urlName);
    }

    private void setupObjectRepository(String fileName) {
        File file = new File(fileName);
        objectRepository = new Properties();
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
            objectRepository.load(reader);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private By findLocator(String locatorName)
    {
        String locatorProperty = getProperty(locatorName);
        String locatorType = locatorProperty.split(";")[0];
        String locatorValue = locatorProperty.split(";")[1];

        By locator = null;

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