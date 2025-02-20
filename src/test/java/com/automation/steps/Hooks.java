package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class Hooks {

    @Before
    public void setUp() {
        ConfigReader.initConfig();
        DriverManager.createDriver();
    }

    @After
    public void cleanUp(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.attach(DriverManager.takeScreenshotAsInputStream(), "image/png", "screenshot");
        }
        scenario.attach(DriverManager.takeScreenshotAsInputStream(), "image/png", "screenshot");
        DriverManager.getDriver().quit();
    }
}

