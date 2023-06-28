Лучшие материалы по уже имеющимся интерфейсам: https://javarush.com/groups/posts/2866-funkcionaljhnihe-interfeysih-v-java

## Более детально разбираем интерфейсы

> #### LectureNote
> 
> Перейти в интерфейс, указать на методы внутри, объяснить в чем разница между ними, далее live codding, НЕ КОПИПАСТИМ!

### Function применение
```java
public class A {
    public static void main(String[] args) {
        Function<Double, Long> function = aDouble -> Math.round(aDouble);
        System.out.println(function.apply(3.6));
    }
}
```

> #### LectureNote
> Обязательно спросить: всем ли понятно, как отработал код и что тут произошло? Объяснить!
> 
> Если возник вопрос что это - <? super R, ? extends V> - можно остановиться и детально объяснить 
> 
> PECS -> "Producer Extends, Consumer Super"
> 
> «Producer Extends» — если вам нужно List для создания T значений (вы хотите прочитать Ts из списка), вам нужно объявить его с помощью ? extends T, например List<? extends Integer>.
> 
> «Consumer Super» — если вам нужно List потреблять T значения (вы хотите записать Ts в список), вам нужно объявить его с помощью ? super T, например, List<? super Integer>. Но нет никаких гарантий, какой тип объекта вы сможете прочитать из этого списка.
>
> Если вам нужно как читать, так и записывать в список, вам нужно объявить его точно без подстановочных знаков, например List<Integer>.
> 
> ```java
> public class Collections { 
>   public static <T> void copy(List<? super T> dest, List<? extends T> src) {
>     for (int i = 0; i < src.size(); i++) 
>       dest.set(i, src.get(i)); 
>   } 
> }
> ```
> **Темы "джинериков" у группы еще не было**, поэтому может быть сложно для понимания, 
как рекомендация - сконцентрироваться на понимании интерфейсов.

---

Смотрим разницу между дифолт методами

```java
// Example2.java
public class Example2 {
    public static void main(String[] args) {
        Function<String, String> function1 = s -> s + "1";
        Function<String, String> function2 = s -> s + "2";
        Function<String, String> function3 = s -> s + "3";
        Function<String, String> function4 = s -> s + "4";
        
        System.out.println(function1.andThen(function2).compose(function3).compose(function4).apply(" -> Compose "));
        System.out.println(function1.andThen(function2).andThen(function3).andThen(function4).apply(" -> AndThen "));
    }
}
```

---

Статический метод интерфейса Function: identity()
Возвращает интерфейс Function, который всегда возвращает входной параметр

```java
// Example3.java
public class Example3 {
    public static void main(String[] args) {
        Function<String, String> function = Function.identity();
        System.out.println(function.apply("Some Value"));
    }
}
```

---

### Supplier применение

> #### LectureNote
> Перейти в интерфейс, посмотреть на метод, обсудить, задать вопросы

```java
// Example4.java
public class Example4 {
    public static void main(String[] args) {
        String str = "String";
        Supplier<String> supplierStr = () -> str.toUpperCase();
        System.out.println(supplierStr.get());
    }
}
```

Одно из основных применений этого интерфейса это использование для включения отложенного выполнения. 
Это означает отсрочку выполнения до тех пор, пока оно не понадобится. 
Например, в классе Optional есть метод orElseGet. Этот метод срабатывает, если у option нет данных.

> #### LectureNote 
> **Optional** - это новое для группы, можно коротко рассказать, для понимания. Класс Optional, представленный в Java 8. Цель класса — предоставить решение на уровне типа для представления необязательных значений вместо null ссылок.

```java
// Example5.java
public class Example5 {
    public static void main(String[] args) {
        Supplier<Double> supplier = () -> Math.random();
        Optional<Double> optional = Optional.empty();
        System.out.println(optional.orElseGet(supplier));
    }
}
```

### Практика

Метод получает на вход запрос с двумя полями (строкой и числом) и возвращает отформатированную строку с переданными данными.

```java
// Example6.java
public class Example6 {
    public static void main(String[] args) {

        // С помощью класса Handler
        // Handler a = new Handler();
        // String result = a.apply(new Request("all ok", 123));
        // System.out.println(result);

        // уже известными способами
        Function<Request, String> func = (s) -> "Message is " + s.getMessage() + ", number is " + s.getNumber();
        System.out.println(func.apply(new Request("Hello, my age is ", 45)));
    }
}

class Request {
    private String message;
    private int number;

    public Request(String message, int number) {
        this.message = message;
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
```

```java
// Example6.java
class Handler implements Function<Request, String> {
    @Override
    public String apply(Request request) {
        return String.format("Message is %s, number is %d",
                request.getMessage(),
                request.getNumber());
    }
}
```

---

### Самостоятельная по парам: 10-15 минут (разделить в Зум по классрумам)

Используя соответственный примитивный интерфейс Supplier получить рандом значения и вывести их в консоль.

решение:

```java
// Example7.java
public class Example7 {
    public static void main(String[] args) {
        Random random = new Random();

        IntSupplier intSupplier = () -> random.nextInt();
        DoubleSupplier doubleSupplier = () -> random.nextDouble();
        LongSupplier longSupplier = () -> random.nextLong();
        BooleanSupplier booleanSupplier = () -> random.nextBoolean();

        System.out.println(intSupplier.getAsInt());
        System.out.println(doubleSupplier.getAsDouble());
        System.out.println(longSupplier.getAsLong());
        System.out.println(booleanSupplier.getAsBoolean());
    }
}
```



### Практика, если осталось время

Можно дать любую практику на фанк интер
Как пример и для повторения Enum

Вернуть правильный Http code из промежутка.

```java
// Example8.java
enum HttpCodes {
    INFORMATIONAL(100, 199, (code, d) -> System.out.println("http code: " + code + ": " + d)),
    SUCCESS(200, 299, (code,d) -> System.out.println("http code: " + code + ": " + d)),
    REDIRECTION(300, 399, (code, d) -> System.out.println("http code: " + code + ": " + d)),
    CLIENT_ERROR(400, 499, (code, d) -> System.out.println("http code: " + code + ": " + d)),
    SERVER_ERROR(500, 599, (code, d) -> System.out.println("http code: " + code + ": " + d));

    final int minCode;
    final int maxCode;
    final Action deistvie;

    HttpCodes(int minCode, int maxCode, Action action) {
        this.minCode = minCode;
        this.maxCode = maxCode;
        this.deistvie = action;
    }

    public static void findValueByCode(int code) {
        for (HttpCodes v: HttpCodes.values()) {
            if (ValueRange.of(v.minCode, v.maxCode).isValidIntValue(code))
                v.doIt(code, v);
        }
    }

    public void doIt(int code, HttpCodes v) {
        if (deistvie != null)
            deistvie.action(code, v);
    }
}


@FunctionalInterface
interface Action {
    void action(int code, HttpCodes d);
}


public class Example8 {
    public static void main(String[] args) {
        HttpCodes.findValueByCode(101);
        HttpCodes.findValueByCode(202);
        HttpCodes.findValueByCode(303);
        HttpCodes.findValueByCode(404);
        HttpCodes.findValueByCode(505);
    }
}
```


