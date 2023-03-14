//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
	private boolean[][] grid;
	
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		int col = this.grid[0].length;
		for (int j = 0; j < this.grid[0].length; j++){
			int cnt = 0;
			for (boolean[] booleans : this.grid) {
				if (booleans[j]) {
					cnt++;
				}
			}
			if (cnt == this.grid.length) {
				col--;
				for (int j1 = j; j1 < col; j1 ++){
					for (int i1 = 0; i1 < this.grid.length; i1++){
						this.grid[i1][j1] = this.grid[i1][j1 + 1];
					}
				}
				for (int j1 = col; j1 < this.grid[0].length; j1++){
					for (int i1 = 0; i1 < this.grid.length; i1++){
						this.grid[i1][j1] = false;
					}
				}
			}
		}
	}
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return this.grid;
	}
}
