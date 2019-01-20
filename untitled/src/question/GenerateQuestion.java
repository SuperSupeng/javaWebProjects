package question;

public class GenerateQuestion {
    public static String[][] getQuestionsList(int n){
        String[][] questions = new String[2][n];
        QuestionDatabase database = new NatureQuestionDatabase();
        String[][] natureQuestions = database.getQuestions(n / 2);
        int i = 0;
        for (i = 0; i < (n / 2); i++) {
            questions[0][i] = natureQuestions[0][i];
            questions[1][i] = natureQuestions[1][i];
        }
        database = new AnimalQuestionDatabase();
        String[][] animalQuestion = database.getQuestions((n - (n / 2)));
        for (int j = 0; i < n; i++, j++) {
            questions[0][i] = animalQuestion[0][j];
            questions[1][i] = animalQuestion[1][j];
        }
        return questions;
    }
}
