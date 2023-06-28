import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class Example2 {
    public static void main(String[] args) {
        // PriorityBlockingQueue — это неограниченная, блокирующаяся очередь
        // добавление элементов иногда может завершаться ошибкой из-за исчерпания ресурсов, что приводит к
        // OutOfMemoryError.

        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println(queue);

        // the top element of the PriorityBlockingQueue
        System.out.println(queue.peek());

        // return the top element and removing it from the PriorityBlockingQueue
        System.out.println(queue.poll());

        System.out.println(queue);

    }
}
