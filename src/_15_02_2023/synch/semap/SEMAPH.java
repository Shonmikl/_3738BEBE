package _15_02_2023.synch.semap;

import java.util.concurrent.Semaphore;

public class SEMAPH {
    public static void main(String[] args) {
        Semaphore box = new Semaphore(1);
        new Person("Natalia", box);
        new Person("Svitlana", box);
        new Person("Sergey", box);
        new Person("Jelena", box);
        new Person("Pavel", box);
    }
}

class Person extends Thread{
    String name;
    private Semaphore semaphore;

    public Person(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
        this.start();
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " is waiting for.....");
            semaphore.acquire();
            System.out.println(name + " is using!");
            Thread.sleep(2500);
            System.out.println(name + " finished");
            System.out.println("------------------------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
