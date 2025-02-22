package com.automation.pages.interfaces;

public interface ProductPage {

    boolean isProductPageDisplayed(String prod);

    void clickAddToCart();

    boolean isCartDrawerDisplayed();

    boolean isAddedProductInCart(String prod);

    void closeCart();

    void clickCheckout();

    void removeProduct(String prod);

    boolean isProductRemoved(String prod);
}
