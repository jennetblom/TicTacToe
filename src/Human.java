import java.util.Random;
import java.util.Scanner;

public class Human extends Player {

    static Scanner scan = new Scanner(System.in);

    public Human(String name, char gamePiece) {
        super(name, gamePiece);
    }
    @Override
    public int askWhichSquare(Gameboard gameboard) {
        //Frågar vilken ruta användaren vill ha och kontrollerar att användaren väljer en tom ruta.
        // Hanterar felinmatningar.
        int whichSquare = -1;
        do {
            try {
                System.out.println("Which square do you want to choose from 1-9?");
                whichSquare = scan.nextInt();

                if (whichSquare < 1 || whichSquare > 9) {
                    System.out.println("Try again. Enter a number between 1-9");
                    continue;
                }
                if (!gameboard.isSquareEmpty(whichSquare)) {
                    System.out.println("The square is taken. Try again");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number!");
                scan.nextLine();
            }
        } while (whichSquare < 1 || whichSquare > 9 || !gameboard.isSquareEmpty(whichSquare));

        return whichSquare;
    }
}

