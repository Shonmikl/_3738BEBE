import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class JTExample9 {
    public static void main(String[] args) {
        List<FootballTeam> footballTeamList = new ArrayList<>();

        footballTeamList.add(new FootballTeam("Essen", 7));
        footballTeamList.add(new FootballTeam("Dusseldorf", 6));
        footballTeamList.add(new FootballTeam("Dortmund", 9));
        footballTeamList.add(new FootballTeam("Cologne", 7));
        footballTeamList.add(new FootballTeam("Wuppertal", 6));

        BiPredicate<String, Integer> biPredicate = (team, power) -> {
            return (team.equalsIgnoreCase("Dusseldorf") || power == 7);
        };

        List<FootballTeam> result1 = customFilter(footballTeamList, biPredicate);
        result1.forEach(x -> System.out.print(x.getName() + " " + x.getPower() + "; "));

        System.out.println();

        List<FootballTeam> result2 = customFilter(footballTeamList, (team, power) -> power == 6);
        result2.forEach(x -> System.out.print(x.getName() + " " + x.getPower() + "; "));
    }

    public static List<FootballTeam> customFilter(List<FootballTeam> list, BiPredicate<String, Integer> biPredicate) {
        return list.stream().filter(x -> biPredicate.test(x.getName(), x.getPower())).toList();
    }
}

class FootballTeam {
    private String name;
    private Integer power;

    public FootballTeam(String name, Integer score) {
        this.name = name;
        this.power = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }
}