package leetcode.hard;

public class H312_Burst_Balloons {

	// foreach k in i to j:
	// dp[j][i] = max(array[j-1]*array[k]*array[i+1] + dp[j][k-1] + dp[k+1][i],
	// dp[j][i]);
	public int maxCoins(int[] nums) {
		// Extend list with head and tail (both are 1), index starts at 1
		int array[] = new int[nums.length + 2];
		array[0] = 1;
		array[array.length - 1] = 1;
		for (int i = 0; i < nums.length; i++) {
			array[i + 1] = nums[i];
		}

		// Initialize DP arrays, 1 index based
		int dp[][] = new int[array.length][array.length]; // dp[i][j] stands for
															// max coins at i
															// step, burst j

		for (int i = 1; i < array.length - 1; i++) {
			for (int j = i; j >= 1; j--) {
				// k as last
				for (int k = j; k <= i; k++) {
					dp[j][i] = Math.max(array[j - 1] * array[k] * array[i + 1] + dp[j][k - 1] + dp[k + 1][i], dp[j][i]);
				}
			}
		}

		return dp[1][array.length - 2];
	}
}
