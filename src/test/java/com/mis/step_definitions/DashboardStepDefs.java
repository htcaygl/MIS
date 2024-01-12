package com.mis.step_definitions;

import com.mis.pages.BasePage;
import com.mis.pages.CheckoutPage;
import com.mis.pages.DashboardPage;
import com.mis.pages.LoginPage;
import com.mis.utilities.BrowserUtils;
import com.mis.utilities.ConfigurationReader;
import com.mis.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DashboardStepDefs {

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
//      BrowserUtils.waitFor(3);
//      dashboardPage.MisPayLogo.click();
//
//      dashboardPage.profileIcon.click();
//      BrowserUtils.waitFor(1);

      BrowserUtils.waitForVisibility(dashboardPage.phoneNumWebEl(phone), 20);
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
        dashboardPage.clickBtn(button);
        BrowserUtils.waitFor(2);
    }

}
