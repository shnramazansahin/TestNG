package com.techpro.tests;

import com.techpro.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class Day09_Actions_KeyBoard extends TestBase {
    /*
    Create a class: ActionsClass3
    Create test method : keysUpDown()
    Go to google
    Send iPhone X prices => convert small letter capital vice versa.
    Highlight the search box by double clicking
     */


    @Test
    public void keysUpDown() {
        driver.get("https://www.google.com/");
       WebElement searchBox = driver.findElement(By.name("q"));
        Actions actions = new Actions(driver);
        //We want to press shift
       actions.keyDown(searchBox, Keys.SHIFT).sendKeys("iPhone X prices").keyUp(searchBox,Keys.SHIFT).perform();





    }
}
