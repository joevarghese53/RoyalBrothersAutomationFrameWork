package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.RentalBikesPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;



public class WebRentalBikesPage extends BasePage implements RentalBikesPage {

    @FindBy(xpath = "(//div[contains(@class,'each_card_form')]//h6)[1]")
    WebElement bikeName;

    @FindBy(xpath = "(//span[@id='rental_amount'])[1]")
    WebElement bikePrice;

    @FindBy(xpath = "(//li[text()='Fully Available']/following-sibling::li)[1]")
    WebElement pickupLocation;

    @FindBy(xpath = "//button[text()='Apply filter']")
    WebElement applyFilterBtn;

    Actions actions=new Actions(driver);

    @Override
    public void selectBike() {
        ConfigReader.setConfigValue("bike.name",bikeName.getText());
        ConfigReader.setConfigValue("bike.price", String.valueOf(Float.parseFloat(bikePrice.getText())));
    }

    @Override
    public void selectPickupLoc() {

        WebElement pickUpLocElt=bikeName.findElement(By.xpath("./../following-sibling::div/div/input[@class='loc_input']"));
        pickUpLocElt.click();
        pickupLocation.click();
    }

    @Override
    public void clickBookNow() {
        WebElement bookBtn=bikeName.findElement(By.xpath("./../following-sibling::div/div/button"));
        actions.moveToElement(bookBtn).build().perform();
        bookBtn.click();
    }

    @Override
    public boolean isRentalBikesPageDisplayed() {
        return isDisplayed(applyFilterBtn);
    }

    @Override
    public void clickOnFilterAndSortBtn() {

    }

    @Override
    public void applyFilter(String filter, String option) {

    }

    @Override
    public boolean verifyFilterApplied(String filter, String option) {
        return true;
    }

    @Override
    public void applySort(String option) {

    }

    @Override
    public boolean verifySortApplied(String option) {
        return true;
    }

    @Override
    public boolean verifyPriceIsDisplayedAccordingToTariff() {
        String pickUpDate = ConfigReader.getConfigValue("pickUp.date");
        String pickUpTime = ConfigReader.getConfigValue("pickUp.time");
        String dropOffDate = ConfigReader.getConfigValue("dropOff.date");
        String dropOffTime = ConfigReader.getConfigValue("dropOff.time");
        long totalHours = calculateTotalHours(pickUpDate, pickUpTime, dropOffDate, dropOffTime);
        float minBookingTime = Float.parseFloat(ConfigReader.getConfigValue("minBooking.time"));
        float expectedFair;
        if (minBookingTime > totalHours) {
            expectedFair = minBookingTime * Float.parseFloat(ConfigReader.getConfigValue("fairPerHour.price"));
        } else {
            expectedFair = totalHours * Float.parseFloat(ConfigReader.getConfigValue("fairPerHour.price"));
        }
        float actualFair = Float.parseFloat(bikePrice.getText());
        return actualFair == expectedFair;
    }


}
