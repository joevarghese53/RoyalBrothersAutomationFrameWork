package com.automation.pages.ui;

public interface ProfilePage {
    boolean isProfilePageDisplayed();

    void clickEmailEditIcon();

    void enterEmail(String email);

    boolean isSuccessMessageDisplayed();

    boolean isEmailUpdated(String email);
}
