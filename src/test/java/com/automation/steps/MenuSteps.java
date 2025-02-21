package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MenuSteps extends BaseSteps {
    @Then("verify user is logged out")
    public void verifyUserIsLoggedOut() {
        if (System.getProperty("platform").equals("mobile")) {
            Assert.assertTrue(menuPage.verifyUserIsLoggedOut());
        } else {
            Assert.assertTrue(homePage.verifyUserIsLoggedOut());
        }
    }

    @Then("verify username is displayed in profile section")
    public void verifyUsernameIsDisplayedInProfileSection() {
        if (System.getProperty("platform").equals("mobile")) {
            Assert.assertTrue(menuPage.isUserNameDisplayed());
        } else {
            Assert.assertTrue(homePage.isUserNameDisplayed());
        }
    }

    @When("user clicks on logout button")
    public void userClicksOnLogoutButton() {
        if (System.getProperty("platform").equals("mobile")) {
            menuPage.clickOnLogoutButton();
        } else {
            homePage.clickOnLogoutButton();
        }
    }

    @And("user clicks on view profile button")
    public void userClicksOnViewProfileButton() {
        if (System.getProperty("platform").equals("mobile")) {
            menuPage.clickProfileButton();
        } else {
            homePage.clickProfileButton();
        }
    }

    @And("clicks help & support button")
    public void clicksHelpSupportButton() {
        menuPage.clickHelp();
    }

    @And("user clicks on {string} button")
    public void userClicksOnButton(String option) {
        if (System.getProperty("platform").equals("mobile")) {
            menuPage.clickOnLogInOrSignUpButton();
        } else {
            homePage.clickOnLogInOrSignUpButton(option);
        }
    }
}
