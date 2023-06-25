package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    public static void takeScreenshotAs(WebDriver driver, String name) {
        generateScreenshot(driver, name);
    }

    private static void generateScreenshot(WebDriver driver, String name) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(file, FileManagement.saveScreenshot(name));
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while taking screenshot:\n" + e);
        }
    }
}
