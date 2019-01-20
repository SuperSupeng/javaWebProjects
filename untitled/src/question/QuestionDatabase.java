package question;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public abstract class QuestionDatabase {
    String[][] questions = null;
    int size;
    String filename;

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
    protected void initQuestions(){
        initSize();
        questions = new String[2][size];

        File file = new File(filename);
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader is = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(is);
            String temp = "";
            int i = 0;
            while ((temp = br.readLine()) != null) {
                String s[] = temp.split(" ");
                questions[0][i] = s[0];
                questions[1][i] = s[1];
                i++;
            }
            br.close();
            is.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //初始化题库大小
    protected void initSize(){
        File file = new File(filename);
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader is = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(is);
            int i = 0;
            while (br.readLine() != null) {
                i++;
            }
            size = i;
            br.close();
            is.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getSize() {
        return size;
    }
}
