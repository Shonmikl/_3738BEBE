package _01_02_2023.intro;

public class Ex6 implements Runnable {
    @Override
    public void run() {
        Thread.currentThread().setName("EX6-THREAD");
        System.out.println("Thread name is: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Ex6());
        thread.start();

        System.out.println("Main: " + Thread.currentThread().getName());
    }
}
