package leetcode.medium;

public class M300_Longest_Increasing_Subsequence {
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] dp = new int[nums.length];
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			dp[i] = 1;
			for (int j = 0; j <= i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = dp[i] > dp[j] + 1 ? dp[i] : dp[j] + 1;
				}
			}
			max = Math.max(dp[i], max);
		}
		return max;
	}
}
