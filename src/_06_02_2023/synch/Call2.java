package _06_02_2023.synch;

public class Call2 {
    static final Object LOCK = new Object();

    public static void main(String[] args) {
        Thread mob = new Thread(new Mobile());
        Thread zoom = new Thread(new Skype());
        Thread skype = new Thread(new Zoom());

        mob.setName("[MOBILE T]");
        zoom.setName("[ZOOM T]");
        skype.setName("[SKYPE T]");

        mob.start();
        zoom.start();
        skype.start();
    }

    void mobileCall() throws InterruptedException {
        synchronized (this) {
            System.out.println("Mobile call starts" + " | " + Thread.currentThread().getName());
            Thread.sleep(1500);
            System.out.println("Mobile call finished" + " | " + Thread.currentThread().getName());
        }
    }

    void skypeCall() throws InterruptedException {
        synchronized (this) {
            System.out.println("Skype call starts" + " | " + Thread.currentThread().getName());
            Thread.sleep(2500);
            System.out.println("Skype call finished" + " | " + Thread.currentThread().getName());
        }
    }

    void zoomCall() throws InterruptedException {
        synchronized (this) {
            System.out.println("Zoom call starts" + " | " + Thread.currentThread().getName());
            Thread.sleep(3500);
            System.out.println("Zoom call finished" + " | " + Thread.currentThread().getName());
        }
    }
}

class Mobile implements Runnable {
    @Override
    public void run() {
        try {
            new Call().mobileCall();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Skype implements Runnable {
    @Override
    public void run() {
        try {
            new Call().skypeCall();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Zoom implements Runnable {
    @Override
    public void run() {
        try {
            new Call().zoomCall();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}