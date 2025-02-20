package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.RbProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class WebRbProductPage extends BasePage implements RbProductPage {

    @FindBy(id = "cart-icon-bubble")
    WebElement cartIcon;

    @FindBy(xpath = "//div[@class='ecomsend-SpinWheel__Modal__CloseButton _closeBtn_rg2mi_33']")
    WebElement spinPopCloseBtn;

    String productXpath="//dropdown-menu//span[text()='%s']";

    @Override
    public boolean isRbProdPageDisplayed() {
        waitUntilVisible(spinPopCloseBtn);
        pause(1);
        spinPopCloseBtn.click();
        return isDisplayed(cartIcon);
    }

    @Override
    public void clickProduct(String prod) {
        WebElement product=driver.findElement(By.xpath(String.format(productXpath,prod)));
        product.click();
    }


}
