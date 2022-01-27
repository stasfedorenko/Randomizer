package stas.controller;

import stas.entity.Participant;

import java.util.HashMap;
import java.util.Map;

public class StringToMap {
    public static Map<String, Participant> toMap(String str) {

        Map<String, Participant> resultMap = new HashMap<>();
        StringBuilder idParticipant = new StringBuilder();
        StringBuilder name = new StringBuilder();
        StringBuilder surname = new StringBuilder();
        StringBuilder idGroup = new StringBuilder();
        boolean flagSeparationIdGroupAndIdParticipant = false;
        boolean flagSeparationNameAndSurname = false;
        for (int i = 0; i < str.length(); i++) {
            Character symbol = str.charAt(i);
            if (symbol.equals('\t')) {
                resultMap.put(
                        idParticipant.toString(),
                        new Participant(
                                idParticipant.toString(),
                                name.toString(),
                                surname.toString(),
                                Integer.parseInt(idGroup.toString())));
                idParticipant.setLength(0);
                name.setLength(0);
                surname.setLength(0);
                idGroup = new StringBuilder();
            } else if (symbol.equals(' ')) {
                if (Character.isLetter(str.charAt(i - 1)) && Character.isLetter(str.charAt(i + 1))) {
                    flagSeparationNameAndSurname = true;
                }
            } else if (Character.isDigit(symbol)) {
                if (!flagSeparationIdGroupAndIdParticipant) {
                    idParticipant.append(symbol);
                    if (!Character.isDigit(str.charAt(i + 1))) {
                        flagSeparationIdGroupAndIdParticipant = true;
                    }
                } else {
                    idGroup.append(symbol);
                    if (!Character.isDigit(str.charAt(i + 1))) {
                        flagSeparationIdGroupAndIdParticipant = false;
                    }
                }
            } else if (Character.isLetter(symbol)) {
                if(!flagSeparationNameAndSurname){
                    name.append(symbol);
                }else{
                    surname.append(symbol);
                    if(!Character.isLetter(str.charAt(i+1))){
                        flagSeparationNameAndSurname = false;
                    }
                }
            }
        }
        return resultMap;
    }
}
