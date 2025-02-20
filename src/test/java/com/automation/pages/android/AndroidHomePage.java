package com.automation.pages.android;


import com.automation.pages.common.BasePage;

import com.automation.pages.interfaces.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidHomePage extends BasePage implements HomePage {

    @FindBy(xpath = "(//android.widget.TextView[@text=' Date '])[1]")
    WebElement pickupDateElement;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='M']/preceding-sibling::android.widget.TextView")
    List<WebElement> monthYear;

    @FindBy(xpath = "(//com.horcrux.svg.SvgView)[2]")
    WebElement nextBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='SEARCH']")
    WebElement searchBtn;

    @FindBy(xpath = "//android.widget.EditText[@text='Select city to book your ride']")
    WebElement locationSearchField;

    @FindBy(xpath = "//android.widget.TextView[@text='SKIP']")
    WebElement skipBtn;

    @FindBy(xpath = "//android.view.View[@content-desc='MENU']")
    WebElement menuIcon;

    @FindBy(xpath = "//android.widget.TextView[@text='Book Now, Ride Anywhere']/../../preceding-sibling::android.view.ViewGroup//android.widget.TextView")
    WebElement locationBtn;

    @FindBy(xpath = "//android.view.View[@content-desc='TARIFFS']")
    WebElement tariffIcon;

    String dateXpath="//android.widget.TextView[@text='%s']";
    String timeXpath="//android.widget.TextView[@text='%s']";
    String locationXpath="//android.view.ViewGroup[@content-desc='%s']/android.view.ViewGroup/android.view.ViewGroup";

    @Override
    public void openApplication(){
        skipBtn.click();
//        skipBtn.click();
    }

    @Override
    public void enterLocation(String loc){
        if (loc.equals("booking.city")) {
            locationSearchField.sendKeys(ConfigReader.getConfigValue(loc));
            WebElement location = driver.findElement(By.xpath(String.format(locationXpath, ConfigReader.getConfigValue(loc).toUpperCase())));
            location.click();
//            location.click();
        }else {
            locationSearchField.sendKeys(loc);
            WebElement location = driver.findElement(By.xpath(String.format(locationXpath, loc.toUpperCase())));
            location.click();
//            location.click();
            ConfigReader.setConfigValue("booking.updatedCity", loc);
        }
    }

    @Override
    public boolean isHomePageDisplayed(){
        return pickupDateElement.isDisplayed();
    }

    @Override
    public void enterDateAndTime(String pDate, String pTime, String dDate, String dTime) {
        pickupDateElement.click();
//        pickupDateElement.click();

        setDateAndTime(pDate,pTime);
        setDateAndTime(dDate,dTime);
    }

    public void setDateAndTime(String date,String time){

        while(!monthYear.get(0).getText().contains(ConfigReader.getConfigValue(date).split(" ")[1].trim()) || !monthYear.get(1).getText().trim().equals(ConfigReader.getConfigValue(date).split(" ")[2].trim())){
            nextBtn.click();
        }

        WebElement dateElt=driver.findElement(By.xpath(String.format(dateXpath,ConfigReader.getConfigValue(date).split(" ")[0])));
        dateElt.click();

        setImplicitWait(2);

        while (!isDisplayed(timeXpath, ConfigReader.getConfigValue(time))) {

            WebElement timeTab1 = driver.findElement(By.xpath("(//android.widget.ScrollView//android.widget.TextView)[5]"));
            WebElement timeTab2 = driver.findElement(By.xpath("//android.widget.ScrollView"));
            int x = timeTab1.getLocation().getX();
            int y1 = timeTab1.getLocation().getY();
            int y2=timeTab2.getLocation().getY();
            int width = timeTab1.getSize().getWidth();
            int height = timeTab1.getSize().getHeight();
            scroll(x + width / 2, y1 + height / 2, x + width / 2, y2);
        }

        setImplicitWait(60);
        driver.findElement(By.xpath(String.format(timeXpath,ConfigReader.getConfigValue(time)))).click();
    }

    @Override
    public void clickSearch() {
        searchBtn.click();
    }

    @Override
    public void clickOnMenuIcon() {
        menuIcon.click();
//        menuIcon.click();
    }

    @Override
    public void clickOnLocationButton() {
        locationBtn.click();
    }

    @Override
    public boolean verifyUpdatedLocation() {
        return locationBtn.getText().toUpperCase().equalsIgnoreCase(ConfigReader.getConfigValue("booking.updatedCity"));
    }

    @Override
    public void clickOnLoginButton() {}

    @Override
    public boolean isUserNameDisplayed() {return true;}

    @Override
    public void clickOnLogoutButton() {}

    @Override
    public boolean verifyUserIsLoggedOut() {
        return false;
    }

    @Override
    public void clickProfileButton() {}

    @Override
    public void clickChatBot() {}

    @Override
    public void navigateToRbStore() {

    }

    @Override
    public void clickOnTariffsIcon() {
        tariffIcon.click();
    }

}
