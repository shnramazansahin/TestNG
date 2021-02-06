package com.techpro.tests;

import com.techpro.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day09_Synchronization2 extends TestBase {
/*
Create a class:Day09_Synchronization2. Create a method: isEnabled
Go to https://the-internet.herokuapp.com/dynamic_controls
Click enable Button
And verify the message is equal to “It's enabled!”
And verify the textbox is enabled (I can type in the box)
And click on Disable button
And verify the message is equal to “It's disabled!”
And verify the textbox is disabled (I cannot type in the box)
 */
    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        String enableText= driver.findElement(By.xpath("//p[@id='message']")).getText();
        Assert.assertEquals(enableText,"It's enabled!");

        //Locating and cliking disable button

        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        String disAbleText= driver.findElement(By.xpath("//p[@id='message']")).getText();
        Assert.assertEquals(disAbleText,"It's disabled!");
        //locating the inpput element
        WebElement inputBox =driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(!inputBox.isEnabled());











    }


}
