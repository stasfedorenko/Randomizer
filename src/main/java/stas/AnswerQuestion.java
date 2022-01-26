package stas;

import java.util.List;
import java.util.Scanner;

public class AnswerQuestion {
    public static void run(List<Participant> participants){
        Scanner sc = new Scanner(System.in);
        String s = "s";
        int t = 0;
        System.out.println("Нажмите Enter");
        while (!s.equals("exit")) {
            if (s.equals("")) {
                if ((t + 1) < participants.size()) {
                    System.out.println(participants.get(t).getName() + " задаёт вопрос.");
                    System.out.println(participants.get(t + 1).getName() + " отвечает.");
                    System.out.println("_");
                    System.out.println("Нажмите Enter");
                    t++;
                } else if ((t + 1) == participants.size()) {
                    System.out.println(participants.get(t).getName() + " задаёт вопрос.");
                    System.out.println(participants.get(0).getName() + " отвечает.");
                    System.out.println("_");
                    System.out.println("Нажмите Enter");
                    t++;
                }
                if (t == participants.size()) {
                    System.out.println("Участники закончились.");
                    break;
                }
            }
            s = sc.nextLine();

        }
    }
}
