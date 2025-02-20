package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.interfaces.MenuPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AndroidMenuPage extends BasePage implements MenuPage {

    @FindBy(xpath = "//android.widget.TextView[@text='Log in or Sign up']")
    WebElement loginBtn;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Account Status')]/preceding-sibling::android.widget.TextView")
    WebElement username;

    @FindBy(xpath = "//android.widget.TextView[@text='RB Wallet']")
    WebElement topElement;

    @FindBy(xpath = "//android.widget.TextView[@text='Cancellation Policy']")
    WebElement bottomElement;

    @FindBy(xpath = "//android.widget.TextView[@text='Logout']")
    WebElement logOutBtn;

    @FindBy(xpath = "//android.widget.TextView[@text=' LOGOUT ']")
    WebElement confirmLogOutBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='VIEW PROFILE']")
    WebElement profileBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Help & Support']")
    WebElement helpBtn;

    @Override
    public void clickOnLoginButton() {
        loginBtn.click();
    }

    @Override
    public boolean isUserNameDisplayed() {
        return username.getText().equals(ConfigReader.getConfigValue("profile.username"));
    }

    @Override
    public void clickOnLogoutButton() {
        scroll(topElement, bottomElement);
        logOutBtn.click();
        confirmLogOutBtn.click();
    }

    @Override
    public boolean verifyUserIsLoggedOut() {
        return isDisplayed(loginBtn);
    }

    @Override
    public void clickProfileButton() {
        profileBtn.click();
//        profileBtn.click();
    }

    @Override
    public void clickHelp() {
        helpBtn.click();
    }


}
