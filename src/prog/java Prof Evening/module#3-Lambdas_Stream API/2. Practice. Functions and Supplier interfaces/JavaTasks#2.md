# Java Tasks#2 Examples

### Examples:
 - [x] Function examples (simple example)
 - [x] Function examples (chains of functions)
 - [x] Function (andThen vs compose)
 - [x] Function (identity())
 - [x] BiFunction
 - [x] Supplier
 - [x] BooleanSupplier / DoubleSupplier / LongSupplier / **IntSupplier**
 

### Function Example (simple example):
it takes an argument (object of type T) and returns an object (object of type R). The argument and output can be a different type

Simple example:
```java
// JTExample1.java
public class JTExample1 {
    public static void main(String[] args) {
        Function<String, Integer> function = (x) -> x.length();
        System.out.println(function.apply("Java"));
    }
}
```

another simple example:
```java
// JTExample1_5.java
public class JTExample1_5 {
    public static void main(String[] args) {
        Function<Integer, String> func = (x) -> "Element: " + x;

        List<Integer> a = Arrays.asList(1,2,3);

//        так
//        List<String> b = a.stream().map(x -> func.apply(x)).toList();

//        или так, т.к. map() пока не изучали
        List<String> b = new ArrayList<>();

        for (Integer i : a)
            b.add("Element " + i);

        System.out.println(b);
    }
}
```

### Function examples (chains of functions)

```java
// JTExamples2.java
public class JTExample2 {
    public static void main(String[] args) {
        Function<String, Integer> func1 = (x) -> x.length();
        Function<Integer, Integer> func2 = (x) -> x * 2;

        int result = func1.andThen(func2).apply("Java");
        System.out.println(result);
    }
}
```

### Function (andThen vs compose)

simple example of Function in previous Java Tasks examples.

```java
// JTExample3.java
public class JTExample3 {
    public static void main(String[] args) {
        Function<Integer, Integer> multiply2 = (a) -> a * 2;
        Function<Integer, Integer> multiply10 = (a) -> a * 10;
        Function<Integer, Integer> add3 = (a) -> a + 3;
        Function<Integer, Integer> add1 = (a) -> a + 1;

        // (((3 * 2) + 3) + 1) => 10
        Function<Integer, Integer> oneChain = multiply2.andThen(add3).andThen(add1);
        System.out.println(oneChain.apply(3));

        // ((((3 * 10) + 1) + 3) * 2 => 68
        Function<Integer, Integer> twoChain = multiply2.compose(add3).compose(add1).compose(multiply10);
        System.out.println(twoChain.apply(3));
    }
}
```

> #### Задание: 
> Выбрать любую формулу (например сигмоиду) и разбить её на составляющие через Function compose or andThen


### Function (Factorial example)

```java
// Example3_5.java
public class JTExample3_5 {
    public static void main(String[] args) {
        
        // Это блочное лямбда-выражение вычисляет факториал целочисленного значения
        
        Function<Integer, Integer> factorial = (x) -> {
            int result = 1;

            for (int i = 1; i <= x; i++)
                result = result * i;

            return result;
        };

        System.out.println(factorial.apply(5));
    }
}
```

### Function (identity())

```java
// JTExample4.java
public class JTExample4 {
    public static void main(String[] args) {
        Function<Integer, Integer> id = Function.identity();
        System.out.println(id.apply(3));
    }
}
```

### BiFunction Example:

Simple Example:
```java
// JTExample5.java
public class JTExample5 {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> func1 = (x1, x2) -> x1 + x2;
        System.out.println(func1.apply(1,2));

        BiFunction<Integer, Integer, List<Integer>> func2 = (x1, x2) -> Arrays.asList(x1, x2);
        System.out.println(func2.apply(10,123));
    }
}
```

### Supplier

```java
// JTExample6.java
public class JTExample6 {

    private static final String VERSION = "v.1.14.9";

    public static void main(String[] args) {
        Supplier<Double> randomizer = () -> Math.random();

        System.out.println(randomizer.get());
        System.out.println(randomizer.get());
        System.out.println(randomizer.get());
        System.out.println(randomizer.get());


        Supplier<String> version = () -> VERSION;
        System.out.println(version.get());
        System.out.println(version.get());
    }
}
```


### Supplier
In Java 8, Supplier is a functional interface; it takes no arguments and returns a result.

```java
// JTExample7.java
public class JTExample7 {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        Supplier<LocalDateTime> s1 = () -> LocalDateTime.now();
        System.out.println(s1.get());

        Supplier<String> s2 = () -> dtf.format(LocalDateTime.now());
        System.out.println(s2.get());
    }
}
```

### IntSupplier

Simple example:
```java
// JTExample8.java
public class JTExample8 {
    public static void main(String[] args) {
        IntSupplier i = () -> Integer.MAX_VALUE;
        System.out.println(i.getAsInt());
    }
}
```

Complex example with Fibonacci:

```java
// JTExample9.java
public class JTExample9 {
    public static void main(String[] args) {
        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;
            @Override
            public int getAsInt() {
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;

                return this.previous;
            }
        };

        IntStream.generate(fib).limit(10).forEach(x -> System.out.println(x));
    }
}
```

### Создадим свой вариант функционального интерфейса

```java
public class Test {
    public static void main(String[] args) {
        A ttt = (x,y) -> System.out.println(x + " " + y);
        ttt.doIt(10,20);
    }
}

@FunctionalInterface
interface A {
    void doIt(Integer a, Integer b);
}
```

### Самостоятельная работа (есть в лекции Java Tasks):

У вас имеется такое lambda выражение, для подсчёта встречаемости определенного числа в массиве

```java
public class Test {
    public static void main(String[] args) {

        (a, b) -> {
            int count = 0;

            for (int i = 0; i < a.length; i++) {
                if (a[i] == b)
                    ++count;
            }

            return count;

        };
    }
}
```

Создайте один из возможных функциональный интерфейс, удовлетворяющий условию данной lambda-функции и приведите пример использования


Решение:

```java
public class Test {
    public static void main(String[] args) {
        B bbb = (a, b) -> {
            int count = 0;

           for (int i = 0; i < a.length; i++) {
               if (a[i] == b)
                   ++count;
           }

           return count;
       };
        
       System.out.println(bbb.doIt(new int[]{1,2,3,1,2,3,1,1,1}, 1));
    }
}

@FunctionalInterface
interface B {
    int doIt(int[] a, int v);
}
```