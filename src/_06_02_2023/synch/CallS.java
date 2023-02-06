package _06_02_2023.synch;

public class CallS {
    static final Object LOCK = new Object();

    public static void main(String[] args) {

        Thread mob = new Thread(new Mobile1());
        Thread skype = new Thread(new Skype1());
        Thread zoom = new Thread(new Zoom1());

        mob.setName("[MOBILE THREAD]");
        skype.setName("[SKYPE THREAD]");
        zoom.setName("[ZOOM THREAD]");

        mob.start();
        skype.start();
        zoom.start();
    }

    void mobileCall() throws InterruptedException {
        synchronized (LOCK) {
            System.out.println(LOCK);
            System.out.println("Mobile call starts " + Thread.currentThread().getName());
            System.out.println("Mobile call finished " + Thread.currentThread().getName());
        }
    }

    void skypeCall() throws InterruptedException {
        synchronized (LOCK) {
            System.out.println(LOCK);
            System.out.println("Skype call starts " + Thread.currentThread().getName());
            System.out.println("Skype call finished " + Thread.currentThread().getName());
        }
    }

    void zoomCall() throws InterruptedException {
        synchronized (LOCK) {
            System.out.println(LOCK);
            System.out.println("Zoom call starts " + Thread.currentThread().getName());
            System.out.println("Zoom call finished " + Thread.currentThread().getName());
        }
    }
}

class Mobile1 implements Runnable {

    @Override
    public void run() {
        try {
            new Call().mobileCall();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Skype1 implements Runnable {

    @Override
    public void run() {
        try {
            new Call().skypeCall();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Zoom1 implements Runnable {

    @Override
    public void run() {
        try {
            new Call().zoomCall();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
