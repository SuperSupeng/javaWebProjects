package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo2 implements Runnable {
    private int count;
    private int amount = 1;

    public Demo2(){
        count = 100;
    }

    public Demo2(int count){
        this.count = count;
    }


    @Override
    public void run() {
        for(int i = 0; i<count; i++){
            amount = amount+1;
        }
    }

    public static void main(String[] args){
        ExecutorService pool = Executors.newCachedThreadPool();
        Demo2 demo2 = new Demo2();
        for(int i = 0; i<100; i++){
            pool.execute(demo2);
        }
        pool.shutdown();
        try{
            Thread.sleep(60);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(demo2.amount);
    }
}
