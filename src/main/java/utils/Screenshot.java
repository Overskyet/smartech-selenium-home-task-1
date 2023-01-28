package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    public static void takeScreenshot(WebDriver driver) {
        generateScreenshot(driver);
    }

    private static void generateScreenshot(WebDriver driver) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(file, FileManagement.saveScreenshot());
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while taking screenshot:\n" + e);
        }
    }
}
