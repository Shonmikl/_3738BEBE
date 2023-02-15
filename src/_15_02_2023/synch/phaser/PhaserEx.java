package _15_02_2023.synch.phaser;

import java.util.concurrent.Phaser;

public class PhaserEx {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(2);
        new Washer(phaser, "Konstantin");
        new Washer(phaser, "Ivan");

        new Washer(phaser, "Alexey");
        new Washer(phaser, "Raul");

    }

    static class Washer extends Thread {
        Phaser phaser;
        String name;

        public Washer(Phaser phaser, String name) {
            this.phaser = phaser;
            this.name = name;
            phaser.register();
            this.start();
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(2500);
                    Thread.currentThread().setName(name);
                    System.out.println(getName() + " is washing a car... .");
                    phaser.arriveAndDeregister();
                    phaser.arriveAndAwaitAdvance();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}