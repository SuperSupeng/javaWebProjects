package menu;

import domain.Student;
import domain.Teacher;
import util.Selector;

import java.util.Scanner;

public class Main {
    /**
     * 1 生成学生类
     * 2 学生填写姓名
     * 3 根据随机抽取的题库进行答题
     * 4 交给老师进行判卷
     * 5 输出该学生得分
     */
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
            //从控制台获得学生的答案，去掉空格，直接转换为大写方便与答案对比
            answers[i] = scanner.next().trim().toUpperCase();
            scanner.nextLine();
        }

        Teacher teacher = new Teacher();
        teacher.addStudent(student);
        teacher.judge();
        System.out.println("姓名：" + student.getName() + "  得分： " + student.getScore());

    }
}
