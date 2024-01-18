package com.mis.step_definitions;

import com.mis.pages.CheckoutPage;
import com.mis.pages.DashboardPage;
import com.mis.pages.LoginPage;
import com.mis.utilities.BrowserUtils;
import com.mis.utilities.ConfigurationReader;
import com.mis.utilities.Driver;
import com.mis.utilities.UsefulMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.util.Random;

public class CheckoutStepDefs {


    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        String url= ConfigurationReader.get("url_checkout");
        Driver.get().get(url);
    }

    @When("user select {int} orderId and {string}")
    public void userSelectMerchantEnterOrderIdAndAmount(int merchantNo, String amount) {

        CheckoutPage checkoutPage=new CheckoutPage();
        BrowserUtils.waitForClickablility(checkoutPage.merchant, 4);

        checkoutPage.merchant.click();

        checkoutPage.selectMerchant(merchantNo);

        BrowserUtils.waitForClickablility(checkoutPage.orderId, 4);

     //   checkoutPage.orderId.sendKeys(phone+"-"+UsefulMethods.getDayAndMonth());

        checkoutPage.orderId.sendKeys(UsefulMethods.getDayAndMonth());

        checkoutPage.amount.sendKeys(amount);

        checkoutPage.checkoutBtn.click();


        if (merchantNo == 9 || merchantNo == 10 )
        {
            BrowserUtils.waitFor(25);
        }
        else {
            BrowserUtils.waitFor(10);

        }
    }

    @And("user enter {string} for {int}")
    public void userEnter(String phoneNumber, int merchantNo) {

        CheckoutPage checkoutPage = new CheckoutPage();

//        if (merchantNo == 9 || merchantNo == 10 )
//        {
//            BrowserUtils.waitFor(20);
//        }
//        else {
//            BrowserUtils.waitFor(15);
//
//        }


        BrowserUtils.waitForClickablility(checkoutPage.phoneNumber, 10);

        checkoutPage.phoneNumber.click();
        checkoutPage.phoneNumber.sendKeys(phoneNumber);
        checkoutPage.submitBtn.click();


    }

    @Then("user see {string} url")
    public void userSeeUrl(String status) {

      //  CheckoutPage checkoutPage = new CheckoutPage();

        switch (status) {
            case "success":
                Assert.assertEquals(Driver.get().getCurrentUrl(),ConfigurationReader.get("success_checkout"));
                break;
            case "cancel":
                Assert.assertEquals(Driver.get().getCurrentUrl(),ConfigurationReader.get("cancel_checkout"));
                break;

        }

    }

    @And("user tap {string} button for {int} on Checkout Page")
    public void userTapButtonOnCheckoutPage(String button, int merchantNo) {

        CheckoutPage checkoutPage = new CheckoutPage();

        BrowserUtils.waitFor(2);

        checkoutPage.clickBtn(button, merchantNo);

        BrowserUtils.waitFor(2);

        //TODO
        //  Assert.assertTrue(Driver.get().getCurrentUrl().contains("https://[securepayments.alrajhibank.com.sa/pg/paymentpage"));

    }

    @And("user enter card information {int}")
    public void userEnterCardInfo(int merchantNo) {


        //merchantNo = 3 test env
        if(merchantNo == 3) {

            CheckoutPage checkoutPage = new CheckoutPage();

            BrowserUtils.waitFor(2);

            BrowserUtils.waitForClickablility(checkoutPage.creditCardInput, 10);

            checkoutPage.creditCardInput.click();

            checkoutPage.creditCardInput.sendKeys(ConfigurationReader.get("creditCardNumber"));

            checkoutPage.creditCardMonth.sendKeys(ConfigurationReader.get("creditCardMonth"));

            checkoutPage.creditCardYear.sendKeys(ConfigurationReader.get("creditCardYear"));

            checkoutPage.creditCardCvv.sendKeys(ConfigurationReader.get("creditCardCvv"));

            checkoutPage.bankPagePayBtn.click();

            BrowserUtils.waitForClickablility(checkoutPage.creditCardOtp, 10);

            checkoutPage.creditCardOtp.sendKeys(ConfigurationReader.get("creditCardOtp"));

            checkoutPage.bankPageSubmitBtn.click();
        }

        BrowserUtils.waitFor(2);


        //TODO
        //  Assert.assertTrue(Driver.get().getCurrentUrl().contains("https://[securepayments.alrajhibank.com.sa/pg/paymentpage"));

    }


    @Then("user should see {string} error and click close button on Checkout Page")
    public void userShouldSeeError(String error) {

        CheckoutPage checkoutPage = new CheckoutPage();

        switch (error) {
            case "purchase limit error":
                BrowserUtils.waitForVisibility(checkoutPage.purchaseLimitError,5);
                Assert.assertTrue(checkoutPage.purchaseLimitError.isDisplayed());
                checkoutPage.errorCloseBtn.click();
                break;
            case "insufficient limit error":
                BrowserUtils.waitForVisibility(checkoutPage.insufficientLimitError, 5);
                Assert.assertTrue(checkoutPage.insufficientLimitError.isDisplayed());
                break;
            case "score error":
                BrowserUtils.waitForVisibility(checkoutPage.scoreError, 30);
                Assert.assertTrue(checkoutPage.scoreError.isDisplayed());
                break;
            case "bnplAmount error":
                BrowserUtils.waitForVisibility(checkoutPage.bnplAmountError, 30);
                Assert.assertTrue(checkoutPage.bnplAmountError.isDisplayed());
                break;
            case "bnplStatus ERROR":
                BrowserUtils.waitForVisibility(checkoutPage.bnplStatusError, 30);
                Assert.assertTrue(checkoutPage.bnplStatusError.isDisplayed());
                break;

        }

    }
}