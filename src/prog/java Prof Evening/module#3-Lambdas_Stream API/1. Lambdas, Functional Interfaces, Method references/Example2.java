import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/*
Функция, которая принимает аргумент и, в свою очередь, генерирует логическое значение в качестве ответа,
называется предикатом.

В языке программирования java предикатный функциональный интерфейс Java — это тип функции, которая принимает одно
значение или аргумент, выполняет какую-то обработку над ним и возвращает логический ответ (True/False)

Predicate имеет некоторые расширения. IntPredicate, DoublePredicate и LongPredicate.
Эти типы функциональных интерфейсов предикатов принимают в качестве аргументов только примитивные типы данных или
значения.

Bi-Predicate является расширением функционального интерфейса Predicate, который вместо одного принимает два
аргумента, выполняет некоторую обработку и возвращает логическое значение.

Синтаксис:
public interface Predicate<T> {  boolean test(T t); }
 */

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

class User {
    private String name, role;

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User Name: " + name + ", Role: " + role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}
