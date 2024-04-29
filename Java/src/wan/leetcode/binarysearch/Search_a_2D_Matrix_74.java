package wan.leetcode.binarysearch;

public class Search_a_2D_Matrix_74 {
	public boolean searchMatrix(int[][] matrix, int target) {
		int row = this.findRow(matrix, 0, matrix.length - 1, target);
		if (row == -1) {
			return false;
		}

		return this.findCol(matrix, row, 0, matrix[0].length, target) == -1 ? false : true;
	}

	private int findRow(int[][] matrix, int startRow, int endRow, int target) {
		if (startRow == endRow) {
			if (matrix[startRow][0] > target || matrix[startRow][matrix[0].length - 1] < target) {
				return -1;
			}
		}
		int index = (startRow + endRow) / 2;
		if (matrix[index][0] > target) {
			return this.findRow(matrix, startRow, index - 1 < startRow ? startRow : index - 1, target);
		} else if (matrix[index][matrix[0].length - 1] < target) {
			return this.findRow(matrix, index + 1 > endRow ? endRow : index + 1, endRow, target);
		} else {
			return index;
		}
	}

	private int findCol(int[][] matrix, int targetRow, int startCol, int endCol, int target) {
		if (startCol == endCol) {
			return matrix[targetRow][startCol] == target ? startCol : -1;
		}
		int index = (startCol + endCol) / 2;
		if (matrix[targetRow][index] > target) {
			return this.findCol(matrix, targetRow, startCol, index - 1 < startCol ? startCol : index - 1, target);
		} else if (matrix[targetRow][index] < target) {
			return this.findCol(matrix, targetRow, index + 1 > endCol ? endCol : index + 1, endCol, target);
		} else {
			return index;
		}
	}

}
