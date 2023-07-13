package com.overskyet.dataProviders;

import com.overskyet.utils.ReadYAMLData;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public final class DataProviders {
    @DataProvider(name = "ymlTestData")
    public static Object[][] getYAMLTestData(Method method) {
        List<Map<String, Object>> rawData = ReadYAMLData.getYAMLDataFor(method.getName(), "TestData.yml");
        Object[][] data = new Object[rawData.size()][1];

        for (int x = 0; x < rawData.size(); x++) {
            Map<String, Object> testData = rawData.get(x);
            data[x][0] = testData;
        }

        return data;
    }
}
