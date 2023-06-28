public class Example3 {
    public static void main(String[] args) throws Exception {

        Object monitor = new Object();

        NewThread thread1 = new NewThread(1);
        NewThread thread2 = new NewThread(2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

class NewThread extends Thread {

    Object monitor;

    long num;

    NewThread(long num, Object monitor) {
        this.num = num;
        this.monitor = monitor;
    }

    NewThread(long num) {
        this.num = num;
        monitor = new Object();
    }

    @Override
    public void run() {
        synchronized (monitor) {
            System.out.println(num + " Захватил монитор. Ожидание");
            try {
                Thread.sleep(2000);
                System.out.println(num + " Подождал");
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}