package com.automation.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CreateAccountSteps extends BaseSteps{

    @Then("verify user is on create account page")
    public void verifyUserIsOnCreateAccountPage() {
        Assert.assertTrue(createAccountPage.verifyUserIsOnCreateAccountPage());
    }

    @When("user enters name {string} and email {string} and clicks submit")
    public void userEntersNameAndEmailAndClicksSubmit(String name, String email) {
        createAccountPage.enterDetails(name, email);
        createAccountPage.clickSubmit();
    }
}
