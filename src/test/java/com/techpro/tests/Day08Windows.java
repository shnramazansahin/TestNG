package com.techpro.tests;

import com.techpro.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Day08Windows extends TestBase {
    /*
    reate a new Class Tests package: Day08_WindowHandleExample
        Method name:windowHandle
        Given user is on the https://the-internet.herokuapp.com/windows
        Then user verifies the text : “Opening a new window”
        Then user verifies the title of the page is “The Internet”
        When user clicks on the “Click Here” button
        Then user verifies the new window title is “New Window”
        Then user verifies the text:  “New Window”
      When user goes back to the previous window and then verifies the title : “The Internet”
     */
    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/windows");
        //Getting the handle of current window
        String winndow1Handle =driver.getWindowHandle();

        String window1Text= driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(window1Text,"Opening a new window");
        String window1Title =driver.getTitle();
        Assert.assertEquals(window1Title,"The Internet");



        driver.findElement(By.linkText("Click Here")).click();

        Set<String>allWindows =driver.getWindowHandles();
        System.out.println(allWindows);
        // driver is on window1 handle.We wanna switch to window2handle
        for(String w: allWindows) {
            if(!w.equals(winndow1Handle)){
                driver.switchTo().window(w);
            }

        }
        String window2Title= driver.getTitle();

        Assert.assertEquals(window2Title,"New Window");
    }
}
