package _25_01_2023.test;

import _25_01_2023.ex.Fruit;
import _25_01_2023.ex.FruitBasket;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class FruitBasketTest {
    private FruitBasket basket = new FruitBasket();
    private final Fruit apple = new Fruit("Apple", 120);
    private final Fruit orange = new Fruit("Orange", 100);
    private final Fruit pear = new Fruit("Pear", 80);

    @BeforeEach
    public void init() {
        basket.add(apple);
        basket.add(orange);
        basket.add(pear);
    }

    @Test
    void testAdd() {
        basket.add(new Fruit("Test", 1));
        Assertions.assertEquals(4, basket.size(), "Adding one more fruit");
    }

    @Test
    void testRemove() {
        basket.remove(orange);
        Assertions.assertEquals(2, basket.size(), "Removing a fruit from the basket");
    }

    @Test
    void testSize() {
        Assertions.assertEquals(3, basket.size(), "Checking basket's size");
    }

    @Test
    void testRemoveException() {
        Assertions.assertThrows(NoSuchElementException.class,
                () -> basket.remove(new Fruit("Kiwi", 3)), "Removing a fruit from the basket");
    }

    @Test
    void testRemoveAll() {
        basket.removeAll();
        Assertions.assertEquals(0, basket.size(), "Removing all fruits");
    }

    @AfterEach
    public void destroy() {
        basket.removeAll();
    }
}