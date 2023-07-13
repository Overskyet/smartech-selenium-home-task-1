package com.overskyet.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ReadYAMLData {
    public static List<Map<String, Object>> getYAMLDataFor(String testMethodName, String dataFileNameWithExtension) {
        return readDataBy(testMethodName, dataFileNameWithExtension);
    }

    private static List<Map<String, Object>> readDataBy(String testMethodName, String dataFileNameWithExtension) {
        Yaml yaml = new Yaml();
        try (FileInputStream fio = new FileInputStream(FileManagement.getFilePathWithNameAndExtension(dataFileNameWithExtension))) {
            Map<String, Object> data = yaml.load(fio);
            if (data.containsKey(testMethodName) && data.get(testMethodName) instanceof ArrayList) {
                return (List<Map<String, Object>>) data.get(testMethodName);
            }
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
        throw new RuntimeException(String.format("Test data for %s is missing or is in incorrect format. Expected test data to be ArrayList.", testMethodName));
    }
}
