package utils;

import helper.enums.ImageExtension;

import java.io.File;
import java.nio.file.Paths;

public class Files {
    /** List files under root project directory */
    public static File[] listFilesWith(String extension) {
        return new File(Paths.get(".").normalize().toAbsolutePath().toString()).listFiles((dir, name) -> name.endsWith(extension));
    }

    /** Save screenshot to the root project directory */
    public static File saveScreenshotAs(String name, ImageExtension extension) {
        return new File(split(Paths.get(".").normalize().toAbsolutePath().toString()) + "/" + name + extension.toString());
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
}
