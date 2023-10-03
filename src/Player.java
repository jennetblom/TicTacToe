import java.util.Scanner;

public class Player {
    private String name;

    char gamePiece;
    public Player(){
    }

    public Player(String name, char gamePiece){
        this.gamePiece=gamePiece;
        this.name=name;
    }

    public char getGamePiece() {
        return gamePiece;
    }

    public void setGamePiece(char gamePiece) {
        this.gamePiece = gamePiece;
    }

}