package util;

import java.io.File;
import java.nio.file.Paths;

public class Files {
    /** List files under root project directory */
    public static File[] listFilesWith(String extension) {
        return new File(Paths.get(".").normalize().toAbsolutePath().toString()).listFiles((dir, name) -> name.endsWith(extension));
    }
}
