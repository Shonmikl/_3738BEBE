package _25_01_2023.test;

import _25_01_2023.ex.Ex1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Ex1Test {


    @Test
    void sumPositiveNumbers() {
        int a = 5;
        int b = 10;
        int expected = a + b;
        Assertions.assertEquals(expected, Ex1.sum(a, b));
    }
}