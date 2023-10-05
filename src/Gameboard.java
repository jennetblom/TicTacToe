import java.util.Scanner;

public class Gameboard {

    static Scanner scan = new Scanner(System.in);
    private static char[][] board;
    private Player currentPlayer;

    public Gameboard() {
        board = new char[3][3];
        initialiseBoard();
    }

    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer(Player player) {
        currentPlayer = player;
    }

    public void initialiseBoard() {

        board[0][0] = ' ';
        board[0][1] = ' ';
        board[0][2] = ' ';
        board[1][0] = ' ';
        board[1][1] = ' ';
        board[1][2] = ' ';
        board[2][0] = ' ';
        board[2][1] = ' ';
        board[2][2] = ' ';


        System.out.println("-------------------------");
        System.out.println("|       |       |       |");
        System.out.println("|   " + board[0][0] + "   |   " + board[0][1] + "   |   " + board[0][2] + "   |");
        System.out.println("|       |       |       |");
        System.out.println("-------------------------");
        System.out.println("|       |       |       |");
        System.out.println("|   " + board[1][0] + "   |   " + board[1][1] + "   |   " + board[1][2] + "   |");
        System.out.println("|       |       |       |");
        System.out.println("-------------------------");
        System.out.println("|       |       |       |");
        System.out.println("|   " + board[2][0] + "   |   " + board[2][1] + "   |   " + board[2][2] + "   |");
        System.out.println("|       |       |       |");
        System.out.println("-------------------------");
    }

    public void drawBoard() {

        System.out.println("-------------------------");
        System.out.println("|       |       |       |");
        System.out.println("|   " + board[0][0] + "   |   " + board[0][1] + "   |   " + board[0][2] + "   |");
        System.out.println("|       |       |       |");
        System.out.println("-------------------------");
        System.out.println("|       |       |       |");
        System.out.println("|   " + board[1][0] + "   |   " + board[1][1] + "   |   " + board[1][2] + "   |");
        System.out.println("|       |       |       |");
        System.out.println("-------------------------");
        System.out.println("|       |       |       |");
        System.out.println("|   " + board[2][0] + "   |   " + board[2][1] + "   |   " + board[2][2] + "   |");
        System.out.println("|       |       |       |");
        System.out.println("-------------------------");
    }

    public boolean setPiece(int whichSquare) {

        int row = (whichSquare - 1) / 3;
        int column = (whichSquare - 1) % 3;

        if (isSquareEmpty(row, column)) {
            board[row][column] = currentPlayer.getGamePiece();
            return true;
        } else {
            return false;
        }
    }

    public boolean isSquareEmpty(int row, int column) {
        if (board[row][column] == ' ') {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIfThreeInArow(char piece) {
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == piece && board[row][1] == piece && board[row][2] == piece) {
                return true;
            }
        }
        for (int column = 0; column < 3; column++) {
            if (board[0][column] == piece && board[1][column] == piece && board[2][column] == piece) {
                return true;
            }
        }
        if (board[0][0] == piece && board[1][1] == piece && board[2][2] == piece) {
            return true;
        }
        if (board[2][0] == piece && board[1][1] == piece && board[0][2] == piece) {
            return true;
        }
        return false;
    }

    public boolean ifThereIsATie() {

        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (board[row][column] == ' ') {
                    return false;

                }
            }
        }
        return true;
    }
}
