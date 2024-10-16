import java.util.Scanner;

class Question {
    String question;
    String[] options;
    int answerIndex;

    public Question(String question, String[] options, int answerIndex) {
        this.question = question;
        this.options = options;
        this.answerIndex = answerIndex;
    }
}

public class KBCGame {
    private Question[] questions;
    private int score;

    public KBCGame() {
        questions = new Question[]{
            new Question("What is the capital of France?", new String[]{"1. Berlin", "2. Madrid", "3. Paris", "4. Rome"}, 2),
            new Question("What is 2 + 2?", new String[]{"1. 3", "2. 4", "3. 5", "4. 6"}, 1),
            new Question("Who wrote 'Romeo and Juliet'?", new String[]{"1. Charles Dickens", "2. William Shakespeare", "3. Mark Twain", "4. Leo Tolstoy"}, 1),
            new Question("What is the largest planet in our solar system?", new String[]{"1. Earth", "2. Jupiter", "3. Mars", "4. Saturn"}, 1),
            new Question("Which element has the chemical symbol 'O'?", new String[]{"1. Gold", "2. Oxygen", "3. Silver", "4. Helium"}, 1)
            // Add more questions as needed
        };
        score = 0;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        for (Question question : questions) {
            System.out.println(question.question);
            for (String option : question.options) {
                System.out.println(option);
            }
            System.out.print("Your answer (1-4): ");
            int answer = scanner.nextInt() - 1;

            if (answer == question.answerIndex) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + question.options[question.answerIndex]);
            }
            System.out.println();
        }
        System.out.println("Your final score is: " + score + " out of " + questions.length);
        scanner.close();
    }

    public static void main(String[] args) {
        KBCGame game = new KBCGame();
        game.startGame();
    }
}
