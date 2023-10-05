// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {



        Gameboard gameboard = new Gameboard();
        Player p1 = new Player("Jennet", 'X');
        Player p2 = new Player("John", 'O');


        while (true) {
            gameboard.switchPlayer(p1);
            gameboard.setPiece();
            gameboard.checkIfThreeInArow(p1.getGamePiece());
            gameboard.drawBoard();
            gameboard.switchPlayer(p2);
            gameboard.setPiece();
            gameboard.checkIfThreeInArow(p2.getGamePiece());
            gameboard.drawBoard();
        }

    }
}