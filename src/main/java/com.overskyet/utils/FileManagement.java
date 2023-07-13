package com.overskyet.utils;

import com.overskyet.helper.enums.ImageExtension;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class FileManagement {
    /** Lists files under root project directory */
    public static File[] listFilesWith(String extension) {
        return new File(Paths.get(".").normalize().toAbsolutePath().toString()).listFiles((dir, name) -> name.endsWith(extension));
    }

    /** Returns string representation of file path under src/test/resources/testData project directory */
    public static String getFilePathWithNameAndExtension(String fileName) throws FileNotFoundException {
        Path basePath = Paths.get(".").normalize().toAbsolutePath();
        File[] files = basePath.resolve("src/test/resources/testData")
                .toFile()
                .listFiles((dir, name) -> name.equals(fileName));

        if (files != null && files.length > 0) {
            return files[0].getPath();
        }

        throw new FileNotFoundException("File not found: " + fileName);
    }

    /** Saves screenshot to the root project directory */
    public static File saveScreenshotAs(String name, ImageExtension extension) throws IOException {
        return new File(generatePath(name + "_" + getCurrentUTCDateAndTimeWithSeconds(), extension));
    }

    /** Saves screenshot to the root project directory */
    public static File saveScreenshot(String name) throws IOException {
        return new File(generatePath(name + "_" + getCurrentUTCDateAndTimeWithSeconds(), ImageExtension.PNG));
    }

    private static String generatePath(String name, ImageExtension extension) throws IOException {
        String folderName = getCurrentDate() + "_Screenshots";
        Path folderPath = Paths.get(".").normalize().toAbsolutePath().resolve(folderName);
        if (!Files.exists(folderPath)) {
            Files.createDirectory(folderPath);
        }
        return folderPath.resolve(name + extension.toString()).toString();
    }

    private static String getCurrentDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    private static String getCurrentUTCDateAndTimeWithSeconds() {
        return OffsetDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'_'HH'_'mm'_'ss'Z'").withZone(ZoneOffset.UTC));
    }
}
