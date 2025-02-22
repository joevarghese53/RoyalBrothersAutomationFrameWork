package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.interfaces.RbProductPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileWriter;
import java.io.IOException;

public class AndroidRbProductPage extends BasePage implements RbProductPage {

    @FindBy(xpath = "//android.view.View[@text=\"Menu\"]")
    WebElement hamburgerMenu;

    @FindBy(xpath = "//android.view.View[@text=\"Cart\"]")
    WebElement cartIcon;

//    @FindBy(xpath = "//android.view.View[@resource-id=\"menu-drawer\"]/android.view.View/android.view.View/android.widget.ListView/android.view.View/android.view.View")
//    WebElement prodOpts;



    @Override
    public boolean isRbProdPageDisplayed() {
        pause(15);
        return isDisplayed(cartIcon);

    }

    @Override
    public void clickProduct(String prod) {
        String prodOptsXpath="//android.view.View[@resource-id=\"menu-drawer\"]/android.view.View/android.view.View/android.widget.ListView/android.view.View/android.view.View";
        hamburgerMenu.click();
        WebElement product;

        System.out.println("xpath:"+isDisplayed(prodOptsXpath+"/android.view.View[@text='%s']",prod.toUpperCase()));
        if(isDisplayed(prodOptsXpath+"/android.view.View[@text='%s']",prod.toUpperCase())){
            prodOptsXpath=prodOptsXpath+String.format("/android.view.View[@text='%s']",prod.toUpperCase());

            product= driver.findElement(By.xpath(prodOptsXpath));
            product.click();

            product=driver.findElement(By.xpath(String.format("//android.widget.TextView[@text=\"%s\"]",prod)));
        } else {
            prodOptsXpath = prodOptsXpath + String.format("/android.widget.TextView[@text='%s']", prod.toUpperCase());
            product = driver.findElement(By.xpath(prodOptsXpath));
        }
        product.click();
    }
}
