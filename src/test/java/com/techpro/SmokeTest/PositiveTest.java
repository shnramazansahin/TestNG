package com.techpro.SmokeTest;

import com.techpro.utilities.ConfigReader;
import com.techpro.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


    public class PositiveTest {
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
        }
        @AfterMethod
        public void tearDown(){
            Driver.closeDriver();
        }
        @Test
        public void positiveLoginTest(){
            username.sendKeys("manager");
            password.sendKeys("Manager2!");
            loginButton.click();
            WebElement addUser=Driver.getDriver().findElement(By.xpath("//span[@class='hidden-480']"));
            Assert.assertTrue(addUser.isDisplayed());
        }
        //WE need a core element  on the page to assert we logged in



    }
