// Number Game
// User have to guess a number.

import java.util.*;

public class Number_Game {

    // Created Scanner object for taking user input
    Scanner sc = new Scanner(System.in);
    int score = 0;

    // Game Implementation
    int Game() {
        // Declaring some variables
        short number, guessCount = 0, guess;

        System.out.println(">>> Number Game <<<");
        // Generating a Random number and storing it in number variable.
        number = (short) (Math.random() * 100);
        // Users have 5 chance to guess the correct number
        // Every right guess comes with 5 points
        // But 1 point per chance will be deducted.
        while (guessCount < 5) {
            System.out.println("Guess a Number :: ");
            guess = sc.nextShort();
            if (guess > number) {
                System.out.println(">>>Guess is way more greater<<<");
            } else if (guess < number) {
                System.out.println(">>>Guess is way more smaller<<<");
            } else {
                System.out.println(">>>YAY! Correct Guess<<<");
                score = score + 5 - guessCount;
                System.out.printf("\n>>>User Score: %d<<<\n", score);
                break;
            }
            System.out.printf("\n>>>User Score: %d<<<\n", score);
            guessCount++;
            System.out.println(">>>TRY AGAIN<<<");
        }
        Menu();
        int choice = sc.nextShort();
        return choice;
    }

    // Menu
    void Menu() {
        System.out.println("\n>>>Press 1. to Restart the game!<<<");
        System.out.println(">>>Press 2. to exit.<<<");
    }

    // Main Function
    public static void main(String[] args) {
        Number_Game game = new Number_Game();
        int choice = game.Game();

        while (choice == 1) {
            choice = game.Game();
        }
    }
}
