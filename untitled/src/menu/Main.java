package menu;

import domain.Student;
import util.Selector;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);
        Selector selector = student.getSelector();
        String[] answers = student.getAnswers();
        System.out.println("请输入姓名: ");
        student.setName(scanner.next());
        scanner.nextLine();

        for (int i = 0; i < selector.getNumber(); i++) {
            System.out.println(selector.getQuestions()[0][i]);
            answers[i] = scanner.next().trim();
            scanner.nextLine();
        }

    }
}
