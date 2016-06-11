package leetcode.medium;

public class M221_Maximal_Square {

	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int dp[][] = new int[matrix.length][matrix[0].length];
		int maxLength = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = matrix[i][j] - '0';
				else if (matrix[i][j] == '0') {
					dp[i][j] = 0;
				} else {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
				}

				maxLength = Math.max(dp[i][j], maxLength);
			}
		}

		return maxLength * maxLength;
	}
}
