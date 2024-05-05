package wan.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class Pacific_Atlantic_Water_Flow_417 {
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		boolean[][] pacific = new boolean[heights.length][heights[0].length];
		boolean[][] atlantic = new boolean[heights.length][heights[0].length];

		for (int j = 0; j < heights[0].length; j++) {
			this.travel(heights, 0, j, pacific, heights[0][j]);
			this.travel(heights, heights.length - 1, j, atlantic, heights[heights.length - 1][j]);
		}

		for (int i = 0; i < heights.length; i++) {
			this.travel(heights, i, 0, pacific, heights[i][0]);
			this.travel(heights, i, heights[0].length - 1, atlantic, heights[i][heights[0].length - 1]);
		}

		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < heights.length; i++) {
			for (int j = 0; j < heights[0].length; j++) {
				if (pacific[i][j] && atlantic[i][j]) {
					List<Integer> position = new ArrayList<Integer>();
					position.add(i);
					position.add(j);
					result.add(position);
				}
			}
		}
		return result;
	}

	private void travel(int[][] heights, int i, int j, boolean[][] visited, int preHeight) {
		if (i < 0 || i == heights.length || j < 0 || j == heights[0].length || visited[i][j]
				|| heights[i][j] < preHeight) {
			return;
		}
		visited[i][j] = true;

		this.travel(heights, i - 1, j, visited, heights[i][j]);
		this.travel(heights, i + 1, j, visited, heights[i][j]);
		this.travel(heights, i, j - 1, visited, heights[i][j]);
		this.travel(heights, i, j + 1, visited, heights[i][j]);
	}
}
