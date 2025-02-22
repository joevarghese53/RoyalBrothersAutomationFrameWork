package com.automation.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;

public class VerifyAccountSteps extends BaseSteps{
    @Then("verify the account verification page is displayed")
    public void verifyTheAccountVerificationPageIsDisplayed() {
        Assert.assertTrue(verifyAccountPage.isAccountVerificationPageDisplayed());
    }
}
