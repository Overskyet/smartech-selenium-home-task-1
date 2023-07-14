package com.overskyet.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    public static File takeScreenshotAs(WebDriver driver, String name) {
        return generateScreenshot(driver, name);
    }

    private static File generateScreenshot(WebDriver driver, String name) {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshotFile;
        try {
            screenshotFile = FileManagement.saveScreenshot(name);
            FileHandler.copy(file, screenshotFile);
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while taking screenshot:\n" + e);
        }
        return screenshotFile;
    }
}
