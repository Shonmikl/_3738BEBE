public class Example4 {
    public static void main(String[] args) {
        Thread t = new Thread( () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Sleepy thread");
        });

        t.start();
    }
}
