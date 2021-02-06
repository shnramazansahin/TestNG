package com.techpro.Pages;

import com.techpro.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
// Step 1
public class FaceLoginPage {

    //we will initialize the driver using a constructor
    public  FaceLoginPage() {
        //Page factory has initElements.It is used to initilaze the driver.
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="email")
    public  WebElement username; // we can not access the class member without making them public

    @FindBy(id="pass")
    public WebElement password;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement loginButton;
    @FindBy(className = "_9ay7")
    public WebElement message;





}
