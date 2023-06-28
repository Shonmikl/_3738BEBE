/*
Для реализации клонирования класс Book должен имплементить Cloneable
Реализация этого метода просто возвращает вызов метода clone для родительского класса
Метод должен выбрасывать исключение CloneNotSupportedException

!!! данный способ осуществляет неполное копирование и подойдет, если клонируемый объект не содержит сложных объектов !!!
добавим в пример объект Автор
 */

public class Example7 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Book7 pinokkio = new Book7("Pinokkio", 1950);
        Book7 miracle = pinokkio.clone();

        miracle.setName("Miracle");

        pinokkio.print();
    }
}


class Book7 implements Cloneable {
    private String name;
    private int year;

    public Book7(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("Book title: " + name);
    }

    protected Book7 clone() throws CloneNotSupportedException {
        return (Book7)super.clone();
    }
}