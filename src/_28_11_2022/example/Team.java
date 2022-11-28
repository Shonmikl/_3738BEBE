package _28_11_2022.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team<T extends Participant> {
    private String name;
    private List<T> participants = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public void addNewParticipant(T participant) {
        participants.add(participant);
        System.out.println("New participant added: " + participant.getName());
    }

    //Team t = new Team("1");
    //Team team = new Team("2");
    //t.playWith(team);
    //this.playWith(team);
    public void playWith(Team<T> team) {
        String winner;
        Random random = new Random();
        int i = random.nextInt(2);
        if (i == 0) {
            winner = this.name;
        } else {
            winner = team.name;
        }
        System.out.println(winner);
    }
}