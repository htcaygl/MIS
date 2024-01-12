package com.mis.step_definitions;

import com.mis.pages.CheckoutPage;
import com.mis.pages.RegisterPage;
import com.mis.utilities.BrowserUtils;
import com.mis.utilities.UsefulMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Random;

public class RegisterStepDefs {

    @When("user enter orderId and amount to the new Phone")
    public void userEnterOrderIdAndAmountToTheNewPhone() {

        CheckoutPage checkoutPage = new CheckoutPage();
        BrowserUtils.waitForClickablility(checkoutPage.orderId, 2);

        Random rnd = new Random();
        String newPhone = String.valueOf(100000000 + rnd.nextInt(900000000));

        checkoutPage.orderId.sendKeys(newPhone+"-"+ UsefulMethods.getDayAndMonth());
        checkoutPage.amount.sendKeys("1");

        checkoutPage.clickBtn("submit");
        BrowserUtils.waitFor(4);

        BrowserUtils.waitForClickablility(checkoutPage.phoneNumber, 4);

        checkoutPage.phoneNumber.click();
        checkoutPage.phoneNumber.sendKeys(newPhone);
        checkoutPage.submitBtn.click();
        BrowserUtils.waitFor(2);


    }
    @And("Terms and Cond and PP is clickable")
    public void termsAndCondAndPPIsClickable() {

        RegisterPage registerPage = new RegisterPage();

        Assert.assertTrue(registerPage.termsAndCond.isEnabled());
        Assert.assertTrue(registerPage.privacyPolicy.isEnabled());



    }
}
