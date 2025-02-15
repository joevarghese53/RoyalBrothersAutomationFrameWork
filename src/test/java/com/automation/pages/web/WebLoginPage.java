package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.LoginPage;

public class WebLoginPage extends BasePage implements LoginPage {
    @Override
    public boolean isLoginPageDisplayed() {
        return false;
    }

    @Override
    public boolean isErrorDisplayed() {
        return false;
    }

    @Override
    public void enterNumber(String number) {

    }
}
