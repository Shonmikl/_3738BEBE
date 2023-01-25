package _25_01_2023.ex;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class FruitBasket {
    private List<Fruit> basket = new ArrayList<>();

    public void add(Fruit fruit) {
        basket.add(fruit);
    }

    public void remove(Fruit fruit) {
        if(!basket.contains(fruit)) {
            throw new NoSuchElementException();
        }
        basket.remove(fruit);
    }

    public int size() {
        return basket.size();
    }

    public void removeAll() {
        basket.clear();
    }
}