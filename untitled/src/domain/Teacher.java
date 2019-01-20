package domain;

import util.Selector;

import java.util.ArrayList;
import java.util.List;

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
            student.setScore(score);
        }
    }
}
