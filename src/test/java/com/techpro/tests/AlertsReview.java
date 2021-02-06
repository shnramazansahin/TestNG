package com.techpro.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertsReview {
    /*
        Go to https://the-internet.herokuapp.com/javascript_alerts
        Create setUp method
        Create 3 test methods:
        acceptAlert() => click on the first alert, verify the text “I am a JS Alert” , click OK , and Verify “You successfuly clicked an alert”
        dismissAlert()=> click on the second alert, verify text "I am a JS Confirm”, click cancel, and Verify “You clicked: Cancel”
        sendKeysAlert()=> click on the third alert, verify text “I am a JS prompt”, type “Hello Word”, click OK, and Verify “You entered: Hello Word”
 */

    WebDriver driver;
    @BeforeMethod
    public void  setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);

    }
    @Test
    public void  acceptAlert() {
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
       String text= driver.switchTo().alert().getText();
        Assert.assertEquals(text,"I am a JS Alert");
        driver.switchTo().alert().accept();
        String result=driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result,"You successfuly clicked an alert");

    }
    @Test
    public void  dismissAlert() {
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        String text= driver.switchTo().alert().getText();
        Assert.assertEquals(text,"I am a JS Confirm");
        driver.switchTo().alert().dismiss();
        String result=driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result,"You clicked: Cancel");
    }
    @Test
    public void  sendKeysAlert() {
       WebElement promot = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        promot.click();
        String text=driver.switchTo().alert().getText();
        Assert.assertEquals(text,"I am a JS prompt");
        driver.switchTo().alert().sendKeys("hello word");
        driver.switchTo().alert().accept();
        String result=driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result,"You entered: hello word");

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }























}
