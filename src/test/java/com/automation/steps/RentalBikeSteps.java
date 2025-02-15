package com.automation.steps;

import com.automation.pages.android.AndroidRentalBikesPage;
import com.automation.pages.ui.RentalBikesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class RentalBikeSteps extends BaseSteps {


    @Then("verify the user is on the rental bikes page")
    public void verifyTheUserIsOnTheRentalBikesPage() {
        Assert.assertTrue(rentalBikesPage.isRentalBikesPageDisplayed());
    }

    @And("selects the first available location")
    public void selectsTheFirstAvailableLocation() {
        rentalBikesPage.selectPickupLoc();
    }

    @And("click book now")
    public void clickBookNow() {
        rentalBikesPage.clickBookNow();
    }

    @When("user clicks the pickup location of the first available bike")
    public void userClicksThePickupLocationOfTheFirstAvailableBike() {
        rentalBikesPage.selectBike();
    }
}
