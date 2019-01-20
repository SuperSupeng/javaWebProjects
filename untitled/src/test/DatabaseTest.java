package test;

import org.junit.Test;
import question.GenerateQuestion;
import question.NatureQuestionDatabase;
import question.QuestionDatabase;

public class DatabaseTest {

    @Test
    public void testDatabase(){
        QuestionDatabase database = new NatureQuestionDatabase();
        String[][] data = database.getQuestions(3);
        for (int i = 0; i < 3; i++) {
            System.out.print(data[0][i]);
            System.out.println(" " + data[1][i]);
        }
        System.out.println(database.getSize());
    }

    @Test
    public void testGenerateDatabase(){
        String[][] data = GenerateQuestion.getQuestionsList(5);
        for (int i = 0; i < 5; i++) {
            System.out.print(data[0][i]);
            System.out.println(" " + data[1][i]);
        }
    }
}
