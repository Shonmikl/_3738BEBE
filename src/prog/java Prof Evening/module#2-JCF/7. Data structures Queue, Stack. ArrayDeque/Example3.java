/*
Интерфейс Deque, представленный в пакете java.util, является подтипом интерфейса Queue.
Deque относится к двусторонней очереди, которая поддерживает добавление или удаление элементов с любого конца
структуры данных.
Его можно использовать либо как очередь (первым пришел, первым ушел/FIFO) , либо как стек (последним пришел – первым
ушел/LIFO).
 */

import java.util.NoSuchElementException;

public class Example3 {
    public static void main(String[] args) {
        MyArrayDeque myArrayDeque = new MyArrayDeque();

        myArrayDeque.addToHead(10);
        myArrayDeque.addToHead(20);
        myArrayDeque.addToHead(30);
        myArrayDeque.addToHead(40);

        System.out.println(myArrayDeque.peekTail());
        myArrayDeque.removeTail();
        System.out.println(myArrayDeque.peekTail());
        myArrayDeque.removeTail();
        System.out.println(myArrayDeque.peekTail());
        myArrayDeque.removeTail();
        System.out.println(myArrayDeque.peekTail());
    }
}

class MyArrayDeque implements MyDeque<Integer> {

    public final int MAX_SIZE = Integer.MAX_VALUE - 5;
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private Integer[] elements;
    private int headIndex;
    private int tailIndex;
    private int numberOfElements;

    public MyArrayDeque() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public MyArrayDeque(int capacity) {
        if (capacity < 1)
            throw new IllegalStateException("Capacity must be 1 or higher");

        elements = new Integer[capacity];
    }

    @Override
    public void addToHead(Integer element) {
        if (numberOfElements == elements.length)
            grow();

        headIndex = decreaseIndex(headIndex);
        elements[headIndex] = element;
        numberOfElements++;
    }

    @Override
    public void addToTail(Integer element) {
        if (numberOfElements == elements.length)
            grow();

        elements[tailIndex] = element;
        tailIndex = increaseIndex(tailIndex);
        numberOfElements++;
    }

    private void grow() {
        int newCapacity = calculateNewCapacity(elements.length);
        growToNewCapacity(newCapacity);
    }

    private int calculateNewCapacity(int currentCapacity) {
        if (currentCapacity == MAX_SIZE) {
            throw new IllegalStateException("Can't grow further");
        }

        int newCapacity = currentCapacity + calculateAdditionalCapacity(currentCapacity);

        if (newCapacity > MAX_SIZE || newCapacity < 0) {
            newCapacity = MAX_SIZE;
        }

        return newCapacity;
    }

    private int calculateAdditionalCapacity(int currentCapacity) {
        return currentCapacity < 255 ? currentCapacity : (int) (currentCapacity / 1.75);
    }

    private void growToNewCapacity(int newCapacity) {
        Integer[] newArray = new Integer[newCapacity];

        int startIndex = elements.length / 2 + 1;
        System.arraycopy(elements, startIndex, newArray, newArray.length / 2 + 1, newArray.length / 2 + tailIndex);

        startIndex = newArray.length / 2 - headIndex - 1;
        if (tailIndex > 0) {
            System.arraycopy(elements, headIndex, newArray, startIndex, newArray.length / 2);
        }

        headIndex = startIndex;
        tailIndex = newArray.length / 2 + tailIndex;
        elements = newArray;
    }

    @Override
    public Integer removHead() {
        Integer element = elementAtHead();
        elements[headIndex] = null;
        headIndex = increaseIndex(headIndex);
        numberOfElements--;
        return element;
    }

    @Override
    public Integer removeTail() {
        Integer element = elementAtTail();
        tailIndex = decreaseIndex(tailIndex);
        elements[tailIndex] = null;
        numberOfElements--;
        return element;
    }

    @Override
    public Integer peekHead() {
        return elementAtHead();
    }

    @Override
    public Integer peekTail() {
        return elementAtTail();
    }

    private Integer elementAtHead() {
        if (isEmpty())
            throw new NoSuchElementException();

        return elements[headIndex];
    }

    private Integer elementAtTail() {
        if (isEmpty())
            throw new NoSuchElementException();

        return elements[decreaseIndex(tailIndex)];
    }

    private int decreaseIndex(int index) {
        index--;
        if (index < 0)
            index = elements.length - 1;

        return index;
    }

    private int increaseIndex(int index) {
        index++;
        if (index == elements.length)
            index = 0;

        return index;
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }
}


interface MyDeque<Integer> {
    void addToHead(Integer element);
    void addToTail(Integer element);
    Integer removHead();
    Integer removeTail();
    Integer peekHead();
    Integer peekTail();
    boolean isEmpty();
}