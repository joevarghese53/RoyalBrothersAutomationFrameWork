package com.automation.steps;

import com.automation.pages.android.AndroidLoginPage;
import com.automation.pages.ui.LoginPage;
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

    @Then("verify error message is displayed")
    public void verifyErrorMessageIsDisplayed() {
    }

    @When("user clicks on logout btn")
    public void userClicksOnLogoutBtn() {
    }
}
