package practice;

public class TicTacToe {
    public String findWinner(char[][] grid) {
        int n = grid.length;

        // Check rows and columns
        for (int i = 0; i < n; i++) {
            // Check row i
            if (checkRow(grid, i, n)) {
                return String.valueOf(grid[i][0]);
            }

            // Check column i
            if (checkColumn(grid, i, n)) {
                return String.valueOf(grid[0][i]);
            }
        }

        // Check diagonals
        if (checkMainDiagonal(grid, n)) {
            return String.valueOf(grid[0][0]);
        }

        if (checkAntiDiagonal(grid, n)) {
            return String.valueOf(grid[0][n - 1]);
        }

        // Check for draw or ongoing game
        return isGridFull(grid, n) ? "Draw" : "Pending";
    }

    private boolean checkRow(char[][] grid, int row, int n) {
        char first = grid[row][0];
        if (first == '.') return false; // Ignore unoccupied cells
        for (int col = 1; col < n; col++) {
            if (grid[row][col] != first) return false;
        }
        return true;
    }

    private boolean checkColumn(char[][] grid, int col, int n) {
        char first = grid[0][col];
        if (first == '.') return false; // Ignore unoccupied cells
        for (int row = 1; row < n; row++) {
            if (grid[row][col] != first) return false;
        }
        return true;
    }

    private boolean checkMainDiagonal(char[][] grid, int n) {
        char first = grid[0][0];
        if (first == '.') return false; // Ignore unoccupied cells
        for (int i = 1; i < n; i++) {
            if (grid[i][i] != first) return false;
        }
        return true;
    }

    private boolean checkAntiDiagonal(char[][] grid, int n) {
        char first = grid[0][n - 1];
        if (first == '.') return false; // Ignore unoccupied cells
        for (int i = 1; i < n; i++) {
            if (grid[i][n - 1 - i] != first) return false;
        }
        return true;
    }

    private boolean isGridFull(char[][] grid, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }
}
