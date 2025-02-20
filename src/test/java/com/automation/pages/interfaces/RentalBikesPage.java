package com.automation.pages.interfaces;

public interface RentalBikesPage {

    void selectBike();

    void selectPickupLoc();

    void clickBookNow();

    boolean isRentalBikesPageDisplayed();

    void clickOnFilterAndSortBtn();

    void applyFilter(String filter, String option);

    boolean verifyFilterApplied(String filter, String option);

    void applySort(String option);

    boolean verifySortApplied(String option);

    boolean verifyPriceIsDisplayedAccordingToTariff();
}
