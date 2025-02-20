package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class RbProductSteps extends BaseSteps{


    @Then("verify the RB products page is displayed")
    public void verifyTheRBProductsPageIsDisplayed() {
        Assert.assertTrue(rbProductPage.isRbProdPageDisplayed());
    }

    @When("user selects the product {string}")
    public void userSelectsTheProduct(String prod) {
        rbProductPage.clickProduct(prod);
    }




}
