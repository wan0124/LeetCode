package wan.leetcode.graph;

public class Rotting_Oranges_994 {
	public int orangesRotting(int[][] grid) {
		int round = 0;
		while (true) {
			boolean anythingRotted = false;
			for (int row = 0; row < grid.length; row++) {
				for (int col = 0; col < grid[0].length; col++) {
					anythingRotted |= this.beingRotting(grid, row, col);
				}
			}
			// no orange rotten, in steady stage, break;
			if (!anythingRotted) {
				break;
			}
			this.flipOrange(grid);
			round++;

		}

		return this.checkResult(grid) ? round : -1;

	}

	// check if this orange will be rotten
	private boolean beingRotting(int[][] grid, int row, int col) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != 1) {
			// we only care about fresh orange
			return false;
		}

		if (this.checkRotting(grid, row, col)) {
			grid[row][col] = -1;
			return true;
		}

		return false;

	}

	private boolean checkRotting(int[][] grid, int row, int col) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
			return false;
		}
		if (row - 1 >= 0 && grid[row - 1][col] == 2) {
			return true;
		}
		if (row + 1 < grid.length && grid[row + 1][col] == 2) {
			return true;
		}
		if (col - 1 >= 0 && grid[row][col - 1] == 2) {
			return true;
		}
		if (col + 1 < grid[0].length && grid[row][col + 1] == 2) {
			return true;
		}
		return false;
	}

	// flip -1 into 2
	private void flipOrange(int[][] grid) {
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] == -1) {
					grid[row][col] = 2;
				}
			}
		}
	}

	// check if every oranges are rotten
	private boolean checkResult(int[][] grid) {
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] == 1) {
					return false;
				}
			}
		}
		return true;
	}
}
