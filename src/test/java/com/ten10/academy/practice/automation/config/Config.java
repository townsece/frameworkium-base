package com.ten10.academy.practice.automation.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Properties properties;
    private static final String envPref = System.getProperty("env", "test") + ".";

    static {
        properties = initPropertiesFromFile("config");
    }

    private static Properties initPropertiesFromFile(String fileName) {
        Properties tempProperties = new Properties();
        String propsLocation = String.format("properties/%s.properties", fileName);
        InputStream inputStream = null;
        try {
            inputStream = Config.class.getClassLoader().getResourceAsStream(propsLocation);
            tempProperties.load(inputStream);
        } catch (IOException ex) {
            throw new RuntimeException("Couldn't find properties file at location: " + propsLocation, ex);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return  tempProperties;
    }

    public static void setProperty(String key, String value)  {
        properties.setProperty(envPref+key, value);
    }

    public static String getProperty(String s) {
        return properties.getProperty(envPref + s);
    }

    public static String getBaseURL(String s) {
        return getProperty(s + "BaseURL");
    }
}
