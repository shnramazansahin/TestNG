package com.techpro.Pages;

import com.techpro.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Day15_DTPage {
    public Day15_DTPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[contains(.,'New')]")
    public WebElement newButton;

    @FindBy(id="DTE_Field_first_name")
    public WebElement firstName;

    @FindBy(id="DTE_Field_last_name")
    public WebElement lastName;

    @FindBy(id="DTE_Field_position")
    public WebElement position;

    @FindBy(id="DTE_Field_office")
    public  WebElement office;

    @FindBy(id="DTE_Field_extn")
    public  WebElement extentions;

    @FindBy(id="DTE_Field_start_date")
    public  WebElement startDate;

    @FindBy(id="DTE_Field_salary")
    public WebElement salary;

    @FindBy(className = "btn")
    public WebElement createButton;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchBox;

    @FindBy(className = "sorting_1")
    public WebElement nameField;


}
