import java.util.Random;

public class Computer extends Player {

    public Computer(char gamePiece){
        super("Computer",gamePiece);
    }

    @Override
    public int askWhichSquare(Gameboard gameboard){
        //A loop where the computer keeps on generating a random number between 1-9 until it's an empty square in the gameboard.

        int randomSquare;
        do {

            Random random = new Random();
            randomSquare = random.nextInt(9) + 1;
        }while(!gameboard.isSquareEmpty(randomSquare));
        return randomSquare;
    }
}
