package com.mis.step_definitions;

import com.mis.pages.BasePage;
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
import org.openqa.selenium.WebElement;


public class DashboardStepDefs {

    public static double debtValue = 0;

    double latestBeforeCredit , creditAfterPayment=0;


    @Then("user should be able to click profile button")
    public void user_should_be_able_to_click_profile_button() {
        DashboardPage dashboardPage = new DashboardPage();

        BrowserUtils.waitFor(3);
        BrowserUtils.waitForClickablility(dashboardPage.MisPayLogo, 15);
        dashboardPage.MisPayLogo.click();

        dashboardPage.profileIcon.click();
        BrowserUtils.waitFor(1);

    }

    @Then("user should be able to see profile info {string} and {string}")
    public void user_should_be_able_to_see_profile_info(String phone, String email) {

     DashboardPage dashboardPage = new DashboardPage();
//
      BrowserUtils.waitFor(3);
//      dashboardPage.MisPayLogo.click();
//
//      dashboardPage.profileIcon.click();
//      BrowserUtils.waitFor(1);

      BrowserUtils.waitForVisibility(dashboardPage.phoneNumWebEl(phone), 30);
      Assert.assertTrue(dashboardPage.phoneNumWebEl(phone).isDisplayed());
      Assert.assertTrue(dashboardPage.emailWebEl(email).isDisplayed());
      BrowserUtils.waitFor(1);
      dashboardPage.logoutBtn.click();
      BrowserUtils.waitFor(2);

    }

    @And("user tap {string} button")
    public void userTapButton(String button) {

        DashboardPage dashboardPage = new DashboardPage();

        BrowserUtils.waitFor(7);

        if(button.equals("Pay with Apple Pay")) {

            debtValue = UsefulMethods.SplitAmount(dashboardPage.debtAmountOnPaymentInfo.getText());

        }

        dashboardPage.clickBtn(button);

        BrowserUtils.waitFor(2);
    }

    @Then("user should see {string} text")
    public void user_should_see_text(String text) {

        DashboardPage dashboardPage = new DashboardPage();

        switch (text) {
            case "Payment Unsuccessfull":
                Assert.assertTrue(dashboardPage.PaymentUnsuccessfullText.isDisplayed());
                break;

        }

        BrowserUtils.waitFor(1);

    }


    @And("user see the Available Credit {string}")
    public void  userSeeTheAvailableCreditTheAmount(String text) {

        DashboardPage dashboardPage = new DashboardPage();

        double creditBeforePayment;


        switch (text) {
            case "Before":
                BrowserUtils.waitForVisibility(dashboardPage.availableCredit, 15);
                creditBeforePayment = dashboardPage.getAvaliableCreditAmount(dashboardPage.availableCredit);
                latestBeforeCredit += creditBeforePayment;
                break;
            case "After":
                creditAfterPayment = dashboardPage.getAvaliableCreditAmount(dashboardPage.availableCredit);

                break;

        }

        System.out.println("latest before credit: "+latestBeforeCredit +  " debt value: "+ debtValue + " creditAfterPayment: "+creditAfterPayment);

    }

    @Then("available credit is updated")
    public void availableCreditIsUpdated() {

        DashboardPage dashboardPage =new DashboardPage();

        boolean result = dashboardPage.calculateAvailableCredit(latestBeforeCredit,creditAfterPayment, debtValue );


        System.out.println("latest before credit: "+latestBeforeCredit +  " debt value: "+ debtValue + " creditAfterPayment: "+creditAfterPayment);

        Assert.assertTrue(result);

    }
}
