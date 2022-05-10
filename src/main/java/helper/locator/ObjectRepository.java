package helper.locator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ObjectRepository {

    private Properties objectRepository;

    public ObjectRepository (String fileName) {
        setupObjectRepository(fileName);
    }

    public String getLocator (String locatorName) {
        return findLocator(locatorName);
    }

    private void setupObjectRepository (String fileName) {
        File file = new File(fileName);
        objectRepository = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream(file);
            objectRepository.load(inputStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private String findLocator (String locatorName) {
        return objectRepository.getProperty(locatorName);
    }
}