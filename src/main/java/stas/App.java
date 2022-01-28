package stas;

import stas.controller.ParserMapToExcel;
import stas.controller.ProgramGuide;
import stas.controller.ParserExcelToMap;
import stas.controller.RandomRealization;
import stas.entity.Participant;

import java.util.Map;

public class App {
    public static void main(String[] args) {

        Map<String, Participant> map = ParserExcelToMap.parse("src/main/java/stas/documents/fileExcel.xlsx");

        ProgramGuide.run(RandomRealization.random(map));
        new ParserMapToExcel().run(map);


    }


}
