package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps extends BaseSteps {

    @Given("user opens website or application")
    public void userOpensWebsiteOrApplication() {
        homePage.openApplication();
    }

    @When("user enters the location as {string}")
    public void userEntersTheLocationAs(String loc) {
        homePage.enterLocation(loc);
    }

    @Then("verify user is on the home page")
    public void verifyUserIsOnTheHomePage() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @When("user enters pickUp and dropOff date and time as {string}, {string},{string},{string}")
    public void userEntersPickUpAndDropOffDateAndTimeAs(String pDate, String pTime, String dDate, String dTime) {
        homePage.enterDateAndTime(pDate, pTime, dDate, dTime);
    }

    @And("clicks the search button")
    public void clicksTheSearchButton() {
        homePage.clickSearch();
    }

    @When("user navigates to menu page")
    public void userNavigatesToMenuPage() {
        if (System.getProperty("platform").equals("mobile")) {
            homePage.clickOnMenuIcon();
        }
    }

    @When("user selects location button")
    public void userSelectsLocationButton() {
        homePage.clickOnLocationButton();
    }

    @Then("verify location is updated correctly")
    public void verifyLocationIsUpdatedCorrectly() {
        Assert.assertTrue(homePage.verifyUpdatedLocation());
    }

    @When("user clicks the chatbot option")
    public void userClicksTheChatbotOption() {
        homePage.clickChatBot();
    }

    @When("user navigates to RB products page")
    public void userNavigatesToRBProductsPage() {
        homePage.navigateToRbStore();
    }
}
