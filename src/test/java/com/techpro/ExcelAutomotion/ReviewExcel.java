package com.techpro.ExcelAutomotion;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReviewExcel {

    @Test
    public void review() throws IOException {
        String path = "src/test/java/Source/Review.xlsx";
        FileInputStream fileInput= new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fileInput);
        Sheet sheet =workbook.getSheetAt(0);
        Row row =sheet.getRow(0);
        Cell cell =row.getCell(0);
        System.out.println(cell);
        Cell cell1=sheet.getRow(1).getCell(1);
        System.out.println(cell1);
        int lastRowNum =sheet.getLastRowNum()+1;
        System.out.println(lastRowNum);
        int physicalNumberOfRows=sheet.getPhysicalNumberOfRows();
        System.out.println(physicalNumberOfRows);

        Map<String,String> studentsMap= new HashMap<>();
        int studentColumn=0;
        int gradeColumn= 1;
        for(int rowNumber=1;rowNumber<lastRowNum;rowNumber++) {
           String students= sheet.getRow(rowNumber).getCell(studentColumn).toString();
           String grades=sheet.getRow(rowNumber).getCell(gradeColumn).toString();
           studentsMap.put(students,grades);

        }
        System.out.println(studentsMap);


    }
    @Test
    public void writeExcel() throws IOException {
        String path ="src/test/java/Source/Review.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet =workbook.getSheetAt(0);

        Row row=sheet.getRow(0);
        Cell rowCell=row.createCell(2);
        rowCell.setCellValue("status");
        sheet.getRow(1).createCell(2).setCellValue("fail");
        sheet.getRow(2).createCell(2).setCellValue("passed");
        sheet.getRow(3).createCell(2).setCellValue("null");
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

    }

}
