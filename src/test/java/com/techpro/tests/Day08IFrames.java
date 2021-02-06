package com.techpro.tests;

import com.techpro.utilities.ReusableMethods;
import com.techpro.utilities.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
/*
how to handle iframes
you need to get int the iframe by follwing ways:
       1.driver.switchTo().frame(0);//index start from 0

       2.driver.switchTo().frame("mce_0_ifr");//id or name value

       3.1 WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
       3.2 driver.switchTo().frame(iframeElement);//WebElement like xpath, etc.
after you are done inside the iframe , you need to get out of it by following way
        driver.switchTo().parentFrame() : takes to one above like iframe3 to iframe 2
        driver.switchTo().defaultContent(); take to main content like iframe2 to iframe
 */

public class Day08IFrames extends TestBase {
    /*
    Go to https://the-internet.herokuapp.com/iframe
    Verify the Bolded text contains “Editor”
    Locate the text box
    Delete the text in the text box
    Type “This text box is inside the iframe”
    Verify the text Elemental Selenium text is displayed on the pa
     */

    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        String boldedText = driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
        Assert.assertTrue(boldedText.contains("Editor"));
        //Number of Iframe
        int numOfIframe = driver.findElements(By.tagName("iframe")).size();
        System.out.println(numOfIframe);
//        driver.switchTo().frame(0);//index start from 0
//        driver.switchTo().frame("mce_0_ifr");//id or name value
       // driver.findElement(By.xpath("//p")) tired this first to locat the texbox but got no such element exception. But the element is there, then noticed it is iframe
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeElement);//WebElement like xpath, etc.

        driver.findElement(By.xpath("//p")).clear();//clear deleted the input text
        driver.findElement(By.xpath("//p")).sendKeys("This text box is inside the iframe");
        ReusableMethods.waitFor(3);
        driver.switchTo().defaultContent(); // will take us out the frame and take the main content
        driver.switchTo().parentFrame();
        WebElement seleniumElement =driver.findElement(By.linkText("Elemental Selenium"));


        }

    }
