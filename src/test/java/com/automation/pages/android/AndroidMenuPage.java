package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.MenuPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidMenuPage extends BasePage implements MenuPage {

    @FindBy(xpath = "//android.widget.TextView[@text=\"Log in or Sign up\"]")
    WebElement loginBtn;

    @Override
    public void clickOnLoginButton() {
        loginBtn.click();
    }

    @Override
    public boolean isUserNameDisplayed() {
        return false;
    }
}
