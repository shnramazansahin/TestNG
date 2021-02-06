package com.techpro.Homeworks;

import com.techpro.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HW01_StageMovment extends TestBase {

    @Test
    public void addChart() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.ARROW_DOWN).perform();
      //  driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        WebElement hoverOver  =driver.findElement(By.xpath("//img[@title='Blouse']"));
        actions.moveToElement(hoverOver).perform();
       driver.findElement(By.xpath("(//span[contains(.,'Add to cart')])[2]")).click();
       driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        String  type =driver.findElement(By.xpath("//span[contains(.,'Blouse')]")).getText();
        Assert.assertEquals(type,"Blouse");

        String  size =driver.findElement(By.xpath("//span[contains(.,'Black, S')]")).getText();
        Assert.assertEquals(size,"Black, S");

        String quantity = driver.findElement(By.xpath("//strong[contains(.,'Quantity')]")).getText();
        Assert.assertEquals(quantity,"Quantity");

        String quantityNo = driver.findElement(By.xpath("//span[@id='layer_cart_product_quantity']")).getText();
        Assert.assertEquals(quantityNo,"1");


        String total = driver.findElement(By.xpath("//strong[contains(.,'Total')]")).getText();
        Assert.assertEquals(total,"Total");

        String totalPrice = driver.findElement(By.xpath("//span[@id='layer_cart_product_price']")).getText();
        Assert.assertEquals(totalPrice,"$27.00");

        driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();

        String summary = driver.findElement(By.xpath("//span[contains(.,'01. Summary')]")).getText();
        Assert.assertEquals(summary,"01. Summary");

        String  inStock =driver.findElement(By.xpath("//span[contains(.,'In stock')]")).getText();
        Assert.assertEquals(inStock,"In stock");

        String unitPrice =driver.findElement(By.xpath("//span[@id='product_price_2_7_0']")).getText();
        Assert.assertEquals(unitPrice,totalPrice);

        String total_product=driver.findElement(By.id("total_product")).getText();
        Assert.assertEquals(total_product,"$27.00");

        String total_shipping=driver.findElement(By.id("total_shipping")).getText();
        Assert.assertEquals(total_shipping,"$2.00");

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);

        String total_price=driver.findElement(By.id("total_price")).getText();
        Assert.assertEquals(total_price,"$29.00");
        WebElement prooceed =driver.findElement(By.xpath("(//span[contains(.,'Proceed to checkout')])[2]"));
        prooceed.click();

        WebElement email=driver.findElement(By.id("email"));
        email.sendKeys("phone@gmail.com");

       WebElement password= driver.findElement(By.id("passwd"));
       password.sendKeys("asdfasdfa"+Keys.ENTER);

       String address =driver.findElement(By.xpath("//h1[contains(.,'Addresses')]")).getText();
       Assert.assertTrue(address.equals("ADDRESSES"));
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//span[contains(.,'Proceed to checkout')])[2]")).click();
        driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
        String shipping =driver.findElement(By.xpath("//h1[contains(.,'Shipping')]")).getText();
        Assert.assertEquals(shipping,"SHIPPING");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//span[contains(.,'Proceed to checkout')])[2]")).click();
       // driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);
        String box =driver.findElement(By.xpath("//p[@class='fancybox-error']")).getText();
        Assert.assertEquals(box,"You must agree to the terms of service before continuing.");
        driver.findElement(By.xpath("//a[@title='Close']")).click();
        WebElement checkBox=driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();
        driver.findElement(By.xpath("(//span[contains(.,'Proceed to checkout')])[2]")).click();
        String paymentText=driver.findElement(By.xpath("//h1[contains(.,'Please choose your payment method')]")).getText();
        Assert.assertEquals(paymentText, "PLEASE CHOOSE YOUR PAYMENT METHOD");


    }

}
