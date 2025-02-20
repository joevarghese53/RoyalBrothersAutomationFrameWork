package com.automation.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class OtpSubmissionSteps extends BaseSteps {


    @Then("verify the otp page is displayed")
    public void verifyTheOtpPageIsDisplayed() {
        Assert.assertTrue(otpSubmissionPage.isOtpPageDisplayed());
    }

    @When("user enters the otp and clicks submit")
    public void userEntersTheOtpAndClicksSubmit() {
        otpSubmissionPage.clickSubmit();
    }

}
