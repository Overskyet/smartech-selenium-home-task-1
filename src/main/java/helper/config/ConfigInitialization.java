package helper.config;

import utils.Files;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Properties;

class ConfigInitialization {

    private static final String STD_PROP_FILE_NAME = "config.properties";
    private final String propertiesFileName;
    private Properties properties;

    ConfigInitialization() {
        this.propertiesFileName = STD_PROP_FILE_NAME;
    }
    ConfigInitialization(String propertiesFileName) {
        this.propertiesFileName = propertiesFileName;
    }

    Properties setupProperties() {
        File file = new File(propertiesFileName);
        properties = new Properties();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            properties.load(reader);
        }  catch (FileNotFoundException e) {
            throw new RuntimeException("Properties file not found: " + propertiesFileName +
                    "\nProperties files present in a root project directory: " + Arrays.toString(Files.listFilesWith(".properties")));
        } catch (SecurityException | IOException e) {
            throw new RuntimeException("Error reading properties file: \n" +
                    e.getMessage() +
                    "\n" + e);
        }
        return properties;
    }
}