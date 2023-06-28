public class Example2 {

    private String name;
    private int age;

    // Вариант 1: в метод equals передали тот же самый объект, у которого вызвали метод equals.
    // Если ссылки у текущего и переданного объектов равны, возвращаем true.
    public boolean equals(Object obj) {

        boolean result = false;

        if (this == obj)
            result = true;

        return result;
    }

    // Вариант 2: в метод equals передали ссылку null — сравнивать не с чем.
    // Объект, у которого вызвали метод equals, точно не null, возвращаем false.
    public boolean equalsAnother(Object obj) {

        boolean result = false;

        if (this == obj)
            result = true;

        if (obj == null)
            result = false;

        return result;
    }

    // вариант 3: в метод equals передали ссылку на объект вообще не класса Cat, возвращаем false.
    public boolean equalsAnotherOne(Object obj) {

        boolean result = false;

        if (this == obj)
            result = true;

        if (obj == null)
            result = false;

        if (!(obj instanceof Person2))
            result = false;

        return result;
    }

    // вариант 4: проверили и убедились выше, что наш объект это Cat
    // преобразовываем его к типу Cat и будем сравнивать внутренности обоих объектов
    // Объекты будут равны, если равно их содержимое
    public boolean equalsAnotherOneCat(Object obj) {

        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (!(obj instanceof Person2))
            return false;

        Cat cat = (Cat) obj;

        return this.name == cat.name && this.age == cat.age;
        // Note -> можно спросить о том все ли верно тут, потому что name это String

        // Ответ:
        //поле name имеет тип String, а значит, поля name нужно сравнивать с помощью вызова метода equals
        //поле name вполне себе может быть равным null: тогда вызвать метод equals у него нельзя, проверка на null
        //если name равно null в обоих Котах, имена равны
    }
}

class Person2 {

}

class Cat2 {
    private String name;
    private int age;


}