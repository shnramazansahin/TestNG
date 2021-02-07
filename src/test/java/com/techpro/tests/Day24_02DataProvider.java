package com.techpro.tests;

import com.techpro.Pages.LoginPage;
import com.techpro.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day24_02DataProvider {
    /*
    In this class, we learnt how to send multiple data with TestNG along with dataprovider anatotion
    First thing needs to be done create a method  Object[][]. this take username and password
    @DataProvider takes a parameter(smoke test) and this parameter will be used in @Test like this -->@Test(dataProvider = "smoke test")

     */

    @Test(dataProvider = "smoke test")
    public void  loginTest(String user, String password) {
        Driver.getDriver().get("https://qa-environment.crystalkeyhotels.com/Account/Logon");
        LoginPage loginPage= new LoginPage();
        loginPage.usernameCrys.sendKeys(user);
        loginPage.passwordCrys.sendKeys(password);
        loginPage.loginButtonCrys.click();
        Assert.assertTrue(Driver.getDriver().findElement(By.id("divMessageResult")).getText().contains("Try again please"));
        Driver.closeDriver();


    }
    @DataProvider(name="smoke test")
    public Object[][] getData() {
        /*
        user1, pass1
        user2, pass2
        user3,pass3
         */

        //                          row,column
        Object[][] data= new Object[3][2];
    // assigining test data for 1 row
         data[0][0]= "user1";
         data[0][1]= "pass1";
    // for second 2 row
        data[1][0]= "user2";
        data[1][1]= "pass2";
    //for second 3 data
        data[2][0]= "user3";
        data[2][1]= "pass3";

        return data;

    }









}
