/*
Данный способ осуществляет неполное копирование и подойдет, если клонируемый объект не содержит сложных объектов !!!
Добавим в пример объект Автор

Переменные pinokkio и miracle будут указывать на разные объекты в памяти, но эти объекты при этом будут указывать на
один объект Author.
Нам необходимо выполнить полное копирование, для этого надо определить метод клонирования у класса Author
 */

public class Example8 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Book8 pinokkio = new Book8("Pinokkio", new Author("Collodi"));
        Book8 miracle = pinokkio.clone();

        miracle.getAuthor().setName("Tolstoy");
        System.out.println(miracle.getAuthor());
        System.out.println(pinokkio.getAuthor());

    }
}

class Book8 implements Cloneable {
    private String name;
    private Author author;

    public Book8(String name, Author author) {
        this.name = name;
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void print() {
        System.out.println("Book title: " + name);
    }

    protected Book8 clone() throws CloneNotSupportedException {
        return (Book8)super.clone();
    }
}

class Author {
    private String name;

    public Author(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}