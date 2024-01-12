package com.mis.pages;

import com.mis.utilities.BrowserUtils;
import com.mis.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }


}
