package com.techpro.tests;

import com.techpro.Pages.Day15_DTPage;
import com.techpro.utilities.ConfigReader;
import com.techpro.utilities.Driver;
import com.techpro.utilities.ExcelUtil;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class Day15_ExcelAutomation {
 // src/test/java/Source/Day15TestData.xlsx
    ExcelUtil excelUtil;
    List<Map<String,String>> testData;
    Day15_DTPage day15_dtPage;
    @Test
    public  void  excelAutomation() throws InterruptedException {
        excelUtil= new ExcelUtil("src/test/java/Source/exceldata.xlsx","datatablessheet");
        testData= excelUtil.getDataList();
  //      System.out.println(testData); gives the entire list

        //i will get the each key value pairs inside the map from the list
        for(Map<String,String> each:testData) { // give me the entire map

            Driver.getDriver().get(ConfigReader.getProperty("dt_url"));
            day15_dtPage= new Day15_DTPage();
            day15_dtPage.newButton.click();
            day15_dtPage.firstName.sendKeys(each.get("firstname"));
            day15_dtPage.lastName.sendKeys(each.get("lastname"));
            day15_dtPage.position.sendKeys(each.get("position"));
            day15_dtPage.office.sendKeys(each.get("office"));
            day15_dtPage.extentions.sendKeys(each.get("extention"));
            day15_dtPage.startDate.sendKeys(each.get("startdate"));
            day15_dtPage.salary.sendKeys(each.get("salary"));
            day15_dtPage.createButton.click();
            day15_dtPage.searchBox.sendKeys(each.get("firstname"));
            Thread.sleep(4000);
            String actualName= day15_dtPage.nameField.getText();
            Assert.assertTrue(actualName.contains(each.get("firstname")));



        }












    }
}
