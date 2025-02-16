package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MenuSteps extends BaseSteps{
    @Then("verify user is logged out")
    public void verifyUserIsLoggedOut() {
        Assert.assertTrue(menuPage.verifyUserIsLoggedOut());
    }

    @Then("verify username is displayed in profile section")
    public void verifyUsernameIsDisplayedInProfileSection() {
        Assert.assertTrue(menuPage.isUserNameDisplayed());
    }

    @And("user clicks on login button")
    public void UserClicksOnLoginButton() {
        menuPage.clickOnLoginButton();
    }

    @When("user clicks on logout button")
    public void userClicksOnLogoutButton() {
        menuPage.clickOnLogoutButton();
    }
}
