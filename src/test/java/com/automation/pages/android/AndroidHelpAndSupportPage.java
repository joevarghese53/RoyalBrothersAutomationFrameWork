package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.interfaces.HelpAndSupportPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidHelpAndSupportPage extends BasePage implements HelpAndSupportPage {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Chat With Us']")
    WebElement chatWithUsBtn;

    @Override
    public boolean isHelpAndSupportPageDisplayed() {
        return isDisplayed(chatWithUsBtn);
    }

    @Override
    public void clickChatWithUsBtn() {
        chatWithUsBtn.click();
        chatWithUsBtn.click();
    }
}
