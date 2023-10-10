import java.util.Scanner;

public class Gameboard {

    //Skapar en gameboardklassen med en scanner, nuvarande spelare och en spelpjäs.
    static Scanner scan = new Scanner(System.in);
    private static char[][] board;
    private Player currentPlayer;

    public Gameboard() {
        board = new char[3][3];
        //När en ny spelbräda skapas kallas metoden iniatiliseBoard() som ger varje ruta ett tomt värde.
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

        //Här ritas den nya spelbrädan upp och ger varje ruta ett tomt värde.
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
        //Här ritas den aktuella spelbrädan upp

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

        int row = (whichSquare - 1) / 3;
        int column = (whichSquare - 1) % 3;
        board[row][column]=currentPlayer.getGamePiece();
    }

    public boolean isSquareEmpty(int whichSquare) {

        int row = (whichSquare - 1) / 3;
        int column = (whichSquare - 1) % 3;

        //Returnera true om en ruta är tom.
        if (board[row][column] == ' ') {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIfThreeInArow(char piece) {

        //Returnera true om det blir tre i rad: horisontellt, vertikalt eller diagonalt. Annars returneras false.
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

        //Kontrollerar om det blir oavgjort genom att se att alla rutor är fyllda.
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
