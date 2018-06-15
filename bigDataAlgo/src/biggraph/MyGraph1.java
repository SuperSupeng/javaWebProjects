package biggraph;

import java.io.*;
import java.util.*;

/**
 * @author super
 */
public class MyGraph1 {
    private Map<Integer, Set<Integer>> graph = null;
    private int n;
    private int e;
    private double a=0.5, b = 0.2,c = 0.2, d = 0.1;
    private int count;

    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public MyGraph1(){
        System.out.println("input n:");
        n = scanner.nextInt();
        graph = new HashMap<>();
        System.out.println("input e:");
        e = scanner.nextInt();
        createThrGraph();
    }

    private double getRandom(){
        return random.nextDouble();
    }

    private void create(int startRow, int endRow, int startCol, int endCol){
        double v = getRandom();
        if(startCol == endCol && startRow == endRow){
            if(!graph.keySet().contains(startCol - 1)){
                Set<Integer> set = new HashSet<>();
                set.add(startRow-1);
                graph.put(startCol - 1, set);
                count++;
            }else{
                Set<Integer> set = graph.get(startCol - 1);
                if(!set.contains(startRow-1)){
                    set.add(startRow-1);
                    graph.put(startCol - 1, set);
                    count++;
                }
            }
        }else{
            if(v <= a){
                create(startRow,(startRow + endRow)/2, startCol, (startCol + endCol)/2);
            }else if(v <= a+b){
                create(startRow, (startRow + endRow)/2, (startCol + endCol)/2, endCol);
            }else if(v <= a+b+c){
                create((startRow + endRow)/2, endRow, startCol, (startCol + endCol)/2);
            }else{
                create((startRow + endRow)/2, endRow, (startCol + endCol)/2, endCol);
            }
        }
    }

    private void createThrGraph(){
        while(count < e){
            create(1,n, 1, n);
        }
    }

    public void show() throws IOException {
        File file = new File("output.txt");
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fos);

        Set<Integer> keySet = graph.keySet();
        System.out.println("----------");
        for(int i : keySet){
            System.out.print(i + "\t");
            osw.write(i + "\t");
            Set<Integer> valueSet = graph.get(i);
            System.out.print(valueSet.size() + "\t");
            osw.write(valueSet.size() + "\t");
            for(int j : valueSet){
                System.out.print(j + ",");
                osw.write(j + ",");
            }
            System.out.println();
            osw.write("\r\n");
        }

        osw.close();
        fos.close();
    }

    public static void main(String[] args){
        MyGraph1 graph = new MyGraph1();
        try {
            graph.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
