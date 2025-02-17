package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.SummaryPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileWriter;
import java.io.IOException;

public class AndroidSummaryPage extends BasePage implements SummaryPage {

    @FindBy(xpath = "//android.widget.TextView[@text=\"ADD-ONS\"]/following-sibling::android.view.ViewGroup[2]//com.horcrux.svg.GroupView")
    WebElement closeBtn;

    @FindBy(xpath = "//android.widget.TextView[@text=\"SUMMARY\"]")
    WebElement summaryText;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Booking details\"]/preceding-sibling::android.widget.TextView")
    WebElement bikeName;

    String bikePriceXpath="//android.widget.TextView[@text=\"Vehicle Rental Charges\"]/following-sibling::android.widget.TextView";

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

        WebElement bikePrice= driver.findElement(By.xpath("//android.widget.TextView[@text=\"Vehicle Rental Charges\"]/following-sibling::android.widget.TextView"));

        return ConfigReader.getConfigValue("bike.name").equals(bike)
                && ConfigReader.getConfigValue("bike.price").equals(bikePrice.getText());
    }
}
