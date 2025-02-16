package com.automation.steps;

import com.automation.pages.android.*;
import com.automation.pages.ui.*;
import com.automation.pages.web.WebHomePage;

public class BaseSteps {

    HomePage homePage;
    LoginPage loginPage;
    OtpSubmissionPage otpSubmissionPage;
    RentalBikesPage rentalBikesPage;
    SummaryPage summaryPage;
    MenuPage menuPage;

    public BaseSteps() {
        if (System.getProperty("platform").equals("web")) {
            homePage = new WebHomePage();
        } else {
            homePage = new AndroidHomePage();
            loginPage = new AndroidLoginPage();
            otpSubmissionPage = new AndroidOtpSubmissionPage();
            rentalBikesPage = new AndroidRentalBikesPage();
            summaryPage = new AndroidSummaryPage();
            menuPage = new AndroidMenuPage();
        }
    }
}
