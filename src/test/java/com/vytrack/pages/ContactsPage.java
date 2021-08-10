package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends BasePage{
    @FindBy(css=".input-widget")
    public WebElement pageNumber;

    public ContactsPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    public WebElement getContactEmail(String email){
        String xpath ="//td[@data-column-label='Email' and contains(text(),'"+email+"')]";
        return Driver.get().findElement(By.xpath(xpath));
    }
}