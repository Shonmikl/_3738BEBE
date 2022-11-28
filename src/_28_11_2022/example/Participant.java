package _28_11_2022.example;

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