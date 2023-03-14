// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

import jdk.internal.net.http.common.Pair;

public class CharGrid {
	private char[][] grid;
	private boolean isPlus(int i, int j){
		int step = 1;
		int cntTop = 0;
		int cntBot = 0;
		int cntLef = 0;
		int cntRig = 0;
		while (i + step <= this.grid.length - 1 ){
			if (grid[i][j] == grid[i + step][j]) {
				cntBot++;
				step++;
			}else {

				break;
			}
		}
		step = 1;
		while (i - step >= 0){
			if (grid[i][j] == grid[i - step][j] ) {
				cntTop++;
				step++;
			}else {

				break;
			}
		}
		step = 1;
		while (j + step <= this.grid[0].length - 1 ){
			if (grid[i][j] == grid[i][j + step]) {
				cntRig++;
				step++;
			}else {
				break;
			}
		}
		step = 1;
		while (j - step >= 0){
			if (grid[i][j] == grid[i][j - step]) {
				cntLef++;
				step++;
			}else {
				break;
			}
		}
		if (cntBot == cntTop && cntBot > 0 ) {
			if (cntBot == cntLef){
				return cntBot == cntRig;
			}
		}
		return false;
	}

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		int xMax = -1, yMax = -1;
		int xMin = this.grid[0].length, yMin = this.grid.length;
		int area = 0;
		boolean found = false;
		for (int i = 0; i < this.grid.length; i++){
			for (int j = 0; j < this.grid[0].length; j++){
				if (grid[i][j] == ch){
					found = true;
					xMin = Math.min(xMin, i);
					yMin = Math.min(yMin, j);
					xMax = Math.max(xMax, i);
					yMax = Math.max(yMax, j);
				}
			}
		}

		if (found) {
			area = (xMax - xMin + 1) * (yMax - yMin + 1);
		}
		return area;
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		int cnt = 0;
		for (int i = 1; i < this.grid.length - 1; i++){
			for (int j = 1; j < this.grid[0].length - 1; j++){
				if (isPlus(i, j)) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
}
