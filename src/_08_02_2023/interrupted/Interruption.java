package _08_02_2023.interrupted;

public class Interruption {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Start");

        InterruptedThread T1 = new InterruptedThread();
        T1.start();
        System.out.println(T1.getState());
        Thread.sleep(1500);
        System.out.println(T1.getState());
        T1.interrupt();
        System.out.println(T1.getState());

        T1.join();
        System.out.println("Main end");
    }
}

class InterruptedThread extends Thread {
    double sqrtSum = 0;

    @Override
    public void run() {
        for (int i = 1; i <= 1_0; i++) {
            if(isInterrupted()) {
                System.out.println("Has been interrupted");
                return;
            }
            sqrtSum += Math.sqrt(i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Current thread T1 " +
                        "was interrupted while sleeping");
                return;
            } finally {
                System.out.println("SQRT: " + sqrtSum);
            }
        }
    }
}