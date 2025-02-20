package com.automation.pages.interfaces;

public interface ChatPage {

    boolean isChatPageDisplayed();

    void sendMsg();

    boolean isUserMsgSent();

    boolean didBotRespondToUser();
}
