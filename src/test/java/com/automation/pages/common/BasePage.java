package com.automation.pages.common;

import com.automation.utils.DriverManager;
import io.appium.java_client.TouchAction;
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

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BasePage {

    protected static WebDriver driver;
    protected WebDriverWait wait;
    public Actions actions;

    public BasePage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        actions = new Actions(driver);
    }

    public boolean isDisplayed(WebElement ele) {
        try {
            setImplicitWait(10);
            return ele.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            setImplicitWait(60);
        }
    }

    public boolean isDisplayed(String xpath, String value) {
        try {
            setImplicitWait(10);
            WebElement ele = driver.findElement(By.xpath(String.format(xpath, value)));
            return ele.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            setImplicitWait(20);
        }
    }

    public boolean isDisplayed(String xpath) {
        try {
            setImplicitWait(3);
            WebElement ele = driver.findElement(By.xpath(xpath));
            return ele.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            setImplicitWait(60);
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
                .addAction(finger1.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((AndroidDriver) driver).perform(Collections.singletonList(sequence));

        pause(1);
    }

    public void clickByOffset(int X, int Y) {
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), X, Y))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((AndroidDriver) driver).perform(Collections.singletonList(sequence));

        pause(1);
    }

    public void scroll() {
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        scroll(width / 2, height / 2 + 600, width, 0);
    }

    public void scroll(WebElement topElement, WebElement bottomElement) {
        int width = bottomElement.getSize().getWidth();
        int height = bottomElement.getSize().getHeight();
        int startX = (bottomElement.getLocation().getX()) + (width / 2);
        int startY = (bottomElement.getLocation().getY()) + (height / 2);
        width = topElement.getSize().getWidth();
        height = topElement.getSize().getHeight();
        int endX = (topElement.getLocation().getX()) + (width / 2);
        int endY = (topElement.getLocation().getY()) + (height / 2);
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger1.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(), endX, endY)).
                addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((AndroidDriver) driver).perform(Collections.singletonList(sequence));
    }

    public void pause(int sec) {
        Actions actions = new Actions(driver);
        actions.pause(Duration.ofSeconds(sec)).build().perform();
    }

    public String getFormattedDate(String expectedFormat, String date, String currentDateFormat) {
        try {
            SimpleDateFormat currentFormatter = new SimpleDateFormat(currentDateFormat);
            Date dateObject = currentFormatter.parse(date);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateObject);

            SimpleDateFormat expectedFormatter = new SimpleDateFormat(expectedFormat);
            return expectedFormatter.format(calendar.getTime());
        } catch (Exception e) {
            throw new RuntimeException("Invalid date format " + expectedFormat);
        }
    }

    public static long calculateTotalHours(String pickUpDate, String pickUpTime, String dropOffDate, String dropOffTime) {
        try {
            String format = "dd MMM yyyy hh:mm a";
            SimpleDateFormat formatter = new SimpleDateFormat(format);

            Date pickUpDateTime = formatter.parse(pickUpDate + " " + pickUpTime);
            Date dropOffDateTime = formatter.parse(dropOffDate + " " + dropOffTime);

            long diffInMillis = dropOffDateTime.getTime() - pickUpDateTime.getTime();
            return TimeUnit.MILLISECONDS.toHours(diffInMillis);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing date/time", e);
        }
    }
}


