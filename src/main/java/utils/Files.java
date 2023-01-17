package utils;

import helper.enums.ImageExtension;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

public class Files {
    /** List files under root project directory */
    public static File[] listFilesWith(String extension) {
        return new File(Paths.get(".").normalize().toAbsolutePath().toString()).listFiles((dir, name) -> name.endsWith(extension));
    }

    /** Save screenshot to the root project directory */
    public static File saveScreenshotAs(String name, ImageExtension extension) {
        return new File(generatePath(name, extension));
    }

    public static File saveScreenshot() {
        return new File(generatePath(getCurrentDateAndTimeWithSeconds().toString(), ImageExtension.PNG));
    }

    private static String generatePath(String name, ImageExtension extension) {
        return (split(Paths.get(".").normalize().toAbsolutePath().toString())
                + File.separator
                + getCurrentDateAndTimeWithoutSeconds()
                + "_Screenshots"
                + File.separator
                + name
                + extension.toString());
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

    private static OffsetDateTime getCurrentDateAndTimeWithoutSeconds() {
        return OffsetDateTime.now(ZoneOffset.UTC).truncatedTo(ChronoUnit.SECONDS);
    }
    private static OffsetDateTime getCurrentDateAndTimeWithSeconds() {
        return OffsetDateTime.now(ZoneOffset.UTC);
    }
}
