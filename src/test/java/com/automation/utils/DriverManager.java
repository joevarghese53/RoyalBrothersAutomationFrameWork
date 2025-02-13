package com.automation.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class DriverManager {

    static WebDriver driver;

    public static void createDriver() {
        if (System.getProperty("platform").equals("web")){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        else {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("automationName", ConfigReader.getConfigValue("capabilities.automationName"));
            capabilities.setCapability("platformName", ConfigReader.getConfigValue("capabilities.platformName"));
            capabilities.setCapability("deviceName", ConfigReader.getConfigValue("capabilities.deviceName"));
            capabilities.setCapability("appium:app", ConfigReader.getConfigValue("capabilities.appium.app"));
            capabilities.setCapability("appPackage", ConfigReader.getConfigValue("capabilities.appPackage"));
            capabilities.setCapability("appActivity", ConfigReader.getConfigValue("capabilities.appActivity"));
            capabilities.setCapability("chromedriverExecutable", ConfigReader.getConfigValue("capabilities.chromedriverExecutable"));
            capabilities.setCapability("unlockType", ConfigReader.getConfigValue("capabilities.unlockType"));
            capabilities.setCapability("unlockKey", ConfigReader.getConfigValue("capabilities.unlockKey"));
            driver = new AndroidDriver(capabilities);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static String takeScreenshotAsBase64(){
        TakesScreenshot ts = (TakesScreenshot) driver;
        return ts.getScreenshotAs(OutputType.BASE64);
    }

    public static byte[] takeScreenshotAsInputStream(){
        TakesScreenshot ts = (TakesScreenshot) driver;
        return ts.getScreenshotAs(OutputType.BYTES);
    }

    public static void takeScreenshotAsFile(){
        TakesScreenshot ts = (TakesScreenshot) driver;
        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        String SsFolderPath = "Screenshots";
        String SsName = "screenshot";
        try {
            FileUtils.copyFile(screenshot, new File(SsFolderPath + SsName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
