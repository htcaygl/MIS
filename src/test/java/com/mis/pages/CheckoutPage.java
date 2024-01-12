package com.mis.pages;

import com.mis.utilities.BrowserUtils;
import com.mis.utilities.ConfigurationReader;
import com.mis.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckoutPage extends BasePage{


    // After checkout success url = 'https://trendyol-whitelabel-test.finbyte.cloud/payment?status=success'
    public static String success_checkout1 = "https://mispay-whitelabel-test.finbyte.cloud/payment?status=success";
    public static String canceled_checkout1 = "https://mispay-whitelabel-test.finbyte.cloud/payment?status=cancelled";

    public CheckoutPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "basic_orderId")
    public WebElement orderId;

    @FindBy(id = "basic_price")
    public WebElement amount;


    @FindBy(xpath = " //span[text()=\"Online\"]")
    public WebElement radioOnline;

    @FindBy(xpath = " //span[text()=\"Offline\"]")
    public WebElement radioOffline;

    @FindBy(xpath = "//div[@class='ant-select-selector']")
    public WebElement merchant;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement checkoutBtn;

    @FindBy(xpath = "//button[text()='Go to Payment']")
    public WebElement goToPaymentBtn;

    @FindBy(xpath = "//button[text()='Go to Home']")
    public WebElement goToHomeBtn;

   //Bank Page
    @FindBy(xpath = "//input[@name='creditCardNumber']")
    public WebElement creditCardInput;

    @FindBy(xpath = "//input[@id='creditMonth']")
    public WebElement creditCardMonth;

    @FindBy(xpath = "//input[@id='creditYear']")
    public WebElement creditCardYear;

    @FindBy(xpath = "//input[@id='cardCvv']")
    public WebElement creditCardCvv;

    @FindBy(xpath = "//input[@value='Pay']")
    public WebElement bankPagePayBtn;

    @FindBy(xpath = "//input[@value='Cancel']")
    public WebElement bankPageCancelBtn;

    @FindBy(xpath = "//input[@id='otp']")
    public WebElement creditCardOtp;

    @FindBy(xpath = "//input[@id='submit-btn']")
    public WebElement bankPageSubmitBtn;

    @FindBy(xpath = "//div[contains(text(),'Your purchase cannot be processed at this time due to')]")
    public WebElement purchaseLimitError;

    @FindBy(xpath = "//div[contains(text(),'Your available budget is insufficient for this transaction.')]")
    public WebElement insufficientLimitError;

    @FindBy(xpath = "//p[contains(text(),'Your credit score is below the required limit for this purchase,')]")
    public WebElement scoreError;

    @FindBy(xpath = "//p[contains(text(),'Your purchase cannot be processed at this time due to exceeding your credit limit.')]")
    public WebElement bnplAmountError;

    @FindBy(xpath = "//p[contains(text(),'purchase limit is insufficient for this transaction.')]")
    public WebElement bnplStatusError;

    @FindBy(xpath = "//p[text()='Return to the Store']")
    public WebElement returnToStoreBtn;


    public void selectMerchant(int num) {

        //num -> 0:dev, 1:test , 2: uat , 9:sandbox, 10:prod

        WebElement merchantEl = null;

//        switch (merchant) {
//
//            //trendyol dev
//            case "Trendyol DEV" :
//                num=0;
//                break;
//
//            //trendyol test
//            case "Trendyol TEST" :
//              num = 1 ;
//              break;
//
//            //trendyol Uat
//              case "Trendyol UAT" :
//              num = 2;
//                break;
//
//        }

        Actions action=new Actions(Driver.get());

        for (int i=0 ; i <num ; i++) {

            action.keyDown(Keys.ARROW_DOWN).build().perform();
        }

        merchantEl= Driver.get().findElement(By.xpath("//input[contains(@aria-activedescendant, 'basic_appId_list_"+num+"')]"));

        merchantEl.sendKeys(Keys.ENTER);
    }


    public void clickBtn(String btn, int merchantNo) {
        switch (btn) {

            case "goToPayment":

                BrowserUtils.waitForClickablility(goToPaymentBtn, 5);

                if(merchantNo == 0) //dev env.
                {
                    goToPaymentBtn.click();
                }
                //merchantNo = 1 test env
                else {

                    goToPaymentBtn.click();

                    BrowserUtils.waitForClickablility(creditCardInput, 10);

                    creditCardInput.click();

                    creditCardInput.sendKeys(ConfigurationReader.get("creditCardNumber"));

                    creditCardMonth.sendKeys(ConfigurationReader.get("creditCardMonth"));

                    creditCardYear.sendKeys(ConfigurationReader.get("creditCardYear"));

                    creditCardCvv.sendKeys(ConfigurationReader.get("creditCardCvv"));

                    bankPagePayBtn.click();

                    BrowserUtils.waitForClickablility(creditCardOtp, 10);

                    creditCardOtp.sendKeys(ConfigurationReader.get("creditCardOtp"));

                    bankPageSubmitBtn.click();

                }

                BrowserUtils.waitFor(2);
                break;

            case "goToHome":

                if(merchantNo == 0 ) {

                    BrowserUtils.waitForClickablility(goToHomeBtn,10);
                    goToHomeBtn.click();
                }
                else {
                    //TODO test env icin bak, bir sey gerekmiyor
                   // goToHomeBtn.click();
                }

                BrowserUtils.waitFor(2);
                break;

            case "returnToStore":

               BrowserUtils.waitForClickablility(returnToStoreBtn,10);
               returnToStoreBtn.click();
               break;

            case "online":

                BrowserUtils.waitForClickablility(radioOnline,10);
                radioOnline.click();
                break;
        }

    }

}
