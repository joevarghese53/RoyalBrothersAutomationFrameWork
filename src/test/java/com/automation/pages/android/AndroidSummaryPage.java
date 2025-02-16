package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.SummaryPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidSummaryPage extends BasePage implements SummaryPage {

    @FindBy(xpath = "//android.widget.TextView[@text=\"ADD-ONS\"]/following-sibling::android.view.ViewGroup[2]//com.horcrux.svg.GroupView")
    WebElement closeBtn;

    @FindBy(xpath = "//android.widget.TextView[@text=\"SUMMARY\"]")
    WebElement summaryText;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Booking details\"]/preceding-sibling::android.widget.TextView")
    WebElement bikeName;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Vehicle Rental Charges\"]/following-sibling::android.widget.TextView")
    WebElement bikePrice;

    @Override
    public boolean isSummaryPageDisplayed() {
        closeBtn.click();
        return isDisplayed(summaryText);
    }

    @Override
    public boolean verifyDetails() {
        summaryText.click();
        setImplicitWait(5);
        while(!isDisplayed(bikePrice)){
            System.out.println(12345);
            scroll();
        }
        setImplicitWait(60);
        return ConfigReader.getConfigValue("bike.name").equals(bikeName.getText())
                && ConfigReader.getConfigValue("bike.price").equals(bikePrice.getText());
    }
}
