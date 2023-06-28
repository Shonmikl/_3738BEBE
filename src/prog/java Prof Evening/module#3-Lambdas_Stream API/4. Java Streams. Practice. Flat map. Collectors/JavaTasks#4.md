### Разбираем примеры stream API на базе данных матчей бундеслиги за 2022 год (информация может быть не точная, но смысл в примерах)

#### Более простой пример:
```java
public class JTExample1 {

    public static void main(String[] args) {

        List<Integer> list_0 = Arrays.asList(10, 11, 22, 12, 14, 10);

        List<FootBallTeam> list_1 = Arrays.asList(
                new FootBallTeam("Dusseldorf", 7),
                new FootBallTeam("Essen", 4),
                new FootBallTeam("Cologne", 6),
                new FootBallTeam("Dortmund", 5),
                new FootBallTeam("Wuppertal", 3),
                new FootBallTeam("Duisburg", 5),
                new FootBallTeam("Bonn", 6),
                new FootBallTeam("Essen", 3),
                new FootBallTeam("Essen", 3)
        );

        // filter
        System.out.println(list_0.stream().filter(x -> x < 15).toList());
        System.out.println(list_0.stream().filter(x -> x == 10).toList());

        System.out.println(list_1.stream().filter(x -> x.getPower() < 5).toList());
        System.out.println(list_1.stream().filter(x -> x.getName().equals("Essen")).toList());

        // sorted
        System.out.println(list_0.stream().sorted().toList());
        System.out.println(list_0.stream().sorted(Collections.reverseOrder()).toList()); // reverse

        // наиболее очевидный способ:
        System.out.println(list_1.stream().sorted((x,y) -> x.getName().compareTo(y.getName())).toList());
        // через компаратор
        System.out.println(list_1.stream().sorted(Comparator.comparing(x -> x.getName())).toList());

        // наиболее очевидный способ:
        System.out.println(list_1.stream().sorted((x,y) -> x.getPower() - y.getPower()).toList());
        // через компаратор
        System.out.println(list_1.stream().sorted(Comparator.comparingInt(x -> x.getPower())).toList());
        // либо можно создать свой compareTo метод
        System.out.println(list_1.stream().sorted().toList());


        // limit
        System.out.println(list_0.stream().limit(2).toList());
        System.out.println(list_1.stream().sorted().limit(3).toList());

        
        // skip
        System.out.println(list_0);
        System.out.println(list_0.stream().skip(2).toList());
        System.out.println();
        System.out.println(list_1);
        System.out.println(list_1.stream().skip(2).collect(Collectors.toList()));

        // distinct
        System.out.println(list_0);
        System.out.println(list_0.stream().distinct().collect(Collectors.toList()));

//        // демонстрация работы списка с объектами ведет себя немного по-другому, можно спустится на уровень
//        // выделения памяти, где хранится объект и т.п. + показать пример с hashcode, чтоб было понимание,
//        // почему distinct в этом случае не отработал как этого хотелось бы
        System.out.println(list_1);
        System.out.println(list_1.stream().distinct().collect(Collectors.toList()));

        // peek
        List<Integer> collect = list_0.stream().peek(x -> System.out.print(x + "; ")).toList();
        System.out.println();
        List<module_3.lecture_4.javaTasksExamples.FootBallTeam> footBallTeams = list_1.stream().peek(x -> System.out.print(x + "; ")).toList();

        // map
        System.out.println(list_0.stream().map(x -> x + 100).toList());
        System.out.println(list_1.stream().map(x -> x.getPower() * 2).toList());


        // flatmap
        // List<List<...>>
        List<List<Integer>> lll = Arrays.asList(list_0, list_0);
        System.out.println(lll.stream().flatMap(x -> x.stream()).map(x -> x*1000).toList());

        // List<List<List<...>>>
        List<List<List<Integer>>> llll = Arrays.asList(lll, lll);
        System.out.println(llll);

        System.out.println(
                llll
                        .stream()
                        .flatMap(
                                x -> x
                                        .stream()
                                        .flatMap(y -> y.stream()
                                        )
                        )
                        .map(x -> x + 9)
                        .toList());

        // List<List<Object>>
        List<List<module_3.lecture_4.javaTasksExamples.FootBallTeam>> qq = Arrays.asList(list_1, list_1);
        System.out.println(qq.stream().flatMap(x -> x.stream()).toList());

        List<List<List<module_3.lecture_4.javaTasksExamples.FootBallTeam>>> qqq = Arrays.asList(qq, qq);
        System.out.println(qqq.stream().flatMap(x -> x.stream().flatMap(y -> y.stream())).toList());

        
        // findFirst
        System.out.println(list_0.stream().findFirst().get());
        System.out.println(list_1.stream().sorted().findFirst().get());

        
        // count
        System.out.println(list_1.stream().map(x -> x.getName()).filter(x -> x.equals("Essen")).count());

        
        // anyMatch
        System.out.println(list_0.stream().anyMatch(x -> x == 0));
        System.out.println(list_0.stream().anyMatch(x -> x == 10));

        System.out.println(list_1.stream().anyMatch(x -> x.getName().equals("Berlin")));
        System.out.println(list_1.stream().anyMatch(x -> x.getName().equals("Wuppertal")));
        System.out.println(list_1.stream().anyMatch(x -> x.hashCode() == list_1.get(1).hashCode()));
    }
}

```

```java
class FootBallTeam implements Comparable<FootBallTeam> {
    private String name;
    private int power;

    public FootBallTeam(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public FootBallTeam(String name) {
        this.name = name;
        this.power = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return name + ": " + power;
    }

    // либо можно создать свой compareTo метод для sort
    @Override
    public int compareTo(FootBallTeam o) {

        if (o == null)
            throw new NullPointerException();

        if (name.equals(o.getName())) {
            if (power > o.getPower())
                return 1;
            else if (power < o.getPower())
                return -1;
            else
                return 0;
        } else
            return name.compareTo(o.getName());
    }
}
```


#### Более реалистичный пример
Можно выделить одну строчку без "new", только данный и поспрашивать что студенты думают на этот счет, что это за данные
Это полезно, т.к. так может выглядеть реальная выборка базы данных за определенный год.
Можно проговорить про NULL и что это нормально в реальной жизни :) а так же как с этим бороться.

```java
class JTExample2 {
    public static void main(String[] args) {

        List<Match> matches = Arrays.asList(
                new Match(new GregorianCalendar(2022, 1, 7), "FC Bayern Munich", "1:02", "Borussia Monchengladbach", "NULL", "NULL"),
                new Match(new GregorianCalendar(2022, 1, 8), "TSG 1899 Hoffenheim", "3:01", "FC Augsburg", "500", "NULL"),
                new Match(new GregorianCalendar(2022, 1, 8), "Freiburg", "2:02", "Arminia Bielefeld", "500", "NULL"),
                new Match(new GregorianCalendar(2022, 1, 8), "Bayer 04 Leverkusen", "2:02", "1. FC Union Berlin", "NULL", "NULL"),
                new Match(new GregorianCalendar(2022, 1, 8), "SpVgg Greuther Fürth", "0:00", "Stuttgart", "NULL", "NULL"),
                new Match(new GregorianCalendar(2022, 1, 8), "RB Leipzig", "4:01", "1. FSV Mainz 05", "NULL", "NULL"),
                new Match(new GregorianCalendar(2022, 1, 8), "Eintracht Frankfurt", "2:03", "Borussia Dortmund", "250", "NULL"),
                new Match(new GregorianCalendar(2022, 1, 9), "Hertha BSC", "1:03", "1. FC Cologne", "3000", "NULL"),
                new Match(new GregorianCalendar(2022, 1, 9), "VfL Bochum", "1:00", "VfL Wolfsburg", "NULL", "NULL"),
                new Match(new GregorianCalendar(2022, 1, 14), "Borussia Dortmund", "5:01", "Freiburg", "750", "NULL"),
                new Match(new GregorianCalendar(2022, 1, 15), "1. FC Cologne", "0:04", "FC Bayern Munich", "1000", "NULL"),
                new Match(new GregorianCalendar(2022, 1, 15), "1. FSV Mainz 05", "1:00", "VfL Bochum", "1000", "NULL"),
                new Match(new GregorianCalendar(2022, 1, 15), "1. FC Union Berlin", "2:01", "TSG 1899 Hoffenheim", "3000", "NULL"),
                new Match(new GregorianCalendar(2022, 1, 15), "Stuttgart", "0:02", "RB Leipzig", "500", "NULL"),
                new Match(new GregorianCalendar(2022, 1, 15), "VfL Wolfsburg", "0:00", "Hertha BSC", "500", "NULL"),
                new Match(new GregorianCalendar(2022, 1, 15), "Borussia Monchengladbach", "1:02", "Bayer 04 Leverkusen", "750", "NULL"),
                new Match(new GregorianCalendar(2022, 1, 16), "FC Augsburg", "1:01", "Eintracht Frankfurt", "NULL", "NULL"),
                new Match(new GregorianCalendar(2022, 1, 16), "Arminia Bielefeld", "2:02", "SpVgg Greuther Fürth", "750", "NULL"),
                new Match(new GregorianCalendar(2022, 1, 21), "Eintracht Frankfurt", "0:02", "Arminia Bielefeld", "1000", "NULL"),
                new Match(new GregorianCalendar(2022, 1, 22), "TSG 1899 Hoffenheim", "2:03", "Borussia Dortmund", "500", "NULL"),
                new Match(new GregorianCalendar(2022, 1, 22), "SpVgg Greuther Fürth", "2:01", "1. FSV Mainz 05", "NULL", "NULL"),
                new Match(new GregorianCalendar(2022, 1, 22), "Freiburg", "2:00", "Stuttgart", "500", "NULL"),
                new Match(new GregorianCalendar(2022, 1, 22), "Borussia Monchengladbach", "1:02", "1. FC Union Berlin", "750", "NULL"),
                new Match(new GregorianCalendar(2022, 1, 22), "Bayer 04 Leverkusen", "5:01", "FC Augsburg", "750", "NULL"),
                new Match(new GregorianCalendar(2022, 1, 22), "VfL Bochum", "2:02", "1. FC Cologne", "750", "NULL"),
                new Match(new GregorianCalendar(2022, 1, 23), "RB Leipzig", "2:00", "VfL Wolfsburg", "1000", "NULL"),
                new Match(new GregorianCalendar(2022, 1, 23), "Hertha BSC", "1:04", "FC Bayern Munich", "3000", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 4), "Hertha BSC", "1:01", "VfL Bochum", "3000", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 5), "1. FSV Mainz 05", "2:00", "TSG 1899 Hoffenheim", "6800", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 5), "Stuttgart", "2:03", "Eintracht Frankfurt", "10000", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 5), "1. FC Cologne", "1:00", "Freiburg", "10000", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 5), "Arminia Bielefeld", "1:01", "Borussia Monchengladbach", "10000", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 5), "FC Augsburg", "2:00", "1. FC Union Berlin", "7600", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 5), "FC Bayern Munich", "3:02", "RB Leipzig", "10000", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 6), "Borussia Dortmund", "2:05", "Bayer 04 Leverkusen", "10000", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 6), "VfL Wolfsburg", "4:01", "SpVgg Greuther Fürth", "500", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 11), "RB Leipzig", "3:01", "1. FC Cologne", "15000", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 12), "Eintracht Frankfurt", "0:02", "VfL Wolfsburg", "10000", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 12), "VfL Bochum", "4:02", "FC Bayern Munich", "8500", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 12), "Borussia Monchengladbach", "3:02", "FC Augsburg", "10000", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 12), "SpVgg Greuther Fürth", "2:01", "Hertha BSC", "7919", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 12), "Freiburg", "1:01", "1. FSV Mainz 05", "10000", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 12), "Bayer 04 Leverkusen", "4:02", "Stuttgart", "10000", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 13), "1. FC Union Berlin", "0:03", "Borussia Dortmund", "10000", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 13), "TSG 1899 Hoffenheim", "2:00", "Arminia Bielefeld", "10000", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 18), "1. FSV Mainz 05", "3:02", "Bayer 04 Leverkusen", "10000", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 19), "Stuttgart", "1:01", "VfL Bochum", "20059", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 19), "VfL Wolfsburg", "1:02", "TSG 1899 Hoffenheim", "7145", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 19), "Arminia Bielefeld", "1:00", "1. FC Union Berlin", "10000", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 19), "FC Augsburg", "1:02", "Freiburg", "15000", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 19), "1. FC Cologne", "1:00", "Eintracht Frankfurt", "10000", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 20), "FC Bayern Munich", "4:01", "SpVgg Greuther Fürth", "25000", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 20), "Borussia Dortmund", "6:00", "Borussia Monchengladbach", "10000", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 20), "Hertha BSC", "1:06", "RB Leipzig", "10000", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 25), "TSG 1899 Hoffenheim", "2:01", "Stuttgart", "18099", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 26), "1. FC Union Berlin", "3:01", "1. FSV Mainz 05", "10000", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 26), "Borussia Monchengladbach", "2:02", "VfL Wolfsburg", "10000", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 26), "SpVgg Greuther Fürth", "1:01", "1. FC Cologne", "9200", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 26), "Freiburg", "3:00", "Hertha BSC", "25000", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 26), "Bayer 04 Leverkusen", "3:00", "Arminia Bielefeld", "10000", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 26), "Eintracht Frankfurt", "0:01", "FC Bayern Munich", "25000", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 27), "VfL Bochum", "0:01", "RB Leipzig", "10000", "NULL"),
                new Match(new GregorianCalendar(2022, 2, 27), "FC Augsburg", "1:01", "Borussia Dortmund", "15330", "NULL"),
                new Match(new GregorianCalendar(2022, 3, 4), "Arminia Bielefeld", "0:01", "FC Augsburg", "19460", "NULL"),
                new Match(new GregorianCalendar(2022, 3, 5), "VfL Bochum", "2:01", "SpVgg Greuther Fürth", "19800", "NULL"),
                new Match(new GregorianCalendar(2022, 3, 5), "RB Leipzig", "1:01", "Freiburg", "24758", "NULL"),
                new Match(new GregorianCalendar(2022, 3, 5), "FC Bayern Munich", "1:01", "Bayer 04 Leverkusen", "25000", "NULL"),
                new Match(new GregorianCalendar(2022, 3, 5), "Hertha BSC", "1:04", "Eintracht Frankfurt", "25000", "NULL"),
                new Match(new GregorianCalendar(2022, 3, 5), "VfL Wolfsburg", "1:00", "1. FC Union Berlin", "15703", "NULL"),
                new Match(new GregorianCalendar(2022, 3, 5), "Stuttgart", "3:02", "Borussia Monchengladbach", "25000", "NULL"),
                new Match(new GregorianCalendar(2022, 3, 6), "1. FC Cologne", "0:01", "TSG 1899 Hoffenheim", "37500", "NULL"),
                new Match(new GregorianCalendar(2022, 3, 16), "1. FSV Mainz 05", "0:01", "Borussia Dortmund", "25000", "NULL"),
                new Match(new GregorianCalendar(2022, 3, 12), "Freiburg", "3:02", "VfL Wolfsburg", "25000", "NULL"),
                new Match(new GregorianCalendar(2022, 3, 12), "1. FC Union Berlin", "1:01", "Stuttgart", "16509", "NULL"),
                new Match(new GregorianCalendar(2022, 3, 12), "TSG 1899 Hoffenheim", "1:01", "FC Bayern Munich", "25600", "NULL"),
                new Match(new GregorianCalendar(2022, 3, 12), "Borussia Monchengladbach", "2:00", "Hertha BSC", "30675", "NULL"),
                new Match(new GregorianCalendar(2022, 3, 13), "Bayer 04 Leverkusen", "0:01", "1. FC Cologne", "22658", "NULL"),
                new Match(new GregorianCalendar(2022, 3, 13), "Borussia Dortmund", "1:00", "Arminia Bielefeld", "33000", "NULL"),
                new Match(new GregorianCalendar(2022, 3, 13), "Eintracht Frankfurt", "2:01", "VfL Bochum", "24000", "NULL"),
                new Match(new GregorianCalendar(2022, 3, 13), "SpVgg Greuther Fürth", "1:06", "RB Leipzig", "9418", "NULL"),
                new Match(new GregorianCalendar(2022, 3, 18), "VfL Bochum", "0:02", "Borussia Monchengladbach", "NULL", "NULL"),
                new Match(new GregorianCalendar(2022, 3, 19), "Hertha BSC", "3:00", "TSG 1899 Hoffenheim", "25000", "NULL"),
                new Match(new GregorianCalendar(2022, 3, 19), "Stuttgart", "3:02", "FC Augsburg", "55785", "NULL"),
                new Match(new GregorianCalendar(2022, 3, 19), "SpVgg Greuther Fürth", "0:00", "Freiburg", "9884", "NULL"),
                new Match(new GregorianCalendar(2022, 3, 19), "1. FSV Mainz 05", "4:00", "Arminia Bielefeld", "25000", "NULL"),
                new Match(new GregorianCalendar(2022, 3, 19), "FC Bayern Munich", "4:00", "1. FC Union Berlin", "37000", "NULL"),
                new Match(new GregorianCalendar(2022, 3, 20), "RB Leipzig", "0:00", "Eintracht Frankfurt", "43058", "NULL"),
                new Match(new GregorianCalendar(2022, 3, 20), "VfL Wolfsburg", "0:02", "Bayer 04 Leverkusen", "16554", "NULL"),
                new Match(new GregorianCalendar(2022, 3, 20), "1. FC Cologne", "1:01", "Borussia Dortmund", "50000", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 6), "FC Augsburg", "2:01", "1. FSV Mainz 05", "18122", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 1), "1. FC Union Berlin", "1:00", "1. FC Cologne", "22012", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 2), "Freiburg", "1:04", "FC Bayern Munich", "34700", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 2), "Bayer 04 Leverkusen", "2:01", "Hertha BSC", "23557", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 2), "TSG 1899 Hoffenheim", "1:02", "VfL Bochum", "15014", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 2), "Eintracht Frankfurt", "0:00", "SpVgg Greuther Fürth", "50500", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 2), "Arminia Bielefeld", "1:01", "Stuttgart", "26011", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 2), "Borussia Dortmund", "1:04", "RB Leipzig", "81365", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 3), "FC Augsburg", "3:00", "VfL Wolfsburg", "23143", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 3), "Borussia Monchengladbach", "1:01", "1. FSV Mainz 05", "44156", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 8), "Stuttgart", "0:02", "Borussia Dortmund", "58248", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 9), "SpVgg Greuther Fürth", "0:02", "Borussia Monchengladbach", "13900", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 9), "FC Bayern Munich", "1:00", "FC Augsburg", "75000", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 9), "1. FC Cologne", "3:02", "1. FSV Mainz 05", "49800", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 9), "VfL Wolfsburg", "4:00", "Arminia Bielefeld", "22512", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 9), "Hertha BSC", "1:04", "1. FC Union Berlin", "74667", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 10), "VfL Bochum", "0:00", "Bayer 04 Leverkusen", "25000", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 10), "Eintracht Frankfurt", "1:02", "Freiburg", "47000", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 10), "RB Leipzig", "3:00", "TSG 1899 Hoffenheim", "35112", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 16), "Borussia Dortmund", "6:01", "VfL Wolfsburg", "79200", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 16), "FC Augsburg", "0:01", "Hertha BSC", "28533", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 16), "1. FSV Mainz 05", "0:00", "Stuttgart", "30128", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 16), "Freiburg", "3:00", "VfL Bochum", "34000", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 16), "Borussia Monchengladbach", "1:03", "1. FC Cologne", "54042", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 17), "Arminia Bielefeld", "0:03", "FC Bayern Munich", "26419", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 17), "1. FC Union Berlin", "2:00", "Eintracht Frankfurt", "22012", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 17), "TSG 1899 Hoffenheim", "0:00", "SpVgg Greuther Fürth", "16110", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 17), "Bayer 04 Leverkusen", "0:01", "RB Leipzig", "26119", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 22), "VfL Wolfsburg", "5:00", "1. FSV Mainz 05", "19055", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 23), "RB Leipzig", "1:02", "1. FC Union Berlin", "45770", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 23), "Freiburg", "3:03", "Borussia Monchengladbach", "34700", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 23), "1. FC Cologne", "3:01", "Arminia Bielefeld", "50000", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 23), "SpVgg Greuther Fürth", "1:04", "Bayer 04 Leverkusen", "11579", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 23), "Eintracht Frankfurt", "2:02", "TSG 1899 Hoffenheim", "50500", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 23), "FC Bayern Munich", "3:01", "Borussia Dortmund", "75000", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 24), "VfL Bochum", "0:02", "FC Augsburg", "23500", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 24), "Hertha BSC", "2:00", "Stuttgart", "54589", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 29), "1. FC Union Berlin", "1:01", "SpVgg Greuther Fürth", "22012", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 30), "Borussia Dortmund", "3:04", "VfL Bochum", "81365", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 30), "Arminia Bielefeld", "1:01", "Hertha BSC", "26021", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 30), "1. FSV Mainz 05", "3:01", "FC Bayern Munich", "33305", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 30), "Stuttgart", "1:01", "VfL Wolfsburg", "52230", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 30), "FC Augsburg", "1:04", "1. FC Cologne", "29511", "NULL"),
                new Match(new GregorianCalendar(2022, 4, 30), "TSG 1899 Hoffenheim", "3:04", "Freiburg", "23627", "NULL"),
                new Match(new GregorianCalendar(2022, 5, 2), "Borussia Monchengladbach", "3:01", "RB Leipzig", "35324", "NULL"),
                new Match(new GregorianCalendar(2022, 5, 2), "Bayer 04 Leverkusen", "2:00", "Eintracht Frankfurt", "26492", "NULL"),
                new Match(new GregorianCalendar(2022, 5, 6), "VfL Bochum", "2:01", "Arminia Bielefeld", "25000", "NULL"),
                new Match(new GregorianCalendar(2022, 5, 7), "Freiburg", "1:04", "1. FC Union Berlin", "34700", "NULL"),
                new Match(new GregorianCalendar(2022, 5, 7), "TSG 1899 Hoffenheim", "2:04", "Bayer 04 Leverkusen", "20033", "NULL"),
                new Match(new GregorianCalendar(2022, 5, 7), "1. FC Cologne", "0:01", "VfL Wolfsburg", "50000", "NULL"),
                new Match(new GregorianCalendar(2022, 5, 7), "SpVgg Greuther Fürth", "1:03", "Borussia Dortmund", "16626", "NULL"),
                new Match(new GregorianCalendar(2022, 5, 7), "Hertha BSC", "1:02", "1. FSV Mainz 05", "71548", "NULL"),
                new Match(new GregorianCalendar(2022, 5, 8), "Eintracht Frankfurt", "1:01", "Borussia Monchengladbach", "51500", "NULL"),
                new Match(new GregorianCalendar(2022, 5, 8), "FC Bayern Munich", "2:02", "Stuttgart", "75000", "NULL"),
                new Match(new GregorianCalendar(2022, 5, 8), "RB Leipzig", "4:00", "FC Augsburg", "37029", "NULL"),
                new Match(new GregorianCalendar(2022, 5, 14), "Stuttgart", "2:01", "1. FC Cologne", "52230", "Mercedes-Benz Arena"),
                new Match(new GregorianCalendar(2022, 5, 14), "Bayer 04 Leverkusen", "2:01", "Freiburg", "30210", "BayArena"),
                new Match(new GregorianCalendar(2022, 5, 14), "VfL Wolfsburg", "2:02", "FC Bayern Munich", "30000", "Volkswagen Arena"),
                new Match(new GregorianCalendar(2022, 5, 14), "Borussia Dortmund", "2:01", "Hertha BSC", "80500", "Signal Iduna Park"),
                new Match(new GregorianCalendar(2022, 5, 14), "FC Augsburg", "2:01", "SpVgg Greuther Fürth", "27907", "WWK Arena"),
                new Match(new GregorianCalendar(2022, 5, 14), "1. FSV Mainz 05", "2:02", "Eintracht Frankfurt", "33000", "Mewa Arena"),
                new Match(new GregorianCalendar(2022, 5, 14), "Arminia Bielefeld", "1:01", "RB Leipzig", "22719", "SchücoArena"),
                new Match(new GregorianCalendar(2022, 5, 14), "1. FC Union Berlin", "3:02", "VfL Bochum", "22012", "Stadion An der Alten Försterei"),
                new Match(new GregorianCalendar(2022, 5, 14), "Borussia Monchengladbach", "5:01", "TSG 1899 Hoffenheim", "50395", "Borussia-Park"),
                new Match(new GregorianCalendar(2022, 8, 5), "Eintracht Frankfurt", "1:06", "FC Bayern Munich", "51500", "Deutsche Bank Park"),
                new Match(new GregorianCalendar(2022, 8, 6), "VfL Bochum", "1:02", "1. FSV Mainz 05", "24110", "Vonovia Ruhrstadion"),
                new Match(new GregorianCalendar(2022, 8, 6), "VfL Wolfsburg", "2:02", "Werder Bremen", "28015", "Volkswagen Arena"),
                new Match(new GregorianCalendar(2022, 8, 6), "Borussia Monchengladbach", "3:01", "TSG 1899 Hoffenheim", "49659", "Borussia-Park"),
                new Match(new GregorianCalendar(2022, 8, 6), "1. FC Union Berlin", "3:01", "Hertha BSC", "22012", "Stadion An der Alten Försterei"),
                new Match(new GregorianCalendar(2022, 8, 6), "FC Augsburg", "0:04", "Freiburg", "25310", "WWK Arena"),
                new Match(new GregorianCalendar(2022, 8, 6), "Borussia Dortmund", "1:00", "Bayer 04 Leverkusen", "81365", "Signal Iduna Park"),
                new Match(new GregorianCalendar(2022, 8, 7), "Stuttgart", "1:01", "RB Leipzig", "46000", "Mercedes-Benz Arena"),
                new Match(new GregorianCalendar(2022, 8, 7), "1. FC Cologne", "3:01", "FC Schalke 04", "50000", "RheinEnergieSTADION"),
                new Match(new GregorianCalendar(2022, 8, 12), "Freiburg", "1:03", "Borussia Dortmund", "34700", "Europa-Park Stadion"),
                new Match(new GregorianCalendar(2022, 8, 13), "Bayer 04 Leverkusen", "1:02", "FC Augsburg", "22903", "BayArena"),
                new Match(new GregorianCalendar(2022, 8, 13), "Werder Bremen", "2:02", "Stuttgart", "41000", "Weser-Stadion"),
                new Match(new GregorianCalendar(2022, 8, 13), "Hertha BSC", "1:01", "Eintracht Frankfurt", "44694", "Olympiastadion Berlin"),
                new Match(new GregorianCalendar(2022, 8, 13), "TSG 1899 Hoffenheim", "3:02", "VfL Bochum", "17005", "PreZero Arena"),
                new Match(new GregorianCalendar(2022, 8, 13), "RB Leipzig", "2:02", "1. FC Cologne", "43579", "Red Bull Arena"),
                new Match(new GregorianCalendar(2022, 8, 13), "FC Schalke 04", "2:02", "Borussia Monchengladbach", "62271", "Veltins-Arena"),
                new Match(new GregorianCalendar(2022, 8, 14), "1. FSV Mainz 05", "0:00", "1. FC Union Berlin", "25009", "Mewa Arena"),
                new Match(new GregorianCalendar(2022, 8, 14), "FC Bayern Munich", "2:00", "VfL Wolfsburg", "75000", "Allianz Arena"),
                new Match(new GregorianCalendar(2022, 8, 19), "Borussia Monchengladbach", "1:00", "Hertha BSC", "48411", "Borussia-Park"),
                new Match(new GregorianCalendar(2022, 8, 20), "Stuttgart", "0:01", "Freiburg", "47500", "Mercedes-Benz Arena"),
                new Match(new GregorianCalendar(2022, 8, 20), "Borussia Dortmund", "2:03", "Werder Bremen", "81365", "Signal Iduna Park"),
                new Match(new GregorianCalendar(2022, 8, 20), "VfL Wolfsburg", "0:00", "FC Schalke 04", "26959", "Volkswagen Arena"),
                new Match(new GregorianCalendar(2022, 8, 20), "FC Augsburg", "1:02", "1. FSV Mainz 05", "23755", "WWK Arena"),
                new Match(new GregorianCalendar(2022, 8, 20), "Bayer 04 Leverkusen", "0:03", "TSG 1899 Hoffenheim", "26300", "BayArena"),
                new Match(new GregorianCalendar(2022, 8, 20), "1. FC Union Berlin", "2:01", "RB Leipzig", "21056", "Stadion An der Alten Försterei"),
                new Match(new GregorianCalendar(2022, 8, 21), "Eintracht Frankfurt", "1:01", "1. FC Cologne", "50800", "Deutsche Bank Park"),
                new Match(new GregorianCalendar(2022, 8, 21), "VfL Bochum", "0:07", "FC Bayern Munich", "26000", "Vonovia Ruhrstadion"),
                new Match(new GregorianCalendar(2022, 8, 26), "Freiburg", "1:00", "VfL Bochum", "32800", "Europa-Park Stadion"),
                new Match(new GregorianCalendar(2022, 8, 27), "RB Leipzig", "2:00", "VfL Wolfsburg", "41243", "Red Bull Arena"),
                new Match(new GregorianCalendar(2022, 8, 27), "Hertha BSC", "0:01", "Borussia Dortmund", "62142", "Olympiastadion Berlin"),
                new Match(new GregorianCalendar(2022, 8, 27), "1. FSV Mainz 05", "0:03", "Bayer 04 Leverkusen", "28500", "Mewa Arena"),
                new Match(new GregorianCalendar(2022, 8, 27), "TSG 1899 Hoffenheim", "1:00", "FC Augsburg", "17206", "PreZero Arena"),
                new Match(new GregorianCalendar(2022, 8, 27), "FC Schalke 04", "1:06", "1. FC Union Berlin", "62271", "Veltins-Arena"),
                new Match(new GregorianCalendar(2022, 8, 27), "FC Bayern Munich", "1:01", "Borussia Monchengladbach", "75000", "Allianz Arena"),
                new Match(new GregorianCalendar(2022, 8, 28), "1. FC Cologne", "0:00", "Stuttgart", "50000", "RheinEnergieSTADION"),
                new Match(new GregorianCalendar(2022, 8, 28), "Werder Bremen", "3:04", "Eintracht Frankfurt", "41000", "Weser-Stadion"),
                new Match(new GregorianCalendar(2022, 9, 2), "Borussia Dortmund", "1:00", "TSG 1899 Hoffenheim", "79300", "Signal Iduna Park"),
                new Match(new GregorianCalendar(2022, 9, 3), "Stuttgart", "1:01", "FC Schalke 04", "47500", "Mercedes-Benz Arena"),
                new Match(new GregorianCalendar(2022, 9, 3), "VfL Bochum", "0:02", "Werder Bremen", "25800", "Vonovia Ruhrstadion"),
                new Match(new GregorianCalendar(2022, 9, 3), "Bayer 04 Leverkusen", "2:03", "Freiburg", "26853", "BayArena"),
                new Match(new GregorianCalendar(2022, 9, 3), "1. FC Union Berlin", "1:01", "FC Bayern Munich", "22012", "Stadion An der Alten Försterei"),
                new Match(new GregorianCalendar(2022, 9, 3), "VfL Wolfsburg", "2:04", "1. FC Cologne", "25654", "Volkswagen Arena"),
                new Match(new GregorianCalendar(2022, 9, 3), "Eintracht Frankfurt", "4:00", "RB Leipzig", "49700", "Deutsche Bank Park"),
                new Match(new GregorianCalendar(2022, 9, 4), "FC Augsburg", "0:02", "Hertha BSC", "25789", "WWK Arena"),
                new Match(new GregorianCalendar(2022, 9, 4), "Borussia Monchengladbach", "0:01", "1. FSV Mainz 05", "51210", "Borussia-Park"),
                new Match(new GregorianCalendar(2022, 9, 9), "Werder Bremen", "0:01", "FC Augsburg", "41000", "Weser-Stadion"),
                new Match(new GregorianCalendar(2022, 9, 10), "Hertha BSC", "2:02", "Bayer 04 Leverkusen", "40643", "Olympiastadion Berlin"),
                new Match(new GregorianCalendar(2022, 9, 10), "TSG 1899 Hoffenheim", "4:01", "1. FSV Mainz 05", "20114", "PreZero Arena"),
                new Match(new GregorianCalendar(2022, 9, 10), "Eintracht Frankfurt", "0:01", "VfL Wolfsburg", "49000", "Deutsche Bank Park"),
                new Match(new GregorianCalendar(2022, 9, 10), "FC Bayern Munich", "2:02", "Stuttgart", "75000", "Allianz Arena"),
                new Match(new GregorianCalendar(2022, 9, 10), "RB Leipzig", "3:00", "Borussia Dortmund", "47069", "Red Bull Arena"),
                new Match(new GregorianCalendar(2022, 9, 10), "FC Schalke 04", "3:01", "VfL Bochum", "62041", "Veltins-Arena"),
                new Match(new GregorianCalendar(2022, 9, 11), "1. FC Cologne", "0:01", "1. FC Union Berlin", "49500", "RheinEnergieSTADION"),
                new Match(new GregorianCalendar(2022, 9, 11), "Freiburg", "0:00", "Borussia Monchengladbach", "34700", "Europa-Park Stadion"),
                new Match(new GregorianCalendar(2022, 9, 16), "1. FSV Mainz 05", "1:01", "Hertha BSC", "25300", "Mewa Arena"),
                new Match(new GregorianCalendar(2022, 9, 17), "Borussia Dortmund", "1:00", "FC Schalke 04", "81100", "Signal Iduna Park"),
                new Match(new GregorianCalendar(2022, 9, 17), "Bayer 04 Leverkusen", "1:01", "Werder Bremen", "30210", "BayArena"),
                new Match(new GregorianCalendar(2022, 9, 17), "FC Augsburg", "1:00", "FC Bayern Munich", "30660", "WWK Arena"),
                new Match(new GregorianCalendar(2022, 9, 17), "Stuttgart", "1:03", "Eintracht Frankfurt", "47500", "Mercedes-Benz Arena"),
                new Match(new GregorianCalendar(2022, 9, 17), "Borussia Monchengladbach", "3:00", "RB Leipzig", "50186", "Borussia-Park"),
                new Match(new GregorianCalendar(2022, 9, 18), "1. FC Union Berlin", "2:00", "VfL Wolfsburg", "22012", "Stadion An der Alten Försterei"),
                new Match(new GregorianCalendar(2022, 9, 18), "VfL Bochum", "1:01", "1. FC Cologne", "25800", "Vonovia Ruhrstadion"),
                new Match(new GregorianCalendar(2022, 9, 18), "TSG 1899 Hoffenheim", "0:00", "Freiburg", "24233", "PreZero Arena"),
                new Match(new GregorianCalendar(2022, 9, 30), "FC Bayern Munich", "4:00", "Bayer 04 Leverkusen", "75000", "Allianz Arena"),
                new Match(new GregorianCalendar(2022, 10, 1), "VfL Wolfsburg", "3:02", "Stuttgart", "24125", "Volkswagen Arena"),
                new Match(new GregorianCalendar(2022, 10, 1), "1. FC Cologne", "3:02", "Borussia Dortmund", "50000", "RheinEnergieSTADION"),
                new Match(new GregorianCalendar(2022, 10, 1), "Freiburg", "2:01", "1. FSV Mainz 05", "34700", "Europa-Park Stadion"),
                new Match(new GregorianCalendar(2022, 10, 1), "Eintracht Frankfurt", "2:00", "1. FC Union Berlin", "50500", "Deutsche Bank Park"),
                new Match(new GregorianCalendar(2022, 10, 1), "RB Leipzig", "4:00", "VfL Bochum", "44403", "Red Bull Arena"),
                new Match(new GregorianCalendar(2022, 10, 1), "Werder Bremen", "5:01", "Borussia Monchengladbach", "42100", "Weser-Stadion"),
                new Match(new GregorianCalendar(2022, 10, 2), "Hertha BSC", "1:01", "TSG 1899 Hoffenheim", "41653", "Olympiastadion Berlin"),
                new Match(new GregorianCalendar(2022, 10, 2), "FC Schalke 04", "2:03", "FC Augsburg", "60328", "Veltins-Arena"),
                new Match(new GregorianCalendar(2022, 10, 7), "TSG 1899 Hoffenheim", "1:02", "Werder Bremen", "25410", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 8), "1. FSV Mainz 05", "1:01", "RB Leipzig", "26100", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 8), "FC Augsburg", "1:01", "VfL Wolfsburg", "26220", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 8), "VfL Bochum", "3:00", "Eintracht Frankfurt", "24850", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 8), "Bayer 04 Leverkusen", "4:00", "FC Schalke 04", "30210", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 8), "Borussia Dortmund", "2:02", "FC Bayern Munich", "81365", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 9), "Borussia Monchengladbach", "5:02", "1. FC Cologne", "54042", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 9), "Hertha BSC", "2:02", "Freiburg", "40481", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 9), "Stuttgart", "0:01", "1. FC Union Berlin", "43250", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 14), "FC Schalke 04", "0:03", "TSG 1899 Hoffenheim", "59811", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 15), "Werder Bremen", "0:02", "1. FSV Mainz 05", "41000", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 15), "Stuttgart", "4:01", "VfL Bochum", "45400", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 15), "VfL Wolfsburg", "2:02", "Borussia Monchengladbach", "26701", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 15), "Eintracht Frankfurt", "5:01", "Bayer 04 Leverkusen", "49700", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 15), "RB Leipzig", "3:02", "Hertha BSC", "47069", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 16), "1. FC Cologne", "3:02", "FC Augsburg", "49000", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 16), "1. FC Union Berlin", "2:00", "Borussia Dortmund", "22012", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 16), "FC Bayern Munich", "5:00", "Freiburg", "75000", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 21), "1. FSV Mainz 05", "5:00", "1. FC Cologne", "31610", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 22), "TSG 1899 Hoffenheim", "0:02", "FC Bayern Munich", "30150", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 22), "Freiburg", "2:00", "Werder Bremen", "34700", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 22), "Bayer 04 Leverkusen", "2:02", "VfL Wolfsburg", "26294", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 22), "FC Augsburg", "3:03", "RB Leipzig", "25109", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 22), "Borussia Dortmund", "5:00", "Stuttgart", "81365", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 22), "Borussia Monchengladbach", "1:03", "Eintracht Frankfurt", "53019", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 23), "VfL Bochum", "2:01", "1. FC Union Berlin", "25460", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 23), "Hertha BSC", "2:01", "FC Schalke 04", "60165", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 28), "Werder Bremen", "1:00", "Hertha BSC", "42100", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 29), "Stuttgart", "2:01", "FC Augsburg", "46400", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 29), "RB Leipzig", "2:00", "Bayer 04 Leverkusen", "45598", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 29), "FC Bayern Munich", "6:02", "1. FSV Mainz 05", "75000", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 29), "VfL Wolfsburg", "4:00", "VfL Bochum", "24037", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 29), "Eintracht Frankfurt", "1:02", "Borussia Dortmund", "50000", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 30), "FC Schalke 04", "0:02", "Freiburg", "61115", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 30), "1. FC Cologne", "1:01", "TSG 1899 Hoffenheim", "49000", "NULL"),
                new Match(new GregorianCalendar(2022, 10, 30), "1. FC Union Berlin", "2:01", "Borussia Monchengladbach", "22012", "NULL"),
                new Match(new GregorianCalendar(2022, 11, 4), "Borussia Monchengladbach", "3:01", "Stuttgart", "53178", "NULL"),
                new Match(new GregorianCalendar(2022, 11, 5), "Hertha BSC", "2:03", "FC Bayern Munich", "74667", "NULL"),
                new Match(new GregorianCalendar(2022, 11, 5), "TSG 1899 Hoffenheim", "1:03", "RB Leipzig", "23127", "NULL"),
                new Match(new GregorianCalendar(2022, 11, 5), "FC Augsburg", "1:02", "Eintracht Frankfurt", "30087", "NULL"),
                new Match(new GregorianCalendar(2022, 11, 5), "Borussia Dortmund", "3:00", "VfL Bochum", "81365", "NULL"),
                new Match(new GregorianCalendar(2022, 11, 5), "1. FSV Mainz 05", "0:03", "VfL Wolfsburg", "26750", "NULL"),
                new Match(new GregorianCalendar(2022, 11, 5), "Werder Bremen", "2:01", "FC Schalke 04", "41000", "NULL"),
                new Match(new GregorianCalendar(2022, 11, 6), "Bayer 04 Leverkusen", "5:00", "1. FC Union Berlin", "30210", "NULL"),
                new Match(new GregorianCalendar(2022, 11, 6), "Freiburg", "2:00", "1. FC Cologne", "33800", "NULL"),
                new Match(new GregorianCalendar(2022, 11, 8), "VfL Wolfsburg", "2:00", "Borussia Dortmund", "28675", "NULL"),
                new Match(new GregorianCalendar(2022, 11, 8), "Stuttgart", "2:01", "Hertha BSC", "44500", "NULL"),
                new Match(new GregorianCalendar(2022, 11, 8), "VfL Bochum", "2:01", "Borussia Monchengladbach", "25900", "NULL"),
                new Match(new GregorianCalendar(2022, 11, 8), "FC Bayern Munich", "6:01", "Werder Bremen", "75000", "NULL"),
                new Match(new GregorianCalendar(2022, 11, 9), "1. FC Cologne", "1:02", "Bayer 04 Leverkusen", "50000", "NULL"),
                new Match(new GregorianCalendar(2022, 11, 9), "RB Leipzig", "3:01", "Freiburg", "41240", "NULL"),
                new Match(new GregorianCalendar(2022, 11, 9), "FC Schalke 04", "1:00", "1. FSV Mainz 05", "58256", "NULL"),
                new Match(new GregorianCalendar(2022, 11, 9), "1. FC Union Berlin", "2:02", "FC Augsburg", "22012", "NULL"),
                new Match(new GregorianCalendar(2022, 11, 9), "Eintracht Frankfurt", "4:02", "TSG 1899 Hoffenheim", "49000", "NULL"),
                new Match(new GregorianCalendar(2022, 11, 11), "Borussia Monchengladbach", "4:02", "Borussia Dortmund", "54042", "Borussia-Park"),
                new Match(new GregorianCalendar(2022, 11, 12), "TSG 1899 Hoffenheim", "1:02", "VfL Wolfsburg", "18014", "PreZero Arena"),
                new Match(new GregorianCalendar(2022, 11, 12), "FC Augsburg", "0:01", "VfL Bochum", "28011", "WWK Arena"),
                new Match(new GregorianCalendar(2022, 11, 12), "Hertha BSC", "2:00", "1. FC Cologne", "60827", "Olympiastadion Berlin"),
                new Match(new GregorianCalendar(2022, 11, 12), "Werder Bremen", "1:02", "RB Leipzig", "41500", "Weser-Stadion"),
                new Match(new GregorianCalendar(2022, 11, 12), "Bayer 04 Leverkusen", "2:00", "Stuttgart", "30210", "BayArena"),
                new Match(new GregorianCalendar(2022, 11, 12), "FC Schalke 04", "0:02", "FC Bayern Munich", "62271", "Veltins-Arena"),
                new Match(new GregorianCalendar(2022, 11, 13), "1. FSV Mainz 05", "1:01", "Eintracht Frankfurt", "33305", "Mewa Arena"),
                new Match(new GregorianCalendar(2022, 11, 13), "Freiburg", "4:01", "1. FC Union Berlin", "33800", "NULL")
        );
    }
}
```

Класс module_3.lecture_4.javaTasksExamples.Match:
```java
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

Далее примеры, которые сводятся к аналитическим параметрам:
```java
class JTExample2 {
    public static void main(String[] args) {
        //...

        
        // выбрать все матчи которые были в первой половине месяца
        matches.stream().filter(x -> x.getDate().get(Calendar.DATE) >= 15).forEach(x -> System.out.println(x));

        
        // посчитать общее количество матчей в выборке
        System.out.println(matches.stream().count());

        
        // выбрать топ 10 самых посещаемых матчей
        System.out.println(matches.stream().sorted((x,y) -> -(x.getWatchers() - y.getWatchers())).limit(10).toList());

        
        // выбрать топ 3 матчей с самой большой разницей в счете на стадионе WWK Arena
        System.out.println(matches.stream().filter(x -> x.getStadium().equals("WWK Arena")).toList());
        System.out.println(
                matches
                        .stream()
                        .filter(x -> x.getStadium().equals("WWK Arena"))
                        .sorted((x,y) -> Math.abs(x.getResult1() - x.getResult2()) - Math.abs((y.getResult1() - y.getResult2()))).toList());

        // посчитать сколько матчей содержат упоминания о стадионе
        System.out.println(matches.stream().filter(x -> !x.getStadium().contains("NULL")).count());
        System.out.println(matches.stream().filter(x -> x.getStadium().contains("NULL")).count());

        
        // посчитать сколько матчей сыграла каждая команда в качестве гостя (в формате map)
        // можно посчитать примерную скорость работы, продемонстрировать что будет быстрее (это не оптимальный вариант замера скорости, но некий ориентир, можно рассказать как это происходит на практике)
        long start = System.nanoTime();

        Map<String, Long> map = new HashMap<>();
        for (module_3.lecture_4.javaTasksExamples.Match match : matches) {
            if (!map.containsKey(match.getTeam2()))
                map.put(match.getTeam2(), 1L);
            else
                map.put(match.getTeam2(), map.get(match.getTeam2()) + 1);
        }

        System.out.println(map);
        long finish = System.nanoTime();
        System.out.println(finish - start);

        
        // и с помощью stream API
        // можно посчитать примерную скорость работы
        long start = System.nanoTime();
        System.out.println(matches.stream().collect(Collectors.groupingBy(x -> x.getTeam2(), Collectors.counting())));
        long finish = System.nanoTime();
        System.out.println(finish - start);

        
        // проверка
        System.out.println(map.values().stream().sorted().toList().equals(matches.stream().collect(Collectors.groupingBy(x -> x.getTeam2(), Collectors.counting())).values().stream().sorted().toList()));
        System.out.println(map.values().stream().sorted().toList());
        System.out.println(matches.stream().collect(Collectors.groupingBy(x -> x.getTeam2(), Collectors.counting())).values().stream().sorted().toList());


        // выделить наиболее популярный день проведения матча
        Map<Integer, Long> collect = matches.stream().collect(Collectors.groupingBy(x -> x.getDate().get(Calendar.DATE), Collectors.counting()));
        System.out.println(collect);
        System.out.println(collect.entrySet().stream().max((x,y) -> x.getValue() > y.getValue() ? 1 : -1));
    }
}
```