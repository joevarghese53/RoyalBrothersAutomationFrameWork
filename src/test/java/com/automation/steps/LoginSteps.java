package com.automation.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps extends BaseSteps {


    @Then("verify user is on login page")
    public void verifyUserIsOnLoginPage() {
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }

    @When("user enters the mobile number {string} and clicks get otp")
    public void userEntersTheMobileNumberAndClicksGetOtp(String number) {
        loginPage.enterNumber(number);
    }

    @When("user enters invalid credentials {string}")
    public void userEntersInvalidCredentials(String num) {
        loginPage.enterNumber(num);
    }

    @Then("verify the error message is displayed")
    public void verifyTheErrorMessageIsDisplayed() {
        Assert.assertTrue(loginPage.isErrorDisplayed());
    }

}
