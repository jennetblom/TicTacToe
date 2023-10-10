import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {


        //choose between 1 player or two players
        System.out.println();
        System.out.println("""
                       ✿ H E L L O ! ✿         
                Welcome to the game of TicTacToe!                   
                """);

        Gameboard gameboard = new Gameboard();
        while (true) {
            int round=0;

            System.out.println("How do you want to play?");
            System.out.println("1. Singleplayer");
            System.out.println("2. Multiplayer ");

            int chooseGameMode = scan.nextInt();

            switch(chooseGameMode) {
                case 1: ArrayList<Player> playerListWithCpu=singlePlayer();
                resetScore(playerListWithCpu,gameboard);
                    while(round<=5) {
                        playGame(playerListWithCpu, gameboard);
                        showScore(playerListWithCpu,gameboard);
                        gameboard.initialiseBoard();
                        round++;
                    }
                    break;
                case 2: ArrayList<Player> playerList = multiPlayer();
                 resetScore(playerList,gameboard);
                    while(round<=5) {
                        playGame(playerList, gameboard);
                        showScore(playerList,gameboard);
                        gameboard.initialiseBoard();
                        round++;
                    }
                    break;
            }
        }
    }

    private static ArrayList<Player> multiPlayer () {
        scan.nextLine();
        ArrayList<Player> playerList = new ArrayList<>();

        System.out.println("Write out the name of first player");
        String playerName1 = scan.nextLine();
        System.out.println("Write out a name for second player");
        String playerName2 = scan.nextLine();

        Human h1 = new Human(playerName1, 'X');
        Human h2 = new Human(playerName2, 'O');
        playerList.add(h1);
        playerList.add(h2);

        return playerList;
    }
    private static ArrayList<Player> singlePlayer () {
        scan.nextLine();
        ArrayList<Player> playerListWithCpu = new ArrayList<>();
        System.out.println("Write out your name");
        String playerName1 = scan.nextLine();
        Human h1 = new Human(playerName1, 'X');
        Computer cpu = new Computer('O');
        System.out.println("Player " + h1.getGamePiece() + ": " + playerName1);
        System.out.println("Player " + cpu.getGamePiece() + ": " + cpu.getName());
        playerListWithCpu.add(h1);
        playerListWithCpu.add(cpu);

        return playerListWithCpu;
    }

    public static void playGame (ArrayList < Player > playerList, Gameboard gameboard){
        while (true) {
            for (Player player : playerList) {
                System.out.println("Player " + player.getName() + " - it's your turn to put " + player.getGamePiece());
                gameboard.switchPlayer(player);
                int whichSquare = player.askWhichSquare(gameboard);
                gameboard.setPiece(whichSquare);
                gameboard.drawBoard();

                if (gameboard.checkIfThreeInArow(player.getGamePiece())) {
                    System.out.println("Player " + player.getName()+ " won!!");
                    System.out.println();
                    player.increaseScore();
                    return;
                }
                if (gameboard.ifThereIsATie()) {
                    System.out.println("No one won! You've got a tie:(");
                    System.out.println();
                    return;
                }
            }
        }
    }
    public static void showScore (ArrayList < Player > playerList, Gameboard gameboard){
        for (Player player : playerList) {
            System.out.println("Player " + player.getName() + " - score: " + player.getScore());
            System.out.println();
        }
    }
    public static void resetScore(ArrayList<Player>players, Gameboard gameboard){
        for(Player player:players){
            player.setScore(0);
        }
    }
}
