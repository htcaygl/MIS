package com.mis.pages;

import com.mis.utilities.BrowserUtils;
import com.mis.utilities.ConfigurationReader;
import com.mis.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage {

    public DashboardPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//img[@alt='profile image']")
    public WebElement profileIcon;

//    @FindBy(xpath = "//p[text()='+966 000000005']")
//    public WebElement phoneNumber;

//    @FindBy(xpath = "//p[text()='hatice.aygul+05v1@finbyte.com']")
//    public WebElement email;

    @FindBy(xpath = "//nav[@class='sc-csvncw iBbLJi']")
    public WebElement menuOpen;

    @FindBy(xpath = "//img[@alt='MIS Pay']")
    public WebElement MisPayLogo;



    public WebElement phoneNumWebEl(String phone) {

        WebElement phoneNumberEl = null;

        phoneNumberEl= Driver.get().findElement(By.xpath("//p[text()='+966 "+phone+"']"));


        return phoneNumberEl;
    }

    public WebElement emailWebEl(String email) {

        WebElement emailEl = null;

        emailEl= Driver.get().findElement(By.xpath("//p[text()='"+email+"']"));

        return emailEl;
    }

}


