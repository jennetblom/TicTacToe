import java.util.Scanner;

public class Gameboard {

    Scanner scan = new Scanner(System.in);
    public static char[][] board = new char[3][3];
    char currentPlayer='X';


    public Gameboard() {

    }

    public void initialiseBoard() {
        board[0][0] = '1';
        board[1][0] = '2';
        board[2][0] = '3';
        board[0][1] = '4';
        board[1][1] = '5';
        board[2][1] = '6';
        board[0][2] = '7';
        board[1][2] = '8';
        board[2][2] = '9';


        System.out.println("-------------------------");
        System.out.println("|       |       |       |");
        System.out.println("|   " + board[0][0] + "   |   " + board[1][0] + "   |   " + board[2][0] + "   |");
        System.out.println("|       |       |       |");
        System.out.println("-------------------------");
        System.out.println("|       |       |       |");
        System.out.println("|   " + board[0][1] + "   |   " + board[1][1] + "   |   " + board[2][1] + "   |");
        System.out.println("|       |       |       |");
        System.out.println("-------------------------");
        System.out.println("|       |       |       |");
        System.out.println("|   " + board[0][2] + "   |   " + board[1][2] + "   |   " + board[2][2] + "   |");
        System.out.println("|       |       |       |");
        System.out.println("-------------------------");
    }

    public void drawBoard() {


        System.out.println("-------------------------");
        System.out.println("|       |       |       |");
        System.out.println("|   " + board[0][0] + "   |   " + board[1][0] + "   |   " + board[2][0] + "   |");
        System.out.println("|       |       |       |");
        System.out.println("-------------------------");
        System.out.println("|       |       |       |");
        System.out.println("|   " + board[0][1] + "   |   " + board[1][1] + "   |   " + board[2][1] + "   |");
        System.out.println("|       |       |       |");
        System.out.println("-------------------------");
        System.out.println("|       |       |       |");
        System.out.println("|   " + board[0][2] + "   |   " + board[1][2] + "   |   " + board[2][2] + "   |");
        System.out.println("|       |       |       |");
        System.out.println("-------------------------");
    }

    public void setPiece() {
        System.out.println("Choose a number between 1-9");
        int whichSquare = scan.nextInt();

        switch (whichSquare) {
            case 1:
                board[0][0] = currentPlayer;
                break;
            case 2:
                board[1][0] = currentPlayer;
                break;
            case 3:
                board[2][0] = currentPlayer;
                break;
            case 4:
                board[0][1] = currentPlayer;
                break;
            case 5:
                board[1][1] = currentPlayer;
                break;
            case 6:
                board[2][1] = currentPlayer;
                break;
            case 7:
                board[0][2] = currentPlayer;
                break;
            case 8:
                board[1][2] = currentPlayer;
                break;
            case 9:
                board[2][2] = currentPlayer;
                break;
        }
        checkThreeInArow();
    }
    public void switchPlayer()  {

        if(currentPlayer=='X'){
            currentPlayer='O';
        }
        else {
            currentPlayer='X';
        }
    }

    public void checkThreeInArow(){
        if(board[0][0]==currentPlayer&&(board[1][0]==currentPlayer&&(board[2][0]==currentPlayer))){
            System.out.println(currentPlayer + " WON");
        }

    }
}


