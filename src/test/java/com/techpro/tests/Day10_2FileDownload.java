package com.techpro.tests;

import com.techpro.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class Day10_2FileDownload extends TestBase {
    /*
    Create a class:FileDownloadTest
    downloadTest()
    In the downloadTest() method, do the following test:
    Go to https://the-internet.herokuapp.com/download
    Download flower.png file
    Then verify if the file downloaded successfully

     */
    @Test
    public void downloadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[.='flower.jpg']")).click();
        Thread.sleep(1000);
        String  userFolder=System.getProperty("user.home");
        String path = userFolder + "\\Downloads\\flower.jpg";
        System.out.println(path);
        boolean isDownloaded=Files.exists(Paths.get(path));
        Assert.assertTrue(isDownloaded);




    }

}
