package leetcode.medium;

public class M73_Set_Matrix_Zeroe {

	public void setZeroes(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		int row = matrix.length;
		int column = matrix[0].length;

		boolean isRow0 = false;
		boolean isColumn0 = false;

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < column; j++) {

				if (matrix[i][j] == 0) {
					if (i == 0) {
						isRow0 = true;
					}
					if (j == 0) {
						isColumn0 = true;
					}
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < row; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 0; j < column; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int i = 1; i < column; i++) {
			if (matrix[0][i] == 0) {
				for (int j = 0; j < row; j++) {
					matrix[j][i] = 0;
				}
			}
		}

		if (isColumn0) {
			for (int i = 0; i < row; i++) {
				matrix[i][0] = 0;
			}
		}

		if (isRow0) {
			for (int i = 0; i < column; i++) {
				matrix[0][i] = 0;
			}
		}
	}
}
