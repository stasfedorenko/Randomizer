package stas.documents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomRealization {
    public static String random(Map<String, String> map) {
        List<String> doNotRepeat = new ArrayList<>();
        int flag = 0;
        System.out.println(map.size());
        System.out.println("===================================");
        while (flag != 7) {
            String check = Integer.toString((int) ((Math.random() * (map.size())) + 1));
            while (!doNotRepeat.contains(map.get(check))) {
                doNotRepeat.add(map.get(check));
                flag++;
            }
        }

        for (int i = 0; i < doNotRepeat.size()-1; i++) {
            System.out.println(doNotRepeat.get(i) + " задаёт вопрос.");
            System.out.println(doNotRepeat.get(i+1) + " отвечает.");
            System.out.println("_");
            if(i==doNotRepeat.size()-2){
                System.out.println(doNotRepeat.get(doNotRepeat.size()-1) + " задаёт вопрос.");
                System.out.println(doNotRepeat.get(0) + " отвечает.");
                System.out.println("Конец программы");
            }
        }


        return null;
    }
}
