package wan.leetcode.arrayandhashing;

import java.util.ArrayList;
import java.util.List;

public class Valid_Sudoku_36 {
	public boolean isValidSudoku(char[][] board) {
		// check row
		List<Character> checkList = new ArrayList<Character>();

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if ('.' == board[i][j]) {
					continue;
				}
				if (checkList.contains(board[i][j])) {
					return false;
				}
				checkList.add(board[i][j]);
			}
			checkList.clear();
		}
		// check column
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if ('.' == board[j][i]) {
					continue;
				}
				if (checkList.contains(board[j][i])) {
					return false;
				}
				checkList.add(board[j][i]);
			}
			checkList.clear();
		}
		// check square
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						if ('.' == board[i + k][j + l]) {
							continue;
						}
						if (checkList.contains(board[i + k][j + l])) {
							return false;
						}
						checkList.add(board[i + k][j + l]);
					}
				}
				checkList.clear();
			}
		}
		return true;
	}
}
