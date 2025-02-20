package com.automation.pages.interfaces;

public interface LoginPage {

    boolean isLoginPageDisplayed();

    boolean isErrorDisplayed();

    void enterNumber(String number);
}
