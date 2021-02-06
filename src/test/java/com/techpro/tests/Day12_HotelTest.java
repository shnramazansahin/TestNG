package com.techpro.tests;

import com.github.javafaker.Faker;
import com.techpro.utilities.ConfigReader;
import com.techpro.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day12_HotelTest {
    /*
        Create a clickOnLogin method
        Click on Hotel Management
        Click on Hotel Rooms
        Click on Add Hotel Room
        Enter All required fields
        To enter a price, we can send keys, OR we can use actions class to drag and drop
        Click Save
        Verify the message: HotelRoom was inserted successfully
        Click OK
     */
    //We can improve this code
    //Create a method and write the code for pre conditions.
    WebElement username;
    WebElement password;
    WebElement loginButton;
    @BeforeMethod
    public void logIn(){
        Driver.getDriver().get(ConfigReader.getProperty("qa_environment"));
        WebElement mainPageLoginButton=Driver.getDriver().findElement(By.linkText("Log in"));
        mainPageLoginButton.click();
        username=Driver.getDriver().findElement(By.id("UserName"));
        password=Driver.getDriver().findElement(By.id("Password"));
        loginButton=Driver.getDriver().findElement(By.id("btnSubmit"));
        loginButton.click();
    }

   @Test

    public void createHoteTest() throws InterruptedException {
       username.sendKeys("manager");
       password.sendKeys("Manager2!");
       loginButton.click();
       WebElement hotelManag=Driver.getDriver().findElement(By.linkText("Hotel Management"));
       Thread.sleep(5000);
       hotelManag.click();
       WebElement hoteRoom = Driver.getDriver().findElement(By.partialLinkText("Hotel Rooms"));
       hoteRoom.click();
       WebElement hoteRoomButtons = Driver.getDriver().findElement(By.partialLinkText("ADD HOTELROOM"));
       hoteRoomButtons.click();
       WebElement dropdown= Driver.getDriver().findElement(By.id("IDHotel"));
       Select select = new Select(dropdown);
       select.selectByIndex(2);
       Faker faker= new Faker();
       WebElement hotelCode = Driver.getDriver().findElement(By.id("Code"));
        hotelCode.sendKeys(faker.code().asin());
        WebElement name = Driver.getDriver().findElement(By.id("Name"));
        name.sendKeys(faker.name().firstName());
       WebElement location = Driver.getDriver().findElement(By.id("Location"));
       location.sendKeys(faker.address().city());
       WebElement textBox = Driver.getDriver().findElement(By.xpath("//textarea[@role='textbox']"));
       textBox.sendKeys("this is a text box");
       WebElement roomType = Driver.getDriver().findElement(By.id("IDGroupRoomType"));
       Select select1 = new Select(roomType);
       select1.selectByIndex(2);

       WebElement price = Driver.getDriver().findElement(By.id("Price"));
       price.sendKeys("700");

       WebElement adoultNo = Driver.getDriver().findElement(By.id("MaxAdultCount"));
       adoultNo.sendKeys("3");
       WebElement childCount = Driver.getDriver().findElement(By.id("MaxChildCount"));
       childCount.sendKeys(faker.number().digit());
       WebElement checkBox = Driver.getDriver().findElement(By.id("IsAvailable"));
      checkBox.click();

       WebElement saveButton = Driver.getDriver().findElement(By.id("btnSubmit"));
       saveButton.click();

       WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
       WebElement successMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));
       //WebElement successMessage=Driver.getDriver().findElement(By.className("bootbox-body"));
       String successMessageText=successMessage.getText();
       Assert.assertEquals(successMessageText,"HotelRoom was inserted successfully");
       WebElement OK = Driver.getDriver().findElement(By.xpath("(//button[@type='button'])[last()]"));
      // (//button[@type='button'])[last()] is same with //button[@type='button'])[6] in this case
       OK.click();

        /*
        HOMEWORK
        When user clicks on Hotel Roooms link
        End filters
        IdHotel :ADA
        IdGroup :Studio
        IsAvailable :true
        And click Search
        Then verify table name includes " Royal Family "
         */










   }


//    @AfterMethod
//    public void tearDown(){
//        Driver.closeDriver();
//    }

}
