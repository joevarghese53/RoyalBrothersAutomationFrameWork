package com.automation.pages.ui;

public interface CheckoutPage {
    boolean isCheckoutPageDisplayed();

    boolean isProductAddedCorrectly(String prodName,String prodPrice);

    boolean isTotalPriceCorrect();
}
