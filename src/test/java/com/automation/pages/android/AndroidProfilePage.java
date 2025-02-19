package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.ProfilePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidProfilePage extends BasePage implements ProfilePage {

    @FindBy(xpath = "//android.widget.TextView[@text=\"Email Id\"]/following-sibling::android.view.ViewGroup/android.widget.EditText")
    WebElement emailTextBox;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Email Id\"]/following-sibling::android.view.ViewGroup/android.widget.EditText/following-sibling::android.view.ViewGroup")
    WebElement emailEditIcon;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"SAVE\"]")
    WebElement saveBtn;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Email updated successfuly\"]")
    WebElement successMsg;

    @Override
    public boolean isProfilePageDisplayed() {
        return isDisplayed(emailTextBox);
    }

    @Override
    public void clickEmailEditIcon() {
        emailEditIcon.click();
//        emailEditIcon.click();
    }

    @Override
    public void enterEmail(String email) {
        emailTextBox.clear();
        emailTextBox.sendKeys(ConfigReader.getConfigValue(email));
        saveBtn.click();
    }

    @Override
    public boolean isSuccessMessageDisplayed() {
        return isDisplayed(successMsg);
    }

    @Override
    public boolean isEmailUpdated(String email) {
        return emailTextBox.getText().equals(ConfigReader.getConfigValue(email));
    }
}
