package com.fundacionjala.pivotalapi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;


public class PropertiesInfo {
    public static final String SETTING_PROPERTIES = "setting.properties";

    private static final Logger LOGGER = Logger.getLogger(PropertiesInfo.class);

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
            LOGGER.error("File nor Found :" + e.getMessage());
        } catch (IOException e) {
            LOGGER.error("File not reading  :" + e.getMessage());
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

}
