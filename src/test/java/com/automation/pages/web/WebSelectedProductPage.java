package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.interfaces.SelectedProductPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebSelectedProductPage extends BasePage implements SelectedProductPage {

    @FindBy(xpath = "(//div[@class='card-wrapper'])[1]")
    WebElement firstProd;

    @FindBy(xpath = "(//a[contains(@class,'card-information__text')])[1]")
    WebElement firstProdName;

    @FindBy(xpath = "//quick-view-drawer/details[@class='menu-opening']//div[contains(@class,'product__info-wrapper')]")
    WebElement prodDrawer;

    @FindBy(xpath = "//quick-view-drawer/details[@class='menu-opening']//div[contains(@class,'product__info-wrapper')]//button[text()='Add to cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "((//a[contains(@class,'card-information__text')])[1]/following-sibling::div[@class='price']//bdi)[1]")
    WebElement firstProdPrice;

    @FindBy(xpath = "//button[@name='checkout']")
    WebElement checkoutBtn;

    @FindBy(xpath = "//cart-items//div[@class='product-content']")
    List<WebElement> cartItems;

    @FindBy(xpath = "//cart-drawer//drawer-close-button")
    WebElement cartCloseBtn;

    @FindBy(xpath = "(//div[@class='card-wrapper'])[2]")
    WebElement secondProd;

    @FindBy(xpath = "(//a[contains(@class,'card-information__text')])[2]")
    WebElement secondProdName;

    @FindBy(xpath = "((//a[contains(@class,'card-information__text')])[2]/following-sibling::div[@class='price']//bdi)[1]")
    WebElement secondProdPrice;

    String productHeadingXpath="//h2[text()='%s']";

    String productMinusBtn = "//a[text()='%s']/../following-sibling::div//button[@name='minus']";

    String productName = "//a[text()='%s']";

    @Override
    public boolean isSelectedProdPageDisplayed(String prod) {
        WebElement prodHeading= driver.findElement(By.xpath(String.format(productHeadingXpath,prod)));
        return isDisplayed(prodHeading);
    }

    @Override
    public void clickChooseOptionOfFirstProd() {
        System.out.println(firstProdPrice.getText());
        ConfigReader.setConfigValue("first.prod.name",firstProdName.getText());
        ConfigReader.setConfigValue("first.prod.price", String.valueOf(Float.parseFloat(firstProdPrice.getText().trim().replace("Rs.",""))));
        WebElement chooseOpt=driver.findElement(By.xpath("(//quick-view-button)[1]"));
        actions.moveToElement(firstProd).pause(1).click(chooseOpt).build().perform();
    }

    @Override
    public boolean isProductDrawerDisplayed() {
//        WebElement prodDrawer=driver.findElement(By.xpath("//quick-view-drawer/details[@class='menu-opening']//div[contains(@class,'product__info-wrapper')]"));
        waitUntilVisible(prodDrawer);
        return isDisplayed(prodDrawer);
    }

    @Override
    public void clickAddToCart() {
//        WebElement addToCartBtn= driver.findElement(By.xpath("//button[text()='Add to cart']"));
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
    }

    @Override
    public void clickChooseOptionOfSecondProd() {
        System.out.println(secondProdPrice.getText());
        ConfigReader.setConfigValue("second.prod.name",secondProdName.getText());
        ConfigReader.setConfigValue("second.prod.price", String.valueOf(Float.parseFloat(secondProdPrice.getText().trim().replace("Rs.",""))));
        WebElement chooseOpt=driver.findElement(By.xpath("(//quick-view-button)[2]"));
        actions.moveToElement(secondProd).pause(1).click(chooseOpt).build().perform();
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
