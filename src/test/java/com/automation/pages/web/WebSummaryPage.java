package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.SummaryPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileWriter;
import java.io.IOException;

public class WebSummaryPage extends BasePage implements SummaryPage {

    @FindBy(xpath = "//h5[text()='SUMMARY']")
    WebElement summaryText;

    @FindBy(id = "summary_bike_name")
    WebElement bikeNameTxt;

    @FindBy(id = "vehicle-rental-charges")
    WebElement rent;

    @Override
    public boolean isSummaryPageDisplayed() {
        return isDisplayed(summaryText);
    }

    @Override
    public boolean verifyDetails() {

        String bikeName=bikeNameTxt.getText();
        String rentValue=rent.getAttribute("data-amount");

        return ConfigReader.getConfigValue("bike.name").equalsIgnoreCase(bikeName) && ConfigReader.getConfigValue("bike.price").equals(rentValue);
    }
}
