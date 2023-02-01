package _01_02_2023.dataRace;

public class Ex10 {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);
        Thread thread3 = new Thread(myRunnable);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Counter {
    static int count = 0;
}

class MyRunnable implements Runnable {
    public void increment() {
        Counter.count++;
        System.out.println("Counter: " + Counter.count);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            increment();
        }
    }
}