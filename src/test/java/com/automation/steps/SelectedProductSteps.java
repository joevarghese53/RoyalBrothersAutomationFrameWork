package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SelectedProductSteps extends BaseSteps{

    @Then("verify the product {string} store page is displayed")
    public void verifyTheProductStorePageIsDisplayed(String prod) {
        Assert.assertTrue(selectedProductPage.isSelectedProdPageDisplayed(prod));
    }


//    @Then("verify if the product drawer is displayed")
//    public void verifyIfTheProductDrawerIsDisplayed() {
//        Assert.assertTrue(selectedProductPage.isProductDrawerDisplayed());
//    }


    @When("user click the first product")
    public void userClickTheFirstProduct() {
        selectedProductPage.clickFirstProduct();
    }

    @And("user click the second product")
    public void userClickTheSecondProduct() {
        selectedProductPage.clickSecondProduct();
    }


}
