package _08_02_2023.tp1;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TP1 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("MAIN START");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //ExecutorService executorService = Executors.newSingleThreadPool();

        executorService.submit(()-> Thread.currentThread().setName("TEST NAME_1"));
        executorService.submit(()-> Thread.currentThread().setName("TEST NAME_2"));
        executorService.submit(()-> Thread.currentThread().setName("TEST NAME_3"));
        executorService.submit(()-> Thread.currentThread().setName("TEST NAME_4"));
        executorService.submit(()-> Thread.currentThread().setName("TEST NAME_5"));
        for (int i = 0; i < 15; i++) {
            executorService.execute((new Run()));
        }
        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("MAIN END");
    }
}

class Run implements Runnable {

    @Override
    public void run() {
        System.out.println("THREAD NAME --> " + Thread.currentThread().getName() + " :: begin");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("THREAD NAME --> " + Thread.currentThread().getName() + " :: end");
    }
}