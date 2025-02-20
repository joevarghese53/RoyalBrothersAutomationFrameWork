package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.RentalBikesPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class WebRentalBikesPage extends BasePage implements RentalBikesPage {

    @FindBy(xpath = "(//div[contains(@class,'each_card_form')]//h6)[1]")
    WebElement bikeName;

    @FindBy(xpath = "(//span[@id='rental_amount'])[1]")
    WebElement bikePrice;

    @FindBy(xpath = "(//span[@id='rental_amount'])")
    List<WebElement> bikePrices;

    @FindBy(xpath = "(//li[text()='Fully Available']/following-sibling::li)[1]")
    WebElement pickupLocation;

    @FindBy(xpath = "//button[text()='Apply filter']")
    WebElement applyFilterBtn;

    @FindBy(xpath = "//input[@placeholder=\"Search Bike Model\"]")
    WebElement modelSearchBox;

    @FindBy(xpath = "//input[@placeholder=\"Search Location\"]")
    WebElement locationSearchBox;

    @FindBy(xpath = "(//input[@value=\"Location\"])[1]")
    WebElement showLocationsBtn;

    @FindBy(xpath = "//li[text()=\"Fully Available\"]/following-sibling::li")
    WebElement availableLocation;

    @FindBy(xpath = "//label[@for=\"price_low_to_high\"]")
    WebElement lowToHighOption;

    @FindBy(xpath = "//label[@for=\"price_high_to_low\"]")
    WebElement highToLowOption;

    String OptionXpath = "//div[not(contains(@class,\"mobile\"))]/ul//label[contains(normalize-space(.), '%s')]";

    Actions actions = new Actions(driver);

    @Override
    public void selectBike() {
        ConfigReader.setConfigValue("bike.name", bikeName.getText());
        ConfigReader.setConfigValue("bike.price", String.valueOf(Float.parseFloat(bikePrice.getText())));
    }

    @Override
    public void selectPickupLoc() {

        WebElement pickUpLocElt = bikeName.findElement(By.xpath("./../following-sibling::div/div/input[@class='loc_input']"));
        pickUpLocElt.click();
        pickupLocation.click();
    }

    @Override
    public void clickBookNow() {
        WebElement bookBtn = bikeName.findElement(By.xpath("./../following-sibling::div/div/button"));
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
        if (filter.equalsIgnoreCase("Model")) {
            modelSearchBox.sendKeys(option);
            driver.findElement(By.xpath(String.format(OptionXpath, option))).click();
            applyFilterBtn.click();
        } else if (filter.equalsIgnoreCase("Location")) {
            locationSearchBox.sendKeys(option);
            driver.findElement(By.xpath(String.format(OptionXpath, option))).click();
            applyFilterBtn.click();
        }

    }

    @Override
    public boolean verifyFilterApplied(String filter, String option) {
        if (filter.equalsIgnoreCase("Model")) {
            return bikeName.getText().contains(option);
        } else if (filter.equalsIgnoreCase("Location")) {
            showLocationsBtn.click();
            waitUntilVisible(availableLocation);
            return availableLocation.getText().contains(option);
        } else {
            System.out.println("wrong option");
            return false;
        }
    }

    @Override
    public void applySort(String option) {
        if (option.equalsIgnoreCase("Low to High")) {
            lowToHighOption.click();
        } else if (option.equalsIgnoreCase("High to Low")) {
            highToLowOption.click();
        }
    }

    @Override
    public boolean verifySortApplied(String option) {
        float prevPrice;
        if (option.equalsIgnoreCase("Low to High")) {
            prevPrice = Float.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                float currPrice = Float.parseFloat(bikePrices.get(i).getText());
                if (currPrice > prevPrice){
                    prevPrice = currPrice;
                } else {
                    return false;
                }
            }
            return true;
        } else if (option.equalsIgnoreCase("High to Low")) {
            prevPrice = Float.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                float currPrice = Float.parseFloat(bikePrices.get(i).getText());
                if (currPrice < prevPrice){
                    prevPrice = currPrice;
                } else {
                    return false;
                }
            }
            return true;
        } else {
            System.out.println("Wrong Option");
            return false;
        }
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
