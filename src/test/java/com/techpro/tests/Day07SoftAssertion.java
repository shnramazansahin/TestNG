package com.techpro.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day07SoftAssertion {

    /*
    when user goes to https://www.google.com/
    and search  procelain teapot
    then verify the page title includes teapot
     */
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

    }



    @Test
    public void test1() {
        WebElement search= driver.findElement(By.xpath("//input[@type='text']"));
        search.sendKeys("procelain teapot" +Keys.ENTER);
        String title= driver.getTitle();
        Assert.assertTrue(title.contains("teapot"));
        Assert.assertTrue(title.contains("teapot"), "title doesnt contain teapot");
        System.out.println("this after hard assertion");
//        SoftAssert soft = new SoftAssert();
//        soft.assertTrue(title.contains("teapot"));
//
//        soft.assertAll();
//

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();

    }






















}
