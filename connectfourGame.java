import java.util.Scanner;

public class ConnectFour {
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private char[][] board;
    private char currentPlayer;

    public ConnectFour() {
        board = new char[ROWS][COLS];
        currentPlayer = 'R'; // 'R' for Red and 'Y' for Yellow
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = '.'; // Empty slots represented by '.'
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean dropDisc(int col) {
        if (col < 0 || col >= COLS) {
            System.out.println("Column out of bounds! Try again.");
            return false;
        }
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][col] == '.') {
                board[i][col] = currentPlayer;
                return true;
            }
        }
        System.out.println("Column is full! Try again.");
        return false;
    }

    public boolean checkWin() {
        // Check horizontal, vertical, and diagonal (both directions) for a win
        return checkHorizontalWin() || checkVerticalWin() || checkDiagonalWin();
    }

    private boolean checkHorizontalWin() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS - 3; col++) {
                if (board[row][col] == currentPlayer &&
                    board[row][col + 1] == currentPlayer &&
                    board[row][col + 2] == currentPlayer &&
                    board[row][col + 3] == currentPlayer) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkVerticalWin() {
        for (int col = 0; col < COLS; col++) {
            for (int row = 0; row < ROWS - 3; row++) {
                if (board[row][col] == currentPlayer &&
                    board[row + 1][col] == currentPlayer &&
                    board[row + 2][col] == currentPlayer &&
                    board[row + 3][col] == currentPlayer) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonalWin() {
        for (int row = 0; row < ROWS - 3; row++) {
            for (int col = 0; col < COLS - 3; col++) {
                if (board[row][col] == currentPlayer &&
                    board[row + 1][col + 1] == currentPlayer &&
                    board[row + 2][col + 2] == currentPlayer &&
                    board[row + 3][col + 3] == currentPlayer) {
                    return true;
                }
            }
            for (int col = 3; col < COLS; col++) {
                if (board[row][col] == currentPlayer &&
                    board[row + 1][col - 1] == currentPlayer &&
                    board[row + 2][col - 2] == currentPlayer &&
                    board[row + 3][col - 3] == currentPlayer) {
                    return true;
                }
            }
        }
        return false;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'R') ? 'Y' : 'R';
    }

    public static void main(String[] args) {
        ConnectFour game = new ConnectFour();
        Scanner scanner = new Scanner(System.in);
        int moves = 0;

        while (true) {
            game.printBoard();
            System.out.println("Player " + game.currentPlayer + ", choose a column (0-6): ");
            int col = scanner.nextInt();

            if (game.dropDisc(col)) {
                moves++;
                if (game.checkWin()) {
                    game.printBoard();
                    System.out.println("Player " + game.currentPlayer + " wins!");
                    break;
                }
                if (moves == ROWS * COLS) {
                    game.printBoard();
                    System.out.println("It's a draw!");
                    break;
                }
                game.switchPlayer();
            }
        }
        scanner.close();
    }
}
