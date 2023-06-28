public class Example5 extends Thread {
    public void run(){

        System.out.println("Hello from java thread!");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        Example5 test = new Example5();
        test.start();

        test.interrupt();
        System.out.println("Interrupted: " + test.isInterrupted());
    }
}
