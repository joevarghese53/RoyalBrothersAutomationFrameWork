package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.restassured.RestAssured;

public class Hooks {

    @Before("@web or @android")
    public void setUpWebOrAndroid() {
        ConfigReader.initConfig();
        DriverManager.createDriver();
    }

    @Before("@api")
    public void setUpApi() {
        ConfigReader.initConfig();
        RestAssured.baseURI = "https://67bbefd1ed4861e07b389a45.mockapi.io/capstone";
        RestAssured.useRelaxedHTTPSValidation();
    }

    @After("@web or @android")
    public void cleanUp(Scenario scenario) {
//        if (scenario.isFailed()) {
//            scenario.attach(DriverManager.takeScreenshotAsInputStream(), "image/png", "screenshot");
//        }
        scenario.attach(DriverManager.takeScreenshotAsInputStream(), "image/png", "screenshot");
        DriverManager.getDriver().quit();
    }
}

