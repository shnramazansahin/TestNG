package com.techpro.ExcelAutomotion;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.CancellationException;

public class ExcelWrite {
    @Test
    public void writeExcel() throws IOException {
        // Locate the path
        String path ="src/test/java/Source/Capitals.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        //following opends the workbook
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row row= sheet.getRow(0);
        // adding a cell to 4th column
        Cell cell4=row.createCell(3);
        // typing in 4th cell
        cell4.setCellValue("Population");
        // creating , typing and in once
        sheet.getRow(1).createCell(3).setCellValue("150000");
        sheet.getRow(2).createCell(3).setCellValue("25000");
        sheet.getRow(3).createCell(3).setCellValue(23423);

        // write and save the values , use fileoutputstream
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        //clsoing the files
        fileOutputStream.close();
        fileInputStream.close();
        workbook.close();





















    }
}
