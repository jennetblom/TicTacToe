import java.util.Scanner;

public class Gameboard {

    //A gameboardklass with a scanner, currentplayer och a gamepiece(X or O)
    static Scanner scan = new Scanner(System.in);
    private static char[][] board;
    private Player currentPlayer;

    public Gameboard() {
        board = new char[3][3];
        //When a new gameboard is created, the method iniatialiseBoard() is called and gives every square an empty value.
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

        //This is where the new game board is drawn, assigning an empty value to each square.
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
        //The gameboard with current values

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

    public void setPiece(int whichSquare) {
        //Converts a square between 1-9 to a row and column on the checkboard.
        //This method places a player's gamepiece on the gameboard.

        int row = (whichSquare - 1) / 3;
        int column = (whichSquare - 1) % 3;
        board[row][column]=currentPlayer.getGamePiece();
    }

    public boolean isSquareEmpty(int whichSquare) {
        //Controls if the square chosen is an empty square.

        int row = (whichSquare - 1) / 3;
        int column = (whichSquare - 1) % 3;

        //Returnera true om en ruta är tom.
        if (board[row][column]== ' ') {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIfThreeInArow(char piece) {

        //Return true if it's three in a row
        //Otherwise return false

        //Controls all the rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == piece && board[row][1] == piece && board[row][2] == piece) {
                return true;
            }
        }
        //Controls all the columns
        for (int column = 0; column < 3; column++) {
            if (board[0][column] == piece && board[1][column] == piece && board[2][column] == piece) {
                return true;
            }
        }
        //Controls the diagonals
        if (board[0][0] == piece && board[1][1] == piece && board[2][2] == piece) {
            return true;
        }
        if (board[2][0] == piece && board[1][1] == piece && board[0][2] == piece) {
            return true;
        }
        return false;
    }

    public boolean ifThereIsATie() {
        //If all the squares is taken, return true;

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
