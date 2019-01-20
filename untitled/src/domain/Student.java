package domain;

import util.Selector;

/**
 * 学生类
 * 包含：
 *      姓名
 *      答案
 *      从题库选择试题的单例选择器
 *      总分
 */
public class Student {
    private String name;
    private String[] answers;
    private Selector selector;
    private int score;

    public Student() {
        //获取单例模式下的选择器
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
