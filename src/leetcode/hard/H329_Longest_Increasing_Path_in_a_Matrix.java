package leetcode.hard;

public class H329_Longest_Increasing_Path_in_a_Matrix {

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;

		int m = matrix.length;
		int n = matrix[0].length;

		int[][] dp = new int[m][n];
		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(dfs(matrix, i, j, dp), max);
			}
		}

		return max;
	}

	private int dfs(int[][] matrix, int x, int y, int[][] dp) {
		if (dp[x][y] != 0)
			return dp[x][y];
		int m = matrix.length, n = matrix[0].length;
		int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		int max = 1;
		for (int[] dir : direction) {

			int x1 = x + dir[0];
			int y1 = y + dir[1];
			if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= n || matrix[x1][y1] <= matrix[x][y])
				continue;
			max = Math.max(max, dfs(matrix, x1, y1, dp) + 1);
		}
		dp[x][y] = max;
		return max;
	}
}
