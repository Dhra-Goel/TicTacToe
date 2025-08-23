import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] board = {'1','2','3','4','5','6','7','8','9'};
        char turn = 'X';
        int moves = 0;

        while (true) {
            // print board
            System.out.println(board[0]+"|"+board[1]+"|"+board[2]);
            System.out.println("-+-+-");
            System.out.println(board[3]+"|"+board[4]+"|"+board[5]);
            System.out.println("-+-+-");
            System.out.println(board[6]+"|"+board[7]+"|"+board[8]);

            // input move
            System.out.print("Player " + turn + ", choose a slot (1-9): ");
            int choice = sc.nextInt();

            if (choice < 1 || choice > 9 || board[choice-1] == 'X' || board[choice-1] == 'O') {
                System.out.println("Invalid move, try again.");
                continue;
            }

            board[choice-1] = turn;
            moves++;

            // check winner
            if ((board[0]==turn && board[1]==turn && board[2]==turn) ||
                (board[3]==turn && board[4]==turn && board[5]==turn) ||
                (board[6]==turn && board[7]==turn && board[8]==turn) ||
                (board[0]==turn && board[3]==turn && board[6]==turn) ||
                (board[1]==turn && board[4]==turn && board[7]==turn) ||
                (board[2]==turn && board[5]==turn && board[8]==turn) ||
                (board[0]==turn && board[4]==turn && board[8]==turn) ||
                (board[2]==turn && board[4]==turn && board[6]==turn)) {
                System.out.println("Player " + turn + " wins!");
                break;
            }

            if (moves == 9) {
                System.out.println("It's a draw!");
                break;
            }

            // switch turn
            turn = (turn == 'X') ? 'O' : 'X';
        }
        sc.close();
    }
}
