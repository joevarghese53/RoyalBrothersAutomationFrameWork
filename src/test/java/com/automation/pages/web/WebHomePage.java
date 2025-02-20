package com.automation.pages.web;

import com.automation.pages.common.BasePage;
import com.automation.pages.interfaces.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class WebHomePage extends BasePage implements HomePage {

    @FindBy(id = "autocomplete-input")
    WebElement locationSearchField;

    @FindBy(id = "pickup-date-desk")
    WebElement pickupDateElement;

    String locationXpath="//p[text()=' %s']";

    @FindBy(xpath = "//a[contains(@class,'current-city')]")
    WebElement locationBtn;

    @FindBy(xpath = "//a[contains(@class,'current-city')]/span")
    WebElement location;

    @FindBy(xpath = "//div[@aria-hidden='false']//div[@class='picker__month']")
    WebElement pickUpMonth;

    @FindBy(xpath = "//div[@aria-hidden='false']//div[@class='picker__year']")
    WebElement pickUpYear;

    @FindBy(xpath = "//div[@aria-hidden='false']//div[@class='picker__nav--next']")
    WebElement nextBtn;

    @FindBy(xpath = "//div[contains(@class,'booking-card-tablet')]//button[text()='Search']")
    WebElement searchBtn;

    @FindBy(xpath = "//a[text()='Login']")
    WebElement loginBtn;

    @FindBy(xpath = "//img[@alt='User Profile']/following-sibling::p")
    WebElement userName;

    @FindBy(xpath = "//ul[@id='nav-mobile']//a[text()='Tariff']")
    WebElement tariffIcon;



//    @FindBy(xpath = "//li[@class='logout-button']")
//    WebElement logoutBtn;
    @FindBy(id = "widget-open")
    WebElement chatBotBtn;

    String dateXpath="//div[@aria-hidden='false']//td/div[text()='%s']";
    String timeXpath="//div[@aria-hidden='false']//li[text()='%s']";

    Actions actions = new Actions(driver);

    @Override
    public void openApplication() {
        driver.get("https://www.royalbrothers.com");
    }

    @Override
    public void enterLocation(String loc) {
        WebElement location2;
        if(loc.equals("booking.city")) {
            locationSearchField.sendKeys(ConfigReader.getConfigValue(loc));
            location2=driver.findElement(By.xpath(String.format(locationXpath,ConfigReader.getConfigValue(loc))));
        }
        else{
            locationSearchField.sendKeys(loc);
            location2=driver.findElement(By.xpath(String.format(locationXpath,loc)));
        }
        ConfigReader.setConfigValue("booking.updatedCity",location2.getText());
        location2.click();
    }

    @Override
    public boolean isHomePageDisplayed() {
        return isDisplayed(pickupDateElement);
    }

    @Override
    public void enterDateAndTime(String pDate, String pTime, String dDate, String dTime) {
        if (isDisplayed(searchBtn)) {
            actions.moveToElement(searchBtn).perform();
        }
        pickupDateElement.click();

        setDateAndTime(pDate, pTime);
        pause(1);
        setDateAndTime(dDate, dTime);
    }

    public void setDateAndTime(String date,String time){
        while(!pickUpMonth.getText().contains(ConfigReader.getConfigValue(date).split(" ")[1].trim()) || !pickUpYear.getText().trim().equals(ConfigReader.getConfigValue(date).split(" ")[2].trim())){
            nextBtn.click();
        }

        WebElement dateElt=driver.findElement(By.xpath(String.format(dateXpath,ConfigReader.getConfigValue(date).split(" ")[0])));
        dateElt.click();

        String timeConfig;
        if(ConfigReader.getConfigValue(time).charAt(0)=='0') {
            timeConfig =ConfigReader.getConfigValue(time).replaceFirst("0","");
        }
        else {
            timeConfig =ConfigReader.getConfigValue(time);
        }


        actions.moveToElement(driver.findElement(By.xpath(String.format(timeXpath,timeConfig)))).perform();
        driver.findElement(By.xpath(String.format(timeXpath,timeConfig))).click();
    }

    @Override
    public void clickSearch() {
        searchBtn.click();
    }

    @Override
    public void clickOnMenuIcon() {}

    @Override
    public void clickOnLocationButton() {
        pause(1);
        locationBtn.click();
    }

    @Override
    public boolean verifyUpdatedLocation() {
        return location.getText().equals(ConfigReader.getConfigValue("booking.updatedCity"));
    }

    @Override
    public void clickOnLoginButton() {
        loginBtn.click();
    }

    @Override
    public boolean isUserNameDisplayed() {
        return userName.getText().equals(ConfigReader.getConfigValue("web.profile.username"));
    }

    @Override
    public void clickOnLogoutButton() {
        actions.moveToElement(userName).build().perform();
        pause(2);
        WebElement logoutBtn=driver.findElement(By.xpath("//li[@class='logout-button']"));
        actions.moveToElement(logoutBtn).pause(1).click().build().perform();
    }

    @Override
    public boolean verifyUserIsLoggedOut() {
        return isDisplayed(loginBtn);
    }

    @Override
    public void clickProfileButton() {
        actions.moveToElement(userName).build().perform();
        pause(2);
        WebElement userProfileBtn=driver.findElement(By.xpath("//li[@class='user-profile-button']"));
        actions.moveToElement(userProfileBtn).pause(1).click().build().perform();
    }

    @Override
    public void clickOnTariffsIcon() {
        tariffIcon.click();
    }

    @Override
    public void clickChatBot() {
        chatBotBtn.click();
    }
}
