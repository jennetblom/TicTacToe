import java.util.Random;
import java.util.Scanner;

public class Player {
    //Skapar en playerklass med 3 instansvariabler: namn, spelpjäs och poäng
    private String name;
    private char gamePiece;
    private int score;
    static Scanner scan = new Scanner(System.in);

    public Player (String name , char gamePiece){
        this.name=name;
        this.score=0;
        this.gamePiece=gamePiece;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGamePiece() {
        return gamePiece;
    }

    public void setGamePiece(char gamePiece) {
        this.gamePiece = gamePiece;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void increaseScore() {
        this.score++;
    }

    public int askWhichSquare(Gameboard gameboard) {

        return 0;
    }
}
