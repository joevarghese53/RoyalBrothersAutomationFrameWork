package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.interfaces.CheckoutPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebCheckoutPage extends BasePage implements CheckoutPage {

    @FindBy(xpath = "//input[@name='reductions']")
    WebElement discountBox;

    @FindBy(xpath = "(//input[@name='reductions']/ancestor::section[1]/../preceding-sibling::div//div[@role='rowgroup'])[2]/div[@role='row']")
    List<WebElement> prodLists;

    @FindBy(xpath = "//span[contains(text(),'Subtotal')]/../following-sibling::div/span")
    WebElement totalPriceElt;

    @Override
    public boolean isCheckoutPageDisplayed() {
        return isDisplayed(discountBox);
    }

    @Override
    public boolean isProductAddedCorrectly(String prod,String price) {
        for(WebElement product:prodLists){
            WebElement prodName=product.findElement(By.xpath("./div/div/p"));
            WebElement prodPrice=product.findElement(By.xpath("./div/div/span[contains(text(),'₹')]"));

            String priceText=prodPrice.getText().replace("₹","");

            if (priceText.contains(",")) {
                priceText = priceText.replace(",", "");
            }
            float price1= Float.parseFloat(priceText.replace("₹",""));

            float price2= Float.parseFloat(ConfigReader.getConfigValue(price));
            if (prodName.getText().equalsIgnoreCase(ConfigReader.getConfigValue(prod)) && price1==price2)
                return true;
        }
        return false;
    }

    @Override
    public boolean isTotalPriceCorrect() {
        float total=0;
        for(WebElement product:prodLists){
            WebElement prodPrice=product.findElement(By.xpath("./div/div/span[contains(text(),'₹')]"));
            String priceText=prodPrice.getText().replace("₹","");
            if (priceText.contains(",")) {
                priceText = priceText.replace(",", "");
            }
            float price= Float.parseFloat(priceText.replace("₹",""));
            total+=price;
        }
        String totalPriceText=totalPriceElt.getText().replace("₹","");
        if (totalPriceText.contains(",")) {
            totalPriceText = totalPriceText.replace(",", "");
        }
        float totalPrice= Float.parseFloat(totalPriceText.replace("₹",""));
        return totalPrice==total;
    }
}
