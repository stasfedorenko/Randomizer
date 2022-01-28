package stas.controller;

import stas.entity.Participant;

import java.util.List;
import java.util.Scanner;

public class ProgramGuide {
    public static void run(List<Participant> participants) {

        Scanner sc = new Scanner(System.in);
        String s = "s";
        double point;
        int participantAsking = 0;
        int participantAnswers = 1;
        boolean flagEnd = false;
        System.out.println("Инструкция:\n--------------------------");
        System.out.println("1. По нажатию на Enter программа выводит на экран двух участников (спрашивающий и отвечающий);");
        System.out.println("2. Далее Вы можете оценить данных участников следующим образом:\n" +
                "   При вводе строки \"m\" Вы можете оценить задающего и отвечающего участника;\n" +
                "   При вводе пустой строки оба участника останутся с 0 баллов.");
        System.out.println("3. При вводе строки \"list\" выводится список всех участников с их баллами;");
        System.out.println("4. При вводе строки \"exit\" программа завершается.");

        while (!s.equals("exit")) {
            if (s.equals("") && !flagEnd) {
                if ((participantAnswers) <= participants.size()) {

                    System.out.println(participants.get(participantAsking).getFullName() + " из группы " +
                            participants.get(participantAsking).getIdGroup() + " задаёт вопрос.");
                    System.out.println(participants.get(participantAnswers).getFullName() + " из группы " +
                            participants.get(participantAnswers).getIdGroup() + " отвечает.");

                    System.out.println("Введите \"m\" для оценки участников " +
                            "или нажмите Enter для продолжения опроса: ");
                    s = sc.nextLine();

                    if ("m".equals(s)) {
                        System.out.println("Сколько баллов заработал за вопрос " +
                                participants.get(participantAsking).getFullName());
                        point = sc.nextDouble();
                        participants.get(participantAsking).setPointsQuestion(point);

                        System.out.println("Сколько баллов заработал за ответ " +
                                participants.get(participantAnswers).getFullName());
                        point = sc.nextDouble();
                        participants.get(participantAnswers).setPointsAnswer(point);
                    }

                    System.out.println("_");

                    participantAsking++;
                    participantAnswers++;

                    if (participantAsking - participantAnswers > 1) {
                        System.out.println("Участники закончились.");
                        flagEnd = true;
                    }
                    if (participantAnswers == participants.size()) {
                        participantAnswers = 0;
                    }
                }
            }
            if (s.equals("list")) {
                ShowListParticipant.showParticipants(participants);
            }
            s = sc.nextLine();
        }
    }
}
