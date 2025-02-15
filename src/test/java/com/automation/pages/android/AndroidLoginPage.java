package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.LoginPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidLoginPage extends BasePage implements LoginPage {

    @FindBy(xpath = "//android.widget.TextView[@text=\"Something Went Wrong, Please Try Again\"]")
    WebElement errorMsg;

    @FindBy(xpath = "//android.widget.TextView[@text=\"GET OTP\"]")
    WebElement getOtpBtn;

    @FindBy(xpath = "//android.widget.EditText[@text=\"Enter Your Phone Number\"]")
    WebElement numberField;

    @Override
    public boolean isErrorDisplayed() {
        return isDisplayed(errorMsg);
    }


    @Override
    public boolean isLoginPageDisplayed() {
        return isDisplayed(getOtpBtn);
    }

    @Override
    public void enterNumber(String number) {
        numberField.sendKeys(ConfigReader.getConfigValue(number));
        getOtpBtn.click();
    }
}
