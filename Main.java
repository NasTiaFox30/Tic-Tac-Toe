public class Main {
    public static void main(String[] args) {
        while (true) {
            //1
            TicTacToe.playerTurn();
            TicTacToe.printBoard();
            if (TicTacToe.isWin(TicTacToe.getPLAYER())) {
                System.out.println("You WIN!");
                break;
            } else if (TicTacToe.isBoardFull()) {
                System.out.println("Tie!");
                break;
            }

            //2
            TicTacToe.computerTurn();
            TicTacToe.printBoard();
            if (TicTacToe.isWin(TicTacToe.getComputer())) {
                System.out.println("Computer WIN!");
                break;
            } else if (TicTacToe.isBoardFull()) {
                System.out.println("Tie!");
                break;
            }
        }
    }
}