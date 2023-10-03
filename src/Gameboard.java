public class Gameboard {


    public Gameboard(){

    }

    public void drawBoard(){

        char[][] board = new char[3][3];
        board[0][0] = '1';
        board[1][0] = '2';
        board[2][0] = '3';
        board[0][1] = '4';
        board[1][1] = '5';
        board[2][1] = '6';
        board[0][2] = '7';
        board[1][2] = '8';
        board[2][2] = '9';

        char s1= board[0][0];
        char s2= board[1][0];
        char s3= board[2][0];
        char s4= board[0][1];
        char s5= board[1][1];
        char s6= board[2][1];
        char s7= board[0][2];
        char s8= board[1][2];
        char s9= board[2][2];
        s1='X';
        s6='O';

        System.out.println("-------------------------");
        System.out.println("|       |       |       |");
        System.out.println("|   "+s1+"   |   "+s2+"   |   "+s3+"   |");
        System.out.println("|       |       |       |");
        System.out.println("-------------------------");
        System.out.println("|       |       |       |");
        System.out.println("|   "+s4+"   |   "+s5+"   |   "+s6+"   |");
        System.out.println("|       |       |       |");
        System.out.println("-------------------------");
        System.out.println("|       |       |       |");
        System.out.println("|   "+s7+"   |   "+s8+"   |   "+s9+"   |");
        System.out.println("|       |       |       |");
        System.out.println("-------------------------");

    }
}
