import java.util.Arrays;

public class Sudoku {
    private int[][] board;

    public Sudoku(int[][] grid) {
        // Create a board from the input grid
        this.board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            this.board[i] = Arrays.copyOf(grid[i], 9);
        }
    }

    public boolean solve() {
        int[] emptyCell = findEmptyCell();
        if (emptyCell == null) {
            return true;
        }
        int row = emptyCell[0];
        int col = emptyCell[1];
        for (int num = 1; num <= 9; num++) {
            if (checkValidity(num, row, col)) {
                board[row][col] = num;
                if (solve()) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    public int[][] getGrid() {
        return board;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                sb.append(num + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private int[] findEmptyCell() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }

    private boolean checkValidity(int num, int row, int col) {
        // Check row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        // Check subgrid
        int subgridRowStart = (row / 3) * 3;
        int subgridColStart = (col / 3) * 3;
        for (int i = subgridRowStart; i < subgridRowStart + 3; i++) {
            for (int j = subgridColStart; j < subgridColStart + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] stringsToGrid(String... rows) {
        int[][] grid = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String[] rowValues = rows[i].trim().split(" ");
            for (int j = 0; j < 9; j++) {
                grid[i][j] = Integer.parseInt(rowValues[j]);
            }
        }
        return grid;
    }

    public static void main(String[] args) {
        int[][] grid = stringsToGrid(
                "3 7 0 0 0 0 0 8 0",
                "0 0 1 0 9 3 0 0 0",
                "0 4 0 7 8 0 0 0 3",
                "0 9 3 8 0 0 0 1 2",
                "0 0 0 0 4 0 0 0 0",
                "5 2 0 0 0 6 7 9 0",
                "6 0 0 0 2 1 0 4 0",
                "0 0 0 5 3 0 9 0 0",
                "0 3 0 0 0 0 0 5 1"
        );
        Sudoku sudoku = new Sudoku(grid);
        sudoku.solve();
        System.out.println(sudoku);
    }
}
