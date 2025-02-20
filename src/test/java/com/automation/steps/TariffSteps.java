package com.automation.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class TariffSteps extends BaseSteps{

    @Then("verify user is on tariffs page")
    public void verifyUserIsOnTariffsPage() {
        Assert.assertTrue(tariffPage.verifyUserIsOnTariffPage());
    }

    @And("clicks on check availability")
    public void clicksOnCheckAvailability() {
        tariffPage.clickOnCheckAvailability();
    }

    @And("store the tariff displayed")
    public void storeTheTariffDisplayed() {
        tariffPage.storeTariffValues();
    }

    @When("user clicks book now on tariff page")
    public void userClicksBookNowOnTariffPage() {
        tariffPage.clickBookNow();
    }

}
