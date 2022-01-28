package stas.parsers;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import stas.entity.Participant;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParserExcelToMap {

    public static Map<String, Participant> parse(String nameFile) {
        Map<String, Participant> participantsMap = new LinkedHashMap<>();
        try {
            FileInputStream file = new FileInputStream(nameFile);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Cell cellId = row.getCell(0);
                Cell cellName = row.getCell(1);
                Cell cellGroup = row.getCell(2);

                String id = String.valueOf((int) cellId.getNumericCellValue());
                String name = cellName.getStringCellValue();
                String surname = "";
                if (name.contains(" ")) {
                    surname = name.substring(0, name.indexOf(" "));
                    name = name.substring(name.indexOf(" ") + 1);
                }
                int idGroup = (int) cellGroup.getNumericCellValue();

                Participant participant = new Participant(id, name, surname, idGroup);
                participantsMap.put(id, participant);

            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return participantsMap;
    }
}