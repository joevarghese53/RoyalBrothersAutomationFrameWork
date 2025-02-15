package com.automation.steps;

import com.automation.pages.android.AndroidOtpSubmissionPage;
import com.automation.pages.ui.OtpSubmissionPage;
import io.cucumber.java.en.And;
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
