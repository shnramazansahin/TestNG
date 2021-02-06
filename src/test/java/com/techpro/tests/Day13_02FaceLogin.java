package com.techpro.tests;

import com.techpro.Pages.FaceLoginPage;
import com.techpro.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
/*
this class is the second step of the POM.First step is creating pages package.
Go to that package for more detail.
 */
public class Day13_02FaceLogin {
    FaceLoginPage faceLoginPage;
    @Test
    public void login() throws InterruptedException {
        Driver.getDriver().get("https://www.facebook.com/");
        faceLoginPage= new FaceLoginPage();
        faceLoginPage.username.sendKeys("fakeusername");
        faceLoginPage.password.sendKeys("23423");
        faceLoginPage.loginButton.click();
        Thread.sleep(2000);
        String errorMessage= "The email address or phone number that you've entered doesn't match any account ";
        Assert.assertEquals(faceLoginPage.message.getText(),errorMessage);











    }
}
