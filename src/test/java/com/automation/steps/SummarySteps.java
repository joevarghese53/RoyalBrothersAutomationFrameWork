package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class SummarySteps extends BaseSteps {

    @Then("verify the summary page is displayed")
    public void verifyTheSummaryPageIsDisplayed() {
        Assert.assertTrue(summaryPage.isSummaryPageDisplayed());
    }

    @And("verify the details displayed")
    public void verifyTheDetailsDisplayed() {
        Assert.assertTrue(summaryPage.verifyDetails());
    }
}
