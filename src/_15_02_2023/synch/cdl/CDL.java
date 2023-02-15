package _15_02_2023.synch.cdl;

import java.util.concurrent.CountDownLatch;

public class CDL {
    static CountDownLatch countDownLatch = new CountDownLatch(4);

    private static void m1() throws InterruptedException {
        Thread.sleep(2500);
        System.out.println("Убрана квартира");
        countDownLatch.countDown();
        System.out.println("CountDownLatch: " + countDownLatch.getCount());
    }

    private static void m2() throws InterruptedException {
        Thread.sleep(3500);
        System.out.println("Приготовлено покушать");
        countDownLatch.countDown();
        System.out.println("CountDownLatch: " + countDownLatch.getCount());
    }

    private static void m3() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Все готовы к приему гостей");
        countDownLatch.countDown();
        System.out.println("CountDownLatch: " + countDownLatch.getCount());
    }

    public static void main(String[] args) {
        new Friend("Natalia", countDownLatch);
        new Friend("Svitlana", countDownLatch);
        new Friend("Sergey", countDownLatch);
        new Friend("Jelena", countDownLatch);
        new Friend("Pavel", countDownLatch);

        try {
            m1();
            m2();
            m3();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Friend extends Thread {
    String name;
    private CountDownLatch countDownLatch;

    public Friend(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start();
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            System.out.println(name + " пришел в гости");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}