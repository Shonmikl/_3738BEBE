/*
Модификаторы доступа

Рассмотрим модификаторы доступа на примере следующей программы:
 */

public class Example5 {
    public static void main(String[] args) {

        Person kate = new Person("Kate", 32, "Baker Street", "+12334567");
        kate.displayName();     // норм, метод public
        kate.displayAge();      // норм, метод имеет модификатор по умолчанию
        kate.displayPhone();    // норм, метод protected
        //kate.displayAddress();  // ! Ошибка, метод private

        System.out.println(kate.name);      // норм, модификатор по умолчанию
        System.out.println(kate.address);   // норм, модификатор public
        System.out.println(kate.age);       // норм, модификатор protected
        //System.out.println(kate.phone);   // ! Ошибка, модификатор private
    }
}

class Person{

    String name;
    protected int age;
    public String address;
    private String phone;

    public Person(String name, int age, String address, String phone){
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }
    public void displayName(){
        System.out.printf("Name: %s \n", name);
    }
    void displayAge(){
        System.out.printf("Age: %d \n", age);
    }
    private void displayAddress(){
        System.out.printf("Address: %s \n", address);
    }
    protected void displayPhone(){
        System.out.printf("Phone: %s \n", phone);
    }
}