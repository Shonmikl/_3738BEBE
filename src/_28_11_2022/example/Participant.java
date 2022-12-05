package _28_11_2022.example;

/**
 * This class responsible for
 * Хранит такие то поля
 * Хранит метода для
 */
public abstract class Participant {
    private String name;
    private int age;

    League league;

    public Participant(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }
}