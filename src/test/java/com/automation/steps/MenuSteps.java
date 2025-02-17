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
        if (System.getProperty("platform").equals("mobile")) {
            Assert.assertTrue(menuPage.isUserNameDisplayed());
        }
        else{
            Assert.assertTrue(homePage.isUserNameDisplayed());
        }
    }

    @And("user clicks on login button")
    public void UserClicksOnLoginButton() {
        if (System.getProperty("platform").equals("mobile")) {
            menuPage.clickOnLoginButton();
        }
        else{
            homePage.clickOnLoginButton();
        }
    }

    @When("user clicks on logout button")
    public void userClicksOnLogoutButton() {
        menuPage.clickOnLogoutButton();
    }
}
