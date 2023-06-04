package utils;

import helper.enums.ImageExtension;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class FileManagement {
    /** List files under root project directory */
    public static File[] listFilesWith(String extension) {
        return new File(Paths.get(".").normalize().toAbsolutePath().toString()).listFiles((dir, name) -> name.endsWith(extension));
    }

    /** Save screenshot to the root project directory */
    public static File saveScreenshotAs(String name, ImageExtension extension) throws IOException {
        return new File(generatePath(name + "_" + getCurrentUTCDateAndTimeWithSeconds(), extension));
    }

    /** Save screenshot to the root project directory */
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

    private static String split(String path) {
        String newPath = path;
        int lastIndexWin = path.lastIndexOf('\\');
        int lastIndexUnix = path.lastIndexOf('/');

        if (lastIndexWin != -1) {
            newPath = path.substring(0, lastIndexWin);
        } else if (lastIndexUnix != -1) {
            newPath = path.substring(0, lastIndexUnix);
        }
        System.out.println("Save screenshot to: " + newPath);
        return newPath;
    }

    private static String getCurrentDate() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    private static String getCurrentUTCDateAndTimeWithSeconds() {
        return OffsetDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'_'HH'_'mm'_'ss'Z'").withZone(ZoneOffset.UTC));
    }
}
