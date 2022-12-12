package _12_12_2022.hw;

public class MyQueueImpl implements MyQueue{
    //Collection
    //[]
    Object[] array;
    @Override
    public void add(Object el) {
        array[0] = el;
    }
}