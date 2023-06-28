import java.util.Scanner;

public class Example7 {
    private static final int FIELD_LENGTH = 10;
    private static final Scanner scanner = new Scanner(System.in);
    private static final int[][] SHIP_DECK_AMOUNT = {{4, 1}, {3, 2}, {2, 1}, {1, 4}};

    public static void main(String[] args) {
        System.out.print("First player, please, input your name: ");
        String playerOne = scanner.nextLine();
        System.out.println("Hi, " + playerOne + "!");

        System.out.print("Second player, please, input your name: ");
        String playerTwo = scanner.nextLine();
        System.out.println("Hi, " + playerTwo + "!");

        char[][] playerFieldOne = new char[FIELD_LENGTH][FIELD_LENGTH];
        char[][] playerFieldTwo = new char[FIELD_LENGTH][FIELD_LENGTH];

        fillPlayerField(playerFieldOne);
        fillPlayerField(playerFieldTwo);
        startGame(playerOne, playerTwo, playerFieldOne, playerFieldTwo);
    }

    private static void fillPlayerField(char[][] playerField) {
        for (int i = 0; i < SHIP_DECK_AMOUNT.length; i++) {
            int shipCount = SHIP_DECK_AMOUNT[i][1];
            for (int j = 0; j < shipCount; j++) {
                System.out.println("Put " + SHIP_DECK_AMOUNT[i][0] + " deck ship. Left: " + (shipCount - j));

                int result = 1;
                int x = 0;
                int y = 0;
                int direction = 0;
                while (result != 0) {
                    System.out.println("Input start x coordinate: ");
                    x = scanner.nextInt();

                    System.out.println("Input start y coordinate: ");
                    y = scanner.nextInt();

                    System.out.println("Input direction of ship: ");
                    System.out.println("1 - horizontal; 2 - vertical;");
                    direction = scanner.nextInt();
                    // if the coordinate did not pass validation, then the method returns a negative
                    // value, so the user will have to enter the coordinates again
                    result = validateCoordinateForShip(playerField, x, y, direction, i);
                }

                int shipDeck = SHIP_DECK_AMOUNT[i][0];
                if (direction == 1) {
                    for (int k = 0; k < shipDeck; k++) {
                        playerField[y][x + k] = '=';
                    }
                }
                if (direction == 2) {
                    for (int k = 0; k < shipDeck; k++) {
                        playerField[y + k][x] = '=';
                    }
                }

                printField(playerField);
            }
        }
    }

    static void printField(char[][] field) {
        for (char[] chars : field) {
            for (char aChar : chars) {
                if (aChar == 0) {
                    System.out.print(" |");
                } else {
                    System.out.print(aChar + "|");
                }
            }

            System.out.println("");
            System.out.println("--------------------");
        }
    }

    private static void startGame(String playerOne, String playerTwo, char[][] playerFieldOne, char[][] playerFieldTwo) {
        // save all the shots
        char[][] playerBattleFieldOne = new char[FIELD_LENGTH][FIELD_LENGTH];
        char[][] playerBattleFieldTwo = new char[FIELD_LENGTH][FIELD_LENGTH];

        // determine the current player
        String currentPlayer = playerOne;
        char[][] currentPlayerField = playerFieldTwo;
        char[][] currentPlayerEnemyField = playerBattleFieldOne;

        while (isPlayerAlive(playerFieldOne) && isPlayerAlive(playerFieldTwo)) {
            // display of all player's shots
            printField(currentPlayerEnemyField);
            // shot coordinates
            System.out.println(currentPlayer + ", please, input x coordinate of shot");
            int xShot = scanner.nextInt();
            System.out.println(currentPlayer + ", please, input y coordinate of shot");
            int yShot = scanner.nextInt();

            // processing the shot
            int shotResult = verificationShot(currentPlayerEnemyField, currentPlayerField, xShot, yShot);
            // if you are a loser the turn goes to the next player
            if (shotResult == 0) {
                currentPlayer = playerTwo;
                currentPlayerField = playerFieldOne;
                currentPlayerEnemyField = playerBattleFieldTwo;
                System.out.println("You're a loser, the move goes to " + currentPlayer);
            }
        }
        System.out.println(currentPlayer + " is winner!");
    }

    /**
     * The method handles the shot.
     */
    private static int verificationShot(char[][] battleField, char[][] field, int x, int y) {
        if ('=' == (field[y][x])) {
            field[y][x] = '#';
            battleField[y][x] = '#';
            System.out.println("Good shot!");
            return 1;
        }
        battleField[y][x] = '*';
        System.out.println("Bad shot!");
        return 0;
    }

    /**
     * Method determines if alive or not
     */
    private static boolean isPlayerAlive(char[][] field) {
        for (char[] cells : field) {
            for (char cell : cells) {
                if ('=' == cell) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int validateCoordinateForShip(char[][] field, int x, int y, int direction, int shipDeck) {
        // horizontally
        if (direction == 1) {
            for (int i = 0; i < shipDeck - 1; i++) {
                if (x > 0) {
                    if ('=' == field[y][x + i - 1]) {
                        return -1;
                    }
                }
                if (y > 0) {
                    if ('=' == field[y - 1][x + i]) {
                        return -1;
                    }
                }
                if ('=' == field[y][x + i] || '=' == field[y][x + i + 1] || '=' == field[y + 1][x + i] || (x + i) > 9) {
                    return -1;
                }
            }
        } else if (direction == 2) { // vertically
            for (int i = 0; i < shipDeck - 1; i++) {
                if (y > 0) {
                    if ('=' == field[y + i - 1][x]) {
                        return -1;
                    }
                }
                if (x > 0) {
                    if ('=' == field[y + i][x - 1]) {
                        return -1;
                    }
                }
                if ('=' == field[y + i][x] || '=' == field[y + i + 1][x] || '=' == field[y + i][x + 1] || (y + i) > 9) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
