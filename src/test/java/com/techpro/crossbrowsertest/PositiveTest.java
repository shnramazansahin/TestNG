package com.techpro.crossbrowsertest;

import com.techpro.utilities.TestBaseCross;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class PositiveTest extends TestBaseCross {
    @Test
    public  void positivetest() {

        driver.get("https://qa-environment.crystalkeyhotels.com/Account/Logon");
        WebElement username = driver.findElement(By.id("UserName"));
        WebElement password = driver.findElement(By.id("Password"));
        WebElement loginButton = driver.findElement(By.id("btnSubmit"));
        username.sendKeys("manager2");
        password.sendKeys("manager2!" + Keys.ENTER);











    }
}
