import java.util.Scanner;

public class TicTacToe {

    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean gameOn = true;

        while (gameOn) {
            printBoard();
            System.out.println("Player " + currentPlayer + "'s turn. Enter row and column (1-3 for both): ");
            
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (row < 0 || col < 0 || row > 2 || col > 2 || board[row][col] != ' ') {
                System.out.println("Invalid move, try again.");
                continue;
            }

            board[row][col] = currentPlayer;

            if (checkWinner(currentPlayer)) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                gameOn = false;
            } else if (isBoardFull()) {
                printBoard();
                System.out.println("The game is a draw!");
                gameOn = false;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        scanner.close();
    }

    public static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public static boolean checkWinner(char player) {
        // Check rows, columns, and diagonals
        return (board[0][0] == player && board[0][1] == player && board[0][2] == player) ||  // Row 1
               (board[1][0] == player && board[1][1] == player && board[1][2] == player) ||  // Row 2
               (board[2][0] == player && board[2][1] == player && board[2][2] == player) ||  // Row 3
               (board[0][0] == player && board[1][0] == player && board[2][0] == player) ||  // Column 1
               (board[0][1] == player && board[1][1] == player && board[2][1] == player) ||  // Column 2
               (board[0][2] == player && board[1][2] == player && board[2][2] == player) ||  // Column 3
               (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||  // Diagonal 1
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);    // Diagonal 2
    }

    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
