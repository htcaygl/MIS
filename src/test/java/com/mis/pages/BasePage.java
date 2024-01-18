package com.mis.pages;

import com.mis.utilities.BrowserUtils;
import com.mis.utilities.UsefulMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginBtn;

    @FindBy(xpath = "//button[text()='Register']")
    public WebElement registerButton;

    @FindBy(xpath = "//button[text()='Terms and Conditions']")
    public WebElement termsAndCond;

    //checkout page-> continue button, checkout btn
    // login page ->
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitBtn;

    @FindBy(xpath = "//button[text()='Continue']")
    public WebElement continueBtn;

    @FindBy(xpath = "//button[text()='English']")
    public WebElement englishBtn;

    @FindBy(xpath = "(//button[@type='button'])[1]")
    public WebElement logoutBtn ;


    //Register page, checkout page,login page
    @FindBy(xpath = "//input[@name='phoneNumber']")
    public WebElement phoneNumber;

    @FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement otp;

    @FindBy(xpath = "//button[text()='Close']")
    public WebElement errorCloseBtn;

    @FindBy(xpath = "//div[text()='IAM info does not exist for user.']")
    public WebElement IamInfoError;

    @FindBy(xpath = "//div[text()='IAM status is inactive']")
    public WebElement inactiveError;

    //onceki otp doesnt match hatasi --- TODO
//    @FindBy(xpath = "//div[text()='OTP does not match.']")
//    public WebElement otpError;

    //checkout sayfasinda otp doesn't match hatasi hem de loginde otp doesnot match hatasi
    @FindBy(xpath = "//div[contains(text(),'OTP does not match')]")
    public WebElement otpError;

    // Menu buttons
    @FindBy(xpath = "//p[text()='Dashboard']")
    public WebElement dashboardBtn;

    @FindBy(xpath = "//p[text()='Purchases']")
    public WebElement purchasesBtn;

    @FindBy(xpath = "//p[text()='Payment Plan']")
    public WebElement paymentPlanBtn;

    @FindBy(xpath = "//p[text()='Campaings']")
    public WebElement campaignsBtn;

    //Marketing page
    @FindBy(xpath = "//button[text()='Go to Console']")
    public WebElement marketingPageGoToConsoleBtn;


    public void topMenu(String btn) {
        switch (btn) {
            case "Dashboard":
                BrowserUtils.waitForClickablility(dashboardBtn,2);
                dashboardBtn.click();
                BrowserUtils.waitFor(2);
                break;
            case "Purchases":
                BrowserUtils.waitForClickablility(purchasesBtn,2);
                purchasesBtn.click();
                BrowserUtils.waitFor(2);
                break;
            case "Payment Plan":
                BrowserUtils.waitForVisibility(paymentPlanBtn,2);
                paymentPlanBtn.click();
                BrowserUtils.waitFor(2);
                break;
            case "Campaigns":
                BrowserUtils.waitForVisibility(campaignsBtn,2);
                campaignsBtn.click();
                BrowserUtils.waitFor(2);
                break;
        }

    }


    public void clickBtn(String btn) {
        switch (btn) {
            case "logout":
                BrowserUtils.waitForClickablility(logoutBtn,2);
                logoutBtn.click();
                BrowserUtils.waitFor(2);
                break;
            case "continue":
                BrowserUtils.waitFor(7);
                BrowserUtils.waitForClickablility(continueBtn,50);
                continueBtn.click();
                BrowserUtils.waitFor(2);
                break;
            case "submit":
                BrowserUtils.waitForClickablility(submitBtn,10);
                submitBtn.click();
                BrowserUtils.waitFor(2);
                break;
            case "login":
                BrowserUtils.waitForClickablility(loginBtn,10);
                loginBtn.click();
                BrowserUtils.waitFor(2);
                break;
            case "english":
                BrowserUtils.waitForClickablility(englishBtn,30);
                englishBtn.click();
                BrowserUtils.waitFor(2);
                break;
            case "Go to Console":
                BrowserUtils.waitForClickablility(marketingPageGoToConsoleBtn,30);
                marketingPageGoToConsoleBtn.click();
                BrowserUtils.waitFor(2);
                break;
        }

    }


}
