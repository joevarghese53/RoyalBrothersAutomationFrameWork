package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ChatSteps extends BaseSteps{

    @Then("verify the chat window is open")
    public void verifyTheChatWindowIsOpen() {
        Assert.assertTrue(chatPage.isChatPageDisplayed());
    }

    @When("user sends the message")
    public void userSendsTheMessage() {
        chatPage.sendMsg();
    }

    @Then("verify if the message has been sent")
    public void verifyIfTheMessageHasBeenSent() {
        Assert.assertTrue(chatPage.isUserMsgSent());
    }

    @And("verify if the chat bot responded to the message")
    public void verifyIfTheChatBotRespondedToTheMessage() {
        Assert.assertTrue((chatPage.didBotRespondToUser()));
    }
}
