package stas;

import java.util.Map;

public class App {
    public static void main(String[] args) {

        String str = ParserExcelFile.parse("src/main/java/stas/documents/fileExcel.xlsx");

        Map<String,String> map = StringToMap.toMap(str);
        RandomRealization.random(map);

    }


}
