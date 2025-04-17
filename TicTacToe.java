//Imported classes
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];
    private static final char PLAYER = 'X';
    private static final char COMPUTER = 'O';
    private static final char EMPTY = ' ';
    private static Scanner scan = new Scanner(System.in);
    private static Random random = new Random();
    private static boolean restart = true;
    
    //    GET|SET
    public static char getPLAYER(){
        return PLAYER;
    }
    public static char getComputer(){
        return COMPUTER;
    }
    public static boolean getRestart(){
        return restart;
    }
}

