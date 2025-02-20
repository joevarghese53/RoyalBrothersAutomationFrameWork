package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CheckoutSteps extends BaseSteps{

    @Then("verify the checkout page is displayed")
    public void verifyTheCheckoutPageIsDisplayed() {
        Assert.assertTrue(checkoutPage.isCheckoutPageDisplayed());
    }

    @And("verify the name {string} and the price {string} of the product")
    public void verifyTheNameAndThePriceOfTheProduct(String prodName, String prodPrice) {
        Assert.assertTrue(checkoutPage.isProductAddedCorrectly(prodName,prodPrice));
    }

    @And("verify if the total price is correct")
    public void verifyIfTheTotalPriceIsCorrect() {
        Assert.assertTrue(checkoutPage.isTotalPriceCorrect());
    }
}
