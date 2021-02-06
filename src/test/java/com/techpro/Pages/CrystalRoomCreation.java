package com.techpro.Pages;

import com.techpro.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrystalRoomCreation {

    public CrystalRoomCreation() {

        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(className="hidden-480")
    public WebElement addRoomReservationButton;
    @FindBy(id="IDUser")
    public WebElement selectUser;
    @FindBy(id="IDHotelRoom")
    public WebElement selectRoom;
    @FindBy(id="Price")
    public WebElement price;
    @FindBy(id="DateStart")
    public WebElement DateStart;
    @FindBy(id="DateEnd")
    public WebElement DateEnd;
    @FindBy(id="AdultAmount")
    public WebElement AdultAmount;
    @FindBy(id="ChildrenAmount")
    public WebElement ChildrenAmount;
    @FindBy(id="ContactNameSurname")
    public WebElement ContactNameSurname;
    @FindBy(id="ContactPhone")
    public WebElement ContactPhone;
    @FindBy(id="ContactEmail")
    public WebElement ContactEmail;
    @FindBy(id="Notes")
    public WebElement Notes;
    @FindBy(id="Approved")
    public WebElement Approved;
    @FindBy(id="btnSubmit")
    public WebElement btnSubmit;
    @FindBy(className = "bootbox-body")
    public WebElement successMessage;
    @FindBy(xpath = "(//button[@type='button'])[8]")
    public WebElement OkButton;



}
