package com.techpro.tests;

import com.techpro.utilities.Driver;
import com.techpro.utilities.JSUtils;
import com.techpro.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Day24_01JSExecuter {
//
//@Test
//    public void jsExecutorTest(){
//
//    Driver.getDriver().get(ConfigReader.getProperty("qa_environment"));
//    WebElement element1 =Driver.getDriver().findElement(By.xpath("(//h2)[10]"));
//    System.out.println(element1.isDisplayed()); // return false bc we must scoll down the page
//    ReusableMethods.waitFor(1);
//    JavascriptExecutor je= (JavascriptExecutor) Driver.getDriver();
//    je.executeScript("arguments[0].scrollIntoView(true);",element1); // this scroll down the page until Selenium can see the element1
//
//
//
//
//    }

    @Test
    public  void JSESexetor() {


    Driver.getDriver().get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
    JavascriptExecutor js=  (JavascriptExecutor) Driver.getDriver();

        WebElement element= Driver.getDriver().findElement(By.xpath("//*[@id='mCSB_3_container']/p[3]"));
        ReusableMethods.waitFor(2);

        js.executeScript("arguments[0].scrollIntoView(true);",element);
        ReusableMethods.waitFor(2);
        System.out.println(element.isDisplayed());
        System.out.println(element.getText());
        WebElement textArea=Driver.getDriver().findElement(By.xpath("//textarea"));
        js.executeScript("arguments[0].scrollIntoView(true);",textArea);
        textArea.clear();
        textArea.sendKeys("i am text area");

        WebElement element2= Driver.getDriver().findElement(By.xpath("(//img[@src=\"images/img5.jpg\"])[2]"));
          boolean imageDisplayed= element2.isDisplayed();
        System.out.println(imageDisplayed);
        js.executeScript("arguments[0].scrollIntoView(true);",element2);
        JSUtils.scrollIntoVIewJS(element2); // same with the one above. this one comes from JSutil class in utilities


    }
    @Test
    public  void JSexecutor3() {

        Driver.getDriver().get("https://qa-environment.crystalkeyhotels.com/Account/Logon");
       WebElement loginButton= Driver.getDriver().findElement(By.id("btnSubmit"));
       JSUtils.changeColor("black",loginButton);




    }

}
