package stas;

import java.util.*;

public class RandomRealization {
    public static String random(Map<String, String> map) {
        List<String> doNotRepeat = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String s = "s";
        int t = 0;
        System.out.println(map.size());
        System.out.println("===================================");
        while (doNotRepeat.size() != map.size()) {
            String check = Integer.toString((int) ((Math.random() * (map.size())) + 1));
            if (!doNotRepeat.contains(map.get(check))) {
                doNotRepeat.add(map.get(check));
            }
        }
        while (!s.equals("exit")) {
            if (s.equals("")) {
                if ((t + 1) < doNotRepeat.size()) {
                    System.out.println(doNotRepeat.get(t) + " задаёт вопрос.");
                    System.out.println(doNotRepeat.get(t + 1) + " отвечает.");
                    System.out.println("_");
                    t++;
                }else if((t+1) == doNotRepeat.size()){
                    System.out.println(doNotRepeat.get(t) + " задаёт вопрос.");
                    System.out.println(doNotRepeat.get(0) + " отвечает.");
                    System.out.println("_");
                    t++;
                }
                if(t==doNotRepeat.size()){
                    System.out.println("Участники закончились.");
                    break;
                }
            }



            s = sc.nextLine();
        }




        return null;
    }
}
