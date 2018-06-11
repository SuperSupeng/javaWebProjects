package biggraph;

import java.util.Random;
import java.util.Scanner;

/**
 * @author super
 */
public class MyGraph {
    private int[][] graph;
    private int n;
    private int e;
    private double a=0.5, b = 0.2,c = 0.2, d = 0.1;
    private int count;

    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public MyGraph(){
        System.out.println("input n:");
        n = scanner.nextInt();
        graph = new int[n][n];
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
           if(graph[startRow-1][startCol-1] != 1){
               graph[startRow-1][startCol-1] = 1;
               count++;
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

    public void show(){
        for (int[] aGraph : graph) {
            for (int anAGraph : aGraph) {
                System.out.print(anAGraph + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        MyGraph graph = new MyGraph();
        graph.show();
    }
}
