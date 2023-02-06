package _06_02_2023.synch;

public class SynchBlock2 {
    volatile static int counter = 0;
    public static void increment() {
        synchronized (SynchBlock2.class) {
            counter++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new M4());
        Thread thread2 = new Thread(new M4());

        thread1.start();
        thread2.start();

        thread1.join();
        thread1.join();
    }
}

class M4 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(i + " ");
        }
    }
}