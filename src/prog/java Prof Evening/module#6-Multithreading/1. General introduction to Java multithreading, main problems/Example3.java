public class Example3 {
    public static void main(String[] args) {

        new NewThread();

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Глaвный поток: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException е) {
            System.out.println("Глaвный поток прерван.");
            System.out.println("Глaвный поток завершен.");
        }
    }
}

class NewThread implements Runnable {
    Thread t;

    NewThread() {
        t = new Thread(this, "Демонстрационный поток");
        System.out.println("Дoчepний поток создан: " + t);
        t.start();
    }

    // точка входа во второй поток
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Дoчepний поток: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException е) {
            System.out.println("Дoчepний поток прерван.");
            System.out.println("Дoчepний поток завершен.");
        }
    }
}