package _01_02_2023.intro;

public class Ex3 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ThreadUpRun());
        Thread thread2 = new Thread(new ThreadDownRun());

        thread1.start();
        thread2.start();

        System.out.println("/////////////////////");

    }
}

class ThreadUpRun implements Runnable {
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            System.out.println(i);
        }
    }
}

class ThreadDownRun implements Runnable {
    public void run() {
        for (int i = 1000; i >= 0; i--) {
            System.out.println(i);
        }
    }
}