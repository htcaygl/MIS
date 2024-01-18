package com.mis.step_definitions;

import com.mis.pages.BasePage;
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

import java.util.Objects;

public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url= ConfigurationReader.get("url_login_test");
          Driver.get().get(url);

    }

    @Then("the user is on the marketing page")
    public void theUserIsOnTheMarketingPage() {
        String url= ConfigurationReader.get("url_marketing_test");
        Driver.get().get(url);
    }

    //wip
    @Given("the user is on the login page for {string}")
    public void the_user_is_on_the_login_page_for_env(String env) {

        String url = "";

        if(Objects.equals(env, "test")) {

            url= ConfigurationReader.get("url_login_test");
        }
        else
            url= ConfigurationReader.get("url_login_prod");

        System.out.println("URL is " +url);

        Driver.get().get(url);

    }

    @When("user enter login {string}")
    public void userEnterLogin(String phone) {

        BrowserUtils.waitFor(10);

        LoginPage loginPage = new LoginPage();
        BrowserUtils.waitForClickablility(loginPage.phoneNumber, 30);

        loginPage.phoneNumber.click();
        loginPage.phoneNumber.sendKeys(phone);
        loginPage.loginBtn.click();

    }

    @When("user enter login credentials")
    public void userEnterLoginCredentials() {

        BrowserUtils.waitFor(10);

        LoginPage loginPage = new LoginPage();
        BrowserUtils.waitForClickablility(loginPage.phoneNumber, 20);

        loginPage.phoneNumber.click();
        loginPage.phoneNumber.sendKeys("000000005");

        loginPage.loginBtn.click();

    }
    @When("user enter {string} Otp")
    public void userEnterOtp(String otp) {

        LoginPage loginPage = new LoginPage();
        BrowserUtils.waitForClickablility(loginPage.otp, 15);
        loginPage.otp.click();
     //   BrowserUtils.waitForPageToLoad(3);
     //   BrowserUtils.waitForVisibility(loginPage.otp,5);
        BrowserUtils.waitFor(3);

        if(otp.equals("valid"))
            { loginPage.otp.sendKeys("111111");
              BrowserUtils.waitForClickablility(loginPage.submitBtn, 15);
              loginPage.submitBtn.click();
              BrowserUtils.waitFor(5);
            }

        else { // otp.equals("invalid")
            loginPage.otp.sendKeys("712635");
            BrowserUtils.waitForClickablility(loginPage.submitBtn, 8);
            loginPage.submitBtn.click();
            BrowserUtils.waitFor(3);
        }



    }

    @Then("user should be able to login")
    public void user_should_be_able_to_login() {
        DashboardPage dashboardPagePage = new DashboardPage();

        Assert.assertTrue( dashboardPagePage.profileIcon.isDisplayed());
        dashboardPagePage.profileIcon.click();
    }

    @Then("user should see {string} error and click close button")
    public void userShouldSeeError(String error) {

        LoginPage loginPage = new LoginPage();

        switch (error) {
            case "IamInfoError":
                BrowserUtils.waitForVisibility(loginPage.IamInfoError, 2);
                Assert.assertTrue(loginPage.IamInfoError.isDisplayed());
                loginPage.errorCloseBtn.click();
                break;
            case "inactiveError":
                BrowserUtils.waitForVisibility(loginPage.inactiveError, 2);
                Assert.assertTrue(loginPage.inactiveError.isDisplayed());
                loginPage.errorCloseBtn.click();
                break;
            case "otp error":
                BrowserUtils.waitForVisibility(loginPage.otpError, 2);
                Assert.assertTrue(loginPage.otpError.isDisplayed());
                loginPage.errorCloseBtn.click();
                break;
        }


    }


}
