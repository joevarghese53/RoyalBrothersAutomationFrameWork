package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.interfaces.ProfilePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidProfilePage extends BasePage implements ProfilePage {

    @FindBy(xpath = "//android.widget.TextView[@text='Email Id']/following-sibling::android.view.ViewGroup/android.widget.EditText")
    WebElement emailTextBox;

    @FindBy(xpath = "//android.widget.TextView[@text='Email Id']/following-sibling::android.view.ViewGroup/android.widget.EditText/following-sibling::android.view.ViewGroup")
    WebElement emailEditIcon;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='SAVE']")
    WebElement saveBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Email updated successfuly']")
    WebElement successMsg;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Phone Number\"]")
    WebElement topElement;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Upload the document and enjoy our services\"]")
    WebElement bottomElement;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"DELETE ACCOUNT\"]")
    WebElement deleteAccountBtn;

    @FindBy(xpath = "//android.widget.TextView[@text=\"I now have my own vehicle\"]")
    WebElement deletionReason;

    @FindBy(xpath = "//android.widget.TextView[@text=\"DELETE\"]")
    WebElement confirmDelete;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Your account with Royal Brothers has been deleted successfully!\"]")
    WebElement deletionMessage;

    @FindBy(xpath = "//android.widget.TextView[@text=\"DONE\"]")
    WebElement deletionDoneBtn;

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

    @Override
    public void clickOnDeleteAccount() {
        scroll(topElement, bottomElement);
        waitUntilClickable(deleteAccountBtn);
        deleteAccountBtn.click();
        deletionReason.click();
        int height = confirmDelete.getSize().getHeight();
        int width = confirmDelete.getSize().getWidth();
        int X = confirmDelete.getLocation().getX() + (width/2);
        int Y = confirmDelete.getLocation().getY() + height - 10;
        clickByOffset(X, Y);
    }

    @Override
    public boolean verifyAccountDeletedMessageIsDisplayed() {
        boolean check = isDisplayed(deletionMessage);
        deletionDoneBtn.click();
        return check;
    }
}
