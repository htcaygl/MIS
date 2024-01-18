package com.mis.pages;

import com.mis.utilities.BrowserUtils;
import com.mis.utilities.ConfigurationReader;
import com.mis.utilities.Driver;
import com.mis.utilities.UsefulMethods;
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

    @FindBy(xpath = "//h1[text()=\"Your Payment has been unsuccessful\"]")
    public WebElement PaymentUnsuccessfullText;

    @FindBy(xpath = "//h2[@class=\"sc-gKPRtg ihmoKO\"]")
    public WebElement availableCredit;

    @FindBy(xpath = "//span[@class=\"sc-grBbyg dRMTqx\"]")
    public WebElement debtAmountOnPaymentInfo;

    @FindBy(xpath = "//input[@id='cancel']")
    public WebElement bankPageCancelBtn;

    @FindBy(xpath = "(//button[text()=\"Pay\"])[1]")
    public WebElement payBtnOnPaymentPlan;

    @FindBy(xpath = "//button[text()=\"Pay with Apple Pay / Credit Card\"]")
    public WebElement payWithApplePayBtn;

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

    public void clickBtn(String btn) {
        switch (btn) {
            case "Pay":
                BrowserUtils.waitForClickablility(payBtnOnPaymentPlan,10);
                payBtnOnPaymentPlan.click();
                BrowserUtils.waitFor(2);
                break;
            case "Pay with Apple Pay":
                BrowserUtils.waitForClickablility(payWithApplePayBtn,15);
                payWithApplePayBtn.click();
                BrowserUtils.waitFor(2);
                break;
            case "Cancel on Bank Page":
                BrowserUtils.waitForClickablility(bankPageCancelBtn,15);
                bankPageCancelBtn.click();
                BrowserUtils.waitFor(2);
                break;
            case "Mispay Logo":
                BrowserUtils.waitForClickablility(MisPayLogo,15);
                MisPayLogo.click();
                BrowserUtils.waitFor(2);
                break;
            default :
                super.clickBtn(btn);
        }




    }

    public double getAvaliableCreditAmount(WebElement element) {


        String elementText= element.getText();

        double splittedAmount = UsefulMethods.SplitAmount(elementText) ;

        return splittedAmount;
    }

    public boolean calculateAvailableCredit(double before, double after, double debt) {

        if (debt == after-before)
            return true;
        else
            return false;
    }



}


