package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebHomePage extends BasePage implements HomePage {

    @FindBy(xpath = "//a[contains(@class,\"current-city\")]")
    WebElement locationBtn;

    @FindBy(xpath = "//a[contains(@class,\"current-city\")]/span")
    WebElement location;

    @Override
    public void openApplication() {
        driver.get("https://www.royalbrothers.com");
    }

    @Override
    public void enterLocation(String loc) {

    }

    @Override
    public boolean isHomePageDisplayed() {
        return false;
    }

    @Override
    public void enterDateAndTime(String pDate, String pTime, String dDate, String dTime) {

    }

    @Override
    public void clickSearch() {

    }

    @Override
    public void clickOnMenuIcon() {

    }

    @Override
    public void clickOnLocationButton() {
        locationBtn.click();
    }

    @Override
    public boolean verifyUpdatedLocation() {
        return location.getText().toUpperCase().equals(ConfigReader.getConfigValue("booking.updatedCity"));
    }
}
