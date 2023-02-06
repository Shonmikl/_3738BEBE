package _06_02_2023.waitNotify;

public class WaitNotify {
    public static void main(String[] args) {
        Market market = new Market();
        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);

        thread1.start();
        thread2.start();
    }
}

class Market {
    private int breadCount = 0;
 //   private final Object lock = new Object();

    public synchronized void getBread() {
 //       synchronized (lock) {
            while (breadCount < 1) {
                try {
//                    lock.
                            wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
  //      }
        breadCount--;
        System.out.println("Consumer has got a bread");
        System.out.println("Bread quantity is: " + breadCount);
        notify();
    }

    public synchronized void putBread() {
//        synchronized (lock) {
            while (breadCount >= 5) {
                try {
                    //lock.
                            wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
 //       }
        breadCount++;
        System.out.println("Producer has produced a bread");
        System.out.println("Bread quantity is: " + breadCount);
 //       lock.
                notify();
    }
}

class Producer implements Runnable {
    Market market;

    public Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.putBread();
        }
    }
}

class Consumer implements Runnable {
    Market market;

    public Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.getBread();
        }
    }
}