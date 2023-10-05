public class Player {
    private String name;
    private char gamePiece;
    private int score;

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

    public void increaseScore() {
        this.score++;
    }
}
