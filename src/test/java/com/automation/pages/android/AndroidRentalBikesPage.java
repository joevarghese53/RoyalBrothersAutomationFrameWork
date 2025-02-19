package com.automation.pages.android;

import com.automation.pages.common.BasePage;
import com.automation.pages.ui.RentalBikesPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidRentalBikesPage extends BasePage implements RentalBikesPage {

    @FindBy(xpath = "//android.widget.TextView[@text=\"km limit\"]/..")
    WebElement bikeContainer;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Select Pickup Location\"]")
    WebElement pickupLocElt;

    @FindBy(xpath = "//android.widget.TextView[@text=\"SELECT PICKUP LOCATION\"]/following-sibling::android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[1]")
    WebElement firstPickupLocation;

    @FindBy(xpath = "//android.widget.TextView[@text=\"BOOK NOW\"]")
    WebElement bookNowBtn;

    @FindBy(xpath = "//android.widget.TextView[@text=\"km limit\"]/preceding-sibling::android.widget.TextView")
    WebElement bikeName;

    @FindBy(xpath = "//android.widget.TextView[@text=\"km limit\"]/following-sibling::android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]")
    WebElement bikePrice;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Search by Model\"]/following-sibling::android.view.ViewGroup/com.horcrux.svg.SvgView")
    WebElement filterBtn;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"APPLY\"]/android.view.ViewGroup")
    WebElement applyBtn;

    @FindBy(xpath = "(//android.widget.HorizontalScrollView//android.widget.TextView)[1]")
    WebElement categoryFilter;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Sort By\"]")
    WebElement sortByBtn;

    @FindBy(xpath = "//android.widget.TextView[@text=\"BOOK NOW\"]/preceding-sibling::android.widget.TextView")
    WebElement bikeFair;

    String filterXpath = "//android.widget.TextView[@text='%s']";

    String optionXpath = "//android.widget.TextView[@text='%s']/preceding-sibling::android.view.ViewGroup";
    String modelOptionXpath = "//android.widget.TextView[@text='%s']/../preceding-sibling::android.view.ViewGroup";

    @Override
    public void selectBike() {
        bikeContainer.click();
//        bikeContainer.click();
        ConfigReader.setConfigValue("bike.name", bikeName.getText());
        ConfigReader.setConfigValue("bike.price", bikePrice.getText());
    }

    @Override
    public void selectPickupLoc() {
        pickupLocElt.click();
        pause(3);
        firstPickupLocation.click();
    }

    @Override
    public void clickBookNow() {
        bookNowBtn.click();
    }

    @Override
    public boolean isRentalBikesPageDisplayed() {
        return isDisplayed(bikeContainer);
    }

    @Override
    public void clickOnFilterAndSortBtn() {
        filterBtn.click();
    }

    @Override
    public void applyFilter(String filter, String option) {
        driver.findElement(By.xpath(String.format(filterXpath, filter))).click();
        if (filter.equalsIgnoreCase("Model")) {
            driver.findElement(By.xpath(String.format(modelOptionXpath, option))).click();
        } else {
            driver.findElement(By.xpath(String.format(optionXpath, option))).click();
        }
        applyBtn.click();
    }

    @Override
    public void applySort(String option) {
        sortByBtn.click();
        driver.findElement(By.xpath(String.format(optionXpath, option))).click();
        applyBtn.click();
    }

    @Override
    public boolean verifySortApplied(String option) {
        WebElement topElement = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,\"All prices are\")]"));
        WebElement bottomElement = driver.findElement(By.xpath("//android.widget.TextView[@text=\"km limit\"]"));
        int topX = topElement.getLocation().getX();
        int topY = topElement.getLocation().getY();
        int bottomX = bottomElement.getLocation().getX();
        int bottomY = bottomElement.getLocation().getY();
        int count = 0;
        float price = (option.equalsIgnoreCase("Low to High")) ? Float.MIN_VALUE : Float.MAX_VALUE;
        while (count < 3) {
            scroll(bottomX, bottomY, topX, topY);
            float newPrice = Float.parseFloat(driver.findElement(By.xpath("//android.widget.TextView[@text=\"BOOK NOW\"]/preceding-sibling::android.widget.TextView")).getText().replace("₹", "").trim());
            if (option.equalsIgnoreCase("Low to High")) {
                if (newPrice > price) {
                    price = newPrice;
                } else {
                    return false;
                }
            } else if (option.equalsIgnoreCase("High to Low")) {
                if (newPrice < price) {
                    price = newPrice;
                } else {
                    return false;
                }
            } else {
                System.out.println("wrong sort option");
                return false;
            }
            count++;
        }
        return true;
    }

    @Override
    public boolean verifyPriceIsDisplayedAccordingToTariff() {
        WebElement topElement = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,\"All prices are\")]"));
        WebElement bottomElement = driver.findElement(By.xpath("//android.widget.ImageView"));
        scroll(topElement, bottomElement);

        String pickUpDate = ConfigReader.getConfigValue("pickUp.date");
        String pickUpTime = ConfigReader.getConfigValue("pickUp.time");
        String dropOffDate = ConfigReader.getConfigValue("dropOff.date");
        String dropOffTime = ConfigReader.getConfigValue("dropOff.time");
        long totalHours = calculateTotalHours(pickUpDate, pickUpTime, dropOffDate, dropOffTime);
        float minBookingTime = Float.parseFloat(ConfigReader.getConfigValue("minBooking.time"));
        float expectedFair;
        if (minBookingTime > totalHours) {
            expectedFair = minBookingTime * Float.parseFloat(ConfigReader.getConfigValue("fairPerHour.price"));
        } else {
            expectedFair = totalHours * Float.parseFloat(ConfigReader.getConfigValue("fairPerHour.price"));
        }

        float actualFair = Float.parseFloat(bikeFair.getText().replaceAll("[^0-9.]", ""));
        return actualFair == expectedFair;
    }

    @Override
    public boolean verifyFilterApplied(String filter, String option) {
        if (filter.equalsIgnoreCase("Model")) {
            return bikeName.getText().contains(option);
        } else if (filter.equalsIgnoreCase("Location")) {
            WebElement topElement = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,\"All prices are\")]"));
            WebElement bottomElement = driver.findElement(By.xpath("//android.widget.TextView[@text=\"km limit\"]"));
            scroll(topElement, bottomElement);
            pickupLocElt.click();
            return firstPickupLocation.getText().contains(option);
        } else if (filter.equalsIgnoreCase("Category")) {
            WebElement topElement = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,\"All prices are\")]"));
            WebElement bottomElement = driver.findElement(By.xpath("//android.widget.TextView[@text=\"km limit\"]"));
            scroll(topElement, bottomElement);
            return categoryFilter.getText().equalsIgnoreCase(option);
        } else {
            System.out.println("Invalid Filter");
            return false;
        }
    }

}
