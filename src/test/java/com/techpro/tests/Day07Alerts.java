package com.techpro.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
/*
        accept()->Same as clicking OK of an alert. driver.switchTo().alert().accept();
        dismiss()->Same as clicking Cancel of an alert. driver.switchTo().alert().dismiss();
        getText()-> To get the alert message of the alert. driver.switchTo().alert().getText();
        sendKeys(“Text”)->To send a text into alert textbox driver.switchTo().alert().sendKeys(“Text")
 */

public class Day07Alerts {
/*
        Go to https://the-internet.herokuapp.com/javascript_alerts
        Create setUp method
        Create 3 test methods:
        acceptAlert() => click on the first alert, verify the text “I am a JS Alert” , click OK , and Verify “You successfuly clicked an alert”
        dismissAlert()=> click on the second alert, verify text "I am a JS Confirm”, click cancel, and Verify “You clicked: Cancel”
        sendKeysAlert()=> click on the third alert, verify text “I am a JS prompt”, type “Hello Word”, click OK, and Verify “You entered: Hello Word”
 */
/*
Interview Quetion:
How to handler alerts?

 */
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @Test
    public void acceptAlert() {
       WebElement firstButton= driver.findElement(By.xpath("//button[@onclick='jsAlert()']") );
        firstButton.click();
       String actuallButton = driver.switchTo().alert().getText();
        Assert.assertEquals(actuallButton,"I am a JS Alert");
        driver.switchTo().alert().accept();
        String actualText= driver.findElement(By.xpath("//*[.='You successfuly clicked an alert']")).getText();
        Assert.assertEquals(actualText,"You successfuly clicked an alert");




    }
    @Test
    public void dismissAlert() {
        WebElement dismiss= driver.findElement(By.xpath("//button[@onclick='jsConfirm()']") );
        dismiss.click();
        String cancelText= driver.switchTo().alert().getText();
        Assert.assertEquals(cancelText,"I am a JS Confirm");
        driver.switchTo().alert().dismiss();
       String result= driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(result,"You clicked: Cancel");

    }
    @Test
    public void sendkeyAlert() {
        WebElement thirButton=  driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        thirButton.click();
        String actualTextThird =driver.switchTo().alert().getText();
        Assert.assertEquals(actualTextThird,"I am a JS prompt");
       driver.switchTo().alert().sendKeys("Hello Word");
       driver.switchTo().alert().accept();
       String result=driver.findElement(By.id("result")).getText();
       Assert.assertEquals(result,"You entered: Hello Word");

    }




}
