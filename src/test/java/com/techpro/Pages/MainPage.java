package com.techpro.Pages;

import com.techpro.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {


    public MainPage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(linkText = "Log in")
    public WebElement mainPageLogInButtonCrys;

    @FindBy(linkText = "Contact")
    public WebElement contact;


}
