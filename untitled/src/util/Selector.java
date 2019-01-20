package util;

import question.GenerateQuestion;

/**
 * 单例模式的选择器
 * 选择器在题库中提取出相应的试卷，提供给学生作答
 * 默认题目数量为6个
 */
public class Selector {
    private static Selector selector = new Selector();
    private int number = 6;
    private String[][] questions = GenerateQuestion.getQuestionsList(number);

    private Selector() {
    }

    public static Selector getInstance() {
        return selector;
    }

    public String[][] getQuestions() {
        return questions;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
