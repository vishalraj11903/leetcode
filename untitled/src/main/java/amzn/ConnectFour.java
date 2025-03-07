package amzn;

public class ConnectFour {

    // Constants for player 1 and player 2
    private static final int PLAYER_1 = 1;
    private static final int PLAYER_2 = 2;

    // Directions for horizontal, vertical, and diagonal checking
    private static final int[][] DIRECTIONS = {
            {0, 1},   // Horizontal (right)
            {1, 0},   // Vertical (down)
            {1, 1},   // Diagonal (down-right)
            {1, -1}   // Diagonal (down-left)
    };

    // Main function to check if the player has made a sequence of four
    public static boolean checkForSequence(int row, int col, int player, int[][] board) {
        // Check in all four directions
        for (int[] direction : DIRECTIONS) {
            if (checkDirection(row, col, player, board, direction)) {
                return true;
            }
        }
        return false;
    }

    // Helper function to check in one direction
    private static boolean checkDirection(int row, int col, int player, int[][] board, int[] direction) {
        int count = 1; // Start with the current move
        int rowDirection = direction[0];
        int colDirection = direction[1];

        // Check in the positive direction
        int r = row + rowDirection;
        int c = col + colDirection;
        while (isValid(r, c, board) && board[r][c] == player) {
            count++;
            r += rowDirection;
            c += colDirection;
        }

        // Check in the negative direction
        r = row - rowDirection;
        c = col - colDirection;
        while (isValid(r, c, board) && board[r][c] == player) {
            count++;
            r -= rowDirection;
            c -= colDirection;
        }

        // If we found a sequence of 4
        return count >= 4;
    }

    // Check if a given position is within bounds
    private static boolean isValid(int row, int col, int[][] board) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }

    // Sample main function to test
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 2},
                {0, 0, 0, 2, 2, 1, 0, 1},
                {0, 2, 2, 2, 1, 2, 0, 1},
                {1, 1, 2, 1, 2, 2, 2, 1}
        };

        // Test example where player 1 plays at (5, 0)
        int row = 5, col = 0, player = 1;
        System.out.println(checkForSequence(row, col, player, board)); // Should print true

        // Test example where player 2 plays at (4, 3)
        row = 4; col = 3; player = 2;
        System.out.println(checkForSequence(row, col, player, board)); // Should print false
    }
}

