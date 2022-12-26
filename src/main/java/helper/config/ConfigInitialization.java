package helper.config;

import utils.Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Properties;

class ConfigInitialization {
    private final String propertiesFileName;
    private Properties properties;

    ConfigInitialization(String propertiesFileName) {
        this.propertiesFileName = propertiesFileName;
    }

    Properties setupProperties() {
        File file = new File(propertiesFileName);
        properties = new Properties();

        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
            properties.load(reader);
        } catch (SecurityException | IOException e) {
            throw new RuntimeException("Error reading properties file: \n" +
                    e.getMessage() + "\n" + e +
                    "\nWas expecting: " + propertiesFileName +
                    "\nGot: " + Arrays.toString(Files.listFilesWith(".properties")));
        }
        return properties;
    }
}