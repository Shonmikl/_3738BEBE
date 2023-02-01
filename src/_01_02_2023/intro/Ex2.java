package _01_02_2023.intro;

public class Ex2 {
    public static void main(String[] args) {
        ThreadUp threadUp = new ThreadUp();
        ThreadDown threadDown = new ThreadDown();

        threadUp.start();
        threadDown.start();

        System.out.println("***********************************");
    }
}

class ThreadUp extends Thread {
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            System.out.println(i);
        }
    }
}

class ThreadDown extends Thread {
    public void run() {
        for (int i = 1000; i >= 0; i--) {
            System.out.println(i);
        }
    }
}