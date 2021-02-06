package com.techpro.tests;

import com.techpro.utilities.TestBase;
import org.apache.tools.ant.taskdefs.FixCRLF;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day09_Actions_HoverOver extends TestBase {
    /*
    Create test method : hoverOver() and test the following scenario:
Given user is on the https://www.amazon.com/
When use click on “ Account” link
Then verify the page title contains “Account”
Create another method: imageTest()
Hover over the Try Prime"nav-link-accountList"
And Verify the image displays.
     */
    @Test
    public void hoverOver()  {

//        driver.get("https://www.ebay.com/");
//        WebElement myac=driver.findElement(By.xpath("//a[@title='My eBay']"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(myac).perform();

        driver.get("https://www.investing.com/");
        WebElement accountList= driver.findElement(By.xpath("//a[@class='nav']"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Actions actions=new Actions(driver);
        //Hovering over the account list element
        actions.moveToElement(accountList).perform();

//        driver.findElement(By.linkText("Account")).click();
//        Assert.assertTrue(driver.getTitle().contains("Your Account"));



    }






}
