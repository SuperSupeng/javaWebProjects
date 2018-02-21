package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo1 {
    public static void main(String[] args){
        ExecutorService pool = Executors.newFixedThreadPool(5);
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());

    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("aaaa");
    }
}
