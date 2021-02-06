package com.techpro.tests;

import com.techpro.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class Day09_Review1 {
//
//    @BeforeMethod
//    public void setUp() {
//        Driver.getDriver().get("http://demo.automationtesting.in/Frames.html");
//    }

    @Test
    public void iframe() {
        Driver.getDriver().get("http://demo.automationtesting.in/Frames.html");
        WebElement iframe =Driver.getDriver().findElement(By.id("singleframe"));
        Driver.getDriver().switchTo().frame(iframe);

        WebElement box= Driver.getDriver().findElement(By.xpath("//input[@type='text']"));
        box.sendKeys("this is frame");

        Driver.getDriver().switchTo().parentFrame();

    }
    @Test
    public void windows() {
        Driver.getDriver().get("http://demo.automationtesting.in/Windows.html");
        String first =Driver.getDriver().getWindowHandle();
        WebElement clickButton =Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-info']"));
        clickButton.click();

       Set<String> second = Driver.getDriver().getWindowHandles();
       for(String w: second) {
           if(!first.equals(second)) {
               Driver.getDriver().switchTo().window(w);
           }
       }


    }
    @Test
    public void  alert() throws InterruptedException {
        Driver.getDriver().get("http://demo.automationtesting.in/Alerts.html");
       WebElement last= Driver.getDriver().findElement(By.xpath("(//a[@class='analystic'])[3]"));
//       Thread.sleep(3000);
       last.click();

        Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-info']")).click();
        Driver.getDriver().switchTo().alert().sendKeys("clean");
        Driver.getDriver().switchTo().alert().accept();


    }

}
