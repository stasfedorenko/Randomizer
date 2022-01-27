package stas.controller;

import stas.entity.Participant;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShowListParticipant {
    public static void showParticipants(List<Participant> list) {
        List<Participant> newList = new ArrayList<>(list);
        newList.sort(Comparator.comparingInt(o -> Integer.parseInt(o.getId())));
        System.out.println(" id  -  name  -  surname  -  idGroup  -  pointsQuestion  -  pointsAnswer  -  pointsOther  - ");
        for (Participant p : newList) {
            System.out.println(
                    " -  id  - " + p.getId() +
                            " -  name  - " + p.getName() +
                            " -  surname  - " + p.getSurname() +
                            " -  idGroup  - " + p.getIdGroup() +
                            " -  pointsQuestion  - " + p.getPointsQuestion() +
                            " -  pointsAnswer  - " + p.getPointsAnswer() +
                            " -  pointsOther  - " + p.getPointsOther());
        }
    }
}
