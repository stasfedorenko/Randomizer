package stas;

import java.util.*;

public class RandomRealization {
    public static void random(Map<String, Participant> map) {
        List<Participant> doNotRepeat = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String s = "s";
        int t = 0;
        int maxCountMemberInGroup = 0;
        int count = 0;

        System.out.println("Нажмите Enter");
        for (int i = 1; i <= map.size(); i++) {
            if (count == 0) {
                count++;
            } else if (map.get(Integer.toString(i)).getIdGroup() == map.get(Integer.toString(i - 1)).getIdGroup()) {
                count++;
            } else {
                if (maxCountMemberInGroup < count) {
                    maxCountMemberInGroup = count;
                }
                count = 1;
            }
            if (i == map.size() && (maxCountMemberInGroup < count)) {
                maxCountMemberInGroup = count;
            }
        }

        while (doNotRepeat.size() != map.size()) {
            String check = Integer.toString((int) ((Math.random() * (map.size())) + 1));
            if (!doNotRepeat.contains(map.get(check))) {
                if (doNotRepeat.size() >= map.size() - maxCountMemberInGroup) {
                    doNotRepeat.add(map.get(check));
                } else {
                    if((doNotRepeat.isEmpty())){
                        doNotRepeat.add(map.get(check));
                    }
                    if ((doNotRepeat.get(doNotRepeat.size() - 1).getIdGroup() != map.get(check).getIdGroup())) {
                        doNotRepeat.add(map.get(check));
                    }
                }
            }
        }

        while (!s.equals("exit")) {
            if (s.equals("")) {
                if ((t + 1) < doNotRepeat.size()) {
                    System.out.println(doNotRepeat.get(t).getName() + " задаёт вопрос.");
                    System.out.println(doNotRepeat.get(t + 1).getName() + " отвечает.");
                    System.out.println("_");
                    System.out.println("Нажмите Enter");
                    t++;
                } else if ((t + 1) == doNotRepeat.size()) {
                    System.out.println(doNotRepeat.get(t).getName() + " задаёт вопрос.");
                    System.out.println(doNotRepeat.get(0).getName() + " отвечает.");
                    System.out.println("_");
                    System.out.println("Нажмите Enter");
                    t++;
                }
                if (t == doNotRepeat.size()) {
                    System.out.println("Участники закончились.");
                    break;
                }
            }
            s = sc.nextLine();

        }
    }
}
