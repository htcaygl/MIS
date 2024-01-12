package com.mis.pages;

import com.mis.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage{

    public RegisterPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//p[text()='Terms and Conditions']")   //register sayfasindakiler, footer degil
    public WebElement termsAndCond;

    @FindBy(xpath = "//p[text()='Privacy Policy']") // footer degil
    public WebElement privacyPolicy;
}
