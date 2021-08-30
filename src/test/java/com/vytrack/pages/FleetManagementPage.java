package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FleetManagementPage extends BasePage{

    public void clickCar(String model){
        String locator="//td[@data-column-label='Model Name' and text()='"+model+"']";
        waitUntilLoaderScreenDisappear();
       BrowserUtils.waitFor(6);
        WebElement elementCar = Driver.get().findElement(By.xpath(locator));
        BrowserUtils.waitForVisibility(elementCar,15);
        BrowserUtils.waitForClickablility(elementCar,15);
        elementCar.click();
    }
}
