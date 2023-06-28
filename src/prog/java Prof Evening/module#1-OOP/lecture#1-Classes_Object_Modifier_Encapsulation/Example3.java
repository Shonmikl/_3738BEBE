/*
Доступ к переменным экземпляра и методам

Пример
Этот пример объясняет, как получить доступ к переменные экземпляра и методам класса в Java:
 */

public class Example3 {
    public static void main(String[] args) {
        /* Создание объекта. */
        Puppy3 myPuppy = new Puppy3("Багет");

        /* Вызов метод класса, чтобы установить возраст щенка. */
        myPuppy.setAge(2);

        /* Вызов другого метода класса, чтобы получить возраст щенка. */
        myPuppy.getAge();

        /* Получение переменной экземпляра класса. */
        System.out.println("Значение переменной:" + myPuppy.puppyAge );

    }
}

class Puppy3 {

    int puppyAge;

    public Puppy3(String name) {
        // Это конструктор и у него один параметр, name.
        System.out.println("Передаваемое имя:" + name );
    }

    public void setAge(int age) {
        puppyAge = age;
    }

    public int getAge( ){
        System.out.println("Возраст щенка:" + puppyAge );
        return puppyAge;
    }

}