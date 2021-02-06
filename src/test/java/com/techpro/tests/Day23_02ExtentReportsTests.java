package com.techpro.tests;

import com.techpro.Pages.ContactFormPage;
import com.techpro.Pages.MainPage;
import com.techpro.utilities.ConfigReader;
import com.techpro.utilities.Driver;
import com.techpro.utilities.ReusableMethods;
import com.techpro.utilities.TestBaseFinal;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day23_02ExtentReportsTests extends TestBaseFinal {
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
