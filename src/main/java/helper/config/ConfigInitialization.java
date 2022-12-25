package helper.config;

import helper.exception.PageClassNotFoundException;
import utils.Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Properties;

class ConfigInitialization {
    private final String fileName;
    private Properties properties;

    ConfigInitialization(String filename) {
        this.fileName = filename;
    }

    Properties setupProperties() {
        File file = new File(fileName);
        properties = new Properties();
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
            properties.load(reader);
        } catch (SecurityException | IOException e) {
            System.out.println(e.getMessage() + "\n" + e +
                    "\nWas expecting: " + fileName +
                    "\nGot: " + Arrays.toString(Files.listFilesWith(".properties")));
            throw new PageClassNotFoundException(e.getMessage() + "\n" + e +
                    "\nWas expecting: " + fileName +
                    "\nGot: " + Arrays.toString(Files.listFilesWith(".properties")));
        }
        return properties;
    }
}
