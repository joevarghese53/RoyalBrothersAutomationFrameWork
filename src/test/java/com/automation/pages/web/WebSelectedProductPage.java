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

    @FindBy(xpath = "(//a[contains(@class,'card-information__text')])[1]")
    WebElement firstProdName;

    @FindBy(xpath = "((//a[contains(@class,'card-information__text')])[1]/following-sibling::div[@class='price']//bdi)[1]")
    WebElement firstProdPrice;

    @FindBy(xpath = "(//a[contains(@class,'card-information__text')])[2]")
    WebElement secondProdName;

    @FindBy(xpath = "((//a[contains(@class,'card-information__text')])[2]/following-sibling::div[@class='price']//bdi)[1]")
    WebElement secondProdPrice;

    String productHeadingXpath="//h2[text()='%s']";

    @Override
    public boolean isSelectedProdPageDisplayed(String prod) {
        WebElement prodHeading= driver.findElement(By.xpath(String.format(productHeadingXpath,prod)));
        return isDisplayed(prodHeading);
    }

//    @Override
//    public void clickChooseOptionOfFirstProd() {
//        System.out.println(firstProdPrice.getText());
//        ConfigReader.setConfigValue("first.prod.name",firstProdName.getText());
//        ConfigReader.setConfigValue("first.prod.price", String.valueOf(Float.parseFloat(firstProdPrice.getText().trim().replace("Rs.",""))));
//        WebElement chooseOpt=driver.findElement(By.xpath("(//quick-view-button)[1]"));
//        actions.moveToElement(firstProd).pause(1).click(chooseOpt).build().perform();
//    }

//    @Override
//    public boolean isProductDrawerDisplayed() {
////        WebElement prodDrawer=driver.findElement(By.xpath("//quick-view-drawer/details[@class='menu-opening']//div[contains(@class,'product__info-wrapper')]"));
//        waitUntilVisible(prodDrawer);
//        return isDisplayed(prodDrawer);
//    }



//    @Override
//    public void clickChooseOptionOfSecondProd() {
//        System.out.println(secondProdPrice.getText());
//        ConfigReader.setConfigValue("second.prod.name",secondProdName.getText());
//        ConfigReader.setConfigValue("second.prod.price", String.valueOf(Float.parseFloat(secondProdPrice.getText().trim().replace("Rs.",""))));
//        WebElement chooseOpt=driver.findElement(By.xpath("(//quick-view-button)[2]"));
//        actions.moveToElement(secondProd).pause(1).click(chooseOpt).build().perform();
//    }



    @Override
    public void clickFirstProduct() {
        System.out.println(firstProdPrice.getText());
        ConfigReader.setConfigValue("first.prod.name",firstProdName.getText());
        ConfigReader.setConfigValue("first.prod.price", String.valueOf(Float.parseFloat(firstProdPrice.getText().trim().replace("Rs.",""))));
        WebElement chooseOpt=driver.findElement(By.xpath("(//quick-view-button)[1]"));
        actions.moveToElement(firstProdName).build().perform();
        firstProdName.click();
    }

    @Override
    public void clickSecondProduct() {
        System.out.println(secondProdPrice.getText());
        ConfigReader.setConfigValue("second.prod.name",secondProdName.getText());
        ConfigReader.setConfigValue("second.prod.price", String.valueOf(Float.parseFloat(secondProdPrice.getText().trim().replace("Rs.",""))));
        WebElement chooseOpt=driver.findElement(By.xpath("(//quick-view-button)[2]"));
        actions.moveToElement(secondProdName).build().perform();
        secondProdName.click();
    }



}
