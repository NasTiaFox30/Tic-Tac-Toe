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

    public static void createBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    //User move
    public static void playerTurn() {
        int row, col;
        do {
            System.out.print("Write a row (1-3): ");
            row = scan.nextInt() - 1;
            System.out.print("Write a column (1-3): ");
            col = scan.nextInt() - 1;
        } while (!isValidMove(row, col));
        board[row][col] = PLAYER;
    }

    private static boolean isValidMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            System.out.println("Try again! Coordinates are wrong.");
            return false;
        }
        if (board[row][col] != EMPTY) {
            System.out.println("Try again! You can't do it here.");
            return false;
        }
        return true;
    }

    //Random Computer move
    public static void computerTurn() {
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!isValidMove(row, col));
        System.out.println("Computer moved on: " + (row + 1) + ", " + (col + 1));
        board[row][col] = COMPUTER;
    }

    //Check for WIN
    public static boolean isWin(char symbol) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }

        //if there is no win:
        return false;
    }

    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    //Restart game
    public static void restartGame(){
        scan.nextLine();
        while(true){
            System.out.print("Do you want to play one more time? (Y/N): ");
            String decision = scan.nextLine().trim().toUpperCase();

            if (decision.equals("Y")){
                restart = true;
                ClearConsole.clear();
                break;
            } else if(decision.equals("N")){
                restart = false;
                System.out.println("Thanks for game!)");
                break;
            }
            else {
                continue;
            }
        }
    }
}