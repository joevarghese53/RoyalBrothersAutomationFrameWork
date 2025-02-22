package com.automation.pages.interfaces;

public interface SelectedProductPage {

    boolean isSelectedProdPageDisplayed(String prod);

//    void clickChooseOptionOfFirstProd();
//
//    boolean isProductDrawerDisplayed();
//
//    void clickChooseOptionOfSecondProd();

//    void clickCheckout();

    void clickFirstProduct();

    void clickSecondProduct();

    void removeProduct(String prod);

    boolean isProductRemoved(String prod);
}
