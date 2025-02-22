package com.automation.pages.interfaces;

public interface ProfilePage {
    boolean isProfilePageDisplayed();

    void clickEmailEditIcon();

    void enterEmail(String email);

    boolean isSuccessMessageDisplayed();

    boolean isEmailUpdated(String email);

    void clickOnDeleteAccount();

    boolean verifyAccountDeletedMessageIsDisplayed();
}
