package com.automation.pages.ui;

public interface LoginPage {

    boolean isLoginPageDisplayed();

    boolean isErrorDisplayed();

    void enterNumber(String number);
}
