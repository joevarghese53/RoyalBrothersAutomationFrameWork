package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.ChatPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidChatPage extends BasePage implements ChatPage {

    @FindBy(xpath = "//android.widget.ListView[@resource-id=\"chat-container\"]//android.widget.TextView")
    WebElement welcomeBotMsg;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"post-message\"]")
    WebElement yourMsgBox;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"widgetSendButton\"]")
    WebElement sndButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"room__msg_\" and @text=\"Hi\"]")
    WebElement userMsg;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"room__msg_\"]/../following-sibling::android.view.View")
    WebElement botResponse;

    @Override
    public boolean isChatPageDisplayed() {
        return isDisplayed(welcomeBotMsg);
    }

    public void sendMsg(){
        yourMsgBox.sendKeys("Hi");
        sndButton.click();
        sndButton.click();
    }

    public boolean isUserMsgSent(){
        return userMsg.getText().equals("Hi");
    }

    @Override
    public boolean didBotRespondToUser() {
        return isDisplayed(botResponse);
    }
}
