package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.HomePage;

public class WebHomePage extends BasePage implements HomePage {
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
}
