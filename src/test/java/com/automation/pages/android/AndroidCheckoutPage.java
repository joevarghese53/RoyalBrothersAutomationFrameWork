package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.interfaces.CheckoutPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidCheckoutPage extends BasePage implements CheckoutPage {

    @FindBy(xpath = "//android.widget.Button[contains(@text,\"Order summary\")]")
    WebElement orderSummaryText;

    @FindBy(xpath = "//android.widget.GridView[@text=\"Shopping cart\"]/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.widget.TextView")
    List<WebElement> prodLists;

    @FindBy(xpath = "//android.view.View[contains(@text,\"Subtotal\")]/following-sibling::android.view.View")
    WebElement totalPriceElt;

    @Override
    public boolean isCheckoutPageDisplayed() {
        orderSummaryText.click();
        return isDisplayed(orderSummaryText);
    }

    @Override
    public boolean isProductAddedCorrectly(String prod, String price) {
        for(WebElement product:prodLists){
            String priceXpath="//android.widget.TextView[@text=\"%s\"]/../../following-sibling::android.view.View[contains(@text,\"₹\")]";
//            WebElement prodName=product.findElement(By.xpath("."));
            System.out.println("234 "+product.getText());
            WebElement prodPrice=driver.findElement(By.xpath(String.format(priceXpath,product.getText())));
            System.out.println("99"+prodPrice.getText());
            String priceText=prodPrice.getText().replace("₹","");

            if (priceText.contains(",")) {
                priceText = priceText.replace(",", "");
            }
            System.out.println(priceText);
            float price1= Float.parseFloat(priceText.replace("₹",""));
            System.out.println(price1);
            float price2= Float.parseFloat(ConfigReader.getConfigValue(price));
            System.out.println(price2);
            System.out.println(ConfigReader.getConfigValue(prod));
            if (product.getText().equalsIgnoreCase(ConfigReader.getConfigValue(prod)) && price1==price2)
                return true;
        }
        return false;
    }

    @Override
    public boolean isTotalPriceCorrect() {
        float total=0;
        for(WebElement product:prodLists){
            String priceXpath="//android.widget.TextView[@text=\"%s\"]/../../following-sibling::android.view.View[contains(@text,\"₹\")]";
//            WebElement prodName=product.findElement(By.xpath("."));
            System.out.println("234 "+product.getText());
            WebElement prodPrice=driver.findElement(By.xpath(String.format(priceXpath,product.getText())));
//            WebElement prodPrice=product.findElement(By.xpath("./div/div/span[contains(text(),'₹')]"));
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
