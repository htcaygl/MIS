package com.mis.step_definitions;

import com.mis.pages.TransactionPage;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class TransactionStepDefs {

    @And("user tap {string} tab")
    public void userTapTab(String btn) {

        TransactionPage transactionPage = new TransactionPage();
        transactionPage.topMenu(btn);

    }

    @Then("user should be able to see datas")
    public void userShouldBeAbleToSeeDatas() {

        TransactionPage transactionPage = new TransactionPage();

        Assert.assertEquals("Trendyol", transactionPage.table("merchant").getText());
        Assert.assertEquals("18/01/2024 19:13", transactionPage.table("date").getText());
        Assert.assertEquals("SAR 200.01", transactionPage.table("amount").getText());

    }
}
