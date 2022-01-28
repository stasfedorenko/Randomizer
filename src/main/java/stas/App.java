package stas;

import stas.parsers.ParserMapToExcel;
import stas.controller.ProgramGuide;
import stas.parsers.ParserExcelToMap;
import stas.controller.RandomRealization;
import stas.entity.Participant;

import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Введите путь к Excel файлу или проигнорируйте данный пункт, нажав Enter:\n");
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        if(path.equals("")){
           path = "src/main/java/stas/documents/fileExcel.xlsx";
        }
        Map<String, Participant> map = ParserExcelToMap.parse(path);
        ProgramGuide.run(RandomRealization.random(map));
        ParserMapToExcel.run(map);


    }


}
