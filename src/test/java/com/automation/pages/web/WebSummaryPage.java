package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.SummaryPage;

public class WebSummaryPage extends BasePage implements SummaryPage {
    @Override
    public boolean isSummaryPageDisplayed() {
        return false;
    }

    @Override
    public boolean verifyDetails() {
        return true;
    }
}
