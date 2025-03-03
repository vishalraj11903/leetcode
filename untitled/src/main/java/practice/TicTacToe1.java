package practice;

public class TicTacToe1 {


    int[][] grid;
    int n;
    public TicTacToe1(int n) {
        this.n = n;
        grid = new int[n][n];
    }

    public int move(int row, int col, int player) {
        grid[row][col] = player;
        if (checkRow(row, player) || checkCol(col, player) || (row == col && checkDiag(player) || (col == n - row - 1 && checkAnti(player)))) {
            return player;
        }
        return 0;
    }

    boolean checkRow(int row, int player) {
        for (int col = 0; col < n; ++col) {
            if (grid[row][col] != player) {
                return false;
            }
        }

        return true;
    }

    boolean checkCol(int col, int player) {
        for (int row = 0; row < n; ++row) {
            if (grid[row][col] != player) {
                return false;
            }
        }

        return true;
    }

    boolean checkDiag(int player) {
        for (int row = 0, col = 0; row < n; ++row, ++col) {
            if (grid[row][col] != player) {
                return false;
            }
        }

        return true;
    }

    boolean checkAnti(int player) {
        for (int row = 0, col = n - row - 1; col >= 0; row++, -- col) {
            if (grid[row][col] != player) {
                return false;
            }
        }

        return true;
    }


}
