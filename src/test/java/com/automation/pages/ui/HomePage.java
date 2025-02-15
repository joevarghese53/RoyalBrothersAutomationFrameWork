package com.automation.pages.ui;

public interface HomePage {

    void openApplication();

    void enterLocation(String loc);

    boolean isHomePageDisplayed();

    void enterDateAndTime(String pDate, String pTime, String dDate, String dTime);

    void clickSearch();

    void clickOnMenuIcon();
}
