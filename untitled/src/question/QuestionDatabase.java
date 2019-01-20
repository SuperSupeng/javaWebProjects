package question;

import java.util.HashSet;
import java.util.Set;

public abstract class QuestionDatabase {
    String[][] questions = null;
    int size;

    //获得题目
    public String[][] getQuestions(int n){
        String[][] results = new String[2][n];
        initQuestions();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int random = (int)(Math.random()*size);
            while (set.contains(random)) {
                random = (int)(Math.random()*size);
            }
            set.add(random);
            results[0][i] = questions[0][random];
            results[1][i] = questions[1][random];
        }
        return results;
    }

    //初始化题库内容
    protected abstract void initQuestions();

    //初始化题库大小
    protected abstract void initSize();
}
