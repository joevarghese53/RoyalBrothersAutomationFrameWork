package com.automation.pages.ui;

public interface MenuPage {

    void clickOnLoginButton();

    boolean isUserNameDisplayed();

    void clickOnLogoutButton();

    boolean verifyUserIsLoggedOut();

    void clickProfileButton();

    void clickHelp();
}
