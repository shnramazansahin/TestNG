package com.techpro.tests;

import com.techpro.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Day09_ActionsUpandDown extends TestBase {

    /*
    PAGE_DOWN =>scrolling down
PAGE_UP =>scrolling up
ARROW_DOWN =>scrolling down
ARROW_UP =>scrolling up
How do you scroll down amazon page? How do you scroll up amazon page?
2:42
Create a class: ActionClass4
Create test method : scrollUpDown()
Go to amazon
Scroll the page down
Scroll the page up
     */

    @Test
    public void  scrollUpDown() {
        driver.get("https://www.ebay.com/");
        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN).perform(); // move more
        actions.sendKeys(Keys.PAGE_UP).perform();

        actions.sendKeys(Keys.ARROW_UP).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform(); //  these two move very little



    }
}
