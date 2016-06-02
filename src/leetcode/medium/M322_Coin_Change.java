package leetcode.medium;

import java.util.Arrays;

public class M322_Coin_Change {

	public int coinChange(int[] coins, int amount) {
		if (coins == null )
			return -1;
		int dp[] = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
				}
			}
		}

		return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
	}
	
	public static void main(String[] args) {
		System.out.println(new M322_Coin_Change().coinChange(new int[]{1}, 0));
	}
}
