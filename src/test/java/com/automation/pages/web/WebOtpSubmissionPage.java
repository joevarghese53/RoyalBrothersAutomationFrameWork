package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.OtpSubmissionPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebOtpSubmissionPage extends BasePage implements OtpSubmissionPage {

    @FindBy(xpath = "//button[text()='Verify']")
    WebElement verifyBtn;

    @FindBy(xpath = "//input[@data-gtm-form-interact-field-id='5']")
    WebElement lastOtpInput;

    @Override
    public boolean isOtpPageDisplayed() {
        return isDisplayed(verifyBtn);
    }

    @Override
    public void clickSubmit() {
//        waitUntilVisible(lastOtpInput);
//        verifyBtn.click();
        pause(15);
    }
}
