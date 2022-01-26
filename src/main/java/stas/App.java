package stas;

import java.util.Map;

public class App {
    public static void main(String[] args) {

        String str = ParserExcelFile.parse("src/main/java/stas/documents/fileExcel.xlsx");
//        System.out.println(str);
        Map<String,Participant> map = StringToParticipantMap.toMap(str);
//        System.out.println(map);
        AnswerQuestion.run(RandomRealization.random(map));

    }


}
