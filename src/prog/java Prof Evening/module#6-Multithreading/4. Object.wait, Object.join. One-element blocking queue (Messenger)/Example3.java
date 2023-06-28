import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Example3 {
    public static void main(String[] args) {
        // Creating BlockingQueue of size 10
        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        // starting producer to produce messages in queue
        new Thread(producer).start();

        // starting consumer to consume messages from queue
        new Thread(consumer).start();

        System.out.println("Producer and Consumer has been started");

    }
}

class Message {

    private final String msg;

    public Message(String str) {
        this.msg = str;
    }

    public String getMsg() {
        return msg;
    }
}

class Producer implements Runnable {

    private final BlockingQueue<Message> queue;

    public Producer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        // produce messages
        for (int idx = 0; idx < 50; idx++) {
            Message msg = new Message("" + idx);
            try {
                Thread.sleep(idx * 100);
                queue.put(msg);
                System.out.println("Produced " + msg.getMsg());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // adding exit message
        Message msg = new Message("exit");
        try {
            queue.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {

    private final BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Message msg;
            Thread.sleep(10000);
            // consuming messages until exit message is received
            while (!(msg = queue.take()).getMsg().equals("exit")) {
                System.out.println("Consumed " + msg.getMsg());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}