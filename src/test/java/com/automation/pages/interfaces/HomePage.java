package com.automation.pages.interfaces;

public interface HomePage {

    void openApplication();

    void enterLocation(String loc);

    boolean isHomePageDisplayed();

    void enterDateAndTime(String pDate, String pTime, String dDate, String dTime);

    void clickSearch();

    void clickOnMenuIcon();

    void clickOnLocationButton();

    boolean verifyUpdatedLocation();

    void clickOnLoginButton();

    boolean isUserNameDisplayed();

    void clickOnLogoutButton();

    boolean verifyUserIsLoggedOut();

    void clickProfileButton();

    void clickOnTariffsIcon();

    void clickChatBot();

    void navigateToRbStore();
}
