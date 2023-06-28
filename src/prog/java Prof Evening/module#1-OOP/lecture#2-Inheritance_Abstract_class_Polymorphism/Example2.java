import java.util.Arrays;

/*
Объяснение:
хэш-код объекта суперкласса (Fruit) и хэш-код объекта подкласса (Ananas) одинаковы, поэтому создается только один объект.
Этот объект относится к классу Ananas (подклассу), так как когда мы пытаемся напечатать имя класса, в котором создан
объект, он печатает Ananas, который является подклассом.

---
когда вызывается конструктор, создание объекта не обязательно!


!!! - не надо спешить, если время лекции на исходе, можно эту тему продолжить на следующей.
Задайте вопросы студентам по пройденному материалу, выясните точно ли всем понятно!
 */

public class Example2 {
    public static void main(String[] args) {
        Ananas ananas = new Ananas();
        ananas.setCellulose(20);
        ananas.setSugar(10);
        ananas.setVitamins(new String[]{"A", "B"});
        System.out.println(ananas);
    }
}


class Fruit {
    public String[] vitamins;
    public int sugar;

    public Fruit() {
        // Print statement
        System.out.println("Super class constructor");

        // Displaying object hashcode of super class
        System.out.println("Super class object hashcode: " + this.hashCode());
        System.out.println(this.getClass().getName());
    }

    @Override
    public String toString() {
        return "vitamins = " + Arrays.toString(vitamins) + ", sugar = " + sugar;
    }

    public void setVitamins(String[] vitamins) {
        this.vitamins = vitamins;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }
}

class Ananas extends Fruit {
    private int cellulose;

    public Ananas() {
        // Print statement
        System.out.println("Subclass constructor invoked");

        // Displaying object hashcode of subclass
        System.out.println("Sub class object hashcode :" + this.hashCode());

        System.out.println(this.hashCode() + " " + super.hashCode());

        System.out.println(this.getClass().getName() + " " + super.getClass().getName());
    }

    @Override
    public String toString() {
        return "Ananas {cellulose = " + cellulose + super.toString() + "}";
    }

    public void setCellulose(int cellulose) {
        this.cellulose = cellulose;
    }
}