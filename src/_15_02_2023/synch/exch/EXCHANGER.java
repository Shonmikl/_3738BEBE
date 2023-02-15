package _15_02_2023.synch.exch;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class EXCHANGER {
    public static void main(String[] args) {
        Exchanger<Action> exchanger = new Exchanger<>();

        List<Action> myList = new LinkedList<>();
        myList.add(Action.SCISSORS);
        myList.add(Action.SCISSORS);
        myList.add(Action.PAPER);

        List<Action> opList = new LinkedList<>();
        opList.add(Action.PAPER);
        opList.add(Action.STONE);
        opList.add(Action.PAPER);

        new Player("P1", myList, exchanger);
        new Player("P2", opList, exchanger);
    }
}

enum Action {
    STONE,
    SCISSORS,
    PAPER
}

class Player extends Thread {
    private String name;
    private List<Action> actionList;

    private Exchanger<Action> exchanger;

    public Player(String name, List<Action> actionList, Exchanger<Action> exchanger) {
        this.name = name;
        this.actionList = actionList;
        this.exchanger = exchanger;
        this.start();
    }

    private void getWinner(Action my, Action op) {
        if (my == Action.SCISSORS && op == Action.PAPER ||
                my == Action.STONE && op == Action.SCISSORS ||
                my == Action.PAPER && op == Action.STONE) {
            System.out.println(name + " --> WINNER!");
        }
    }

    @Override
    public void run() {
        Action reply;
        for (Action action : actionList) {
            try {//a1 a2
                reply = exchanger.exchange(action);
                getWinner(action, reply);
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}