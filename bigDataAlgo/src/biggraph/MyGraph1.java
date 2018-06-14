package biggraph;

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
            if(!graph.keySet().contains(startRow - 1)){
                Set<Integer> set = new HashSet<>();
                set.add(startCol-1);
                graph.put(startRow - 1, set);
                count++;
            }else{
                Set<Integer> set = graph.get(startRow - 1);
                if(!set.contains(startCol-1)){
                    set.add(startCol-1);
                    graph.put(startRow - 1, set);
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

    public void show() {
        Set<Integer> keySet = graph.keySet();
        System.out.println("from |to");
        for(int i : keySet){
            System.out.print(i + "    |");
            Set<Integer> valueSet = graph.get(i);
            for(int j : valueSet){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        MyGraph1 graph = new MyGraph1();
        graph.show();
    }
}
