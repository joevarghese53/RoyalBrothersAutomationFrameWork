package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.interfaces.TariffPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class WebTariffPage extends BasePage implements TariffPage {

    @FindBy(xpath = "//h1[contains(text(),'tariff')]")
    WebElement tariffPageHeading;

    @FindBy(xpath = "(//small[contains(text(),'Min')])[1]")
    WebElement minBooking;

    @FindBy(xpath = "//span[contains(text(),'Booking Time')]/../following-sibling::div//b")
    WebElement fairPerHour;

    @FindBy(xpath = "//form[@class='home_search_form']//button[text()='Search']")
    WebElement searchBtn;

    @FindBy(xpath = "(//button[text()='Book Now'])[1]")
    WebElement bookNowBtn;


    Actions actions = new Actions(driver);

    @Override
    public boolean verifyUserIsOnTariffPage() {
        return isDisplayed(tariffPageHeading);
    }

    @Override
    public void clickOnCheckAvailability() {
        searchBtn.click();
    }

    @Override
    public void storeTariffValues() {
        String minBookingTime = minBooking.getText().replaceAll("[^0-9]", "");
        String fair = fairPerHour.getText();
        ConfigReader.setConfigValue("minBooking.time", minBookingTime);
        ConfigReader.setConfigValue("fairPerHour.price", fair);
        System.out.println("saved");
        System.out.println(minBookingTime);
        System.out.println(fair);

    }

    @Override
    public void clickBookNow() {
        actions.moveToElement(bookNowBtn).build().perform();
        bookNowBtn.click();
    }
}
