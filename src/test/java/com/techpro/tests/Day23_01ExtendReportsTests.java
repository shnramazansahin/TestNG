package com.techpro.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.techpro.Pages.ContactFormPage;
import com.techpro.Pages.MainPage;
import com.techpro.utilities.ConfigReader;
import com.techpro.utilities.Driver;
import com.techpro.utilities.ReusableMethods;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Day23_01ExtendReportsTests {

    protected static ExtentReports extentReports;
    protected   static ExtentTest extentTest;
    protected  static ExtentHtmlReporter extentHtmlReporter;
    @BeforeTest
        public void setUp() {
        extentReports = new ExtentReports();
                                                            //folder name   /report name
        String filePath= System.getProperty("user.dir")+ "/test-output/myprojectreport.html"; // path of the reports
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter); // attaching thml report to the extentReports
        // we can add custom  OPTIONAL information on our report.
        extentReports.setSystemInfo("envirment","QA envirment");
        extentReports.setSystemInfo("browser", ConfigReader.getProperty("browser"));
        extentReports.setSystemInfo("Automation Eng", "no one");
        extentHtmlReporter.config().setDocumentTitle("CrystalKeys Hotel Reports");
        extentHtmlReporter.config().setReportName("Crystal key automation reports");

    }
    @AfterTest

       public void tearDownn() {
        // closing the extent reports
        extentReports.flush();
    }
    @AfterMethod
    public  void  tearDown(ITestResult result) throws IOException {
        //     id the test case fails
        if(result.getStatus()==ITestResult.FAILURE){
            // naming the screenshot with the current date to avoid duplication
            String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            // TakesScreenshot is an interface of selenium that takes the screenshot
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            File source = ts.getScreenshotAs(OutputType.FILE);
            // full path to the screenshot location             folder       screenshotname = Scneenshots+date+.png
            String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + date + ".png";
            File finalDestination = new File(target);
            // save the screenshot to the path given
            FileUtils.copyFile(source, finalDestination);
//            This line will mark the test method as FAILED.
            extentTest.fail("TEST CASE IS FAILED : "+result.getName());
        }else if (result.getStatus()==ITestResult.SKIP){
            extentTest.skip("TEST CASE IS SKIPPED : "+result.getName());
        }

    }

    MainPage mainPage= new MainPage();
    ContactFormPage contactPage= new ContactFormPage();


    @Test
    public  void contactUs() {
        extentTest=extentReports.createTest("Crystal Keys extendReportsTest","Contact Page Test");
        extentTest.info("Opening the Application home page");
        Driver.getDriver().get(ConfigReader.getProperty("qa_environment"));
        extentTest.info("Clicking the contact link");
        mainPage.contact.click();
        extentTest.info("Entering Name");
        contactPage.nameSurname.sendKeys("sending name");
        extentTest.info("entering email");
        contactPage.Email.sendKeys("sending@fakegmail.com");
        extentTest.info("entering phone number");
        contactPage.PhoneNo.sendKeys("9999999");
        extentTest.pass("Sending the subject");
        contactPage.Subject.sendKeys("sending the subject");
        extentTest.pass("sending the message");
        contactPage.Message.sendKeys("I would like to cancel my weekend reservation");
        extentTest.pass("clicking");
        contactPage.sendMessageButton.click();
        extentTest.pass("Clicked on the click button");
        ReusableMethods.waitForVisibility(contactPage.errorMessage,3);
        extentTest.pass("Found the message");
        System.out.println(contactPage.errorMessage.getText());
        Assert.assertTrue(contactPage.errorMessage.getText().contains("Errors occured, please try again1"));
        extentTest.pass("TEST CASE PASSED");

    }

}
