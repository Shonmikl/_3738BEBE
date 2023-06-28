// Запуск такого кода подразумевает демонстрацию как работают потоки
// в консоли мы увидим более-менее неплохое разделение по потокам, вначале один, после второй
// но нет гарантий по смешиванию, потоки могут смешиваться (можно увеличить счётчик в fori для демонстрации)
// помимо этого счётчик работает как бы сквозным образом
// например вывод может быть таким:
// Thread-1: 1
// Thread-1: 2
// Thread-1: 3
// Thread-1: 4
// Thread-1: 5
// Thread-0: 1
// Thread-0: 6
// Thread-0: 7
// Thread-0: 8
// Thread-0: 9

// но при добавлении зарезервированного слова synchronized и видим результат:
// Thread-0: 1
// Thread-0: 2
// Thread-0: 3
// Thread-0: 4
// Thread-0: 5
// Thread-1: 1
// Thread-1: 2
// Thread-1: 3
// Thread-1: 4
// Thread-1: 5

// разделение по потокам, у каждого потока свой счётчик, нет сквозного счётчика


public class Example2 {

    static int counter;

    public static void main(String[] args)  throws Exception{

        Runnable runnable = new Runnable() {
            @Override
            public void run() {  // после меняем на public synchronized void run() {
                // либо можно добавить в код synchronized(this) { в этом случае this - монитор синхронизации, поток захватывает монитор
                counter = 0;
                for (int i = 0; i < 5; i++) {
                    counter += 1;
                    System.out.println(Thread.currentThread().getName() + ": " + counter);
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
