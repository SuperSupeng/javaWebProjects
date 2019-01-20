package domain;

import util.Selector;

import java.util.ArrayList;
import java.util.List;

/**
 * 教师类
 * 包含：
 *      姓名
 *      等待判卷的学生集合
 *      好老师，坏老师属性（默认为好老师）
 */
public class Teacher {

    private String name;
    private List<Student> students;
    private boolean isGood;

    public Teacher() {
        students  = new ArrayList<>();
        isGood = true;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGood() {
        return isGood;
    }

    public void setGood(boolean good) {
        isGood = good;
    }

    //判断学生答案是否正确
    public void judge(){
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            Selector selector = student.getSelector();
            int score = 0;
            for (int j = 0; j < selector.getNumber(); j++) {
                if (student.getAnswers()[j].equals(selector.getQuestions()[1][j])) {
                    score += 10;
                }
            }
            if (this.isGood != true) {
                score -= 10;
            }
            //将学生最后的总分交给学生
            student.setScore(score);
        }
    }
}
