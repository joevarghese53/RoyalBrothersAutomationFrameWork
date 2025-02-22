package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.interfaces.ProductPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidProductPage extends BasePage implements ProductPage {

    @FindBy(xpath = "//android.widget.Button[@text=\"ADD TO CART\"]")
    WebElement addToCartBtn;

    @FindBy(xpath = "//android.widget.Button[contains(@text,\"CHECK OUT\")]")
    WebElement checkoutBtn;

    @FindBy(xpath = "//android.view.View[@resource-id=\"main-cart-items\"]/android.widget.ListView//android.view.View[3]//android.widget.TextView")
    List<WebElement> cartItems;

    @FindBy(xpath = "//android.view.View[@resource-id=\"cart\"]/android.widget.TextView[1]")
    WebElement cartCloseBtn;

    String prodXpath="//android.widget.TextView[@text=\"%s\"]";
    @Override
    public boolean isProductPageDisplayed(String prod) {
        return isDisplayed(prodXpath, ConfigReader.getConfigValue(prod));
    }

    @Override
    public void clickAddToCart() {
        while (!isDisplayed(addToCartBtn)){
            scroll();
        }
        addToCartBtn.click();
    }

    @Override
    public boolean isCartDrawerDisplayed() {
        waitUntilVisible(checkoutBtn);
        System.out.println(checkoutBtn.getText());
        return isDisplayed(checkoutBtn);
    }

    @Override
    public boolean isAddedProductInCart(String prod) {
        System.out.println(isDisplayed(cartItems.get(0)));
        for(WebElement item:cartItems){
            System.out.println("1212"+item.getText());
            System.out.println("5645"+ConfigReader.getConfigValue(prod));
            if(item.getText().equalsIgnoreCase(ConfigReader.getConfigValue(prod))){
                System.out.println(54656);
                return true;
            }
        }
        return false;
    }

    @Override
    public void closeCart() {
        cartCloseBtn.click();
        scroll(driver.manage().window().getSize().getWidth()/2,driver.manage().window().getSize().getHeight()/2,driver.manage().window().getSize().getWidth()/2,driver.manage().window().getSize().getHeight()/2+30);
    }

    @Override
    public void clickCheckout() {
        checkoutBtn.click();
    }
}
