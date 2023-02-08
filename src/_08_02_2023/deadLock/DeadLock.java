package _08_02_2023.deadLock;

public class DeadLock {
    public static final Object LOCK_1 = new Object();
    public static final Object LOCK_2 = new Object();

    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();

        t1.setName(":T1:");
        t2.setName(":T2:");

        t1.start();
        t2.start();
    }
}

class T1 extends Thread {

    @Override
    public void run() {
        System.out.println(":T1: Try to catch LOCK_1");
        synchronized (DeadLock.LOCK_1) {
            System.out.println("****:T1: Monitor LOCK_1 was caught****");
            System.out.println(":T1: Try to catch LOCK_2"); //-------------------------------------------
            synchronized (DeadLock.LOCK_2) {
                System.out.println("****:T1: Monitors LOCK_2 and LOCK_1 were caught****");
            }
        }
    }
}

class T2 extends Thread {

    @Override
    public void run() {
        System.out.println(":T2: Try to catch LOCK_2");
        synchronized (DeadLock.LOCK_2) {
            System.out.println("****:T2: Monitor LOCK_2 was caught****");
            System.out.println(":T2: Try to catch LOCK_1"); //-----------------------------------------------
            synchronized (DeadLock.LOCK_1) {
                System.out.println("****:T2: Monitors LOCK_2 and LOCK_1 were caught****");
            }
        }
    }
}