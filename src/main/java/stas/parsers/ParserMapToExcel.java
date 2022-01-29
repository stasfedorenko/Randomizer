package stas.parsers;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import stas.entity.Participant;

import java.io.*;
import java.util.Map;
import java.util.Set;

public class ParserMapToExcel {
    public static void run(Map<String, Participant> map) {
        String path = "src/main/java/stas/documents/result.xlsx";
        try {

            File resultFileExcel = new File(path);
            FileInputStream file = new FileInputStream(resultFileExcel);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Set<String> newRows = map.keySet();
            int rownum = sheet.getLastRowNum();

            if(sheet.getLastRowNum()!=0){
                System.out.println("Clear the result.xlsx...");
                for(int i=0;i<= sheet.getLastRowNum();i++){
                    Row row = sheet.getRow(i);
                    Cell cellId = row.getCell(0);
                    Cell cellSurname = row.getCell(1);
                    Cell cellName = row.getCell(2);
                    Cell cellIdGroup = row.getCell(3);
                    Cell cellPointsQuestion = row.getCell(4);
                    Cell cellPointsAnswer = row.getCell(5);
                    Cell cellPointsOther = row.getCell(6);
                    row.removeCell(cellId);
                    row.removeCell(cellSurname);
                    row.removeCell(cellName);
                    row.removeCell(cellIdGroup);
                    row.removeCell(cellPointsQuestion);
                    row.removeCell(cellPointsAnswer);
                    row.removeCell(cellPointsOther);
                }
                file.close();
                FileOutputStream os = new FileOutputStream(resultFileExcel);
                workbook.write(os);
                os.flush();
                os.close();
                workbook = new XSSFWorkbook(new FileInputStream(path));
                sheet = workbook.getSheetAt(0);
                rownum = 0;
            }
            System.out.println("Writing on XLSX file Started ...");
            for (String key : newRows) {
                Row row = sheet.createRow(rownum++);
                int cellnum = 0;




                if (rownum == 1) {
                    Cell cellId = row.createCell(cellnum++);
                    Cell cellSurname = row.createCell(cellnum++);
                    Cell cellName = row.createCell(cellnum++);
                    Cell cellIdGroup = row.createCell(cellnum++);
                    Cell cellPointsQuestion = row.createCell(cellnum++);
                    Cell cellPointsAnswer = row.createCell(cellnum++);
                    Cell cellPointsOther = row.createCell(cellnum);

                    cellId.setCellValue("id");
                    cellSurname.setCellValue("Surname");
                    cellName.setCellValue("Name");
                    cellIdGroup.setCellValue("Group");
                    cellPointsQuestion.setCellValue("PointsQuestion");
                    cellPointsAnswer.setCellValue("PointsAnswer");
                    cellPointsOther.setCellValue("PointsOther");
                    row = sheet.createRow(rownum++);
                    cellnum = 0;
                }
                Cell cellId = row.createCell(cellnum++);
                Cell cellSurname = row.createCell(cellnum++);
                Cell cellName = row.createCell(cellnum++);
                Cell cellIdGroup = row.createCell(cellnum++);
                Cell cellPointsQuestion = row.createCell(cellnum++);
                Cell cellPointsAnswer = row.createCell(cellnum++);
                Cell cellPointsOther = row.createCell(cellnum);

                cellId.setCellValue(Integer.parseInt(map.get(key).getId()));
                cellSurname.setCellValue(map.get(key).getSurname());
                cellName.setCellValue(map.get(key).getName());
                cellIdGroup.setCellValue(map.get(key).getIdGroup());
                cellPointsQuestion.setCellValue(map.get(key).getPointsQuestion());
                cellPointsAnswer.setCellValue(map.get(key).getPointsAnswer());
                cellPointsOther.setCellValue(map.get(key).getPointsOther());
            }

            file.close();
            FileOutputStream os = new FileOutputStream(resultFileExcel);

            workbook.write(os);
            os.flush();
            os.close();
            System.out.println("Writing on XLSX file Finished ...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
