package threadPool;


import java.util.concurrent.atomic.AtomicInteger;

public class Demo3 {
    public static int count = 0;
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static  volatile int countValue = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        count++;
                        atomicInteger.getAndIncrement();
                        countValue++;
                    }
                }
            }.start();
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("static count: " + count);
        System.out.println("AtomicInteger: " + atomicInteger.intValue());
        System.out.println("countVolatile: " + countValue);
    }
}
