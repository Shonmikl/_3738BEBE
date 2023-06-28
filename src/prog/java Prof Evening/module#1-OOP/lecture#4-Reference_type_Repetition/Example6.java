/*
Здесь создаем два объекта Book и один присваиваем другому.
Мы изменяем только объект miracle, вместе с ним изменяется и объект pinokkio.
Они указывают на одну и ту же область в памяти, где собственно данные об объекте pinokkio.
 */

public class Example6 {
    public static void main(String[] args) {
        Book pinokkio = new Book("Pinokkio", 1950);
        pinokkio.print();

        Book miracle = pinokkio;
        miracle.setName("Miracle");
        pinokkio.print();
    }
}

class Book {

    private String name;
    private int year;

    public Book(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public void print() {
        System.out.println("Book title: " + name);
    }

    public void setName(String name) {
        this.name = name;
    }
}