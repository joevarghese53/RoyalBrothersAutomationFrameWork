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

    @When("user click choose options of the first product")
    public void userClickChooseOptionsOfTheFirstProduct() {
        selectedProductPage.clickChooseOptionOfFirstProd();
    }

    @Then("verify if the product drawer is displayed")
    public void verifyIfTheProductDrawerIsDisplayed() {
        Assert.assertTrue(selectedProductPage.isProductDrawerDisplayed());
    }

    @When("user clicks add to cart")
    public void userClicksAddToCart() {
        selectedProductPage.clickAddToCart();
    }

    @Then("verify if the cart drawer is displayed")
    public void verifyIfTheCartDrawerIsDisplayed() {
        Assert.assertTrue(selectedProductPage.isCartDrawerDisplayed());
    }

    @When("user closes the cart drawer")
    public void userClosesTheCartDrawer() {
        selectedProductPage.closeCart();
    }

    @And("user click choose options of the second product")
    public void userClickChooseOptionsOfTheSecondProduct() {selectedProductPage.clickChooseOptionOfSecondProd();

    }

    @When("user click checkout button")
    public void userClickCheckoutButton() {
        selectedProductPage.clickCheckout();
    }

    @And("verify if the added product {string} is displayed")
    public void verifyIfTheAddedProductIsDisplayed(String prod) {
        Assert.assertTrue((selectedProductPage.isAddedProductInCart(prod)));
    }
}
