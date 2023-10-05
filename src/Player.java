import java.util.Scanner;

public class Player {
    private String name;

    char gamePiece;
    int score;

    public Player (String name , char gamePiece){
        this.name=name;
        this.score=0;
        this.gamePiece=gamePiece;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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

}