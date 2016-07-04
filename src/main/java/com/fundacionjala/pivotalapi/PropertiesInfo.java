package com.fundacionjala.pivotalapi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class PropertiesInfo {
    public static final String SETTING_PROPERTIES = "setting.properties";
    private static PropertiesInfo instance;

    private Properties properties;

    private PropertiesInfo() {
        loadProperties();
    }

    public static PropertiesInfo getInstance() {
        if (instance == null) {
            instance = new PropertiesInfo();
        }
        return instance;
    }

    private void loadProperties() {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(SETTING_PROPERTIES);
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    private String getProperty(String propertyKey) {
        return properties.getProperty(propertyKey);
    }

    public String getBaseUrl() {
        return getProperty("urlApi");
    }

    public String getToken() {
        return getProperty("token");
    }

    public String getProxy() {
        return getProperty("proxy");
    }

    public String getHeaderToken() {
        return getProperty("headerToken");
    }

    public String getTypeJson() {
        return getProperty("typeJson");
    }

}
