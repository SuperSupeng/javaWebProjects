package domain;

import util.Selector;

public class Student {
    private String name;
    private String[] answers;
    private Selector selector;
    private int score;

    public Student() {
        selector = Selector.getInstance();
        answers = new String[selector.getNumber()];
    }

    public Selector getSelector() {
        return selector;
    }

    public void setSelector(Selector selector) {
        this.selector = selector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
