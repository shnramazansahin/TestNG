package com.techpro.Pages;

import com.techpro.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationPracticeContactPage {
    public AutomationPracticeContactPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(id="id_contact")
    public WebElement heading;

    @FindBy(id="email")
    public WebElement email;

    @FindBy(id="id_order")
    public WebElement orderReference;

    @FindBy(id="fileUpload")
    public WebElement fileUpload;

    @FindBy(id="submitMessage")
    public WebElement sendButton;

    @FindBy(id="message")
    public WebElement messageBox;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    public WebElement successMessage;









}
