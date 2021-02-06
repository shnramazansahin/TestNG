package com.techpro.Pages;

import com.techpro.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(id = "UserName")
    public WebElement usernameCrys;

    @FindBy(id = "Password")
    public WebElement passwordCrys;

    @FindBy(id = "btnSubmit")
    public WebElement loginButtonCrys;
}
