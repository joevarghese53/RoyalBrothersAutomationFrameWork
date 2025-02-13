package com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties properties;

    public static void initConfig(){
        properties = new Properties();
        try {
            String env = System.getProperty("env", "dev");
            properties.load(new FileInputStream("src/test/resources/config/config.properties"));
            properties.load(new FileInputStream("src/test/resources/config/"+env+"_config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setConfigValue(String key, String value){
        properties.setProperty(key, value);
    }

    public static String getConfigValue(String key){
        return properties.getProperty(key);
    }
}
