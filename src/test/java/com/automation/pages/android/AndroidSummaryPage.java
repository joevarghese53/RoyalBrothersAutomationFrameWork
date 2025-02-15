package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.SummaryPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidSummaryPage extends BasePage implements SummaryPage {

    @FindBy(xpath = "//android.widget.TextView[@text=\"ADD-ONS\"]/following-sibling::android.view.ViewGroup[2]//com.horcrux.svg.GroupView")
    WebElement closeBtn;

    @FindBy(xpath = "//android.widget.TextView[@text=\"SUMMARY\"]")
    WebElement summaryText;

    @Override
    public boolean isSummaryPageDisplayed() {
        closeBtn.click();
        return isDisplayed(summaryText);
    }

    @Override
    public void verifyDetails() {

    }
}
