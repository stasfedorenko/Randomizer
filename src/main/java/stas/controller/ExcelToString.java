package stas.controller;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

public class ExcelToString {

    public static String parse(String nameFile) {
        HashMap<Integer, String[]> groups = new HashMap<>();
        String result = "";
        try {
            FileInputStream file = new FileInputStream(nameFile);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();
                    Cell cellId = row.getCell(0);
                    Cell cellGroup = row.getCell(2);
                    Cell cellName = row.getCell(1);
                    String cv = String.valueOf(cellGroup.getNumericCellValue());
                    String[] array = new String[]{cv, cellName.getStringCellValue()};
                    groups.put((int) cellId.getNumericCellValue(), array);

                }
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}