# Lambdas, Functional Interfaces, Method references

> #### LectureNote
> На выбор, что сначала или функциональные интерфейсы, или лямбды.
> 
> Как рекомендация, начать с интерфейсов и после первого, объяснить, что такое лямбда-выражения.
Код примера и слайд в презентации представлены после функциональных интерфейсов

---

### FunctionalInterface
 - Наличие 1 абстрактного метода - это единственное условие для функционального интерфейса
 - Эти интерфейсы также известны как Single Abstract Method interfaces (SAM interfaces)
 - К функциональному интерфейсу необходимо объявить аннотацию @FunctionalInterface.
Это не обязательно, но при наличии данной аннотации код не скомпилируется, если будет больше или меньше, чем 1 абстрактный метод.
- Рекомендуется добавлять @FunctionalInterface. 
Это позволит использовать интерфейс в лямбда выражениях, не остерегаясь того, что кто-то добавит в интерфейс новый абстрактный метод и он перестанет быть функциональным.

---

> #### LectureNote
> Продемонстрировать примеры других функциональных интерфейсов с аннотацией и без нее

- Runnable. Есть аннотация @FunctionalInterface. Этот интерфейс содержит только метод run();
- Comparable. Нет аннотации. Этот интерфейс содержит только метод compareTo();
- ActionListener. Нет аннотации. Этот интерфейс содержит только метод actionPerformed();
- Callable. Есть аннотация @FunctionalInterface. Этот интерфейс содержит только метод call().

---

### Consumer
 - Принимает только один аргумент;
 - Интерфейс не имеет возвращаемого значения. Ничего не возвращает; 
 - Существуют также функциональные варианты Consumer как DoubleConsumer, IntConsumer и LongConsumer. Эти варианты принимают примитивные значения в качестве аргументов; 
 - Bi-Consumer — вариант интерфейса Consumer - принимает два аргумента. Bi-Consumer не имеет возвращаемого значения.

> #### LectureNote
> Зайти в интерфейс и показать, после написать и объяснить пример, лямбды это следующий слайд, можно прыгнуть туда и объяснить, а можно пока остановиться только на интерфейсе.

```java
// Example1.java
public class Example1 {
    public static void main(String[] args) {
        // Consumer to display a number
        Consumer<Integer> display = System.out::println;

        // Implement display using accept()
        display.accept(10);

        // Consumer to multiply 2 to every integer of a list
        Consumer<List<Integer>> modify = list -> list.replaceAll(integer -> 2 * integer);

        // Consumer to display a list of numbers
        Consumer<List<Integer>> displayList = list -> list.forEach(a -> System.out.print(a + " "));

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);

        // Implement modify using accept()
        modify.accept(list);

        // Implement displayList using accept()
        displayList.accept(list);
    }
}
```

---

### Predicate

 - Функция, которая принимает аргумент и, в свою очередь, генерирует логическое значение в качестве ответа, называется предикатом;
 - В языке программирования java предикатный функциональный интерфейс Java — это тип функции, которая принимает одно значение или аргумент, выполняет какую-то обработку над ним и возвращает логический ответ (True/False);
 - Predicate имеет некоторые расширения. IntPredicate, DoublePredicate и LongPredicate. Эти типы функциональных интерфейсов предикатов принимают в качестве аргументов только примитивные типы данных или значения;
 - Bi-Predicate является расширением функционального интерфейса Predicate, который вместо одного принимает два аргумента, выполняет некоторую обработку и возвращает логическое значение.

> #### LectureNote
> Аналогично Consumer.
> 
> Зайти в интерфейс и показать, после написать и объяснить пример, лямбды это следующий слайд, можно прыгнуть туда и объяснить, а можно пока остановиться только на интерфейсе.

```java
// Example2.java
class User {

    private String name, role;

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String toString() {
        return "User Name : " + name + ", Role :" + role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}

public class Example2 {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("Aleks", "admin"));
        users.add(new User("Thea", "member"));

        List<User> admins = process(users, (User user) -> user.getRole().equals("admin"));

        System.out.println(admins);
    }

    public static List<User> process(List<User> users, Predicate<User> predicate) {
        List<User> result = new ArrayList<>();

        for (User user : users) {
            if (predicate.test(user))
                result.add(user);
        }

        return result;
    }
}
```

---
### Function

 - Function — это тип функционального интерфейса в Java, который получает только один аргумент и возвращает значение после необходимой обработки; 
 - Bi-Function — принимает два аргумента.

```java
// Example3.java
public class Example3 {
    public static void main(String[] args) {
        // Function which takes in a number and returns half of it
        Function<Integer, Double> half = (a) -> a / 2.0;

        // Applying the function to get the result
        System.out.println(half.apply(8));
    }
}
```

---
### Supplier
 - Supplier не принимает никаких входных данных или аргументов и при этом возвращает один выходной тип; 
 - Обычно используется при ленивой генерации значений или для определения логики генерации любой последовательности; 
 - Например, логика ряда Фибоначчи может быть сгенерирована с помощью метода Stream.generate, который реализуется функциональным интерфейсом поставщика; 
 - Расширения функционального интерфейса BooleanSupplier, DoubleSupplier, LongSupplier и IntSupplier;
 - Возвращаемый тип всех этих дополнительных специализаций — это только их соответствующие примитивы.

```java
// Example4.java
public class Example4 {
    public static void main(String[] args) {

        // This function returns a random value.
        Supplier<Double> randomValue = () -> Math.random();

        // Print the random value using get()
        System.out.println(randomValue.get());
    }
}
```

---
### Lambdas
 - Начиная с Java 8, лямбда-выражения можно использовать для представления экземпляра функционального интерфейса;
 - Лямбда-выражения похожи на функции и принимают параметры точно так же, как и функции;
 - Лямбда-выражения также можно использовать и с кастомными функциональными интерфейсами.

```java
// Example5.java
public class Example5 {
    public static void main(String[] args) {
        ArrayList<Integer> arrL = new ArrayList<>();

        arrL.add(1);
        arrL.add(2);
        arrL.add(3);
        arrL.add(4);
        arrL.add(5);

        arrL.forEach(n -> System.out.print(n + " "));

        System.out.println();

        arrL.forEach(n -> {
            if (n % 2 == 0)
                System.out.print(n + " ");
        });
    }
}
```

---
### Custom interface and lambdas

```java
// Example6.java
public class Example6 {
    public static void main(String[] args) {
        MyFuncInterface add = (int x, int y) -> x + y;
        MyFuncInterface multiply = (int x, int y) -> x * y;

        System.out.println("Addition: " + add.operate(2,3, add));
        System.out.println("Multiplying: " + multiply.operate(2,3, multiply));
    }
}

@FunctionalInterface
interface MyFuncInterface {
    int operation(int x, int y);

    default int operate(int x, int y, MyFuncInterface myFuncInterface) {
        return myFuncInterface.operation(x,y);
    }
}
```
