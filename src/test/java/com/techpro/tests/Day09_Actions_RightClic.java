package com.techpro.tests;

import com.techpro.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day09_Actions_RightClic extends TestBase {

    /*
    Crate an Action object
    Locate the element you wanna work on
    Perform the action on the WebElement by using action obj
    actions.perform();
     */


/*
            Task:
            Create a test method : contextClickMethod() and test the following scenario:
            Given user is on the https://the-internet.herokuapp.com/context_menu
            When use Right clicks on the box
            Then verify the alert message is “You selected a context menu”
            Then accept the alert
 */
    @Test
    public void  contextClickMethod() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement box  =driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        //Right Clickk
        actions.contextClick(box).perform();
        String alertText=driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.equals("You selected a context menu"));
        driver.switchTo().alert().accept();


    }















}
