package com.automation.pages.common;

import com.automation.utils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

public class BasePage {

    protected static WebDriver driver;
    WebDriverWait wait;

    public BasePage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public boolean isDisplayed(WebElement ele) {
        try {
            setImplicitWait(10);
            return ele.isDisplayed();
        } catch (Exception e){
            return false;
        } finally {
            setImplicitWait(60);
        }
    }

    public boolean isDisplayed(String xpath, String value) {
        try {
            setImplicitWait(3);
            WebElement ele = driver.findElement(By.xpath(String.format(xpath, value)));
            return ele.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            setImplicitWait(20);
        }
    }

    public void waitUntilVisible(WebElement ele) {
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public void waitUntilClickable(WebElement elt) {
        wait.until(ExpectedConditions.elementToBeClickable(elt));
    }

    public boolean isEnabled(WebElement elt) {
        try {
            setImplicitWait(10);
            return elt.isEnabled();
        } catch (Exception e) {
            return false;
        } finally {
            setImplicitWait(60);
        }
    }

    public void setImplicitWait(int sec) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
    }

    public void scroll(int startX, int startY, int endX, int endY) {
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger1.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(), endX, endY)).
                addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((AndroidDriver) driver).perform(Collections.singletonList(sequence));
    }

    public void scroll(){
        int width=driver.manage().window().getSize().getWidth();
        int height=driver.manage().window().getSize().getHeight();
        scroll(width/2,height/2,width,0);
    }
    public void pause(int sec) {
        Actions actions = new Actions(driver);
        actions.pause(Duration.ofSeconds(sec)).build().perform();
    }
}
