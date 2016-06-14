package leetcode.medium;

public class M357_Count_Numbers_with_Unique_Digits {
	public int countNumbersWithUniqueDigits(int n) {
		n = Math.min(n, 10);
		int[] dp = new int[n + 1];
		dp[0] = 1;
		int result = 1;
		for (int i = 1; i <= n; i++) {
			dp[i] = 9;
			for (int j = 9; j >= 9 - i + 2; j--) {
				dp[i] *= j;
			}
			result += dp[i];
		}

		return result;
	}
}
