package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.interfaces.SelectedProductPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidSelectedProductPage extends BasePage implements SelectedProductPage {

    @FindBy(xpath = "(//android.widget.TextView[@text=\"CHOOSE OPTIONS\"])[1]/../preceding-sibling::android.view.View/android.widget.TextView")
    WebElement firstProdName;

    @FindBy(xpath = "(//android.widget.TextView[@text=\"CHOOSE OPTIONS\"])[2]/../preceding-sibling::android.view.View/android.widget.TextView")
    WebElement secondProdName;

    @FindBy(xpath = "//quick-view-drawer/details[@class='menu-opening']//div[contains(@class,'product__info-wrapper')]")
    WebElement prodDrawer;

    @FindBy(xpath = "//quick-view-drawer/details[@class='menu-opening']//div[contains(@class,'product__info-wrapper')]//button[text()='Add to cart']")
    WebElement addToCartBtn;

    @FindBy(xpath = "(//android.widget.TextView[@text=\"CHOOSE OPTIONS\"])[1]/../preceding-sibling::android.widget.ListView//android.widget.TextView[2]")
    WebElement firstProdPrice;

    @FindBy(xpath = "(//android.widget.TextView[@text=\"CHOOSE OPTIONS\"])[2]/../preceding-sibling::android.widget.ListView//android.widget.TextView[2]")
    WebElement secondProdPrice;

    String product="//android.widget.TextView[@text=\"%s\"]";
    @Override
    public boolean isSelectedProdPageDisplayed(String prod) {
        return isDisplayed(product,prod);
    }

    @Override
    public void clickFirstProduct() {
        System.out.println(firstProdPrice.getText());
        ConfigReader.setConfigValue("first.prod.name",firstProdName.getText());
        String price;
        if(firstProdPrice.getText().contains(",")){
            price=firstProdPrice.getText().replace(",","");
        }
        else{
            price=firstProdPrice.getText();
        }
        ConfigReader.setConfigValue("first.prod.price", String.valueOf(Float.parseFloat(price.trim().replace("Rs.",""))));
//        WebElement chooseOpt=driver.findElement(By.xpath("(//quick-view-button)[1]"));
        actions.moveToElement(firstProdName).click().build().perform();
    }

    @Override
    public void clickSecondProduct() {
        System.out.println(secondProdPrice.getText());
        ConfigReader.setConfigValue("second.prod.name",secondProdName.getText());
        String price;
        if(secondProdPrice.getText().contains(",")){
            price=secondProdPrice.getText().replace(",","");
        }
        else{
            price=secondProdPrice.getText();
        }
        ConfigReader.setConfigValue("second.prod.price", String.valueOf(Float.parseFloat(price.trim().replace("Rs.",""))));
//        WebElement chooseOpt=driver.findElement(By.xpath("(//quick-view-button)[2]"));
        actions.moveToElement(secondProdName).click().build().perform();
    }
}
