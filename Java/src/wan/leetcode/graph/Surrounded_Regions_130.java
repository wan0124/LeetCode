package wan.leetcode.graph;

public class Surrounded_Regions_130 {
	public void solve(char[][] board) {
		// check the edge of this board
		for (int row = 0; row < board.length; row++) {
			this.checkRegion(board, row, 0);
			this.checkRegion(board, row, board[0].length - 1);
		}

		for (int col = 0; col < board[0].length; col++) {
			this.checkRegion(board, 0, col);
			this.checkRegion(board, board.length - 1, col);
		}

		// after we check
		// the last 'O' is the position we need to flip them to the 'X'

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				if (board[row][col] == 'O') {
					board[row][col] = 'X';
				} else if (board[row][col] == '*') {
					board[row][col] = 'O';
				}
			}
		}
	}

	private void checkRegion(char[][] board, int row, int col) {
		if (row >= board.length || col >= board[0].length || row < 0 || col < 0 || board[row][col] != 'O') {
			// why we return when the char is 'O'?
			// because we want to find every 'O' witch is or connected to the 'O' on border
			return;
		}
		// marked this position is the 'O' on the border or connected to the 'O' on
		// border
		board[row][col] = '*';

		this.checkRegion(board, row + 1, col);
		this.checkRegion(board, row - 1, col);
		this.checkRegion(board, row, col + 1);
		this.checkRegion(board, row, col - 1);
	}
}
