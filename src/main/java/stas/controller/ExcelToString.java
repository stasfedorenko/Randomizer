package stas.controller;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;

public class ExcelToString {

    public static String parse(String nameFile) {

        String result = "";
        try {
            FileInputStream file = new FileInputStream(nameFile);

            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                boolean findNumGroup = false;
                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_FORMULA:
                            if(!findNumGroup){
                                findNumGroup = true;
                                result += ((int) cell.getNumericCellValue() + " ");
                            }else{
                                findNumGroup = false;
                                result += ((int) cell.getNumericCellValue() + "\t");
                            }
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            if(!findNumGroup){
                                findNumGroup = true;
                                result += ((int) cell.getNumericCellValue() + " ");
                            }else{
                                result += ((int) cell.getNumericCellValue() + "\t");
                            }
                            break;
                        case Cell.CELL_TYPE_STRING:
                            result += (cell.getStringCellValue() + " ");
                            break;
                    }
                }
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}