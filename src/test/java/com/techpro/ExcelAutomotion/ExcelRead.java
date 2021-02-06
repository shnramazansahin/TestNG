package com.techpro.ExcelAutomotion;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Test
    public class ExcelRead {

    public  void readExcel() throws IOException {

        String path ="src/test/java/Source/Capitals.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        //following opends the workbook
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row row =sheet.getRow(0);
        Cell cell= row.getCell(0);
        System.out.println(cell);
        Cell usaCell=sheet.getRow(1).getCell(0);
        int lastRowNum= sheet.getLastRowNum() +1 ; //return last row number that has data
        //getLastRow index start at 0..We need to add 1 to find
        System.out.println("row num " + lastRowNum);
        int physicalNumberOfRows=sheet.getPhysicalNumberOfRows();// returns num of row used
        System.out.println(physicalNumberOfRows);
        //physicalNumberOfRows index starts from 1

        Map<String,String> worldCapitals = new HashMap<>();
        int countryColumn=0;
        int capitalColum=1;

        for(int rowNumber=1;rowNumber<lastRowNum;rowNumber++) {
            String country =sheet.getRow(rowNumber).getCell(countryColumn).toString();
           // System.out.println(country);
            String capital=sheet.getRow(rowNumber).getCell(capitalColum).toString();
            worldCapitals.put(country,capital);
        }
        System.out.println(worldCapitals);

        fileInputStream.close();
        workbook.close();


   }

}
