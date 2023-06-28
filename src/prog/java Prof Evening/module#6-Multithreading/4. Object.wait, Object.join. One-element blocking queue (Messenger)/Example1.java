public class Example1 {
    public static void main(String[] args) {
        Crossbow crossbow = new Crossbow();
        new Thread(crossbow::fire).start();
        new Thread(crossbow::reload).start();
    }
}

class Crossbow {
    private int arrows = 10;

    // When the arrows end, the wait() method is called and releases.
    synchronized public void fire() {
        for (int idx = arrows; idx >= 0; idx--) {

            if (idx != 0) {
                System.out.println("The arrow is " + (arrows - idx + 1) + " right on the target!");
            } else {
                System.out.println("The arrows are over");
                arrows = 0;
                System.out.println("Count arrows " + arrows);
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Carry a new quiver with arrows!!");
            }
        }
    }

    // reload() brings new arrows, calls the notify() method, which awakens the thread
    synchronized public void reload() {
        System.out.println("New arrows on the way!");
        arrows = 10;
        System.out.println("Count arrows = " + arrows);
        notify();
    }
}