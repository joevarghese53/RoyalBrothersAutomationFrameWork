package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @When("user applies coupon code {string}")
    public void userAppliesCouponCode(String couponCode) {
        summaryPage.applyCoupon(couponCode);
    }

    @Then("verify coupon code {string} is applied")
    public void verifyCouponCodeIsApplied(String couponCode) {
        Assert.assertTrue(summaryPage.verifyCouponCodeIsApplied(couponCode));
    }
}
