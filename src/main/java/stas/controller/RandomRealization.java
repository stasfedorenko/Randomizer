package stas.controller;

import stas.entity.Participant;

import java.util.*;

public class RandomRealization {
    public static List<Participant> random(Map<String, Participant> map) {
        List<Participant> doNotRepeat = new ArrayList<>();
        List<Participant> list = new ArrayList<>(map.values());

        int maxCountMemberInGroup = 0;
        int count = 0;
        int maxNumGroup = list.stream().max(Comparator.comparingInt(Participant::getIdGroup)).get().getIdGroup();
        for (int i = 1; i <= maxNumGroup; i++) {
            for (int y = 0; y < list.size(); y++) {
                if (list.get(y).getIdGroup() == i) {
                    count++;
                }
            }
            if (maxCountMemberInGroup < count) {
                maxCountMemberInGroup = count;
            }
            count = 0;
        }

        while (doNotRepeat.size() != list.size()) {
            int check = (int) ((Math.random() * (list.size())));
            if (!doNotRepeat.contains(list.get(check))) {
                if (doNotRepeat.size() >= map.size() - maxCountMemberInGroup) {
                    doNotRepeat.add(list.get(check));
                } else {
                    if ((doNotRepeat.isEmpty())) {
                        doNotRepeat.add(list.get(check));
                    }
                    if ((doNotRepeat.get(doNotRepeat.size() - 1).getIdGroup() != list.get(check).getIdGroup())) {
                        doNotRepeat.add(list.get(check));
                    }
                }
            }
        }


        return doNotRepeat;
    }
}
