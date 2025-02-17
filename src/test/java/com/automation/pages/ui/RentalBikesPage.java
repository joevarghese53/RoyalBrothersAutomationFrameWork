package com.automation.pages.ui;

public interface RentalBikesPage {

    void selectBike();

    void selectPickupLoc();

    void clickBookNow();

    boolean isRentalBikesPageDisplayed();

    void clickOnFilterAndSortBtn();

    void applyFilter(String filter, String option);
}
