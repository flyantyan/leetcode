package leetcode.medium;

public class H334_Increasing_Triplet_Subsequence {

	public boolean increasingTriplet(int[] nums) {
		if (nums == null || nums.length < 2)
			return false;

		int[] dp = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {

			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
			if (dp[i] == 3)
				return true;
		}
		return false;
	}
}
