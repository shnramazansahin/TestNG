package com.techpro.tests;

import com.techpro.Pages.CrystalRoomCreation;
import com.techpro.Pages.DefaultPage;
import com.techpro.Pages.LoginPage;
import com.techpro.Pages.MainPage;
import com.techpro.utilities.ConfigReader;
import com.techpro.utilities.Driver;
import com.techpro.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day14_RoomCreationWithPOM {

    MainPage mainPage;
    LoginPage loginPage;
    DefaultPage defaultPage;

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("qa_environment"));
        mainPage = new MainPage();
        mainPage.mainPageLogInButtonCrys.click();
        loginPage = new LoginPage();
        loginPage.usernameCrys.sendKeys(ConfigReader.getProperty("username"));
        loginPage.passwordCrys.sendKeys(ConfigReader.getProperty("password"));
        loginPage.loginButtonCrys.click();

        defaultPage = new DefaultPage();
        defaultPage.hotelMagagement.click();
        defaultPage.roomReservation.click();

    }

    CrystalRoomCreation crystalRoomCreation;
    Select select;

    @Test
    public void roomCreate() {

        crystalRoomCreation = new CrystalRoomCreation();
        crystalRoomCreation.addRoomReservationButton.click();
        select = new Select(crystalRoomCreation.selectUser);
        select.selectByIndex(3);
        Select select1 = new Select(crystalRoomCreation.selectRoom);
        select1.selectByIndex(3);
        crystalRoomCreation.price.sendKeys("234");
        crystalRoomCreation.DateStart.sendKeys("1/19/2021");
        crystalRoomCreation.DateEnd.sendKeys("1/27/2021");
        crystalRoomCreation.AdultAmount.sendKeys("3");
        crystalRoomCreation.ChildrenAmount.sendKeys("3");
        crystalRoomCreation.ContactNameSurname.sendKeys("brown");
        crystalRoomCreation.ContactPhone.sendKeys("1234567899");
        crystalRoomCreation.ContactEmail.sendKeys("abc@gmail.com");
        crystalRoomCreation.Notes.sendKeys("no notes");
        crystalRoomCreation.Approved.click();
        crystalRoomCreation.btnSubmit.click();

         WebElement successMessage=ReusableMethods.waitForClickablility(By.className("bootbox-body"),5);

         /*
       WebDriverWait wait= new WebDriverWait(Driver.getDriver(),5);
       WebElement successMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));
       this part is the same with the following :
       WebElement successMessage=ReusableMethods.waitForClickablility(By.className("bootbox-body"),5);
       The reason we are using it, it is reusable. We call this method from utilities package
          */

       String successMessageText  = successMessage.getText();
        Assert.assertEquals(successMessageText,ConfigReader.getProperty("expectedSuccessMessage"));
        crystalRoomCreation.OkButton.click();


    }
    @AfterMethod
  public  void  tearDown() {
        Driver.closeDriver();
    }
}








