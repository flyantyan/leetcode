package leetcode.medium;

public class M62_Unique_Paths {
	// public int uniquePaths(int m, int n) {
	// if(m == 1 || n ==1)
	// return 1 ;

	// return uniquePaths(m-1 , n ) + uniquePaths(m , n-1);
	// }

	public int uniquePaths(int m, int n) {

		if (m == 1 || n == 1)
			return 1;

		int[] path = new int[n];
		for (int i = 0; i < n; i++) {
			path[i] = 1;
		}
		path[0] = 1;

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				path[j] += path[j - 1];
			}
		}
		return path[n - 1];
	}

	public int uniquePaths1(int m, int n) {
		int[][] path = new int[m][n];
		path[0][0] = 1;

		if (m == 1 || n == 1) {
			return 1;
		}

		for (int i = 1; i < m; i++) {
			path[i][0] = 1;
		}
		for (int j = 1; j < n; j++) {
			path[0][j] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				path[i][j] = path[i - 1][j] + path[i][j - 1];
			}
		}

		return path[m - 1][n - 1];
	}
}
