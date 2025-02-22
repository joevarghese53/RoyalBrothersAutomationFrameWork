package com.automation.pages.interfaces;

public interface LoginPage {

    boolean isLoginPageDisplayed();

    boolean isErrorDisplayed();

    void enterNumber(String number);

    void signUpWithDetails(String name, String email, String password, String number);
}
