import java.util.concurrent.CyclicBarrier;

// пример применения CyclicBarrier
// представим, что у нас есть фуникулер, который поднимает людей на вершину холма, он может перевести
// ограниченное количество людей, например 2
// люди приходят на платформу, но фуникулер перевозит только двоих, мы фиксируем это в консоли
// в конечном итоге каждый челвоек будет находиться на вершине холма с помощью нашего фуникулера
// ((CyclicBarrier'а)

public class Example3 {
    public static void main(String[] args) throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Funicular());

        // список людей, кто желает забраться на вершину горы
        String[] personNames = new String[]{"Roman", "Alena", "Kira", "Anna", "Leo", "Bob", "Vladislav", "Inna"};

        for (int i = 0; i < personNames.length; i++) {
            new Thread(new PersonOnFunicular(personNames[i], cyclicBarrier)).start();
            Thread.sleep(400);
        }
    }
}

class Funicular implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println("Funicular took some people and is going to the top of hill");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class PersonOnFunicular implements Runnable {

    private String personName;
    private CyclicBarrier cyclicBarrier;

    public PersonOnFunicular(String personName, CyclicBarrier cyclicBarrier) {
        this.personName = personName;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println("-> " + personName + " in waiting on platform");
            cyclicBarrier.await();
            System.out.println("<- " + personName + " on the top");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}