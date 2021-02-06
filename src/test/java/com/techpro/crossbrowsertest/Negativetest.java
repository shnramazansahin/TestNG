package com.techpro.crossbrowsertest;

import com.techpro.utilities.TestBaseCross;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Negativetest extends TestBaseCross {

    @Test
    public void invalidID() {
        driver.get("https://qa-environment.crystalkeyhotels.com/Account/Logon");
        WebElement username = driver.findElement(By.id("UserName"));
        WebElement password = driver.findElement(By.id("Password"));
        WebElement loginButton = driver.findElement(By.id("btnSubmit"));
        username.sendKeys("manager");
        password.sendKeys("manager2!" + Keys.ENTER);
    }

    @Test
    public void invalidPassword() {
        driver.get("https://qa-environment.crystalkeyhotels.com/Account/Logon");
        WebElement username = driver.findElement(By.id("UserName"));
        WebElement password = driver.findElement(By.id("Password"));
        WebElement loginButton = driver.findElement(By.id("btnSubmit"));
        username.sendKeys("manager");
        password.sendKeys("manager2" + Keys.ENTER);
    }

    @Test
    public void invalidIdandPass() {
        driver.get("https://qa-environment.crystalkeyhotels.com/Account/Logon");
        WebElement username = driver.findElement(By.id("UserName"));
        WebElement password = driver.findElement(By.id("Password"));
        WebElement loginButton = driver.findElement(By.id("btnSubmit"));
        username.sendKeys("manager");
        password.sendKeys("manager2" + Keys.ENTER);
    }





}
