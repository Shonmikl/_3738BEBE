package _01_02_2023.dataRace;


public class Ex11 {
    static int counter = 0;

    public synchronized static void increment() {
        counter++;
        System.out.println(counter);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new M());
        Thread thread2 = new Thread(new M());
        Thread thread3 = new Thread(new M());

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("[ " + counter + " ]");
    }
}

class M implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            try {
                Thread.sleep(3);
                Ex11.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}