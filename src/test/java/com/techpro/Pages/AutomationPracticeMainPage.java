package com.techpro.Pages;

import com.techpro.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationPracticeMainPage {
    public AutomationPracticeMainPage () {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(linkText = "Contact us")
    public WebElement contactUs;





}
