package com.automation.pages.interfaces;

public interface SummaryPage {

    boolean isSummaryPageDisplayed();

    boolean verifyDetails();

    void applyCoupon(String couponCode);

    boolean verifyCouponCodeIsApplied(String couponCode);
}
