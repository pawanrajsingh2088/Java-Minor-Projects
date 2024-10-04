import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorsGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] options = {"Rock", "Paper", "Scissors"};
        String playerMove, computerMove;
        String playAgain;
        boolean keepPlaying = true;

        System.out.println("Welcome to the Rock, Paper, Scissors Game!");

        while (keepPlaying) {
            // Get player move
            System.out.println("Enter your move (Rock, Paper, or Scissors): ");
            playerMove = scanner.nextLine().toLowerCase();

            // Validate player move
            if (!playerMove.equals("rock") && !playerMove.equals("paper") && !playerMove.equals("scissors")) {
                System.out.println("Invalid move. Please try again.");
                continue;
            }

            // Get computer's move
            int randomIndex = random.nextInt(3); // Randomly select between 0, 1, and 2
            computerMove = options[randomIndex].toLowerCase();

            System.out.println("Computer chose: " + computerMove);

            // Determine the winner
            if (playerMove.equals(computerMove)) {
                System.out.println("It's a tie!");
            } else if (playerMove.equals("rock") && computerMove.equals("scissors") ||
                       playerMove.equals("paper") && computerMove.equals("rock") ||
                       playerMove.equals("scissors") && computerMove.equals("paper")) {
                System.out.println("You win!");
            } else {
                System.out.println("Computer wins!");
            }

            // Ask if the player wants to play again
            System.out.println("Do you want to play again? (yes/no)");
            playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equals("yes")) {
                keepPlaying = false;
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}