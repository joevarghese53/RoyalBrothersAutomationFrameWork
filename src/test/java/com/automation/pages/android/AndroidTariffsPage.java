package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.interfaces.TariffPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidTariffsPage extends BasePage implements TariffPage {

    @FindBy(xpath = "//android.widget.TextView[@text='Bike Rental']")
    WebElement bikeRentalHeading;

    @FindBy(xpath = "//android.widget.TextView[@text='CHECK AVAILABILITY']")
    WebElement checkAvailability;

    @FindBy(xpath = "//android.widget.TextView[@text='km limit']/../../following-sibling::android.view.ViewGroup//com.horcrux.svg.SvgView")
    WebElement expandArrow;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'min booking')]")
    WebElement minBooking;

    @FindBy(xpath = "//android.widget.TextView[@text='BOOK NOW']/preceding-sibling::android.widget.TextView")
    WebElement fairPerHour;

    @FindBy(xpath = "//android.widget.TextView[@text='BOOK NOW']")
    WebElement bookNowBtn;

    @Override
    public boolean verifyUserIsOnTariffPage() {
        return isDisplayed(bikeRentalHeading);
    }

    @Override
    public void clickOnCheckAvailability() {
        checkAvailability.click();
    }

    @Override
    public void storeTariffValues() {
        WebElement topElement = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'All prices are')]"));
        WebElement bottomElement = driver.findElement(By.xpath("//android.widget.ImageView"));
        scroll(topElement, bottomElement);
        expandArrow.click();
        String minBookingTime = minBooking.getText().replaceAll("[^0-9.]", "");
        ConfigReader.setConfigValue("minBooking.time", minBookingTime);
        String fair = fairPerHour.getText().replaceAll("[^0-9.]", "");
        ConfigReader.setConfigValue("fairPerHour.price", fair);
    }

    @Override
    public void clickBookNow() {
        bookNowBtn.click();
    }
}
