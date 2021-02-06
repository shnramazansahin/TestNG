package com.techpro.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
   private static WebDriver driver;
    //Setup ,create  and return the driver instance
    public static WebDriver getDriver(){
        /*
        If driver is not being used, if it is not pointing anywhere, then instantiate the driver
        We want to use only one driver in the entire framework
         */
        if(driver==null) { // it means that if the driver is not running , empty
            //ConfigReader.getProperty("browser") ==>chrome
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
            }
        }
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    //create a close driver method
    public static void closeDriver() {
        if(driver!=null) { // means that driver is pointing somewhere, running
            driver.quit(); // close the driver
            driver=null; // make the driver empty so it can start when we call it again.
        }

    }


}
