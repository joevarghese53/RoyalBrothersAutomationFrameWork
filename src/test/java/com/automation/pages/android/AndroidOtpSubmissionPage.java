package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.OtpSubmissionPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidOtpSubmissionPage extends BasePage implements OtpSubmissionPage {

    @FindBy(xpath = "//android.widget.TextView[@text=\"OTP sent to\"]")
    WebElement otpText;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"SUBMIT\"]")
    WebElement submitBtn;

    @FindBy(xpath = "//android.widget.TextView[@text=\"SUBMIT\"]")
    WebElement submitBtnText;

    @Override
    public boolean isOtpPageDisplayed() {
        return isDisplayed(otpText);
    }

    @Override
    public void clickSubmit(){
        waitUntilClickable(submitBtn);
        pause(3);
        submitBtnText.click();
    }
}
