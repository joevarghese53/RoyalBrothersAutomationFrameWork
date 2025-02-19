package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HelpAndSupportSteps extends BaseSteps{

    @Then("verify user is on help & support page")
    public void verifyUserIsOnHelpSupportPage() {
        Assert.assertTrue(helpAndSupportPage.isHelpAndSupportPageDisplayed());
    }

    @When("user clicks on chat with us option")
    public void userClicksOnChatWithUsOption() {
        helpAndSupportPage.clickChatWithUsBtn();
    }


}
