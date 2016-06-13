package leetcode.medium;

import java.awt.List;

public class M240_Search_a_2D_Matrix_II {

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0)
			return false;

		// Initialize at the top right corner
		int i = 0;
		int j = matrix[0].length - 1;

		while (i < matrix.length && j >= 0) {
			if (matrix[i][j] == target)
				return true;
			if (matrix[i][j] < target)
				i++;
			else
				j--;
		}
		return false;
	}

	public static void main(String[] args) {
		new M240_Search_a_2D_Matrix_II().searchMatrix(new int[][] { { -1, 3 } }, -1);
		List s = null;
		s.remove(0);
	}
}
