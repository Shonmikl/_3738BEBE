package _01_02_2023.intro;

public class Ex9 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main starts");

        Thread thread = new Thread(new Worker());
        System.out.println(thread.getState());

        thread.start();
        System.out.println(thread.getState());

        thread.join();
        System.out.println(thread.getState());

        System.out.println("Main finished");
    }
}

class Worker implements Runnable {

    @Override
    public void run() {
        System.out.println("Worker starts");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Worker finished");
    }
}
