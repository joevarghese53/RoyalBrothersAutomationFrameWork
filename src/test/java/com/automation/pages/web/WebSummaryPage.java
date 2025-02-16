package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.SummaryPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebSummaryPage extends BasePage implements SummaryPage {

    @FindBy(xpath = "//h5[text()='SUMMARY']")
    WebElement summaryText;

    @FindBy(xpath = "//h5/span[@id='summary_bike_company_name']")
    WebElement bikeCompanyName;

    @FindBy(xpath = "//h5/span[@id='summary_bike_company_name']/following-sibling::span")
    WebElement bikeModelName;

    @FindBy(id = "vehicle-rental-charges")
    WebElement rent;

    @Override
    public boolean isSummaryPageDisplayed() {
        return isDisplayed(summaryText);
    }

    @Override
    public boolean verifyDetails() {
        String bikeName=bikeCompanyName.getText()+" "+bikeModelName.getText();
        String rentValue=rent.getAttribute("data-amount");

        System.out.println(ConfigReader.getConfigValue("bike.name"));
        System.out.println(bikeName);
        System.out.println(ConfigReader.getConfigValue("bike.price"));
        System.out.println(rentValue);
        return ConfigReader.getConfigValue("bike.name").equalsIgnoreCase(bikeName) && ConfigReader.getConfigValue("bike.price").equals(rentValue);
    }
}
