import java.util.*;

// Пример сортировки по одному полю

public class Example3 {
    public static void main(String[] args) {
        Person3 one = new Person3(1990, null, "Roman");
        Person3 two = new Person3(1991, null, "Tom");
        Person3 three = new Person3(1992, null, "Bob");

        ArrayList<Person3> list1 = new ArrayList<>();

        list1.add(two);
        list1.add(three);
        list1.add(one);

        System.out.println("original: " + list1);

        list1.sort(new SortByName()); // or Collections.sort(list1, new SortByName());
        System.out.println("sorted by name: " + list1);

        System.out.println("original: " + list1);

        list1.sort(new CustomingSortingComparator());
        System.out.println("multiple sorted: " + list1);
    }
}

class Person3 {
    private final int year;
    private final Address address;
    private final String name;

    public Person3(int year, Address address, String name) {
        this.year = year;
        this.address = address;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person {year=" + year + ", name=" + name + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Person3 person3 = (Person3) o;
        return year == person3.year && address.equals(person3.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, address);
    }


    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}

class Address {

}

class SortByYear implements Comparator<Person3> {
    @Override
    public int compare(Person3 o1, Person3 o2) {
        return o1.getYear() - o2.getYear();
    }
}

class SortByName implements Comparator<Person3> {
    @Override
    public int compare(Person3 o1, Person3 o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

// Сортировка коллекции по более чем одному полю
class CustomingSortingComparator implements Comparator<Person3> {
    @Override
    public int compare(Person3 o1, Person3 o2) {

        int nameCompare = o1.getName().compareTo(o2.getName());
        int yearCompare = o1.getYear() - o2.getYear();

        return nameCompare == 0 ? yearCompare : nameCompare;
    }

    // Note -> Можно организовать сравнение не только по двум полям.
}