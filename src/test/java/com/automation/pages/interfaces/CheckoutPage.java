package com.automation.pages.interfaces;

public interface CheckoutPage {
    boolean isCheckoutPageDisplayed();

    boolean isProductAddedCorrectly(String prodName,String prodPrice);

    boolean isTotalPriceCorrect();
}
