package wan.leetcode.graph;

public class Max_Area_of_Island_695 {
	public int maxAreaOfIsland(int[][] grid) {
		int maxRow = grid.length - 1;
		int maxCol = grid[0].length - 1;

		int maxArea = 0;

		for (int i = 0; i <= maxRow; i++) {
			for (int j = 0; j <= maxCol; j++) {
				if (grid[i][j] == 1) {
					maxArea = Math.max(maxArea, this.checkIsland(grid, i, j, maxRow, maxCol));
				}
			}
		}

		return maxArea;
	}

	private int checkIsland(int[][] grid, int i, int j, int maxRow, int maxCol) {
		if (i < 0 || i > maxRow || j < 0 || j > maxCol) {
			return 0;
		}

		if (grid[i][j] == 0 || grid[i][j] == -1) {
			return 0;
		}

		grid[i][j] = -1;

		return 1 + this.checkIsland(grid, i - 1, j, maxRow, maxCol) + this.checkIsland(grid, i + 1, j, maxRow, maxCol)
				+ this.checkIsland(grid, i, j - 1, maxRow, maxCol) + this.checkIsland(grid, i, j + 1, maxRow, maxCol);

	}
}
