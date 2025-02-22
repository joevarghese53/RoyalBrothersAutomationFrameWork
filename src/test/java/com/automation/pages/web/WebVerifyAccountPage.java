package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.interfaces.VerifyAccountPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebVerifyAccountPage extends BasePage implements VerifyAccountPage {

    @FindBy(xpath = "//h5[text()=\"Verify account\"]")
    WebElement verifyAccountTitle;

    @Override
    public boolean isAccountVerificationPageDisplayed() {
        return isDisplayed(verifyAccountTitle);
    }


}
