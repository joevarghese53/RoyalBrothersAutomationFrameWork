package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.interfaces.ProductPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebProductPage extends BasePage implements ProductPage {

    @FindBy(xpath = "//div[@class='shopify-payment-button']/preceding-sibling::button[text()='Add to cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//button[@name='checkout']")
    WebElement checkoutBtn;

    @FindBy(xpath = "//cart-items//div[@class='product-content']")
    List<WebElement> cartItems;

    @FindBy(xpath = "//cart-drawer//drawer-close-button")
    WebElement cartCloseBtn;

    String prodXpath="//h1[contains(text(),'%s')]";
    String productMinusBtn = "//a[text()='%s']/../following-sibling::div//button[@name='minus']";
    String productName = "//a[text()='%s']";

    @Override
    public boolean isProductPageDisplayed(String prod) {
        return isDisplayed(prodXpath,ConfigReader.getConfigValue(prod));
    }

    @Override
    public void clickAddToCart() {
        actions.moveToElement(addToCartBtn).build().perform();
        pause(2);
        addToCartBtn.click();
//        WebElement addToCartBtn= driver.findElement(By.xpath("//button[text()='Add to cart']"));
//        addToCartBtn.click();
    }

    @Override
    public boolean isCartDrawerDisplayed() {
        waitUntilVisible(checkoutBtn);
        System.out.println(checkoutBtn.getText());
        return isDisplayed(checkoutBtn);
    }

    @Override
    public boolean isAddedProductInCart(String prod) {
        for(WebElement item:cartItems){
            System.out.println(item.getText());
            System.out.println(ConfigReader.getConfigValue(prod));
            if(item.getText().equalsIgnoreCase(ConfigReader.getConfigValue(prod))){
                return true;
            }
        }
        return false;
    }

    @Override
    public void closeCart() {
        cartCloseBtn.click();
        driver.navigate().back();
    }

    @Override
    public void clickCheckout() {
        checkoutBtn.click();
    }

    @Override
    public void removeProduct(String prod) {
        driver.findElement(By.xpath(String.format(productMinusBtn,ConfigReader.getConfigValue(prod)))).click();
    }

    @Override
    public boolean isProductRemoved(String prod) {
        pause(3);
        return isDisplayed(productName, ConfigReader.getConfigValue(prod));
    }
}
