package util;

import java.io.*;

/**
 * @author super
 */
public class CounterReaderUtil {

    public static String readCount(String path){
        try {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String result = br.readLine();
            br.close();
            isr.close();
            fis.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0";
    }

    public static void saveCount(String s, String path){
        try {
            File file = new File(path);
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            osw.write(s);
            osw.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
