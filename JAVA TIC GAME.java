import java.util.Scanner;

 class TicTacToeGame {
    private char[][] board;
    private char currentPlayer;
    private boolean isGameOver;

    public TicTacToeGame() {
        board = new char[3][3];
        currentPlayer = 'X';
        isGameOver = false;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private void printBoard() {
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

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkWinner() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != '-' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }

        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }

        return false;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Player 1: X");
        System.out.println("Player 2: O");
        System.out.println("Player 1 goes first.");

        while (!isGameOver) {
            printBoard();

            int row, col;
            do {
                System.out.print("Player " + currentPlayer + ", enter row (1-3): ");
                row = scanner.nextInt() - 1;
                System.out.print("Player " + currentPlayer + ", enter column (1-3): ");
                col = scanner.nextInt() - 1;
            } while (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != '-');

            board[row][col] = currentPlayer;

            if (checkWinner()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                isGameOver = true;
            } else if (isBoardFull()) {
                printBoard();
                System.out.println("It's a draw!");
                isGameOver = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.playGame();
    }
}
