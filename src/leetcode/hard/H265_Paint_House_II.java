package leetcode.hard;

public class H265_Paint_House_II {

	public int minCostII(int[][] costs) {
		if (costs == null)
			return 0;
		int min1 = 0;
		int min2 = 0;
		int lastColor = -1;

		for (int i = 0; i < costs.length; i++) {
			int curMin1 = Integer.MAX_VALUE;
			int curMin2 = Integer.MAX_VALUE;
			int curColor = -1;
			for (int j = 0; j < costs[0].length; j++) {
				int cost = costs[i][j] + ((j == lastColor) ? min2 : min1);
				if (cost < curMin1) {
					curMin2 = curMin1;
					curMin1 = cost;
					curColor = j;
				} else if (cost < curMin2) {
					curMin2 = cost;
				}
			}
			min1 = curMin1;
			min2 = curMin2;
			lastColor = curColor;
		}
		return min1;
	}
}
