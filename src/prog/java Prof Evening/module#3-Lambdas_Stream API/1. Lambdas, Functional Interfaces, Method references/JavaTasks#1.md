# Java Tasks#1 Examples

### Examples:
 - [x] Consumer
 - [x] **DoubleConsumer** / IntConsumer / LongConsumer
 - [x] BiConsumer
 - [x] Predicate
 - [x] **IntPredicate** / DoublePredicate / LongPredicate
 - [x] BiPredicate


### Consumer Example
In Java 8, Consumer is a functional interface; it takes an argument and returns nothing

Simple example:
```java
// JTExample1.java
public class JTExample1 {
    public static void main(String[] args) {
        Consumer<String> print = (x) -> System.out.println(x);
        print.accept("java");
    }
}
```

High Order Function example:

Аналог forEach, в котором работает вывод в консоль
```java
// JTExample2.java
public class JTExample2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12,13,42,51);

        // implementation of the Consumer's accept methods.
        Consumer<Integer> consumer =  (x) -> System.out.println(x);
        // it can be "Consumer<Integer> consumer =  (Integer x) -> System.out.println(x);"
        
        analogForEach(list, consumer);

    }

    // it can be "public static <T> void forEach(List<T> list, Consumer<T> consumer)"
    public static void analogForEach(List<Integer> list, Consumer<Integer> consumer) {

        // it can be "for (T t : list)"
        for (Integer t : list)
            consumer.accept(t);
    }
}
```

High Order Function example, put consumer as argument:
Аналог forEach, в котором работает вывод в консоль длины элемента String

```java
// JTExample3.java
public class JTExample3 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Roman", "Alexey", "Denis", "Yaroslav");
        analogForEach(list, (x) -> System.out.println(x.length()));
    }

    public static void analogForEach(List<String> list, Consumer<String> consumer) {
        for (String s : list)
            consumer.accept(s);
    }
}
```

### DoubleConsumer Example
```java
// JTExample4.java
public class JTExample4 {
    public static void main(String[] args) {
        DoubleConsumer consumer = a -> System.out.println(a * 10);
        consumer.accept(50);
    }
}
```

### BiConsumer Example
```java
// Example5.java
public class JTExample5 {
    public static void main(String[] args) {
        BiConsumer<Integer, Integer> biConsumer = (x, y) -> System.out.println(x + y);
        biConsumer.accept(10,20);
    }
}
```

### Predicate Example
In Java 8, Predicate is a functional interface, which accepts an argument and returns a boolean. Usually, it used to apply in a filter for a collection of objects.

Complex example with Predicate and with two Predicates (and / or using):

```java
public class JTExample6 {

    static List<Integer> list = Arrays.asList(1,2,3,10,11,12,31,32,33);

    public static void main(String[] args) {
        usingFiler();
        usingPredicate();
        usingPredicateAndMethod();
        usingPredicateOrMethod();
    }

    public static void usingFiler() {

        List<Integer> list_result = list.stream().filter(x -> x > 5).collect(Collectors.toList());

        System.out.println(list_result);
    }

    public static void usingPredicate() {
        Predicate<Integer> predicate = (x) -> x > 5;

        List<Integer> list_result = list.stream().filter(predicate).collect(Collectors.toList());
        System.out.println(list_result);
    }

    public static void usingPredicateAndMethod() {
        Predicate<Integer> predicateMore5 = (x) -> x > 5;
        Predicate<Integer> predicateLess30 = (x) -> x < 30;

        List<Integer> list_result = list.stream().filter(predicateMore5.and(predicateLess30)).toList();
        System.out.println(list_result);
    }

    public static void usingPredicateOrMethod() {
        Predicate<Integer> predicateMore12 = (x) -> x > 11;
        Predicate<Integer> predicateEquals10 = (x) -> x == 10;

        List<Integer> list_result = list.stream().filter(predicateMore12.or(predicateEquals10)).toList();
        System.out.println(list_result);
    }
}
```

### IntPredicate Example:

```java
// JTExample7.java
public class JTExample7 {
    public static void main(String[] args) {
        IntPredicate predicate = (x) -> x > 10;
        List<Integer> list = Arrays.asList(11,5,20,4,18);

        for (Integer k : list)
            System.out.println(predicate.test(k));

        // or use
//        List<Integer> list_result = IntStream.of(11,5,20,4,18).filter(predicate).boxed().toList();
//        System.out.println(list_result);
    }
}
```

### BiPredicate Example:
If the String length matches the provided length?

```java
// JTExample8.java
public class JTExample8 {
    public static void main(String[] args) {
        BiPredicate<String, Integer> predicate = (x, y) -> x.length() == y;

        System.out.println(predicate.test("Roman", 5));
        System.out.println(predicate.test("Earth", 10));
    }
}
```

more complex example, bi-predicate as an argument in function. Filtering FootBall teams:
```java
// JTExample9.java
public class JTExample9 {
    public static void main(String[] args) {
        List<FootballTeam> footballTeamList = new ArrayList<>();

        footballTeamList.add(new FootballTeam("Essen", 7));
        footballTeamList.add(new FootballTeam("Dusseldorf", 6));
        footballTeamList.add(new FootballTeam("Dortmund", 9));
        footballTeamList.add(new FootballTeam("Cologne", 7));
        footballTeamList.add(new FootballTeam("Wuppertal", 6));

        BiPredicate<String, Integer> biPredicate = (team, power) -> {
            return (team.equalsIgnoreCase("Dusseldorf") || power == 7);
        };

        List<FootballTeam> result1 = customFilter(footballTeamList, biPredicate);
        result1.forEach(x -> System.out.print(x.getName() + " " + x.getPower() + "; "));

        System.out.println();

        List<FootballTeam> result2 = customFilter(footballTeamList, (team, power) -> power == 6);
        result2.forEach(x -> System.out.print(x.getName() + " " + x.getPower() + "; "));
    }

    public static List<FootballTeam> customFilter(List<FootballTeam> list, BiPredicate<String, Integer> biPredicate) {
        return list.stream().filter(x -> biPredicate.test(x.getName(), x.getPower())).toList();
    }
}

class FootballTeam {
    private String name;
    private Integer power;

    public FootballTeam(String name, Integer score) {
        this.name = name;
        this.power = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }
}
```