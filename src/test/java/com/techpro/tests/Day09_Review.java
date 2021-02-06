package com.techpro.tests;

import com.techpro.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Day09_Review extends TestBase {


    @Test
    public void review() throws InterruptedException {
        //hover over
        driver.get("https://www.investing.com/");
        Actions actions = new Actions(driver);
        WebElement market=driver.findElement(By.xpath("//a[@class='nav']"));
        actions.moveToElement(market).perform();
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();

    }
    @Test
    public  void ebay() {
        driver.get("https://www.ebay.com/");
       WebElement shop= driver.findElement(By.xpath("//a[@title='My eBay']"));
       Select dropDown = new Select(shop);
       dropDown.selectByIndex(2);

    }


}
