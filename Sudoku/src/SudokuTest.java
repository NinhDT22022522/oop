import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SudokuTest {
    @Test
    public void testSolveEasySudoku() throws IllegalAccessException {
        int[][] grid = Sudoku.stringsToGrid(
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
        SudokuSolver sudokuSolver = new BackTrackSolver();
        Sudoku sudokuEasy = new Sudoku(grid, sudokuSolver);
        Assertions.assertTrue(sudokuEasy.solve());
        int[][] expected = Sudoku.stringsToGrid(
                "1 6 4 7 9 5 3 8 2",
                "2 8 7 4 6 3 9 1 5",
                "9 3 5 2 8 1 4 6 7",
                "3 9 1 8 7 6 5 2 4",
                "5 4 6 1 3 2 7 9 8",
                "7 2 8 9 5 4 1 3 6",
                "8 1 9 6 4 7 2 5 3",
                "6 7 3 5 2 9 8 4 1",
                "4 5 2 3 1 8 6 7 9"
        );
        Assertions.assertArrayEquals(expected, sudokuEasy.getGrid());
    }

    @Test
    public void testSolveHardSudoku() throws IllegalAccessException {
        int[][] grid = Sudoku.stringsToGrid(
                "7 0 6 0 0 3 2 1 5",
                "9 2 0 0 7 5 0 0 0",
                "0 0 0 0 0 0 0 0 8",
                "3 0 0 0 0 0 0 0 0",
                "0 1 0 0 0 0 6 4 0",
                "0 0 8 0 0 1 0 7 0",
                "0 5 9 1 0 0 0 0 0",
                "0 0 2 0 4 0 3 0 0",
                "8 3 0 0 6 0 0 0 7"
        );
        SudokuSolver sudokuSolver1 = new BackTrackSolver();
        Sudoku sudokuHard = new Sudoku(grid, sudokuSolver1);
        Assertions.assertTrue(sudokuHard.solve());
        int[][] expected = Sudoku.stringsToGrid(
                "7 8 6 4 9 3 2 1 5",
                "9 2 1 8 7 5 4 3 6",
                "5 4 3 2 1 6 7 9 8",
                "3 9 7 6 2 4 5 8 1",
                "2 1 5 7 8 9 6 4 3",
                "4 6 8 3 5 1 9 7 2",
                "6 5 9 1 3 7 8 2 4",
                "1 7 2 5 4 8 3 6 9",
                "8 3 4 9 6 2 1 5 7"
        );
        Assertions.assertArrayEquals(expected, sudokuHard.getGrid());
    }
}
