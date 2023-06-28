## Введение по работе с файлами (и не только)

#### Println vs Printf

```java
public class Example1 {
    public static void main(String[] args) {
        System.out.println("Пример с переносами строк:");
        System.out.printf("one%ntwo%nthree");

        System.out.println();
        System.out.println();

        System.out.println("Пример с логическими типами:");
        System.out.printf("%b%n", null);
        System.out.printf("%B%n", false);
        System.out.printf("%B%n", 2);
        System.out.printf("%b%n", "text");

        System.out.println();

        System.out.println("Пример с текстовыми данными:");
        System.out.printf("%50.4s", "Hi guys!");

        System.out.println();

        System.out.println("Пример с символами:");
        System.out.printf("%c%n", 'a');
        System.out.printf("%C%n", 'a');

        System.out.println();

        System.out.println("Примеры с числами:");
        int x = 100;
        System.out.printf("Printing simple integer: x = %d\n", x);
        System.out.printf("Formatted with precision: PI = %.2f\n", Math.PI);

        float y = 3.14f;
        System.out.printf("Formatted to specific width: n = %.6f\n", y);

        y = 1234567.3f;
        System.out.printf("Formatted to right margin: n = %50.4f\n", y);

        System.out.println();

        System.out.println("примеры с датой:");
        Date date = new Date();
        System.out.println(date);

        // Символы H, M, S отвечают за часы, минуты и секунды
        System.out.printf("hours %tH: minutes %tM: seconds %tS%n", date, date, date);
        System.out.printf("%1$tA, %1$tB %1$tY %n", date);
    }
}
```

#### Scanner
Сканнер был разобран в java basic, можно слегка повторить

System.in : это стандартный поток ввода, который используется для чтения символов с клавиатуры или любого другого
стандартного устройства ввода.

Если тип считываемого параметра определен заранее - можно использовать его, а можно использовать более общий тип String, double, проводить проверки данных перед расчётами
```java
public class Example2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double n = Double.parseDouble(scanner.next());//scanner.nextInt();
        double k = Double.parseDouble(scanner.next());//scanner.nextInt();

        System.out.println(n + k);
    }
}
```

#### В качестве альтернативы Scanner'у:

```java
public class Example3 {
    public static void main(String[] args) {

        InputStreamReader stream = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(stream);

        double n = 0;
        double k = 0;

        try {
            n = Double.parseDouble(br.readLine());
            k = Double.parseDouble(br.readLine());

            System.out.println(n + k);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
```

#### Считывание файлов:
```java
public class Example3 {
    public static void main(String[] args) {
        /*
        InputStreamReader — считывает байты и декодирует
        */
        try {
            InputStream stream = new FileInputStream("test.txt");
            Reader reader = new InputStreamReader(stream);
            int data = reader.read();

            while (data != -1) {
                System.out.print((char) data + " ");
                data = reader.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

на это месте можно "декодировать" файл с данными матчей (test.txt):
```agsl
2022, 1, 7, FC Bayern Munich, 1:02, Borussia Monchengladbach, NULL, NULL
2022, 1, 8, TSG 1899 Hoffenheim, 3:01, FC Augsburg, 500, NULL
2022, 1, 8, Freiburg, 2:02, Arminia Bielefeld, 500, NULL
2022, 1, 8, Bayer 04 Leverkusen, 2:02, 1. FC Union Berlin, NULL, NULL
2022, 1, 8, SpVgg Greuther Fürth, 0:00, Stuttgart, NULL, NULL
2022, 1, 8, RB Leipzig, 4:01, 1. FSV Mainz 05, NULL, NULL
2022, 1, 8, Eintracht Frankfurt, 2:03, Borussia Dortmund, 250, NULL
2022, 1, 9, Hertha BSC, 1:03, 1. FC Cologne, 3000, NULL
2022, 1, 9, VfL Bochum, 1:00, VfL Wolfsburg, NULL, NULL
2022, 1, 14, Borussia Dortmund, 5:01, Freiburg, 750, NULL
2022, 1, 15, 1. FC Cologne, 0:04, FC Bayern Munich, 1000, NULL
2022, 1, 15, 1. FSV Mainz 05, 1:00, VfL Bochum, 1000, NULL
2022, 1, 15, 1. FC Union Berlin, 2:01, TSG 1899 Hoffenheim, 3000, NULL
2022, 1, 15, Stuttgart, 0:02, RB Leipzig, 500, NULL
2022, 1, 15, VfL Wolfsburg, 0:00, Hertha BSC, 500, NULL
2022, 1, 15, Borussia Monchengladbach, 1:02, Bayer 04 Leverkusen, 750, NULL
2022, 1, 16, FC Augsburg, 1:01, Eintracht Frankfurt, NULL, NULL
2022, 1, 16, Arminia Bielefeld, 2:02, SpVgg Greuther Fürth, 750, NULL
2022, 1, 21, Eintracht Frankfurt, 0:02, Arminia Bielefeld, 1000, NULL
2022, 1, 22, TSG 1899 Hoffenheim, 2:03, Borussia Dortmund, 500, NULL
2022, 1, 22, SpVgg Greuther Fürth, 2:01, 1. FSV Mainz 05, NULL, NULL
2022, 1, 22, Freiburg, 2:00, Stuttgart, 500, NULL
2022, 1, 22, Borussia Monchengladbach, 1:02, 1. FC Union Berlin, 750, NULL
2022, 1, 22, Bayer 04 Leverkusen, 5:01, FC Augsburg, 750, NULL
2022, 1, 22, VfL Bochum, 2:02, 1. FC Cologne, 750, NULL
2022, 1, 23, RB Leipzig, 2:00, VfL Wolfsburg, 1000, NULL
2022, 1, 23, Hertha BSC, 1:04, FC Bayern Munich, 3000, NULL
2022, 2, 4, Hertha BSC, 1:01, VfL Bochum, 3000, NULL
2022, 2, 5, 1. FSV Mainz 05, 2:00, TSG 1899 Hoffenheim, 6800, NULL
2022, 2, 5, Stuttgart, 2:03, Eintracht Frankfurt, 10000, NULL
2022, 2, 5, 1. FC Cologne, 1:00, Freiburg, 10000, NULL
2022, 2, 5, Arminia Bielefeld, 1:01, Borussia Monchengladbach, 10000, NULL
2022, 2, 5, FC Augsburg, 2:00, 1. FC Union Berlin, 7600, NULL
2022, 2, 5, FC Bayern Munich, 3:02, RB Leipzig, 10000, NULL
2022, 2, 6, Borussia Dortmund, 2:05, Bayer 04 Leverkusen, 10000, NULL
2022, 2, 6, VfL Wolfsburg, 4:01, SpVgg Greuther Fürth, 500, NULL
2022, 2, 11, RB Leipzig, 3:01, 1. FC Cologne, 15000, NULL
2022, 2, 12, Eintracht Frankfurt, 0:02, VfL Wolfsburg, 10000, NULL
2022, 2, 12, VfL Bochum, 4:02, FC Bayern Munich, 8500, NULL
2022, 2, 12, Borussia Monchengladbach, 3:02, FC Augsburg, 10000, NULL
2022, 2, 12, SpVgg Greuther Fürth, 2:01, Hertha BSC, 7919, NULL
2022, 2, 12, Freiburg, 1:01, 1. FSV Mainz 05, 10000, NULL
2022, 2, 12, Bayer 04 Leverkusen, 4:02, Stuttgart, 10000, NULL
2022, 2, 13, 1. FC Union Berlin, 0:03, Borussia Dortmund, 10000, NULL
2022, 2, 13, TSG 1899 Hoffenheim, 2:00, Arminia Bielefeld, 10000, NULL
2022, 2, 18, 1. FSV Mainz 05, 3:02, Bayer 04 Leverkusen, 10000, NULL
2022, 2, 19, Stuttgart, 1:01, VfL Bochum, 20059, NULL
2022, 2, 19, VfL Wolfsburg, 1:02, TSG 1899 Hoffenheim, 7145, NULL
2022, 2, 19, Arminia Bielefeld, 1:00, 1. FC Union Berlin, 10000, NULL
2022, 2, 19, FC Augsburg, 1:02, Freiburg, 15000, NULL
2022, 2, 19, 1. FC Cologne, 1:00, Eintracht Frankfurt, 10000, NULL
2022, 2, 20, FC Bayern Munich, 4:01, SpVgg Greuther Fürth, 25000, NULL
2022, 2, 20, Borussia Dortmund, 6:00, Borussia Monchengladbach, 10000, NULL
2022, 2, 20, Hertha BSC, 1:06, RB Leipzig, 10000, NULL
2022, 2, 25, TSG 1899 Hoffenheim, 2:01, Stuttgart, 18099, NULL
2022, 2, 26, 1. FC Union Berlin, 3:01, 1. FSV Mainz 05, 10000, NULL
2022, 2, 26, Borussia Monchengladbach, 2:02, VfL Wolfsburg, 10000, NULL
2022, 2, 26, SpVgg Greuther Fürth, 1:01, 1. FC Cologne, 9200, NULL
2022, 2, 26, Freiburg, 3:00, Hertha BSC, 25000, NULL
2022, 2, 26, Bayer 04 Leverkusen, 3:00, Arminia Bielefeld, 10000, NULL
2022, 2, 26, Eintracht Frankfurt, 0:01, FC Bayern Munich, 25000, NULL
2022, 2, 27, VfL Bochum, 0:01, RB Leipzig, 10000, NULL
2022, 2, 27, FC Augsburg, 1:01, Borussia Dortmund, 15330, NULL
2022, 3, 4, Arminia Bielefeld, 0:01, FC Augsburg, 19460, NULL
2022, 3, 5, VfL Bochum, 2:01, SpVgg Greuther Fürth, 19800, NULL
2022, 3, 5, RB Leipzig, 1:01, Freiburg, 24758, NULL
2022, 3, 5, FC Bayern Munich, 1:01, Bayer 04 Leverkusen, 25000, NULL
2022, 3, 5, Hertha BSC, 1:04, Eintracht Frankfurt, 25000, NULL
2022, 3, 5, VfL Wolfsburg, 1:00, 1. FC Union Berlin, 15703, NULL
2022, 3, 5, Stuttgart, 3:02, Borussia Monchengladbach, 25000, NULL
2022, 3, 6, 1. FC Cologne, 0:01, TSG 1899 Hoffenheim, 37500, NULL
2022, 3, 16, 1. FSV Mainz 05, 0:01, Borussia Dortmund, 25000, NULL
2022, 3, 12, Freiburg, 3:02, VfL Wolfsburg, 25000, NULL
2022, 3, 12, 1. FC Union Berlin, 1:01, Stuttgart, 16509, NULL
2022, 3, 12, TSG 1899 Hoffenheim, 1:01, FC Bayern Munich, 25600, NULL
2022, 3, 12, Borussia Monchengladbach, 2:00, Hertha BSC, 30675, NULL
2022, 3, 13, Bayer 04 Leverkusen, 0:01, 1. FC Cologne, 22658, NULL
2022, 3, 13, Borussia Dortmund, 1:00, Arminia Bielefeld, 33000, NULL
2022, 3, 13, Eintracht Frankfurt, 2:01, VfL Bochum, 24000, NULL
2022, 3, 13, SpVgg Greuther Fürth, 1:06, RB Leipzig, 9418, NULL
2022, 3, 18, VfL Bochum, 0:02, Borussia Monchengladbach, NULL, NULL
2022, 3, 19, Hertha BSC, 3:00, TSG 1899 Hoffenheim, 25000, NULL
2022, 3, 19, Stuttgart, 3:02, FC Augsburg, 55785, NULL
2022, 3, 19, SpVgg Greuther Fürth, 0:00, Freiburg, 9884, NULL
2022, 3, 19, 1. FSV Mainz 05, 4:00, Arminia Bielefeld, 25000, NULL
2022, 3, 19, FC Bayern Munich, 4:00, 1. FC Union Berlin, 37000, NULL
2022, 3, 20, RB Leipzig, 0:00, Eintracht Frankfurt, 43058, NULL
2022, 3, 20, VfL Wolfsburg, 0:02, Bayer 04 Leverkusen, 16554, NULL
2022, 3, 20, 1. FC Cologne, 1:01, Borussia Dortmund, 50000, NULL
2022, 4, 6, FC Augsburg, 2:01, 1. FSV Mainz 05, 18122, NULL
2022, 4, 1, 1. FC Union Berlin, 1:00, 1. FC Cologne, 22012, NULL
2022, 4, 2, Freiburg, 1:04, FC Bayern Munich, 34700, NULL
2022, 4, 2, Bayer 04 Leverkusen, 2:01, Hertha BSC, 23557, NULL
2022, 4, 2, TSG 1899 Hoffenheim, 1:02, VfL Bochum, 15014, NULL
2022, 4, 2, Eintracht Frankfurt, 0:00, SpVgg Greuther Fürth, 50500, NULL
2022, 4, 2, Arminia Bielefeld, 1:01, Stuttgart, 26011, NULL
2022, 4, 2, Borussia Dortmund, 1:04, RB Leipzig, 81365, NULL
2022, 4, 3, FC Augsburg, 3:00, VfL Wolfsburg, 23143, NULL
2022, 4, 3, Borussia Monchengladbach, 1:01, 1. FSV Mainz 05, 44156, NULL
2022, 4, 8, Stuttgart, 0:02, Borussia Dortmund, 58248, NULL
2022, 4, 9, SpVgg Greuther Fürth, 0:02, Borussia Monchengladbach, 13900, NULL
2022, 4, 9, FC Bayern Munich, 1:00, FC Augsburg, 75000, NULL
2022, 4, 9, 1. FC Cologne, 3:02, 1. FSV Mainz 05, 49800, NULL
2022, 4, 9, VfL Wolfsburg, 4:00, Arminia Bielefeld, 22512, NULL
2022, 4, 9, Hertha BSC, 1:04, 1. FC Union Berlin, 74667, NULL
2022, 4, 10, VfL Bochum, 0:00, Bayer 04 Leverkusen, 25000, NULL
2022, 4, 10, Eintracht Frankfurt, 1:02, Freiburg, 47000, NULL
2022, 4, 10, RB Leipzig, 3:00, TSG 1899 Hoffenheim, 35112, NULL
2022, 4, 16, Borussia Dortmund, 6:01, VfL Wolfsburg, 79200, NULL
2022, 4, 16, FC Augsburg, 0:01, Hertha BSC, 28533, NULL
2022, 4, 16, 1. FSV Mainz 05, 0:00, Stuttgart, 30128, NULL
2022, 4, 16, Freiburg, 3:00, VfL Bochum, 34000, NULL
2022, 4, 16, Borussia Monchengladbach, 1:03, 1. FC Cologne, 54042, NULL
2022, 4, 17, Arminia Bielefeld, 0:03, FC Bayern Munich, 26419, NULL
2022, 4, 17, 1. FC Union Berlin, 2:00, Eintracht Frankfurt, 22012, NULL
2022, 4, 17, TSG 1899 Hoffenheim, 0:00, SpVgg Greuther Fürth, 16110, NULL
2022, 4, 17, Bayer 04 Leverkusen, 0:01, RB Leipzig, 26119, NULL
2022, 4, 22, VfL Wolfsburg, 5:00, 1. FSV Mainz 05, 19055, NULL
2022, 4, 23, RB Leipzig, 1:02, 1. FC Union Berlin, 45770, NULL
2022, 4, 23, Freiburg, 3:03, Borussia Monchengladbach, 34700, NULL
2022, 4, 23, 1. FC Cologne, 3:01, Arminia Bielefeld, 50000, NULL
2022, 4, 23, SpVgg Greuther Fürth, 1:04, Bayer 04 Leverkusen, 11579, NULL
2022, 4, 23, Eintracht Frankfurt, 2:02, TSG 1899 Hoffenheim, 50500, NULL
2022, 4, 23, FC Bayern Munich, 3:01, Borussia Dortmund, 75000, NULL
2022, 4, 24, VfL Bochum, 0:02, FC Augsburg, 23500, NULL
2022, 4, 24, Hertha BSC, 2:00, Stuttgart, 54589, NULL
2022, 4, 29, 1. FC Union Berlin, 1:01, SpVgg Greuther Fürth, 22012, NULL
2022, 4, 30, Borussia Dortmund, 3:04, VfL Bochum, 81365, NULL
2022, 4, 30, Arminia Bielefeld, 1:01, Hertha BSC, 26021, NULL
2022, 4, 30, 1. FSV Mainz 05, 3:01, FC Bayern Munich, 33305, NULL
2022, 4, 30, Stuttgart, 1:01, VfL Wolfsburg, 52230, NULL
2022, 4, 30, FC Augsburg, 1:04, 1. FC Cologne, 29511, NULL
2022, 4, 30, TSG 1899 Hoffenheim, 3:04, Freiburg, 23627, NULL
2022, 5, 2, Borussia Monchengladbach, 3:01, RB Leipzig, 35324, NULL
2022, 5, 2, Bayer 04 Leverkusen, 2:00, Eintracht Frankfurt, 26492, NULL
2022, 5, 6, VfL Bochum, 2:01, Arminia Bielefeld, 25000, NULL
2022, 5, 7, Freiburg, 1:04, 1. FC Union Berlin, 34700, NULL
2022, 5, 7, TSG 1899 Hoffenheim, 2:04, Bayer 04 Leverkusen, 20033, NULL
2022, 5, 7, 1. FC Cologne, 0:01, VfL Wolfsburg, 50000, NULL
2022, 5, 7, SpVgg Greuther Fürth, 1:03, Borussia Dortmund, 16626, NULL
2022, 5, 7, Hertha BSC, 1:02, 1. FSV Mainz 05, 71548, NULL
2022, 5, 8, Eintracht Frankfurt, 1:01, Borussia Monchengladbach, 51500, NULL
2022, 5, 8, FC Bayern Munich, 2:02, Stuttgart, 75000, NULL
2022, 5, 8, RB Leipzig, 4:00, FC Augsburg, 37029, NULL
2022, 5, 14, Stuttgart, 2:01, 1. FC Cologne, 52230, Mercedes-Benz Arena
2022, 5, 14, Bayer 04 Leverkusen, 2:01, Freiburg, 30210, BayArena
2022, 5, 14, VfL Wolfsburg, 2:02, FC Bayern Munich, 30000, Volkswagen Arena
2022, 5, 14, Borussia Dortmund, 2:01, Hertha BSC, 80500, Signal Iduna Park
2022, 5, 14, FC Augsburg, 2:01, SpVgg Greuther Fürth, 27907, WWK Arena
2022, 5, 14, 1. FSV Mainz 05, 2:02, Eintracht Frankfurt, 33000, Mewa Arena
2022, 5, 14, Arminia Bielefeld, 1:01, RB Leipzig, 22719, SchücoArena
2022, 5, 14, 1. FC Union Berlin, 3:02, VfL Bochum, 22012, Stadion An der Alten Försterei
2022, 5, 14, Borussia Monchengladbach, 5:01, TSG 1899 Hoffenheim, 50395, Borussia-Park
2022, 8, 5, Eintracht Frankfurt, 1:06, FC Bayern Munich, 51500, Deutsche Bank Park
2022, 8, 6, VfL Bochum, 1:02, 1. FSV Mainz 05, 24110, Vonovia Ruhrstadion
2022, 8, 6, VfL Wolfsburg, 2:02, Werder Bremen, 28015, Volkswagen Arena
2022, 8, 6, Borussia Monchengladbach, 3:01, TSG 1899 Hoffenheim, 49659, Borussia-Park
2022, 8, 6, 1. FC Union Berlin, 3:01, Hertha BSC, 22012, Stadion An der Alten Försterei
2022, 8, 6, FC Augsburg, 0:04, Freiburg, 25310, WWK Arena
2022, 8, 6, Borussia Dortmund, 1:00, Bayer 04 Leverkusen, 81365, Signal Iduna Park
2022, 8, 7, Stuttgart, 1:01, RB Leipzig, 46000, Mercedes-Benz Arena
2022, 8, 7, 1. FC Cologne, 3:01, FC Schalke 04, 50000, RheinEnergieSTADION
2022, 8, 12, Freiburg, 1:03, Borussia Dortmund, 34700, Europa-Park Stadion
2022, 8, 13, Bayer 04 Leverkusen, 1:02, FC Augsburg, 22903, BayArena
2022, 8, 13, Werder Bremen, 2:02, Stuttgart, 41000, Weser-Stadion
2022, 8, 13, Hertha BSC, 1:01, Eintracht Frankfurt, 44694, Olympiastadion Berlin
2022, 8, 13, TSG 1899 Hoffenheim, 3:02, VfL Bochum, 17005, PreZero Arena
2022, 8, 13, RB Leipzig, 2:02, 1. FC Cologne, 43579, Red Bull Arena
2022, 8, 13, FC Schalke 04, 2:02, Borussia Monchengladbach, 62271, Veltins-Arena
2022, 8, 14, 1. FSV Mainz 05, 0:00, 1. FC Union Berlin, 25009, Mewa Arena
2022, 8, 14, FC Bayern Munich, 2:00, VfL Wolfsburg, 75000, Allianz Arena
2022, 8, 19, Borussia Monchengladbach, 1:00, Hertha BSC, 48411, Borussia-Park
2022, 8, 20, Stuttgart, 0:01, Freiburg, 47500, Mercedes-Benz Arena
2022, 8, 20, Borussia Dortmund, 2:03, Werder Bremen, 81365, Signal Iduna Park
2022, 8, 20, VfL Wolfsburg, 0:00, FC Schalke 04, 26959, Volkswagen Arena
2022, 8, 20, FC Augsburg, 1:02, 1. FSV Mainz 05, 23755, WWK Arena
2022, 8, 20, Bayer 04 Leverkusen, 0:03, TSG 1899 Hoffenheim, 26300, BayArena
2022, 8, 20, 1. FC Union Berlin, 2:01, RB Leipzig, 21056, Stadion An der Alten Försterei
2022, 8, 21, Eintracht Frankfurt, 1:01, 1. FC Cologne, 50800, Deutsche Bank Park
2022, 8, 21, VfL Bochum, 0:07, FC Bayern Munich, 26000, Vonovia Ruhrstadion
2022, 8, 26, Freiburg, 1:00, VfL Bochum, 32800, Europa-Park Stadion
2022, 8, 27, RB Leipzig, 2:00, VfL Wolfsburg, 41243, Red Bull Arena
2022, 8, 27, Hertha BSC, 0:01, Borussia Dortmund, 62142, Olympiastadion Berlin
2022, 8, 27, 1. FSV Mainz 05, 0:03, Bayer 04 Leverkusen, 28500, Mewa Arena
2022, 8, 27, TSG 1899 Hoffenheim, 1:00, FC Augsburg, 17206, PreZero Arena
2022, 8, 27, FC Schalke 04, 1:06, 1. FC Union Berlin, 62271, Veltins-Arena
2022, 8, 27, FC Bayern Munich, 1:01, Borussia Monchengladbach, 75000, Allianz Arena
2022, 8, 28, 1. FC Cologne, 0:00, Stuttgart, 50000, RheinEnergieSTADION
2022, 8, 28, Werder Bremen, 3:04, Eintracht Frankfurt, 41000, Weser-Stadion
2022, 9, 2, Borussia Dortmund, 1:00, TSG 1899 Hoffenheim, 79300, Signal Iduna Park
2022, 9, 3, Stuttgart, 1:01, FC Schalke 04, 47500, Mercedes-Benz Arena
2022, 9, 3, VfL Bochum, 0:02, Werder Bremen, 25800, Vonovia Ruhrstadion
2022, 9, 3, Bayer 04 Leverkusen, 2:03, Freiburg, 26853, BayArena
2022, 9, 3, 1. FC Union Berlin, 1:01, FC Bayern Munich, 22012, Stadion An der Alten Försterei
2022, 9, 3, VfL Wolfsburg, 2:04, 1. FC Cologne, 25654, Volkswagen Arena
2022, 9, 3, Eintracht Frankfurt, 4:00, RB Leipzig, 49700, Deutsche Bank Park
2022, 9, 4, FC Augsburg, 0:02, Hertha BSC, 25789, WWK Arena
2022, 9, 4, Borussia Monchengladbach, 0:01, 1. FSV Mainz 05, 51210, Borussia-Park
2022, 9, 9, Werder Bremen, 0:01, FC Augsburg, 41000, Weser-Stadion
2022, 9, 10, Hertha BSC, 2:02, Bayer 04 Leverkusen, 40643, Olympiastadion Berlin
2022, 9, 10, TSG 1899 Hoffenheim, 4:01, 1. FSV Mainz 05, 20114, PreZero Arena
2022, 9, 10, Eintracht Frankfurt, 0:01, VfL Wolfsburg, 49000, Deutsche Bank Park
2022, 9, 10, FC Bayern Munich, 2:02, Stuttgart, 75000, Allianz Arena
2022, 9, 10, RB Leipzig, 3:00, Borussia Dortmund, 47069, Red Bull Arena
2022, 9, 10, FC Schalke 04, 3:01, VfL Bochum, 62041, Veltins-Arena
2022, 9, 11, 1. FC Cologne, 0:01, 1. FC Union Berlin, 49500, RheinEnergieSTADION
2022, 9, 11, Freiburg, 0:00, Borussia Monchengladbach, 34700, Europa-Park Stadion
2022, 9, 16, 1. FSV Mainz 05, 1:01, Hertha BSC, 25300, Mewa Arena
2022, 9, 17, Borussia Dortmund, 1:00, FC Schalke 04, 81100, Signal Iduna Park
2022, 9, 17, Bayer 04 Leverkusen, 1:01, Werder Bremen, 30210, BayArena
2022, 9, 17, FC Augsburg, 1:00, FC Bayern Munich, 30660, WWK Arena
2022, 9, 17, Stuttgart, 1:03, Eintracht Frankfurt, 47500, Mercedes-Benz Arena
2022, 9, 17, Borussia Monchengladbach, 3:00, RB Leipzig, 50186, Borussia-Park
2022, 9, 18, 1. FC Union Berlin, 2:00, VfL Wolfsburg, 22012, Stadion An der Alten Försterei
2022, 9, 18, VfL Bochum, 1:01, 1. FC Cologne, 25800, Vonovia Ruhrstadion
2022, 9, 18, TSG 1899 Hoffenheim, 0:00, Freiburg, 24233, PreZero Arena
2022, 9, 30, FC Bayern Munich, 4:00, Bayer 04 Leverkusen, 75000, Allianz Arena
2022, 10, 1, VfL Wolfsburg, 3:02, Stuttgart, 24125, Volkswagen Arena
2022, 10, 1, 1. FC Cologne, 3:02, Borussia Dortmund, 50000, RheinEnergieSTADION
2022, 10, 1, Freiburg, 2:01, 1. FSV Mainz 05, 34700, Europa-Park Stadion
2022, 10, 1, Eintracht Frankfurt, 2:00, 1. FC Union Berlin, 50500, Deutsche Bank Park
2022, 10, 1, RB Leipzig, 4:00, VfL Bochum, 44403, Red Bull Arena
2022, 10, 1, Werder Bremen, 5:01, Borussia Monchengladbach, 42100, Weser-Stadion
2022, 10, 2, Hertha BSC, 1:01, TSG 1899 Hoffenheim, 41653, Olympiastadion Berlin
2022, 10, 2, FC Schalke 04, 2:03, FC Augsburg, 60328, Veltins-Arena
2022, 10, 7, TSG 1899 Hoffenheim, 1:02, Werder Bremen, 25410, NULL
2022, 10, 8, 1. FSV Mainz 05, 1:01, RB Leipzig, 26100, NULL
2022, 10, 8, FC Augsburg, 1:01, VfL Wolfsburg, 26220, NULL
2022, 10, 8, VfL Bochum, 3:00, Eintracht Frankfurt, 24850, NULL
2022, 10, 8, Bayer 04 Leverkusen, 4:00, FC Schalke 04, 30210, NULL
2022, 10, 8, Borussia Dortmund, 2:02, FC Bayern Munich, 81365, NULL
2022, 10, 9, Borussia Monchengladbach, 5:02, 1. FC Cologne, 54042, NULL
2022, 10, 9, Hertha BSC, 2:02, Freiburg, 40481, NULL
2022, 10, 9, Stuttgart, 0:01, 1. FC Union Berlin, 43250, NULL
2022, 10, 14, FC Schalke 04, 0:03, TSG 1899 Hoffenheim, 59811, NULL
2022, 10, 15, Werder Bremen, 0:02, 1. FSV Mainz 05, 41000, NULL
2022, 10, 15, Stuttgart, 4:01, VfL Bochum, 45400, NULL
2022, 10, 15, VfL Wolfsburg, 2:02, Borussia Monchengladbach, 26701, NULL
2022, 10, 15, Eintracht Frankfurt, 5:01, Bayer 04 Leverkusen, 49700, NULL
2022, 10, 15, RB Leipzig, 3:02, Hertha BSC, 47069, NULL
2022, 10, 16, 1. FC Cologne, 3:02, FC Augsburg, 49000, NULL
2022, 10, 16, 1. FC Union Berlin, 2:00, Borussia Dortmund, 22012, NULL
2022, 10, 16, FC Bayern Munich, 5:00, Freiburg, 75000, NULL
2022, 10, 21, 1. FSV Mainz 05, 5:00, 1. FC Cologne, 31610, NULL
2022, 10, 22, TSG 1899 Hoffenheim, 0:02, FC Bayern Munich, 30150, NULL
2022, 10, 22, Freiburg, 2:00, Werder Bremen, 34700, NULL
2022, 10, 22, Bayer 04 Leverkusen, 2:02, VfL Wolfsburg, 26294, NULL
2022, 10, 22, FC Augsburg, 3:03, RB Leipzig, 25109, NULL
2022, 10, 22, Borussia Dortmund, 5:00, Stuttgart, 81365, NULL
2022, 10, 22, Borussia Monchengladbach, 1:03, Eintracht Frankfurt, 53019, NULL
2022, 10, 23, VfL Bochum, 2:01, 1. FC Union Berlin, 25460, NULL
2022, 10, 23, Hertha BSC, 2:01, FC Schalke 04, 60165, NULL
2022, 10, 28, Werder Bremen, 1:00, Hertha BSC, 42100, NULL
2022, 10, 29, Stuttgart, 2:01, FC Augsburg, 46400, NULL
2022, 10, 29, RB Leipzig, 2:00, Bayer 04 Leverkusen, 45598, NULL
2022, 10, 29, FC Bayern Munich, 6:02, 1. FSV Mainz 05, 75000, NULL
2022, 10, 29, VfL Wolfsburg, 4:00, VfL Bochum, 24037, NULL
2022, 10, 29, Eintracht Frankfurt, 1:02, Borussia Dortmund, 50000, NULL
2022, 10, 30, FC Schalke 04, 0:02, Freiburg, 61115, NULL
2022, 10, 30, 1. FC Cologne, 1:01, TSG 1899 Hoffenheim, 49000, NULL
2022, 10, 30, 1. FC Union Berlin, 2:01, Borussia Monchengladbach, 22012, NULL
2022, 11, 4, Borussia Monchengladbach, 3:01, Stuttgart, 53178, NULL
2022, 11, 5, Hertha BSC, 2:03, FC Bayern Munich, 74667, NULL
2022, 11, 5, TSG 1899 Hoffenheim, 1:03, RB Leipzig, 23127, NULL
2022, 11, 5, FC Augsburg, 1:02, Eintracht Frankfurt, 30087, NULL
2022, 11, 5, Borussia Dortmund, 3:00, VfL Bochum, 81365, NULL
2022, 11, 5, 1. FSV Mainz 05, 0:03, VfL Wolfsburg, 26750, NULL
2022, 11, 5, Werder Bremen, 2:01, FC Schalke 04, 41000, NULL
2022, 11, 6, Bayer 04 Leverkusen, 5:00, 1. FC Union Berlin, 30210, NULL
2022, 11, 6, Freiburg, 2:00, 1. FC Cologne, 33800, NULL
2022, 11, 8, VfL Wolfsburg, 2:00, Borussia Dortmund, 28675, NULL
2022, 11, 8, Stuttgart, 2:01, Hertha BSC, 44500, NULL
2022, 11, 8, VfL Bochum, 2:01, Borussia Monchengladbach, 25900, NULL
2022, 11, 8, FC Bayern Munich, 6:01, Werder Bremen, 75000, NULL
2022, 11, 9, 1. FC Cologne, 1:02, Bayer 04 Leverkusen, 50000, NULL
2022, 11, 9, RB Leipzig, 3:01, Freiburg, 41240, NULL
2022, 11, 9, FC Schalke 04, 1:00, 1. FSV Mainz 05, 58256, NULL
2022, 11, 9, 1. FC Union Berlin, 2:02, FC Augsburg, 22012, NULL
2022, 11, 9, Eintracht Frankfurt, 4:02, TSG 1899 Hoffenheim, 49000, NULL
2022, 11, 11, Borussia Monchengladbach, 4:02, Borussia Dortmund, 54042, Borussia-Park
2022, 11, 12, TSG 1899 Hoffenheim, 1:02, VfL Wolfsburg, 18014, PreZero Arena
2022, 11, 12, FC Augsburg, 0:01, VfL Bochum, 28011, WWK Arena
2022, 11, 12, Hertha BSC, 2:00, 1. FC Cologne, 60827, Olympiastadion Berlin
2022, 11, 12, Werder Bremen, 1:02, RB Leipzig, 41500, Weser-Stadion
2022, 11, 12, Bayer 04 Leverkusen, 2:00, Stuttgart, 30210, BayArena
2022, 11, 12, FC Schalke 04, 0:02, FC Bayern Munich, 62271, Veltins-Arena
2022, 11, 13, 1. FSV Mainz 05, 1:01, Eintracht Frankfurt, 33305, Mewa Arena
2022, 11, 13, Freiburg, 4:01, 1. FC Union Berlin, 33800, NULL

```

в итоге файл по считыванию должен получиться таким:
```java
package module_4.lecture_1.javaTasksExamples;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

public class JTExample1 {
    public static void main(String[] args) throws Exception {

        InputStream stream = new FileInputStream("test.txt");
        Reader reader = new InputStreamReader(stream);

        int data = reader.read();

        String line = "";

        List<Match> matches = new ArrayList<>();

        while (data != -1) {

            if ((char)data != '\n') {
                line = line + (char)data;
            } else {

                String[] lineParsed = line.split(", ");
                System.out.println(Arrays.toString(lineParsed));

                matches.add(
                        new Match(
                                new GregorianCalendar(
                                        Integer.parseInt(lineParsed[0]),
                                        Integer.parseInt(lineParsed[1]),
                                        Integer.parseInt(lineParsed[2])
                                ),
                                lineParsed[3],
                                lineParsed[4],
                                lineParsed[5],
                                lineParsed[6],
                                lineParsed[7]
                        )
                );

                line = "";
            }
            data = reader.read();
        }

        System.out.println(matches.stream().count());
    }
}

class Match {
    private Calendar date;
    private String team1, result, team2, watchers, stadium;

    public Match(Calendar date, String team1, String result, String team2, String watchers, String stadium) {
        this.date = date;
        this.team1 = team1;
        this.result = result;
        this.team2 = team2;
        this.watchers = watchers;
        this.stadium = stadium;
    }

    public int getResult1() {
        return Integer.parseInt(result.split(":")[0]);
    }

    public int getResult2() {
        return Integer.parseInt(result.split(":")[1]);
    }

    public Calendar getDate() {
        return date;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public int getWatchers() {
        if (watchers.contains("NULL"))
            return 0;
        else
            return Integer.parseInt(watchers);
    }

    public String getStadium() {
        return stadium;
    }

    @Override
    public String toString() {
        return date.get(Calendar.YEAR) + "-" + date.get(Calendar.MONTH) + "-" + date.get(Calendar.DATE) + " " + team1 + " " + getResult1() + ":" + getResult2() + " " + team2 + " " + getWatchers();
    }
}
```

#### Работа с ОС, файлами, директориями:

```java
public class Example5 {
    public static void main(String[] args) {
        File file = new File("test.txt");
        boolean isExist = file.exists();

        System.out.println("Файл сущействует?: " + isExist);

        file = new File("new_dir");

        boolean wasCreated = file.mkdir();
        System.out.println("Directory was created: " + wasCreated);

        long length = file.length();
        System.out.println(length);

        boolean success = file.delete();
        System.out.println(success);

        File direcory = new File("data");
        boolean isDirecory = file.isDirectory();
        System.out.println(isDirecory);

        direcory = new File("data");
        String[] fileNames = file.list();
        File[] files = file.listFiles();
    }
}
```

#### пример чтения и записи:

```java
public class Example6 {
    public static void main(String[] args) {
        inputExample();
        outputExample();
    }

    public static void inputExample() {
        // пример чтения
        try {
            String path = "test_stream.txt";
            FileInputStream input = new FileInputStream(path);

            int data = input.read();

            while (data != -1) {
                System.out.print((char) data + " ");
                data = input.read();
            }

            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void outputExample() {
        try {
            String path = "test_stream.txt";
            FileOutputStream out = new FileOutputStream(path, true);
            out.write("\nhello from java outputstream".getBytes());
            out.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
```