package leetcode;

public class P_0240_Search_a_2D_Matrix_II {
	public boolean searchMatrix(int[][] matrix, int target) {
		int row = 0;
		int col = matrix[0].length - 1;
		while (row < matrix.length && col >= 0) {
			if (matrix[row][col] == target)
				return true;
			else if (matrix[row][col] < target)
				row++;
			else if (matrix[row][col] > target)
				col--;
		}
		return false;
	}

	public boolean searchMatrixBottomLeft(int[][] matrix, int target) {
		int row = matrix.length - 1;
		int col = 0;
		while (row >= 0 && col < matrix[0].length) {
			if (matrix[row][col] == target)
				return true;
			else if (matrix[row][col] < target)
				col++;
			else if (matrix[row][col] > target)
				row--;
		}
		return false;
	}

	public static void main(String[] args) {
		P_0240_Search_a_2D_Matrix_II handler = new P_0240_Search_a_2D_Matrix_II();
		int[][] matrix = { { 122 } };
		int target = 123;
		boolean res = handler.searchMatrix(matrix, target);
		System.out.println(res);

	}

}
