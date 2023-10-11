import java.util.Random;

public class Computer extends Player {

    public Computer(char gamePiece){
        super("Computer",gamePiece);
    }

    @Override
    public int askWhichSquare(Gameboard gameboard){
//Slumpar ett tal mellan 1-9 som ska representera rutnätet. Dubbelkollar att rutan är tom, annars kör loopen igen.

        int randomSquare;
        do {

            Random random = new Random();
            randomSquare = random.nextInt(9) + 1;
        }while(!gameboard.isSquareEmpty(randomSquare));
        return randomSquare;
    }
}
