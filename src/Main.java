// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        Gameboard board = new Gameboard();
        board.initialiseBoard();

        while (true) {
            board.setPiece();
            board.drawBoard();
            board.switchPlayer();
        }

    }

}

