package com.automation.pages.interfaces;

public interface SelectedProductPage {

    boolean isSelectedProdPageDisplayed(String prod);

    void clickChooseOptionOfFirstProd();

    boolean isProductDrawerDisplayed();

    void clickAddToCart();

    boolean isCartDrawerDisplayed();

    boolean isAddedProductInCart(String prod);

    void closeCart();

    void clickChooseOptionOfSecondProd();

    void clickCheckout();

    void removeProduct(String prod);

    boolean isProductRemoved(String prod);
}
