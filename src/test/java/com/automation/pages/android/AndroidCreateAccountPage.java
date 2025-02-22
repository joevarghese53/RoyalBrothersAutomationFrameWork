package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.interfaces.CreateAccountPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidCreateAccountPage extends BasePage implements CreateAccountPage {
    @FindBy(xpath = "//android.widget.EditText[@text=\"Enter Your Name As Per Your ID\"]")
    WebElement nameTextField;

    @FindBy(xpath = "//android.widget.EditText[@text=\"Enter Your Email\"]")
    WebElement emailTextField;

    @FindBy(xpath = "//android.widget.TextView[@text=\"SUBMIT\"]")
    WebElement submitBtn;

    @Override
    public boolean verifyUserIsOnCreateAccountPage() {
        return isDisplayed(nameTextField);
    }

    @Override
    public void enterDetails(String name, String email) {
        nameTextField.sendKeys(ConfigReader.getConfigValue(name));
        emailTextField.sendKeys(ConfigReader.getConfigValue(email));
    }

    @Override
    public void clickSubmit() {
        submitBtn.click();
    }
}
