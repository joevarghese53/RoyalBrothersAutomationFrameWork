package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.interfaces.SummaryPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebSummaryPage extends BasePage implements SummaryPage {

    @FindBy(xpath = "//h5[text()='SUMMARY']")
    WebElement summaryText;

    @FindBy(id = "summary_bike_name")
    WebElement bikeNameTxt;

    @FindBy(id = "vehicle-rental-charges")
    WebElement rent;

    @FindBy(xpath = "//div[not(contains(@class,'mobile-price'))]/div[contains(@class,'coupon_div')]//input[@class='code_field']")
    WebElement couponTextField;

    @FindBy(xpath = "//div[not(contains(@class,'mobile-price'))]/div[contains(@class,'coupon_div')]//button[text()='Apply']")
    WebElement applyCouponBtn;

    @FindBy(xpath = "//div[not(contains(@class,'mobile-price'))]/div[contains(@class,'coupon_div')]//div[@class='applied_coupon']")
    WebElement couponAppliedMessage;

    @FindBy(xpath = "//div[not(contains(@class,'mobile-price'))]/div[contains(@class,'coupon_div')]//div[@class='applied_coupon']//span")
    WebElement couponApplied;

    @Override
    public boolean isSummaryPageDisplayed() {
        return isDisplayed(summaryText);
    }

    @Override
    public boolean verifyDetails() {

        String bikeName=bikeNameTxt.getText();
        String rentValue=rent.getAttribute("data-amount");

        return ConfigReader.getConfigValue("bike.name").equalsIgnoreCase(bikeName) && ConfigReader.getConfigValue("bike.price").equals(rentValue);
    }

    @Override
    public void applyCoupon(String couponCode) {
        couponTextField.sendKeys(ConfigReader.getConfigValue(couponCode));
        applyCouponBtn.click();
    }

    @Override
    public boolean verifyCouponCodeIsApplied(String couponCode) {
        waitUntilVisible(couponApplied);
        waitUntilVisible(couponApplied);
        return isDisplayed(couponAppliedMessage) && couponApplied.getText().equals(ConfigReader.getConfigValue(couponCode));
    }
}
