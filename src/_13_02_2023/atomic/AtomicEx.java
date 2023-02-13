package _13_02_2023.atomic;

import java.util.concurrent.atomic.AtomicInteger;

//todo
public class AtomicEx {
    static AtomicInteger counter = new AtomicInteger(0);
    public synchronized static void increment() {
//        counter++;
        System.out.println(counter.addAndGet(5));
    }

    public static void main(String[] args) throws InterruptedException {
        M11 m11 = new M11();

        Thread t1 = new Thread(m11);
        Thread t2 = new Thread(m11);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

class M11 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 22; i++) {
            AtomicEx.increment();
        }
    }
}