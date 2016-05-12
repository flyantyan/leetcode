package leetcode.easy;

public class E121_Best_Time_to_Buy_and_Sell_Stock {
	public int maxProfit(int[] prices) {
		// Use a variable keep current min value , max candidate is current
		// value - current min value

		if (prices == null || prices.length == 0)
			return 0;

		int min = prices[0]; // keep current min value
		int max = 0; // candidate current valus - min value

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] - min > max)
				max = prices[i] - min;

			if (min > prices[i])
				min = prices[i];
		}

		return max;
	}
}
