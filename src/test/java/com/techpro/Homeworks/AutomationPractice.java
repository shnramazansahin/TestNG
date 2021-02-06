package com.techpro.Homeworks;

import com.techpro.Pages.AutomationPracticeContactPage;
import com.techpro.Pages.AutomationPracticeMainPage;
import com.techpro.utilities.Driver;
import com.techpro.utilities.TestBaseFinal;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomationPractice  extends TestBaseFinal {

 AutomationPracticeMainPage mainPage = new AutomationPracticeMainPage();
 AutomationPracticeContactPage contactPage= new AutomationPracticeContactPage();

    @Test
    public void contactTest() throws InterruptedException {

        Driver.getDriver().get("http://automationpractice.com/index.php");
        Thread.sleep(3000);
        mainPage.contactUs.click();
        Select select1= new Select(contactPage.heading);
        select1.selectByIndex(1);
        contactPage.email.sendKeys("abc@gmail.com");
        contactPage.orderReference.sendKeys("2332");
        contactPage.messageBox.sendKeys("this is message");
        String path=  "C:\\Users\\User\\Desktop\\flower.jpg";
        contactPage.fileUpload.sendKeys(path);
        contactPage.sendButton.click();
        Assert.assertFalse(contactPage.successMessage.getText().contains("successfully"));




    }


}
