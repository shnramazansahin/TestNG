package com.techpro.Homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonHW {
    /*
                Go to https://www.amazon.com/
                Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
                Print the first selected option and assert if it equals “All Departments”
                Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.(after you select you need to use get first selected option method)
                Print all of the dropdown options
                Print the the total number of options in the dropdown
                Check if Appliances is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
                BONUS: Check if the dropdown is in Alphabetical Order
         */

    WebDriver driver;
    WebElement choose;
    Select select;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
        choose  = driver.findElement(By.xpath("//select[@title='Search in']"));
        select = new Select(choose);

    }
    @Test
    public void dropDown() {

        String allDepartmants = select.getFirstSelectedOption().getText();
        Assert.assertEquals(allDepartmants,"All Departments");

    }

    @Test
    public void  fourthIndex() {
        select = new Select(choose);
        select.selectByIndex(4);
       String amazonDevices= select.getFirstSelectedOption().getText();

        Assert.assertEquals(amazonDevices,"Amazon Devices");

    }
    @Test
    public void allOptions() {

       select = new Select(choose);
         List<WebElement>allDropDown= select.getOptions();
         for(WebElement w:allDropDown) {
             System.out.println(w.getText());
        }


    }
    @Test
    public void size() {

        select = new Select(choose);
       int sizeOfDrowDown= select.getOptions().size();
        System.out.println(sizeOfDrowDown);

    }
    @Test
    public void AppliancesTest() {

         select = new Select(choose) ;
        List<WebElement>list =select.getOptions();
        List<String> stringList = new ArrayList<>();
        for(WebElement w: list) {
            stringList.add( w.getText());
        }

        Assert.assertTrue(stringList.contains("Appliances"));

    }
    @Test
    public void sortTest() {

        select = new Select(choose) ;
        List<WebElement>list =select.getOptions();
        List<String> stringList = new ArrayList<>();
        for(WebElement w: list) {
            stringList.add( w.getText());
        }

        List<String>sortedList= stringList;
        Collections.sort(stringList);
        Assert.assertEquals(stringList, sortedList);




    }
    @AfterMethod
    public  void tearDown() {
        driver.close();
    }



}
