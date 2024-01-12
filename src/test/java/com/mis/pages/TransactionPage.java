package com.mis.pages;

import com.mis.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionPage extends BasePage {

    public TransactionPage() {
        PageFactory.initElements(Driver.get(), this);
    }


    public WebElement table(String data){

        WebElement element = null;

        switch (data) {

            case "merchant" :
                element= Driver.get().findElement(By.xpath("(//table//tbody//td//p)[1]"));
                break;

            case "date" :
                element= Driver.get().findElement(By.xpath("(//table//tbody//td//p)[2]"));
                break;

            case "amount" :
                element= Driver.get().findElement(By.xpath("(//table//tbody//td//p)[3]"));
            break;

        }

        return element ;
    }
}
