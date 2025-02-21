package com.automation.pages.interfaces;

public interface MenuPage {

    void clickOnLogInOrSignUpButton();

    boolean isUserNameDisplayed();

    void clickOnLogoutButton();

    boolean verifyUserIsLoggedOut();

    void clickProfileButton();

    void clickHelp();

}
