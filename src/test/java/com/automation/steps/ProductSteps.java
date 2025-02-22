package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductSteps extends BaseSteps{

    @When("user clicks add to cart")
    public void userClicksAddToCart() {
        productPage.clickAddToCart();
    }

    @Then("verify if the cart drawer is displayed")
    public void verifyIfTheCartDrawerIsDisplayed() {
        Assert.assertTrue(productPage.isCartDrawerDisplayed());
    }

    @When("user closes the cart drawer")
    public void userClosesTheCartDrawer() {
        productPage.closeCart();
    }

    @When("user click checkout button")
    public void userClickCheckoutButton() {
        productPage.clickCheckout();
    }

    @And("verify if the added product {string} is displayed")
    public void verifyIfTheAddedProductIsDisplayed(String prod) {
        Assert.assertTrue((productPage.isAddedProductInCart(prod)));
    }

    @Then("verify if the product {string} page is displayed")
    public void verifyIfTheProductPageIsDisplayed(String prod) {
        Assert.assertTrue(productPage.isProductPageDisplayed(prod));
    }
}
