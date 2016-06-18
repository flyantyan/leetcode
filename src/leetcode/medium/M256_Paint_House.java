package leetcode.medium;

public class M256_Paint_House {

	public int minCost(int[][] costs) {
		if (costs == null || costs.length == 0)
			return 0;

		int r = 0;
		int g = 0;
		int b = 0;
		for (int i = 0; i < costs.length; i++) {
			int rr = r;
			int gg = g;
			int bb = b;

			r = costs[i][0] + Math.min(gg, bb);
			g = costs[i][2] + Math.min(rr, bb);
			b = costs[i][1] + Math.min(gg, rr);
		}

		return Math.min(r, Math.min(g, b));
	}
}
