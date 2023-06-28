public class Example2 {
    public static void main(String[] args) {

        ThreadJoin thread1 = new ThreadJoin();
        ThreadJoin thread2 = new ThreadJoin();
        ThreadJoin thread3 = new ThreadJoin();

        thread1.start();

        // start second thread after waiting for 2 seconds or if it's dead
        try {
            thread1.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();

        // start third thread only when first thread is dead
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread3.start();

        // let all threads finish execution before finishing main thread
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads has been terminated, exiting main thread");
    }
}

class ThreadJoin extends Thread {
    @Override
    public void run() {
        System.out.println("Thread started " + Thread.currentThread().getName());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread ended " + Thread.currentThread().getName());
    }
}