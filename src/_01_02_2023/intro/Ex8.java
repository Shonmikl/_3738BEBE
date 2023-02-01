package _01_02_2023.intro;

public class Ex8 extends Thread {
    public void run() {
        for (int i = 0; i < 11; i++) {
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread name is: " + Thread.currentThread().getName() + " :" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadRun1());
        Ex8 ex8 = new Ex8();

        thread.setName("THREAD_RUN_1");
        ex8.setName("EX_8");

        thread.start();
        ex8.start();

        thread.join();
        ex8.join(1000);

        System.out.println("MAIN");
    }
}


class ThreadRun1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 11; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread name is: " + Thread.currentThread().getName() + " :" + i);
        }
    }
}