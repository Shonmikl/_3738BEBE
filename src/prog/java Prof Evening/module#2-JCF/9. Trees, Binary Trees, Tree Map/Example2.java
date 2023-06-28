import java.util.Comparator;
import java.util.TreeMap;

public class Example2 {
    public static void main(String[] args) {
        TreeMap<Student, Integer> map = new TreeMap<>(new SortByAge());
        map.put(new Student(33, "Aleks"), 33);
        map.put(new Student(19, "Thea"), 19);
        map.put(new Student(23, "Thomas"), 23);

        System.out.println(map);
    }
}

class SortByAge implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();
    }
}

class Student {
    private int age;
    private String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Stident {" + "age=" + age + ", name=" + name + "}";
    }

    public int getAge() {
        return age;
    }
}
