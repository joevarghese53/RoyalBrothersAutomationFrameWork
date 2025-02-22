package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.interfaces.LoginPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidLoginPage extends BasePage implements LoginPage {

    @FindBy(xpath = "//android.widget.TextView[@text='GET OTP']")
    WebElement getOtpBtn;

    @FindBy(xpath = "//android.widget.EditText[@text='Enter Your Phone Number']")
    WebElement numberField;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Please Provide Valid Phone\"]")
    WebElement errorMsg;

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
        if (number.equals("phone.number") || number.equals("phone.deletion.number")){
            numberField.sendKeys(ConfigReader.getConfigValue(number));
        }else {
            numberField.sendKeys(number);
        }
        getOtpBtn.click();
    }

    @Override
    public void signUpWithDetails(String name, String email, String password, String number) {

    }
}
