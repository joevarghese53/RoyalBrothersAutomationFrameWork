package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.interfaces.ChatPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebChatPage extends BasePage implements ChatPage {

    @FindBy(id="iframe_widget")
    WebElement iframe;

    @FindBy(xpath = "//li[contains(@class,'bot')][1]//div[contains(@class,'media-heading')]")
    WebElement welcomeBotMsg;

    @FindBy(xpath = "//input")
    WebElement yourMsgBox;

    @FindBy(id = "room__msg_")
    WebElement userMsg;

    @FindBy(xpath = "//div[@id='room__msg_']/ancestor::li/following-sibling::li[contains(@class,'bot')][1]//div[contains(@class,'media-heading')]")
    WebElement botResponse;

    @Override
    public boolean isChatPageDisplayed() {
        driver.switchTo().frame(iframe);
        waitUntilVisible(welcomeBotMsg);
        return isDisplayed(welcomeBotMsg);
    }

    @Override
    public void sendMsg() {
        yourMsgBox.sendKeys("Hi"+ Keys.ENTER);
    }

    @Override
    public boolean isUserMsgSent() {
        waitUntilVisible(userMsg);
        return isDisplayed(userMsg);
    }

    @Override
    public boolean didBotRespondToUser() {
        return isDisplayed(botResponse);
    }
}
