import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //prompt users for moves + toUpperCase to accept input despite caps//
        while (true) {
            System.out.println("Let's play Rock Paper Scissors!");
            System.out.println("Player A, enter your move (R/P/S): ");
            String moveA = scanner.nextLine().toUpperCase();
            while (!isValidMove(moveA)) {
                System.out.println("Invalid move! Please enter R, P, or S: ");
                moveA = scanner.nextLine().toUpperCase();
            }

            System.out.println("Player B, enter your move (R/P/S): ");
            String moveB = scanner.nextLine().toUpperCase();
            while (!isValidMove(moveB)) {
                System.out.println("Invalid move! Please enter R, P, or S: ");
                moveB = scanner.nextLine().toUpperCase();
            }

            System.out.println("Player A chose: " + moveA);
            System.out.println("Player B chose: " + moveB);

            if (moveA.equals(moveB)) {
                System.out.println("It's a tie!");
            } else if ((moveA.equals("R") && moveB.equals("S")) ||
                    (moveA.equals("P") && moveB.equals("R")) ||
                    (moveA.equals("S") && moveB.equals("P"))) {
                System.out.println("Player A wins! " + getWinningPhrase(moveA, moveB));
            } else {
                System.out.println("Player B wins! " + getWinningPhrase(moveB, moveA));
            }
            //prompt to play again//
            System.out.println("Do you want to play again? (Y/N)");
            String playAgain = scanner.nextLine().toUpperCase();
            if (!playAgain.equals("Y")) {
                break;
            }
        }

        scanner.close();
    }
    //print the winning phrase//
    public static boolean isValidMove(String move) {
        return move.equals("R") || move.equals("P") || move.equals("S");
    }

    public static String getWinningPhrase(String winningMove, String losingMove) {
        if (winningMove.equals("R")) {
            if (losingMove.equals("S")) {
                return "Rock breaks Scissors";
            } else {
                return "Paper covers Rock";
            }
        } else if (winningMove.equals("P")) {
            return "Scissors cuts Paper";
        } else {
            return "Unknown move";
        }
    }
}