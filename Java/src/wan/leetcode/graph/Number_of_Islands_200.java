package wan.leetcode.graph;

public class Number_of_Islands_200 {
	public int numIslands(char[][] grid) {
		int islandCount = 0;

		int rowMax = grid.length - 1;
		int colMax = grid[0].length - 1;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					this.checkIsland(grid, i, j, rowMax, colMax);
					islandCount++;
				}
			}
		}

		return islandCount;
	}

	private void checkIsland(char[][] grid, int i, int j, int rowMax, int colMax) {
		// if the position is out of bound
		if (i < 0 || i > rowMax || j < 0 || j > colMax) {
			return;
		}
		// if this position is water or has visited
		if (grid[i][j] == '0' || grid[i][j] == '*') {
			return;
		}
		// set this position as has visited
		grid[i][j] = '*';

		// check the position which is near by
		this.checkIsland(grid, i - 1, j, rowMax, colMax);
		this.checkIsland(grid, i + 1, j, rowMax, colMax);
		this.checkIsland(grid, i, j - 1, rowMax, colMax);
		this.checkIsland(grid, i, j + 1, rowMax, colMax);

	}
}
