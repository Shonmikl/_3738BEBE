# Stream API

Stream использует функциональный стиль при работе с разными структурами данных

> #### LectureNote
> 
> Напомнить что такое функциональное программирование
>
> **Первый, важный момент**. Функциональное программирование предполагает обходиться вычислением результатов функций от исходных данных и результатов
других функций, и не предполагает явного хранения состояния программы. 
> 
> **Второй, важный момент**. Функциональное программирование не предполагает изменяемость этого состояния, в отличие от
императивного, где одной из базовых концепций является переменная, хранящая своё значение и позволяющая менять его по
мере выполнения алгоритма.

---

Простой пример для демонстрации

Найти сумму нечетных чисел в коллекции.

```java
// Example1.java
public class Example1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);

        int result = 0;

        for (Integer i : list) {
            if (i % 2 != 0)
                result += 1;
        }

        System.out.println(result);

        // functional way
        int result2 = list.stream().filter(p -> p % 2 != 0).reduce((c1, c2) -> c1 + c2).orElse(0);
        System.out.println(result2);

        // functional way using reference
        int result3 = list.stream().filter(p -> p % 2 != 0).reduce(Integer::sum).orElse(0);
        System.out.println(result3);
    }
}
```

---

### Разбираемся в операциях.

### Конвеерные

> #### LectureNote
> Идём по операциям на слайде и показываем в коде.

```java
// Example2.java
public class Example2 {
    public static void main(String[] args) {
        List<String> c = Arrays.asList("10", "20", "1", "10", "15", "50", "25");

        System.out.println("Original: " + c);

        // filter & count
        long result = c.stream().filter(p -> p.equals("10")).count();
        System.out.println("Result of filtering and counting: " + result);

        // sorted
        List<String> result2 = c.stream().sorted().collect(Collectors.toList());
        System.out.println("Result of sorting: " + result2);

        // sorted & limit
        List<String> result3 = c.stream().sorted().limit(3).collect(Collectors.toList());
        System.out.println("Result of sorting and limit(3): " + result3);

        // sorted & skip
        List<String> result4 = c.stream().sorted().skip(3).collect(Collectors.toList());
        System.out.println("Result of sorting and skip(3): " + result4);

        // distinct
        List<String> result5 = c.stream().distinct().collect(Collectors.toList());
        System.out.println("Result of distinct: " + result5);

        // actions via peek()
        System.out.print("Result of peek() mathod: ");
        c.stream().peek( (e) -> System.out.print(e + " hello; ")).collect(Collectors.toList());

        System.out.println();

        // map example1
        System.out.print("Result of map() mathod: ");
        c.stream().map( x -> x + " times").forEach(q -> System.out.print(q + " "));

        System.out.println();

        // map example2
        int[] q = new int[]{1,2,3,4,5};
        int[] qq = Arrays.stream(q).map(x -> x + 10).toArray();
        System.out.println("Result of map example2: " + Arrays.toString(qq));

        // mapToInt
        int[] result6 = c.stream().mapToInt(x -> Integer.parseInt(x)).toArray();
        System.out.println("Result of mapToInt() method: " + Arrays.toString(result6));

        // flatmap (как бы распаковка коллекции или работа с элементами элементов коллекции)
        ArrayList<List<Integer>> l1 = new ArrayList<>();

        ArrayList<Integer> one = new ArrayList<>();
        one.add(1);
        one.add(2);
        one.add(3);

        ArrayList<Integer> two = new ArrayList<>();
        two.add(4);
        two.add(5);
        two.add(6);

        l1.add(one);
        l1.add(two);

        System.out.print("Result of flatmap method: ");
        l1.stream()
                .flatMap(x -> x.stream())
                .map(x -> x * 2)
                .forEach( x -> System.out.print(x + " "));
        System.out.println();

        // flatmap example2
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4,5,6);
        List<Integer> list3 = Arrays.asList(7,8,9);

        List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);
        List<Integer> listOfAllIntegers = listOfLists
                .stream()
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
        System.out.println("Result of example2 for flatmap method: " + listOfAllIntegers);

    }
}
```

---

### Терминальные (Example3.java)

> #### LectureNote
> Идём по операциям на слайде и показываем в коде.

```java
// Example3.java
public class Example3 {
    public static void main(String[] args) {
        List<String> coll_str = Arrays.asList("10", "20", "100", "10", "15", "50", "25");
        List<Integer> coll_int = Arrays.asList(1,2,3,4,5);

        // find first
        System.out.println("GetFirst result: " + coll_str.stream().findFirst().orElse("0"));

        //collect
        System.out.println("Collect.toSet() result: " + coll_str.stream().collect(Collectors.toSet()));

        // count
        System.out.println("Count result: " + coll_str.stream().count());

        // anyMatch
//        System.out.println(coll_str.stream().anyMatch("10"::equals));
        System.out.println("anyMatch() result: " + coll_str.stream().anyMatch(x -> x.equals("10")));

        // allMatch
        System.out.println("allMatch() result: " + coll_str.stream().allMatch(x -> x.equals("10")));

        // min for str
        System.out.println("Result of min for col_str: " + coll_str
                .stream()
                .min((s, anotherString) -> s.compareTo(anotherString)));

        // min for int
        System.out.println("Result of min for col_int: " + coll_int
                .stream()
                .min((x,y) -> x.compareTo(y)));

        // foreach применит функцию ко всем элементам, но порядок выполнения гарантировать не может
        System.out.print("Result of foreach(): ");
        coll_str.stream().forEach(p -> System.out.print(p + " "));
        System.out.println();

        // toArray
        String[] qwe = coll_str.stream().toArray(String[]::new);
        System.out.println("Result of toArray(): " + Arrays.toString(qwe));

        //reduce преобразует все элементы в один объект
        System.out.println("Result of reduce: " + coll_str.stream().reduce((c1, c2) -> c1 + " " +c2));

        // reduce with int
        System.out.println("Result of reduce with int: " + coll_int.stream().reduce((a,b) -> (a + b)));
    }
}

```

---
### Немного практики для закрепления

```java
// Example4.java
public class Example4 {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(2, 3, 4, 5);

        List<Integer> square = number.stream().map(x -> x * x).collect(Collectors.toList());
        System.out.println(square);

        List<String> names = Arrays.asList("Java", "Collection", "Stream", "Array");
        List<String> result = names.stream().filter(s -> s.startsWith("S")).collect(Collectors.toList());
        System.out.println(result);

        result = names.stream().sorted().collect(Collectors.toList());
        System.out.println(result);

        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 2);
        Set<Integer> squareSet = numbers.stream().map(x -> x * x).collect(Collectors.toSet());
        System.out.println(squareSet);

        System.out.print("Map result: ");
        number.stream().map(x -> x * x).forEach(x -> System.out.print(x + " "));
        System.out.println();

        int even = number.stream().filter(x -> x % 2 == 0).reduce(0, (ans, i) -> ans + i);
        // или тоже самое, но по-другому
        // int even = number.stream().filter(x -> x % 2 == 0).reduce((ans, i) -> (ans + i)).stream().mapToInt(Integer::intValue).sum();
        System.out.println(even);
    }
}
```

---

### Подробнее о collect 
Позволяет гибко управлять преобразованием значений в разные типы: коллекции, массивы, map. 
Делается это благодаря статистическим методам Collectors

 - toList — стрим приводится к списку;
 - toCollection — получаем коллекцию;
 - toSet — получаем множество;
 - toConcurrentMap, toMap — если нужен map;
 - summingInt, summingDouble, summingLong — если требуется получить сумму чисел;
 - averagingInt, averagingDouble, averagingLong — если хотите вернуть среднее значение;
 - groupingBy — если необходимо разбить коллекцию на части.

---
### Потоки могут быть последовательными и параллельными. 

> #### LectureNote
> Чуть более подробно
> 
> Первые выполняются в текущем потоке, вторые используют общий пул ForkJoinPool.commonPool(). 
> 
> В параллельном стриме элементы разделяются на группы. Их обработка проходит в каждом потоке по отдельности. 
Затем они снова объединяются, чтобы вывести результат. 
С помощью методов parallel и sequential можно явно указать, что нужно сделать параллельным, а что — последовательным.

 - isParallel	скажет, параллельный стрим или нет
 - parallel	сделает стрим параллельным или вернет сам себя
 - sequential	сделает стрим последовательным или вернет сам себя

---

### Самостоятельная - делим группу на пары. 15-20 минут

1. Дан лист строк "BigBen", "BigBob", "Big", "Ben", "Big Bob". сколько раз объект «Big» встречается в коллекции

        Arrays.asList("BigBen", "BigBob", "Big", "Ben", "Big Bob");

        решение:
        
        Example5.java (one)
        list.stream().filter("Big"::equals).count();


2. Найти самый маленький элемент: Arrays.asList("a1", "b5", "a2", "b4")

        решение
        Example5.java (two)
        list.stream().min(String::compareTo).get();

---

### Если осталось время на практику

1. Выполнить сортировку в обратном алфавитном порядке и удалить дубликаты.

        // Example5.java (three)
        прямой порядок
        List<String> list = Arrays.asList("a1", "b5", "c1", "a2", "b4", "c1", "a1");
        List<String> stringList = list.stream().sorted(String::compareTo).distinct().collect(Collectors.toList());
        System.out.println(stringList);

        // Example5.java (four)
        обратный порядок
        List<String> stringList = list.stream().sorted((o1, o2) -> -o1.compareTo(o2)).distinct().collect(Collectors.toList());
        System.out.println(stringList);

> #### LectureNote 
> Можно напомнить, что возвращает compareTo метод.


