package stas;

import java.util.HashMap;
import java.util.Map;

public class StringToParticipantMap {
    public static Map<String, Participant> toMap(String str) {

        Map<String, Participant> resultMap = new HashMap<>();
        StringBuilder idParticipant = new StringBuilder();
        StringBuilder name = new StringBuilder();
        StringBuilder idGroup = new StringBuilder();
        boolean flagIdSeparation = false;
        for (int i = 0; i < str.length(); i++) {
            Character symbol = str.charAt(i);
            if (symbol.equals('\t')) {
                resultMap.put(
                        idParticipant.toString(),
                        new Participant(
                                idParticipant.toString(),
                                name.toString(),
                                Integer.parseInt(idGroup.toString())));
                idParticipant = new StringBuilder();
                name.setLength(0);
                idGroup = new StringBuilder();
            } else if (symbol.equals(' ')) {
                if (Character.isLetter(str.charAt(i - 1)) && Character.isLetter(str.charAt(i + 1))) {
                    name.append(symbol);
                }
            } else if (Character.isDigit(symbol)) {
                if (!flagIdSeparation) {
                    idParticipant.append(symbol);
                    if (!Character.isDigit(str.charAt(i + 1))) {
                        flagIdSeparation = true;
                    }
                } else {
                    idGroup.append(symbol);
                    flagIdSeparation = false;
                }
            } else if (Character.isLetter(symbol)) {
                name.append(symbol);
            }
        }
        return resultMap;
    }
}
