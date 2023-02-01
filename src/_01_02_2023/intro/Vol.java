package _01_02_2023.intro;

public class Vol extends Thread {
    volatile boolean b = true;

    public void run() {
        long counter = 0;
        while (b) {
            counter++;
        }
        System.out.println("Counter: " + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        Vol vol = new Vol();
        vol.start();
        Thread.sleep(1000);
        System.out.println("Wake up");
        vol.b = false;
        vol.join();
        System.out.println("Main end");
    }
}