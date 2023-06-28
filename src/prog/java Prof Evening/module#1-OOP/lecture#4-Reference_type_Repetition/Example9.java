/*
переменные pinokkio и miracle будут указывать на разные объекты в памяти, но эти объекты при этом будут указывать на один объект Author.
нам необходимо выполнить полное копирование, для этого надо определить метод клонирования у класса Author

Важно!!!
---
Избегайте clone и ищите собственное решение для копирования :)
 */

public class Example9 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Book9 pinokkio = new Book9("Pinokkio", new Author9("Collodi"));
        Book9 miracle = pinokkio.clone();

        miracle.getAuthor().setName("Tolstoy");

        System.out.println(miracle.getAuthor());
        System.out.println(pinokkio.getAuthor());
    }
}

class Book9 implements Cloneable {
    private String name;
    private Author9 author;

    public Book9(String name, Author9 author) {
        this.name = name;
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author9 getAuthor() {
        return author;
    }

    public void print() {
        System.out.println("Book title: " + name);
    }

    protected Book9 clone() throws CloneNotSupportedException {
        Book9 newBook = (Book9)super.clone();
        newBook.author = (Author9) author.clone();

        return newBook;
    }
}

class Author9 implements Cloneable {
    private String name;

    public Author9(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Author9)super.clone();
    }
}
