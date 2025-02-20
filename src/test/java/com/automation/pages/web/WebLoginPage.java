package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.interfaces.LoginPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WebLoginPage extends BasePage implements LoginPage {

    @FindBy(xpath = "//ul[contains(@class,'login_signup_tabs')]//a[contains(text(),'Login')]")
    WebElement loginTab;

    @FindBy(xpath = "//div[@id='login']//input[@id='phone_no']")
    WebElement phoneNumberBox;

    @FindBy(xpath = "//button[text()='Login with OTP']")
    WebElement otpLoginBtn;

    @FindBy(xpath = "//div[@id='login']//iframe")
    WebElement iframe;

    @FindBy(xpath = "//div[text()='Enter Valid Phone Number']")
    WebElement errorMsg;

    Actions actions=new Actions(driver);
    @Override
    public boolean isLoginPageDisplayed() {
        return isDisplayed(loginTab);
    }

    @Override
    public boolean isErrorDisplayed() {
        return isDisplayed(errorMsg);
    }

    @Override
    public void enterNumber(String number) {
        loginTab.click();
        if(!isValidInteger(number)) {
            phoneNumberBox.sendKeys(ConfigReader.getConfigValue(number));
        }
        else{
            phoneNumberBox.sendKeys(number);
        }

        driver.switchTo().frame(iframe);

        WebElement captcha= driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']"));
        captcha.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='login']//iframe")));
        driver.switchTo().defaultContent();

        waitUntilVisible(otpLoginBtn);

        actions.moveToElement(otpLoginBtn).build().perform();
        otpLoginBtn.click();
    }

    public boolean isValidInteger(String str) {
        System.out.println("inside");
        if (str == null) {
            return false;  // If it's not exactly 10 characters, return false
        }

         try{
            System.out.println("inside2");
            Long.parseLong(str); // Try to parse the string as an integer
            return true;  // If parsing succeeds, it's a valid integer
        } catch (NumberFormatException e) {
            System.out.println("inside3");
            return false;  // If parsing fails, it's not a valid integer
        }
    }
}
