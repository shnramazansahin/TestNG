package com.techpro.Homeworks;

import com.techpro.utilities.ConfigReader;
import com.techpro.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.events.Event;


public class RoomCreation {
    WebElement username;
    WebElement password;
    WebElement loginButton;
    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("qa_environment"));
        WebElement mainPageLoginButton=Driver.getDriver().findElement(By.linkText("Log in"));
        mainPageLoginButton.click();
        username=Driver.getDriver().findElement(By.id("UserName"));
        username.sendKeys("manager");
        password=Driver.getDriver().findElement(By.id("Password"));
        password.sendKeys("Manager2!");
        loginButton=Driver.getDriver().findElement(By.id("btnSubmit"));
        loginButton.click();

    }
    Select select;
    @Test
    public void roomCreate() throws InterruptedException {
        WebElement hotelManagement=Driver.getDriver().findElement(By.linkText("Hotel Management"));
        hotelManagement.click();
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.partialLinkText("Room reservations")).click();
        Driver.getDriver().findElement(By.linkText("ADD ROOM RESERVATION")).click();
        WebElement IdUSer =Driver.getDriver().findElement(By.id("IDUser"));
        select = new Select(IdUSer);
        select.selectByIndex(4);
        WebElement selectRoom= Driver.getDriver().findElement(By.id("IDHotelRoom"));
        select = new Select(selectRoom);
        select.selectByIndex(3);
        WebElement price=Driver.getDriver().findElement(By.id("Price"));
        price.sendKeys("333");
        WebElement dateStart=Driver.getDriver().findElement(By.id("DateStart"));
        dateStart.sendKeys("01/21/2021");
        WebElement dateEnd=Driver.getDriver().findElement(By.id("DateEnd"));
        dateEnd.sendKeys("01/27/2021");
        WebElement adultAmount=Driver.getDriver().findElement(By.id("AdultAmount"));
        adultAmount.sendKeys("4");
        WebElement childrenAmount=Driver.getDriver().findElement(By.id("ChildrenAmount"));
        childrenAmount.sendKeys("41");
        WebElement contactNameSurname=Driver.getDriver().findElement(By.id("ContactNameSurname"));
        contactNameSurname.sendKeys("jack brown");
        WebElement contactPhone=Driver.getDriver().findElement(By.id("ContactPhone"));
        contactPhone.sendKeys("1234567899");
        WebElement contactEmail=Driver.getDriver().findElement(By.id("ContactEmail"));
        contactEmail.sendKeys("abc@gnail.com");
        WebElement notes=Driver.getDriver().findElement(By.id("Notes"));
        notes.sendKeys("no noted");
        WebElement approvedCheckBox=Driver.getDriver().findElement(By.id("Approved"));
        approvedCheckBox.click();
        WebElement button = Driver.getDriver().findElement(By.id("btnSubmit"));
        button.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));
        String successMessage=message.getText();
       // WebElement message = Driver.getDriver().findElement(By.className("bootbox-body"));
        Assert.assertEquals(successMessage,"RoomReservation was inserted successfully");
        WebElement okButton = Driver.getDriver().findElement(By.xpath("(//button[@type='button'])[8]"));
        okButton.click();






    }















}
