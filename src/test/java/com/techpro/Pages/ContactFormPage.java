package com.techpro.Pages;

import com.techpro.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactFormPage {

  public ContactFormPage() {
      PageFactory.initElements(Driver.getDriver(),this);
  }
  @FindBy(id="NameSurname")
   public WebElement nameSurname;

    @FindBy(id="Email")
    public WebElement Email;

    @FindBy(id="PhoneNo")
    public WebElement PhoneNo;

    @FindBy(id="Subject")
    public WebElement Subject;

    @FindBy(id="Message")
    public WebElement Message;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement sendMessageButton;

    @FindBy(id="divMessageResult")
    public WebElement errorMessage;









}
