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
                Hello! :D
                Welcome to the game of TicTacToe!                            
                """);


        Gameboard gameboard = new Gameboard();
        System.out.println("How do you want to play?");
        System.out.println("1. Singleplayer");
        System.out.println("2. Multiplayer ");
        int chooseGameMode= scan.nextInt();

        switch(chooseGameMode){
            case 1:
                ArrayList<Player> playerListWithCpu = singlePlayer();
                singlePlayerGame(playerListWithCpu, gameboard);
                break;
            case 2:
                ArrayList<Player> playerList = multiPlayer();
                multiPlayerGame(playerList,gameboard);
                break;
        }

    }

    private static ArrayList<Player> multiPlayer() {
        scan.nextLine();
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
    private static ArrayList<Player>singlePlayer(){
        scan.nextLine();
        ArrayList<Player>playerListWithCpu=new ArrayList<>();
        System.out.println("Write out the name of first player");
        String playerName1 = scan.nextLine();
        Player p1=new Player(playerName1,'X');
        Player CPU=new Player("Computer", 'O');
        System.out.println("Player "+ p1.getGamePiece()+": " + playerName1);
        System.out.println("Player "+ CPU.getGamePiece()+": " + CPU.getName());
        playerListWithCpu.add(p1);
        playerListWithCpu.add(CPU);

        return playerListWithCpu;
    }
    public static int askComputerWhichSquare(){
        Random random = new Random();
        int randomSquare = random.nextInt(9)+1;
        return randomSquare;
    }
    public static int askWhichSquare() {

        System.out.println("Which square do you want to choose");
        int whichSquare = scan.nextInt();
        return whichSquare;
    }

    public static void multiPlayerGame(ArrayList<Player> playerList, Gameboard gameboard) {

        while (true) {
            for (Player player : playerList) {
                System.out.println("Player " + player.getName() + " - it's your turn to put " + player.getGamePiece());
                gameboard.switchPlayer(player);
                int whichSquare = askWhichSquare();
                gameboard.setPiece(whichSquare);
                gameboard.drawBoard();

                if(gameboard.checkIfThreeInArow(player.getGamePiece())){
                    System.out.println("CONGRATZZZ YOU WON!!! "+ "Player "+player.getName());
                    System.out.println();
                    player.increaseScore();
                    return;
                }
                if(gameboard.ifThereIsATie()){
                    System.out.println("No one won! You've got a tie:(");
                    System.out.println();
                    return;
                }
            }
        }
    }
    public static void singlePlayerGame(ArrayList<Player>playersWithCpu, Gameboard gameboard){

        int whichSquare;
        while (true) {
            System.out.println();
            System.out.println("Player " + playersWithCpu.get(0).getName() + " - it's your turn to put " + playersWithCpu.get(0).getGamePiece());
            gameboard.switchPlayer(playersWithCpu.get(0));
            whichSquare=askWhichSquare();
            gameboard.setPiece(whichSquare);
            gameboard.drawBoard();
            if(gameboard.checkIfThreeInArow(playersWithCpu.get(0).getGamePiece())){
                System.out.println("CONGRATZZZ YOU WON!!! "+ "Player "+playersWithCpu.get(0).getName());
                System.out.println();
                playersWithCpu.get(0).increaseScore();
                return;
            }
            System.out.println();
            System.out.println("Player " + playersWithCpu.get(1).getName() + " - it's your turn to put " + playersWithCpu.get(1).getGamePiece());
            gameboard.switchPlayer(playersWithCpu.get(1));
            whichSquare=askComputerWhichSquare();
            gameboard.setPiece(whichSquare);
            gameboard.drawBoard();
            if(gameboard.checkIfThreeInArow(playersWithCpu.get(1).getGamePiece())){
                System.out.println("CONGRATZZZ YOU WON!!! "+ "Player "+playersWithCpu.get(1).getName());
                System.out.println();
                playersWithCpu.get(1).increaseScore();
                return;
            }
            if(gameboard.ifThereIsATie()){
                System.out.println("No one won! You've got a tie:(");
                System.out.println();
                return;
            }

        }
    }

    public static void showScore(ArrayList<Player> playerList, Gameboard gameboard){
        for(Player player:playerList){
            //  System.out.println();
            System.out.println("Player " + player.getName()+ " - score: "+player.getScore());
            System.out.println();
        }
    }
}
