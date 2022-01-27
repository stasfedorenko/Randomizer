package stas;

import stas.controller.ProgramGuide;
import stas.controller.ExcelToString;
import stas.controller.RandomRealization;
import stas.controller.StringToMap;
import stas.entity.Participant;

import java.util.Map;

public class App {
    public static void main(String[] args) {

        String str = ExcelToString.parse("src/main/java/stas/documents/fileExcel.xlsx");
//        System.out.println(str);
        Map<String, Participant> map = StringToMap.toMap(str);
//        System.out.println(map);
        ProgramGuide.run(RandomRealization.random(map));

    }


}
