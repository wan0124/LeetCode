package wan.leetcode.backtracking;

public class Word_Search_79 {
	public boolean exist(char[][] board, String word) {
		// check all the char as root(first char)
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (this.backtrack(board, i, j, 0, word)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean backtrack(char[][] board, int i, int j, int index, String word) {
		if (index == word.length()) {
			return true;
		}
		// if one of i, j is out of bound, then return fasle;
		// if this char is '*', means this char we have traveled, return false;
		// if this char != word.charAt(index), return false;
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)
				|| board[i][j] == '*') {
			return false;
		}

		char tempChar = board[i][j];
		// change the char to rememeber which char we have traveled
		board[i][j] = '*';

		// four direction
		boolean isFound = this.backtrack(board, i + 1, j, index + 1, word)
				|| this.backtrack(board, i - 1, j, index + 1, word) || this.backtrack(board, i, j + 1, index + 1, word)
				|| this.backtrack(board, i, j - 1, index + 1, word);
//recover the char
		board[i][j] = tempChar;

		return isFound;
	}
}
