import java.util.Arrays;

public class BackTrackSolver implements SudokuSolver{
    @Override
    public boolean solve(int[][] grid) {

        int[] emptyCell = findEmptyCell(grid);
        if (emptyCell == null) {
            return true;
        }
        int row = emptyCell[0];
        int col = emptyCell[1];
        for (int num = 1; num <= 9; num++) {
            if (checkValidity(num, row, col, grid)) {
                grid[row][col] = num;
                System.out.println(toString(grid));
                if (solve(grid)) {
                    return true;
                }
                grid[row][col] = 0;
            }
        }
        return false;
    }
    private int[] findEmptyCell(int[][] grid){
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (grid[row][col] == 0) {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }

    private boolean checkValidity(int num, int row, int col, int[][] grid) {
        // Check row
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == num) {
                return false;
            }
        }
        // Check column
        for (int i = 0; i < 9; i++) {
            if (grid[i][col] == num) {
                return false;
            }
        }
        // Check subgrid
        int subgridRowStart = (row / 3) * 3;
        int subgridColStart = (col / 3) * 3;
        for (int i = subgridRowStart; i < subgridRowStart + 3; i++) {
            for (int j = subgridColStart; j < subgridColStart + 3; j++) {
                if (grid[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private String toString(int[][] grid) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : grid) {
            for (int num : row) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
