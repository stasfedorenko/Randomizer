package stas;

import java.util.HashMap;
import java.util.Map;

public class StringToMap {
    public static Map<String, String> toMap(String str) {

        Map<String, String> resultMap = new HashMap<>();
        StringBuilder numOrder = new StringBuilder();
        StringBuilder name = new StringBuilder();
        boolean flagEndName = false;
        for (int i = 0; i < str.length(); i++) {
            Character symbol = str.charAt(i);
            if (symbol.equals('\t')) {
                resultMap.put(numOrder.toString(), name.toString());
                numOrder = new StringBuilder();
                name.setLength(0);
            } else if (symbol.equals(' ')) {
                if (Character.isLetter(str.charAt(i - 1)) && Character.isLetter(str.charAt(i + 1))) {
                    name.append(symbol);
                }
            } else if (Character.isDigit(symbol)) {
                numOrder.append(symbol);
            } else if (Character.isLetter(symbol)) {
                name.append(symbol);
            }
        }
        return resultMap;
    }
}
