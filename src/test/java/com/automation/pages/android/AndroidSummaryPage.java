package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.interfaces.SummaryPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidSummaryPage extends BasePage implements SummaryPage {

    @FindBy(xpath = "//android.widget.TextView[@text='ADD-ONS']/following-sibling::android.view.ViewGroup[2]//com.horcrux.svg.GroupView")
    WebElement closeBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='SUMMARY']")
    WebElement summaryText;

    @FindBy(xpath = "//android.widget.TextView[@text='Booking details']/preceding-sibling::android.widget.TextView")
    WebElement bikeName;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='Apply Coupon']/android.view.ViewGroup")
    WebElement applyCouponOption;

    @FindBy(xpath = "//android.widget.EditText[@text='Enter Coupon code']")
    WebElement applyCouponTextField;

    @FindBy(xpath = "(//android.widget.TextView[@text='APPLY'])[1]")
    WebElement applyCouponBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Offers/Coupons']/following-sibling::android.view.ViewGroup[1]/android.widget.TextView")
    WebElement appliedCouponMessage;

    String bikePriceXpath="//android.widget.TextView[@text='Vehicle Rental Charges']/following-sibling::android.widget.TextView";

    @Override
    public boolean isSummaryPageDisplayed() {
        closeBtn.click();
        return isDisplayed(summaryText);
    }

    @Override
    public boolean verifyDetails() {

        String bike=bikeName.getText();

        summaryText.click();
        while(!isDisplayed(bikePriceXpath)){
            scroll();
        }

        WebElement bikePrice= driver.findElement(By.xpath("//android.widget.TextView[@text='Vehicle Rental Charges']/following-sibling::android.widget.TextView"));

        return ConfigReader.getConfigValue("bike.name").equals(bike)
                && ConfigReader.getConfigValue("bike.price").equals(bikePrice.getText());
    }

    @Override
    public void applyCoupon(String couponCode) {
        WebElement topElement = driver.findElement(By.xpath("//android.widget.TextView[@text='SUMMARY']"));
        WebElement bottomElement = driver.findElement(By.xpath("//android.widget.TextView[@text='Excludes :']"));
        scroll(topElement, bottomElement);
        applyCouponOption.click();
        applyCouponTextField.sendKeys(ConfigReader.getConfigValue(couponCode));
        applyCouponBtn.click();
        applyCouponBtn.click();
    }

    @Override
    public boolean verifyCouponCodeIsApplied(String couponCode) {
        return appliedCouponMessage.getText().replace("Applied","").trim().replace("'","").equals(ConfigReader.getConfigValue(couponCode));
    }
}
