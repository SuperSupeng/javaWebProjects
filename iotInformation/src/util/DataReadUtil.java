package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author super
 */
public class DataReadUtil {

    private static void readAndSave() throws Exception{
        File file = new File("src\\1901.txt");
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String s = null;

        File outFile = new File("src\\out.txt");
        FileOutputStream fos = new FileOutputStream(outFile);
        OutputStreamWriter osw = new OutputStreamWriter(fos);

        while((s = br.readLine()) != null){
            String a = s.substring(15,23);
            String b = s.substring(87,92);
            int flag = 0;
            if(b.startsWith("-")){
                flag = 1;
            }
            b = b.substring(1);
            String v = Integer.parseInt(b)+"";
            if(flag == 1){
                v = "-" + v;
            }
            osw.write("(" + a.substring(0,4)+","+a.substring(4,6)+","+a.substring(6,8)+","+v+")"+"\r\n");
        }
        osw.close();
        fos.close();
        br.close();
        isr.close();
        fis.close();
    }

    public static String getDataPath(){
        try {
            readAndSave();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "src\\out.txt";
    }
}
