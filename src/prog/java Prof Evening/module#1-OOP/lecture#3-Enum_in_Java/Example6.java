import java.util.Random;
import java.util.Scanner;

public class Example6 {
    public static void main(String[] args) {
        final int cardsForPlayer = 5;
        int players;

        final Scanner sc = new Scanner(System.in);
        final Random random = new Random();

        final String[] suits = {"clubs", "diamonds", "hearts", "spades"};
        final String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        final int numberOfCards = suits.length * rank.length; // number of cards
        System.out.println(numberOfCards);

        while (true) {
            System.out.print("Enter number of players: ");

            if (sc.hasNextInt()) {
                players = sc.nextInt();

                if (cardsForPlayer * players <= numberOfCards) {
                    break;
                } else {
                    if (players == 0) {
                        System.out.println("The game has been terminated");
                        break;
                    } else if (players < 0) {
                        System.out.println("The number of players cannot be less than 0");
                        break;
                    } else {
                        System.out.println("Too many players");
                    }
                }
            } else {
                System.out.println("You have not entered a number, or your number is too large");
            }
        }

        // deck initialization
        String[] deck = new String[numberOfCards];
        for (int i = 0; i < rank.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                deck[suits.length * i + j] = rank[i] + " " + suits[j];
            }
        }

        // deck shuffling
        for (int i = 0; i < numberOfCards; i++) {
            int card = i + (random.nextInt(numberOfCards - i));

            String temp = deck[card];
            deck[card] = deck[i];
            deck[i] = temp;
        }

        // the shuffled deck is displayed
        for (int i = 0; i < players * cardsForPlayer; i++) {
            System.out.print(deck[i] + ", ");

            if (i % cardsForPlayer == cardsForPlayer - 1)
                System.out.println();
        }
    }
}
