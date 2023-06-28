import java.util.*;

public class JTExample1 {

    public static void main(String[] args) {

        List<Integer> list_0 = Arrays.asList(10,11,22,12,14,10);

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
//        System.out.println(list_0.stream().filter(x -> x < 15).toList());
//        System.out.println(list_0.stream().filter(x -> x == 10).toList());
//
//        System.out.println(list_1.stream().filter(x -> x.getPower() < 5).toList());
//        System.out.println(list_1.stream().filter(x -> x.getName().equals("Essen")).toList());

        // sorted
//        System.out.println(list_0.stream().sorted().toList());
//        System.out.println(list_0.stream().sorted(Collections.reverseOrder()).toList()); // reverse
//
//        // наиболее очевидный способ:
//        System.out.println(list_1.stream().sorted((x,y) -> x.getName().compareTo(y.getName())).toList());
//        // через компаратор
//        System.out.println(list_1.stream().sorted(Comparator.comparing(x -> x.getName())).toList());
//
//        // наиболее очевидный способ:
//        System.out.println(list_1.stream().sorted((x,y) -> x.getPower() - y.getPower()).toList());
//        // через компаратор
//        System.out.println(list_1.stream().sorted(Comparator.comparingInt(x -> x.getPower())).toList());
//        // либо можно создать свой compareTo метод
//        System.out.println(list_1.stream().sorted().toList());

        // limit
//        System.out.println(list_0.stream().limit(2).toList());
//        System.out.println(list_1.stream().sorted().limit(3).toList());

        // skip
//        System.out.println(list_0);
//        System.out.println(list_0.stream().skip(2).toList());
//        System.out.println();
//        System.out.println(list_1);
//        System.out.println(list_1.stream().skip(2).collect(Collectors.toList()));

        // distinct
//        System.out.println(list_0);
//        System.out.println(list_0.stream().distinct().collect(Collectors.toList()));
//
//        // демонстрация работы списка с объектами ведет себя немного по-другому, можно спустится на уровень
//        // выделения памяти, где хранится объект и т.п. + показать пример с hashcode, чтоб было понимание,
//        // почему distinct в этом случае не отработал как этого хотелось бы
//        System.out.println(list_1);
//        System.out.println(list_1.stream().distinct().collect(Collectors.toList()));

        // peek
//        List<Integer> collect = list_0.stream().peek(x -> System.out.print(x + "; ")).toList();
//        System.out.println();
//        List<module_3.lecture_4.javaTasksExamples.FootBallTeam> footBallTeams = list_1.stream().peek(x -> System.out.print(x + "; ")).toList();

        // map
//        System.out.println(list_0.stream().map(x -> x + 100).toList());
//        System.out.println(list_1.stream().map(x -> x.getPower() * 2).toList());

        // flatmap
        // List<List<...>>
//        List<List<Integer>> lll = Arrays.asList(list_0, list_0);
//        System.out.println(lll.stream().flatMap(x -> x.stream()).map(x -> x*1000).toList());
//
//        // List<List<List<...>>>
//        List<List<List<Integer>>> llll = Arrays.asList(lll, lll);
//        System.out.println(llll);
//
//        System.out.println(
//                llll
//                        .stream()
//                        .flatMap(
//                                x -> x
//                                        .stream()
//                                        .flatMap(y -> y.stream()
//                                        )
//                        )
//                        .map(x -> x + 9)
//                        .toList());

        // List<List<Object>>
//        List<List<module_3.lecture_4.javaTasksExamples.FootBallTeam>> qq = Arrays.asList(list_1, list_1);
//        System.out.println(qq.stream().flatMap(x -> x.stream()).toList());
//
//        List<List<List<module_3.lecture_4.javaTasksExamples.FootBallTeam>>> qqq = Arrays.asList(qq, qq);
//        System.out.println(qqq.stream().flatMap(x -> x.stream().flatMap(y -> y.stream())).toList());

        // findFirst
//        System.out.println(list_0.stream().findFirst().get());
//        System.out.println(list_1.stream().sorted().findFirst().get());

        // count
//        System.out.println(list_1.stream().map(x -> x.getName()).filter(x -> x.equals("Essen")).count());

        // anyMatch
        System.out.println(list_0.stream().anyMatch(x -> x == 0));
        System.out.println(list_0.stream().anyMatch(x -> x == 10));

        System.out.println(list_1.stream().anyMatch(x -> x.getName().equals("Berlin")));
        System.out.println(list_1.stream().anyMatch(x -> x.getName().equals("Wuppertal")));
        System.out.println(list_1.stream().anyMatch(x -> x.hashCode() == list_1.get(1).hashCode()));


    }
}

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

