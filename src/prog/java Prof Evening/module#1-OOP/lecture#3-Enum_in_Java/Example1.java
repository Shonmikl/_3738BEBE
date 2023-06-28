/*
Как и в случае с классами, вы можете дать им конструктор, добавить переменные экземпляра и методы и даже реализовать
интерфейсы.
Следует иметь в виду, что, в отличие от классов, перечисления не наследуют другие классы и не могут быть расширены
(т.е. стать суперклассом).
 */

enum Day {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;
}

public class Example1 {
    Day day;

    public Example1(Day day) {
        this.day = day;
    }

    public void dayIsNice() {
        switch (day) {
            case MONDAY:
                System.out.println("bad");
                break;

            case FRIDAY:
                System.out.println("better");
                break;

            case SATURDAY:
            case SUNDAY:
                System.out.println("best");
                break;

            default:
                System.out.println("so-so");
                break;
        }
    }

    public static void main(String[] args) {
        String str = "MONDAY";
        Example1 example1 = new Example1(Day.valueOf(str));
        example1.dayIsNice();
    }

}
