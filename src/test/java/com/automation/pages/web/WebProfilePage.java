package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.ProfilePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WebProfilePage extends BasePage implements ProfilePage {

    @FindBy(className = "user_details_container")
    WebElement userDetailsContainer;

    @FindBy(id = "emailbtn")
    WebElement emailEditIcon;

    @FindBy(id = "email")
    WebElement emailTextBox;

    @FindBy(xpath = "//div[text()='Email Updated Successfully!']")
    WebElement successMsg;

    @FindBy(id = "toast-close")
    WebElement closeError;

    @Override
    public boolean isProfilePageDisplayed() {
        return isDisplayed(userDetailsContainer);
    }

    @Override
    public void clickEmailEditIcon() {
        emailEditIcon.click();
        emailTextBox.clear();
        closeError.click();
        pause(1);
        emailEditIcon.click();
        emailEditIcon.click();
    }

    @Override
    public void enterEmail(String email) {
        emailTextBox.sendKeys(ConfigReader.getConfigValue(email));
        emailEditIcon.click();
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
