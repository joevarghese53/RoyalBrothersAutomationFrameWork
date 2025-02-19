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

    @And("user clicks book now")
    public void userClicksBookNow() {
        rentalBikesPage.clickBookNow();
    }

    @When("user clicks the pickup location of the first available bike")
    public void userClicksThePickupLocationOfTheFirstAvailableBike() {
        rentalBikesPage.selectBike();
    }

    @When("user clicks on filter and sort button")
    public void userClicksOnFilterAndSortButton() {
        rentalBikesPage.clickOnFilterAndSortBtn();
    }

    @And("user applies filter {string} with option {string}")
    public void userAppliesFilterWithOption(String filter, String option) {
        rentalBikesPage.applyFilter(filter, option);
    }

    @Then("verify filter {string} is applied with {string}")
    public void verifyFilterIsAppliedWith(String filer, String option) {
        Assert.assertTrue(rentalBikesPage.verifyFilterApplied(filer, option));
    }

    @And("user applies sorting with {string}")
    public void userAppliesSortingWith(String option) {
        rentalBikesPage.applySort(option);
    }

    @Then("verify items are sorted according to {string}")
    public void verifyItemsAreSortedAccordingTo(String option) {
        Assert.assertTrue(rentalBikesPage.verifySortApplied(option));
    }

    @And("verify price is displayed according to tariff")
    public void verifyPriceIsDisplayedAccordingToTariff() {
        Assert.assertTrue(rentalBikesPage.verifyPriceIsDisplayedAccordingToTariff());
    }
}
