package com.automation.pages.interfaces;

public interface CreateAccountPage{
    boolean verifyUserIsOnCreateAccountPage();

    void enterDetails(String name, String email);

    void clickSubmit();
}
