package com.automation.steps;

import com.automation.pages.android.*;
import com.automation.pages.ui.*;
import com.automation.pages.web.*;

public class BaseSteps {

    HomePage homePage;
    LoginPage loginPage;
    OtpSubmissionPage otpSubmissionPage;
    RentalBikesPage rentalBikesPage;
    SummaryPage summaryPage;
    MenuPage menuPage;
    ProfilePage profilePage;
    HelpAndSupportPage helpAndSupportPage;
    ChatPage chatPage;
    TariffPage tariffPage;

    public BaseSteps() {
        if (System.getProperty("platform").equals("web")) {
            homePage = new WebHomePage();
            loginPage = new WebLoginPage();
            otpSubmissionPage = new WebOtpSubmissionPage();
            rentalBikesPage = new WebRentalBikesPage();
            summaryPage = new WebSummaryPage();
            profilePage = new WebProfilePage();
            tariffPage = new WebTariffPage();
        } else {
            homePage = new AndroidHomePage();
            loginPage = new AndroidLoginPage();
            otpSubmissionPage = new AndroidOtpSubmissionPage();
            rentalBikesPage = new AndroidRentalBikesPage();
            summaryPage = new AndroidSummaryPage();
            menuPage = new AndroidMenuPage();
            profilePage = new AndroidProfilePage();
            helpAndSupportPage = new AndroidHelpAndSupportPage();
            chatPage = new AndroidChatPage();
            tariffPage = new AndroidTariffsPage();
        }
    }
}
