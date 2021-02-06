package com.techpro.Homeworks;

import com.techpro.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day08_IframeHW extends TestBase {



    @Test
    public void iframeTest(){
        driver.get("https://html.com/tags/iframe/");
        Actions actions=new Actions(driver);
        //Need to scroll down the page, otherwose the iframe of  button is not displayed
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //Locating and switching to the iframe. Because play button is inside the frame
        WebElement firstIFrame=driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));
        driver.switchTo().frame(firstIFrame);
        //Locating and clicking teh play button
        WebElement playButton=driver.findElement(By.xpath("//button[@aria-label='Play']"));
        playButton.click();
    }


}
