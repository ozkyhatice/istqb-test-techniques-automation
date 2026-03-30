package com.example.config;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }

    public static String getFullUrl(String path) {
        String baseUrl = prop.getProperty("base.url");
        if (baseUrl == null) {
            throw new IllegalStateException("base.url is missing in config.properties");
        }

        if (!baseUrl.endsWith("/")) {
            baseUrl += "/";
        }

        if (path == null) {
            return baseUrl;
        }

        if (path.startsWith("/")) {
            path = path.substring(1);
        }

        return baseUrl + path;
    }
}
