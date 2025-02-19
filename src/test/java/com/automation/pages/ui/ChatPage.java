package com.automation.pages.ui;

public interface ChatPage {

    boolean isChatPageDisplayed();

    void sendMsg();

    boolean isUserMsgSent();

    boolean didBotRespondToUser();
}
