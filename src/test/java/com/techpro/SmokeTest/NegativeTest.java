package com.techpro.SmokeTest;

import com.techpro.utilities.ConfigReader;
import com.techpro.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class NegativeTest {

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


    @Test
    public void invalidPassword(){
//        user: manager(right username)
//        pw: Manage!(wrong password)
        username.sendKeys("manager");
        password.sendKeys("Manage!");
        loginButton.click();

        //Then verify the error message includes “Wrong password”
        WebElement errorMessage=Driver.getDriver().findElement(By.id("divMessageResult"));
        String errorMessageText=errorMessage.getText();
        Assert.assertTrue(errorMessageText.contains("Wrong password"));

    }
    @Test(groups = "regression")
    public void invalidID(){
//        user: manager123 (invalid)
//        pw: Manager2! (valid)
        username.sendKeys("manager123");
        password.sendKeys("Manager2!");
        loginButton.click();

        //Then verify the error message includes “Try again please”
        WebElement errorMessage=Driver.getDriver().findElement(By.id("divMessageResult"));
        String errorMessageText=errorMessage.getText();
        Assert.assertTrue(errorMessageText.contains("Try again please"));
    }
    @Test(groups = "regression")
    public void invalidIDAndPassword(){

//        user: manager123 (invalid)
//        pw: Manage! (invalid)
        username.sendKeys("manager123");
        password.sendKeys("Manage!");
        loginButton.click();

//        Then verify the error message includes “Username or password is incorrect, please correct them and try again”
        WebElement errorMessage=Driver.getDriver().findElement(By.id("divMessageResult"));
        String errorMessageText=errorMessage.getText();
        Assert.assertTrue(errorMessageText.contains("Username or password is incorrect, please correct them and try again"));
    }

}