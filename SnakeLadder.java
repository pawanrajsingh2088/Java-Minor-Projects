import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class SnakeLadder {
    final static int WINNING_POSITION = 100;
    static Map<Integer, Integer> snakes = new HashMap<>();
    static Map<Integer, Integer> ladders = new HashMap<>();
    static {
        // Setting up snakes
        snakes.put(99, 54);
        snakes.put(70, 55);
        snakes.put(52, 42);
        snakes.put(25, 2);
        snakes.put(95, 72);

        // Setting up ladders
        ladders.put(6, 25);
        ladders.put(11, 40);
        ladders.put(60, 85);
        ladders.put(46, 90);
        ladders.put(17, 69);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int player1Position = 0;
        int player2Position = 0;
        boolean isPlayer1Turn = true;

        System.out.println("Welcome to Snake and Ladder Game!");

        while (player1Position < WINNING_POSITION && player2Position < WINNING_POSITION) {
            System.out.println((isPlayer1Turn ? "Player 1" : "Player 2") + "'s turn. Press Enter to roll the dice...");
            scanner.nextLine();

            int diceValue = random.nextInt(6) + 1;
            System.out.println("Rolled a " + diceValue);

            if (isPlayer1Turn) {
                player1Position = movePlayer(player1Position, diceValue);
                System.out.println("Player 1 is at position: " + player1Position);
            } else {
                player2Position = movePlayer(player2Position, diceValue);
                System.out.println("Player 2 is at position: " + player2Position);
            }

            if (player1Position == WINNING_POSITION) {
                System.out.println("Player 1 wins!");
                break;
            } else if (player2Position == WINNING_POSITION) {
                System.out.println("Player 2 wins!");
                break;
            }

            isPlayer1Turn = !isPlayer1Turn; // Switch turns
        }

        scanner.close();
    }

    private static int movePlayer(int playerPosition, int diceValue) {
        playerPosition += diceValue;

        if (playerPosition > WINNING_POSITION) {
            playerPosition -= diceValue; // Cannot move beyond the winning position
        } else if (snakes.containsKey(playerPosition)) {
            System.out.println("Oh no! Bitten by a snake!");
            playerPosition = snakes.get(playerPosition);
        } else if (ladders.containsKey(playerPosition)) {
            System.out.println("Yay! Climbing a ladder!");
            playerPosition = ladders.get(playerPosition);
        }

        return playerPosition;
    }
}