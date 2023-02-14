import java.util.Scanner;

public class TikTakToe {
    public static void main(String[] args) {

        String[] board = { "-", "-", "-",
                "-", "-", "-",
                "-", "-", "-" };

        Scanner scan = new Scanner(System.in);

        String current_player = "O";

        boolean game_going = true;

        while (game_going == true) {

            // flip player
            if (current_player.equals("X")) {
                current_player = "O";
            } else {
                current_player = "X";
            }

            // Print board
            System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
            System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
            System.out.println(board[6] + " | " + board[7] + " | " + board[8]);

            // handle turn
            boolean valid = false;

            System.out.println(current_player + "`s turn");
            System.out.print("Where do you want to go? [1-9]: ");
            int position = scan.nextInt();

            // check if in range of board
            while (valid == false) {
                if (position >= 1 && position <= 9) {
                    position--;
                    if (board[position].equals("-")) {
                        valid = true;
                    }
                } else {
                    System.out.println("You can not go there. go again!: ");
                    System.out.print("Where do you want to go? [1-9]: ");
                    position = scan.nextInt();
                }
            }
            board[position] = current_player;

            // check if game over

            // check rows
            for (int i = 0; i < 9; i += 3) {
                if (!board[i].equals("-") && !board[i + 1].equals("-") && !board[i + 2].equals("-")) {
                    if (board[i].equals(board[i + 1]) && board[i].equals(board[i + 2])
                            && board[i + 1].equals(board[i + 2])) {
                        game_going = false;
                    }
                }
            }

            // check colums
            for (int i = 0; i < 3; i++) {
                if (!board[i].equals("-") && !board[i + 3].equals("-") && !board[i + 6].equals("-")) {
                    if (board[i].equals(board[i + 3]) && board[i].equals(board[i + 6])
                            && board[i + 3].equals(board[i + 6])) {
                        game_going = false;
                    }
                }
            }

            // check diagonals
            if (!board[0].equals("-") && !board[4].equals("-") && !board[8].equals("-")) {
                if (board[0].equals(board[4]) && board[0].equals(board[8]) && board[4].equals(board[8])) {
                    game_going = false;
                }
            }
            if (!board[2].equals("-") && !board[4].equals("-") && !board[6].equals("-")) {
                if (board[2].equals(board[4]) && board[0].equals(board[6]) && board[4].equals(board[6])) {
                    game_going = false;
                }
            }

            // check tie
            if (!board[0].equals("-") && !board[1].equals("-") && !board[2].equals("-") && !board[3].equals("-")
                    && !board[4].equals("-") && !board[5].equals("-") && !board[6].equals("-") && !board[7].equals("-")
                    && !board[8].equals("-")) {
                game_going = false;
            }
        }

        // after game
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);

        System.out.println(current_player + " has won.");
        scan.close();
    }
}
