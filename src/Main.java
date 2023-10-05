import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        //choose between 1 player or two players
        System.out.println();
        System.out.println("""
                Hello! :D
                Welcome to the game of TicTacToe!                            
                """);


        Gameboard gameboard = new Gameboard();



        ArrayList<Player> playerList = multiPlayer();
        playGame(playerList, gameboard);

    }

    private static ArrayList<Player> multiPlayer() {
        ArrayList<Player> playerList = new ArrayList<>();

        System.out.println("Write out the name of first player");
        String playerName1 = scan.nextLine();
        System.out.println("Write out a name for second player");
        String playerName2 = scan.nextLine();

        Player p1 = new Player(playerName1, 'X');
        Player p2 = new Player(playerName2, 'O');
        playerList.add(p1);
        playerList.add(p2);

        return playerList;
    }

    public static int askWhichSquare() {

        System.out.println("Which square do you want to choose");
        int whichSquare = scan.nextInt();
        return whichSquare;
    }

    public static void playGame(ArrayList<Player> playerList, Gameboard gameboard) {

        while (true) {
            for (Player player : playerList) {
                System.out.println("Player " + player.getName() + " - it's your turn to put " + player.getGamePiece());
                gameboard.switchPlayer(player);
                int whichSquare = askWhichSquare();
                gameboard.setPiece(whichSquare);
                gameboard.drawBoard();
                gameboard.checkIfThreeInArow(player.getGamePiece());
                gameboard.ifThereIsATie();

                if(gameboard.checkIfThreeInArow(player.getGamePiece())){
                    System.out.println("CONGRATZZZ YOU WON!!! "+ player.getName());
                    player.increaseScore();
                    System.out.println("You have " +player.getScore() +" in score");
                    return;
                }
                if(gameboard.ifThereIsATie()){
                    System.out.println("No one won! You've got a tie");
                    return;
                }
            }
        }

    }
}
