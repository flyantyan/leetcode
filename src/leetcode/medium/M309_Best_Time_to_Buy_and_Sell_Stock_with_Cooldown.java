package leetcode.medium;

public class M309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {

	//https://asanchina.wordpress.com/2016/01/04/309-best-time-to-buy-and-sell-stock-with-cooldown/
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		int[][] dp = new int[prices.length][2];
		int len = prices.length;
		for (int i = 1; i < prices.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
			dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - prices[i - 1]);
		}

		return Math.max(dp[len - 1][0], dp[len - 1][1]);

	}
}
