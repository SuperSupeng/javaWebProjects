package question;

import java.io.*;

public class NatureQuestionDatabase extends QuestionDatabase {


    @Override
    public void initQuestions() {
        initSize();
        System.out.println("size:" + size);
        questions = new String[2][size];

        File file = new File("nature.txt");
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

    @Override
    protected void initSize() {
        File file = new File("nature.txt");
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

}
