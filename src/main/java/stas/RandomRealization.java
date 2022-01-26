package stas;

import java.util.*;

public class RandomRealization {
    public static List<Participant> random(Map<String, Participant> map) {
        List<Participant> doNotRepeat = new ArrayList<>();

        int maxCountMemberInGroup = 0;
        int count = 0;


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


        return doNotRepeat;
    }
}
