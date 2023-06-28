public class Example6 extends Thread {
    public void run(){
        System.out.println("Hello from java thread!");

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Example6 test = new Example6();
        test.start();

        test.interrupt();
        System.out.println("Interrupted: " + test.isInterrupted());
    }
}
