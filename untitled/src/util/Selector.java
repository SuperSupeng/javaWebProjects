package util;

import question.GenerateQuestion;

public class Selector {
    private static Selector selector = new Selector();
    private int number = 6;
    String[][] questions = GenerateQuestion.getQuestionsList(number);

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
