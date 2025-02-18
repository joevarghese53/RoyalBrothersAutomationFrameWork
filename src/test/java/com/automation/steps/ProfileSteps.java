package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProfileSteps extends BaseSteps{

    @Then("verify the profile page is displayed")
    public void verifyTheProfilePageIsDisplayed() {
        Assert.assertTrue(profilePage.isProfilePageDisplayed());
    }

    @When("user clicks on the edit icon of email section")
    public void userClicksOnTheEditIconOfEmailSection() {
        profilePage.clickEmailEditIcon();
    }

    @Then("verify the success message is displayed")
    public void verifyTheSuccessMessageIsDisplayed() {
        Assert.assertTrue(profilePage.isSuccessMessageDisplayed());
    }

    @And("user enters the email address {string} and saves it")
    public void userEntersTheEmailAddressAndSavesIt(String email) {
        profilePage.enterEmail(email);
    }

    @And("verify the email box contains the updated mail address {string}")
    public void verifyTheEmailBoxContainsTheUpdatedMailAddress(String mail) {
        Assert.assertTrue(profilePage.isEmailUpdated(mail));
    }
}
