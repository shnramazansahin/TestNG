package com.techpro.tests;

import com.techpro.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day10_0FileUpLoad extends TestBase {
    /*
    When user goes to https://the-internet.herokuapp.com/upload
    And click on the chooseFile button
    And selects an image from the computer
    And click on the upload button
    Then verify the File uploaded!  Message displayed
     */


    @Test
    public void fileUploadTest() {

        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement file =driver.findElement(By.id("file-upload"));
        String path = "C:\\Users\\User\\Desktop\\flower.jpg";
       file.sendKeys(path);

       WebElement upLoad=driver.findElement(By.id("file-submit"));
       upLoad.click();
       String textVerify=driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(textVerify,"File Uploaded!");




    }

}
