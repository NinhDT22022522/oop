import static java.util.Arrays.copyOf;

public class Sudoku {
    private int[][] board;
    private SudokuSolver sudokuSolver;

    public Sudoku(int[][] grid, SudokuSolver sudokuSolver) {
        // Create a board from the input grid
        this.board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            this.board[i] = copyOf(grid[i], 9);
        }
        this.sudokuSolver = sudokuSolver;
    }

    public boolean solve() {
        if (sudokuSolver == null){
            throw new RuntimeException("Solver is not set");
        }
        else return sudokuSolver.solve(this.getGrid());
    }

    public int[][] getGrid() {
        return board;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();

    }




    public static int[][] stringsToGrid(String... rows) throws IllegalAccessException {
        if (rows.length < 9){
            throw new IllegalAccessException("Grid does not contain enough rows!!!");
        }
        int[][] grid = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String[] rowValues = rows[i].trim().split(" ");
            if (rowValues.length < 9){
                throw new IllegalAccessException("Row " + i + " does not contain enough values!!!");
            }
            for (int j = 0; j < 9; j++) {
                try {
                    grid[i][j] = Integer.parseInt(rowValues[j]);
                }
                catch(NumberFormatException numberFormatException){
                    grid[i][j] = 0;
                }
            }
        }
        return grid;
    }

    public void setSolver(SudokuSolver sudokuSolver){
        this.sudokuSolver = sudokuSolver;
    }

    public static void main(String[] args) throws IllegalAccessException {
        int[][] grid = stringsToGrid(
                "1 6 4 0 0 0 0 0 2",
                "2 0 0 4 0 3 9 1 0",
                "0 0 5 0 8 0 4 0 7",
                "0 9 0 0 0 6 5 0 0",
                "5 0 0 1 0 2 0 0 8",
                "0 0 8 9 0 0 0 3 0",
                "8 0 9 0 4 0 2 0 0",
                "0 7 3 5 0 9 0 0 1",
                "4 0 0 0 0 0 6 7 9"
        );
        SudokuSolver sudokuSolver1 = new BackTrackSolver();
        Sudoku sudoku = new Sudoku(grid, sudokuSolver1);
        sudoku.setSolver(sudokuSolver1);
        System.out.println(sudoku.solve());
    }
}
