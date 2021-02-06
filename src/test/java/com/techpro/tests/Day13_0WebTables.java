package com.techpro.tests;

import com.techpro.utilities.ConfigReader;
import com.techpro.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Day13_0WebTables {

    /*
    tr= table rows
    td= table data. it is like cells in the excel
    td= table head
    if you wanna find something in the body part start with //tbody
    jf you wanna find something outside of the body start with //table

     */
    /*
     to find a element in a spesic condition in  a webtable
    //tbdoy//tr[x]//td[y]
    to find the all data in x colum:
    //tbody//tr//td[x] or  //tbody//* //td[x]
     */
    /*
    Create a class: WebTables
    Create a method: login()
    Log in  https://qa-environment.crystalkeyhotels.com/
    //Click on Hotel Management
    //Click on Hotel Rooms
    Create a test method: entireTable() and Find the size of the entire table body and print all of headers
    Create a test method: printRows() and Print all of the rows and print the element s on the 4th row
    Create a test method: printCells() and a the total number of cells in the table body and print all of the cells
    Create a test method: printColumns() and print Find the total number of columns and Print the elements of the 5th column
    Create a test method: printData(int row, int column); This method should print the given cell. Example: printData(2,3); should print 2nd row,3rd column
     */

    WebElement username;
    WebElement password;
    WebElement loginButton;
    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("qa_environment"));
        WebElement mainPageLoginButton=Driver.getDriver().findElement(By.linkText("Log in"));
        mainPageLoginButton.click();
        username=Driver.getDriver().findElement(By.id("UserName"));
        password=Driver.getDriver().findElement(By.id("Password"));
        loginButton=Driver.getDriver().findElement(By.id("btnSubmit"));
        username.sendKeys("manager");
        password.sendKeys("Manager2!");
        loginButton.click();
        //We need a core element on the page to assert we are on the right page
        WebElement addUserButton=Driver.getDriver().findElement(By.xpath("//span[@class='hidden-480']"));
        Assert.assertTrue(addUserButton.isDisplayed(),"Login Test Fail");
        //NOTE: If any step is skipped, there might be synchronization issue. Then use wait
        WebElement hotelManagement=Driver.getDriver().findElement(By.linkText("Hotel Management"));
        hotelManagement.click();
        WebElement hotelRooms=Driver.getDriver().findElement(By.partialLinkText("Hotel Rooms"));
        hotelRooms.click();
    }
    @Test(groups = "regression1")
    public void entireTable() throws InterruptedException {
        Thread.sleep(3000);
        WebElement tbody=Driver.getDriver().findElement(By.xpath("//tbody"));
        System.out.println(tbody.getText());
        // printint the entire table
        List<WebElement>tableDat =Driver.getDriver().findElements(By.xpath("//tbody//td"));
        for(WebElement each:tableDat) {
            System.out.println(each.getText());

        }
        //printitng the size of the table
        System.out.println("there are "+tableDat.size());

        //printint the headers
        List<WebElement> allHeaders= Driver.getDriver().findElements(By.xpath("//th"));
        for (WebElement w:allHeaders) {
            System.out.println(w.getText());
        }

    }
    @Test
    public void printRow() {
        //All Rows
        List<WebElement> allRows= Driver.getDriver().findElements(By.xpath("//tbody//tr"));
        int count=1;
        for (WebElement w:allRows) {
            System.out.println("Row" + count + w.getText());
            count++;
        }
        //4th Row
        WebElement forhtRow= Driver.getDriver().findElement(By.xpath("//tbody//tr[4]"));
        System.out.println(forhtRow.getText());



    }
    @Test
    public void printCells() {
        List<WebElement> allCells= Driver.getDriver().findElements(By.xpath("//tbody//td"));
        System.out.println(allCells.size());
        for(WebElement w:allCells) {
            System.out.println(w.getText());
        }
    }

    @Test
    public void printColums() {
        // to find the colms options are :
        //th------>it returns the headers.Num of headers are equl. to colums. make more sense to use and easy
        //tbody/tr[1]/td


        List<WebElement> allcolums= Driver.getDriver().findElements(By.xpath("//th"));
        System.out.println(allcolums.size());
        for(WebElement w:allcolums) {
            System.out.println(w.getText());
        }
        // print the element in 5th column

        List<WebElement> fifthcolums= Driver.getDriver().findElements(By.xpath("//tbody//td[5]"));
        System.out.println(fifthcolums.size());
        for(WebElement w:fifthcolums) {
            System.out.println(w.getText());
        }


    }

    public  void printData(int row, int column) {
        // xpath //tbody//tr[2]//td[3]
        //Since number are chaning xpath:
            //tbody//tr["+ROWNUM+"]+ //td["+COLNUM+"]
        String xpathData = "//tbody//tr["+row+"]//td["+column+"]";
        WebElement data= Driver.getDriver().findElement(By.xpath(xpathData));
        System.out.println(data.getText());
    }
    @Test
    public void printDataTest() {
        printData(2,3);
    }




}
