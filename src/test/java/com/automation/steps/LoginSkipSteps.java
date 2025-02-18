package com.automation.steps;

import com.automation.pages.android.AndroidLoginPage;
import com.automation.pages.ui.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSkipSteps extends BaseSteps {


    @When("user enters invalid credentials {string}")
    public void userEntersInvalidCredentials(String num) {
        loginPage.enterNumber(num);
    }

    @Then("verify the error message is displayed")
    public void verifyTheErrorMessageIsDisplayed() {
        Assert.assertTrue(loginPage.isErrorDisplayed());
    }

}
