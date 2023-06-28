# Java Streams. Practice. Flat map. Collectors

### flatMap practice

> #### LectureNote
> В качестве примера flatMapToInt()

// Example1.java (method one):

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {17, 13, 15}, {7, 9, 23}};
 
        int[] newArr = Arrays.stream(arr)
            .flatMapToInt(Arrays::stream) // преобразовываем IntStream<int[]> в IntStream, можно написать через ляибду
            .toArray(); 	              // преобразовываем IntStream в int[]
 
        System.out.println(Arrays.toString(newArr));
    }

---
### Самостоятельная

    String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

Отфильтровать "a" (исключить из печати) и распечатать все символы.

Решение (Example1.java (method two)):

    public static void main(String[] args) {

        String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        List<String> collect = Stream.of(array)       // создали Stream<String[]>
          .flatMap(Stream::of)                        // преобразовали в Stream<String>
          .filter(x -> !"a".equals(x))                // отфильтровали "a"
          .collect(Collectors.toList());              // вернули как лист

        collect.forEach(System.out::println);
    }

### Practice

Студент записывает книги которые прочитал, задача вывести все прочитанные книги у всех студентов (в качестве
дополнения, применить фильтр на любую тему)

> #### LectureNote
> Вспомним про Set (можно задать вопрос)

```java
// Example2.java
class Student {
    private int id;
    private String name;
    private Set<String> book;

    public void addBook(String book) {
        if (this.book == null)
            this.book = new HashSet<>();

        this.book.add(book);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getBook() {
        return book;
    }

    public void setBook(Set<String> book) {
        this.book = book;
    }
}
```

```java
// Example2.java
public class Example2 {
    
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("Aleks");
        student1.addBook("Java 8 vs Java 19");
        student1.addBook("Spring Boot in Action");
        student1.addBook("Effective Java");

        Student student2 = new Student();
        student2.setName("Thomas");
        student2.addBook("HTML introducing");
        student2.addBook("Effective Java");

        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);

        Set<String> result = 
                list.stream()                       //  Stream<Set<String>>
                .map(x -> x.getBook())              //  Stream<String>
                .flatMap(x -> x.stream())           //  filter HTML book
                .filter(x -> !x.contains("HTML"))   //  remove duplicated
                .collect(Collectors.toSet());       

        System.out.println(result);
    }
}
```

### Collectors

```java
// Example3.java
class Item {
    
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
```

```java
// Example3.java
public class Example3 {
    public static void main(String[] args) {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("New", 33.5));
        itemList.add(new Item("City", 14));
        itemList.add(new Item("Window", 13));
        itemList.add(new Item("Phone", 43));
        itemList.add(new Item("Milk", 15));
        itemList.add(new Item("Bun", 1));
        itemList.add(new Item("Table", 30));
        itemList.add(new Item("Sun", 11));
        itemList.add(new Item("Door", 14));
        itemList.add(new Item("Paper", 43));
        itemList.add(new Item("Phone", 31));


        System.out.println(itemList.stream()
                .filter(x -> x.getPrice() > 10)
                .map(x -> x.getName())
//                .collect(Collectors.toList())); // we have double Phone
                .collect(Collectors.toSet())); // we don't have duplicates
    }
}
```

---

### Самостоятельная

    String[][] array = new String[][]{{"Hello", "world"}, {"Hello", "Java"}, {"Hello", "student"}, {"Welcome", "to", "Tel-Ran"}};

Посчитать общее количество слов (дополнительно, посчитать только не повторяющиеся слова)

```java
// Example4.java
public class Example4 {
    public static void main(String[] args) {
        String[][] array = new String[][]{
                {"Hello", "world"}, {"Hello", "Java"}, {"Hello", "student"}, {"Welcome", "to", "Tel-Ran"}
        };

        // решение
        long count = Arrays.stream(array)
                .flatMap(x -> Arrays.stream(x))
                .count();

        System.out.println(count);

        long count2 = Arrays.stream(array)
                .flatMap(x -> Arrays.stream(x))
                .distinct()
                .count();

        System.out.println(count2);
    }
}
```

### IntStream range and rangeClosed

        IntStream range = IntStream.range(1, 10);
        int[] ints = range.toArray();
        System.out.println(Arrays.toString(ints));

        IntStream range1 = IntStream.rangeClosed(1,10);
        System.out.println(Arrays.toString(range1.toArray()));

### Primitive Stream to array

        Stream<Integer> aaa = Stream.of(1,2,3);
        int[] ints1 = aaa.mapToInt(x -> x).toArray();

### String Stream to array

        Stream<String> aaa = Stream.of("1","2","3");
        String[] bbb = aaa.toArray(x -> new String[x]);

        System.out.println(Arrays.toString(bbb));

### IntStream to array:

        IntStream aaa = IntStream.of(1,2,3);
        int[] aaaa = aaa.toArray();

### Stream iterate with step:

        Stream<Integer> aaa = Stream.iterate(200, x -> x + 5);
        System.out.println(aaa.takeWhile(a -> a <250).toList());

### Stream concat:

        Stream<Integer> aaa = Arrays.asList(1,2,3).stream();
        Stream<Integer> bbb = Arrays.asList(40,50,60,70).stream();

        System.out.println(Stream.concat(aaa, bbb).toList());

---

### Самостоятельная на повторение

```java
// Example5.java
class Employee {
    private String name, staff;
    private double salary;

    public Employee(String name, String staff, double salary) {
        this.name = name;
        this.staff = staff;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getStaff() {
        return staff;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name +  " is CEO, salary=" + salary;
    }
}

public class Example5 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
    
        employees.add(new Employee("Aleks", "Developer", 1500));
        employees.add(new Employee("Thomas", "Manager", 680.50));
        employees.add(new Employee("Thea", "CEO", 2000));
        employees.add(new Employee("Mary", "Manager", 700));
        employees.add(new Employee("Ken", "Developer", 900));
    
        List<Employee> employeesNoCEO = employees
                .stream()
                .filter(x -> !"CEO".equals(x.getStaff()))
                .toList();
    
        System.out.println(employeesNoCEO);
    
        List<Employee> employeesDevOnly = employees
                .stream()
                .filter(x -> !"CEO".equals(x.getStaff()))
                .filter(x -> !"Manager".equals(x.getStaff()))
                .toList();
    
        System.out.println(employeesDevOnly);
    
    }
}
```