public class Example2 {
    public static void main(String[] args) {
        Runnable r = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello world!");
        };

        Thread t = new Thread(r);

        t.start();
    }
}
