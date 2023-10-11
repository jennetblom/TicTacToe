import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println();
        System.out.println("""
                       ✿ H E L L O ! ✿         
                Welcome to the game of TicTacToe!                   
                """);

        //Frågar användaren ifall den vill spela singleplayer, multiplayer eller om den vill avsluta.
        //Varje gamemode spelas i 5 omgångar!
        int chooseGameMode=0;
        Gameboard gameboard = new Gameboard();
        do{
            int round=0;
            System.out.println("Choose between 1,2 or 3!");
            System.out.println("1. Singleplayer");
            System.out.println("2. Multiplayer ");
            System.out.println("3. Quit ");

            try {
                chooseGameMode = scan.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Invalid input :(");
                scan.next();
                continue;
            }
            switch(chooseGameMode) {
                case 1: ArrayList<Player> playerListWithCpu=singlePlayer();
                    resetScore(playerListWithCpu);
                    while(round<5) {
                        playGame(playerListWithCpu, gameboard);
                        showScore(playerListWithCpu,gameboard);
                        gameboard.initialiseBoard();
                        round++;
                    }
                    break;
                case 2: ArrayList<Player> playerList = multiPlayer();
                    resetScore(playerList);
                    while(round<5) {
                        playGame(playerList, gameboard);
                        showScore(playerList,gameboard);
                        gameboard.initialiseBoard();
                        round++;
                    }
                    break;
                case 3: System.out.println("Goodbye! :)");
                    break;
                default: System.out.println("Try again!");
            }
        } while (chooseGameMode!=3);
    }


    private static ArrayList<Player> multiPlayer () {
        //Iniatialiserar spelet om det är två spelare
        //Returnerar en lista med spelare
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
        //Iniatialiserar spelet om det bara är en spelare och en dator som ska spela
        //Returnerar en lista med spelare
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
        //Loopar igenom spelet, och kontrollerar ifall det blir en vinst eller om det blir oavgjort
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
        //Visar poängen för spelarna
        for (Player player : playerList) {
            System.out.println("Player " + player.getName() + " - score: " + player.getScore());
            System.out.println();
        }
    }
    public static void resetScore(ArrayList<Player>players){
        //Nollställer poängen
        for (Player player : players) {
            player.setScore(0);
        }
    }
}
