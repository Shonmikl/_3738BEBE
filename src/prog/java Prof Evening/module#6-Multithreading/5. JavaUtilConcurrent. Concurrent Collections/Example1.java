import java.util.concurrent.*;

// пример применения Semaphore в работе небольшого ресторана, в котором всего 5 столиков, но в людей, желающих
// пообедать больше, чем свободных столов

public class Example1 {
    public static void main(String[] args) throws Exception {

        // устанавливая флаг true, Semaphore будет раздавать разрешения в порядке очереди
        Semaphore semaphore = new Semaphore(5, true);

        // свободные столики (5 штук) - по умолчанию создаются с параметром false
        // true - занято, false - свободно
        boolean[] freeTables = new boolean[5];

        // список людей, кто желает пообедать в этом ресторане
        String[] personNames = new String[]{"Roman", "Alena", "Kira", "Anna", "Leo", "Bob", "Vladislav", "Inna"};

        for (int i = 0; i < personNames.length; i++) {
            new Thread(new Person(personNames[i], semaphore, freeTables)).start();
            Thread.sleep(700);
        }

    }
}

class Person implements Runnable {
    private String personName;
    private Semaphore semaphore;
    private boolean[] freeTables;

    public Person(String personName, Semaphore semaphore, boolean[] freeTables) {
        this.personName = personName;
        this.semaphore = semaphore;
        this.freeTables = freeTables;
    }

    @Override
    public void run() {
        System.out.println("-> " + personName + " подошёл в ресторан.");
        try {
            // запрашивается доступ, если доступ не разрешён - поток ожидает разрешения
            semaphore.acquire();
            int parkingNumber = -1;

            synchronized (freeTables) {
                for (int i = 0; i < 5; i++) {
                    if (!freeTables[i]) {

                        // определяем место как занятое
                        freeTables[i] = true;

                        // наличие свободного места гарантирует Semaphore
                        parkingNumber = i;

                        System.out.println("[!] " + personName + " был размещён за столиком #" + (i + 1));
                        break;
                    }
                }
            }

            // время на приготовление ланча и его завершение
            Thread.sleep(5000);

            synchronized (freeTables) {
                freeTables[parkingNumber] = false;
            }

            semaphore.release();
            synchronized (freeTables) {
                System.out.println("<- " + personName + " закончил свой ланч и покинул ресторан");
                System.out.println("[!] столик " + (parkingNumber + 1) + " освободился");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}